package com.kelmerdev.config;

import com.kelmerdev.exeception.BadRequestException;
import com.kelmerdev.exeception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@RestControllerAdvice
@AllArgsConstructor
public class ExceptionHandling {

    private MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "la solicitud tiene errores de Validacion");

        Set<String> errors = new HashSet<>();
        List<FieldError> fieldErrors = exception.getFieldErrors();

        for (FieldError fieldError : fieldErrors) {
            String message = messageSource.getMessage(fieldError, Locale.getDefault());
            errors.add(message);
        }

        problemDetail.setProperty("errors", errors);

        return problemDetail;
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ProblemDetail handlerResourceNotFoundException(ResourceNotFoundException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, "El recurso no ha sido encontrado");

    }

    @ExceptionHandler(BadRequestException.class)
    public ProblemDetail handlerBadRequestException(BadRequestException exception) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

}
