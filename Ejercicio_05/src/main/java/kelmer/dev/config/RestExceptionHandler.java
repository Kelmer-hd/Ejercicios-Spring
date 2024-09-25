package kelmer.dev.config;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@AllArgsConstructor
@RestControllerAdvice
public class RestExceptionHandler {

    private MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                "La solicitud tiene unos errores de validación.");

        // Mapeamos los errores en lugar de usar un Set simple
        Map<String, String> fieldErrorsMap = new HashMap<>();
        List<FieldError> fieldErrors = ex.getFieldErrors();

        for (FieldError fe : fieldErrors) {
            String message = messageSource.getMessage(fe, Locale.getDefault());
            fieldErrorsMap.put(fe.getField(), message); // Guardamos el campo y su mensaje de error
        }

        // Agregamos los errores como una propiedad
        problemDetail.setProperty("errors", fieldErrorsMap);

        return problemDetail;
    }
}
