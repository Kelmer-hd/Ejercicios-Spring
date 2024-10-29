package kelmerdev.com.exception;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.util.*;

@ControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {

    private MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                "La solicitud tiene unos errores de validación.");

        List<String> errors = new ArrayList<>();

        for (FieldError error : ex.getFieldErrors()) {
            String fieldName = error.getField();
            String message = error.getDefaultMessage();
            errors.add(fieldName + ": " + message);
        }

        problemDetail.setProperty("errors", errors);
        return problemDetail;
    }
        /*
        Map<String, List<String>> fieldErrors = new HashMap<>();

        for (FieldError error : ex.getFieldErrors()) {
            String fieldName = error.getField();
            String message = error.getDefaultMessage();

            fieldErrors.computeIfAbsent(fieldName, k -> new ArrayList<>()).add(message);
        }

       problemDetail.setProperty("errors", fieldErrors);
        return problemDetail;
    }
    */

    @ExceptionHandler(ResourceNotFoundException.class)
    public ProblemDetail handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
                "El recurso no ha sido encontrado.");
    }

    @ExceptionHandler(BadRequestException.class)
    public ProblemDetail handleBadRequestException(BadRequestException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }


}
