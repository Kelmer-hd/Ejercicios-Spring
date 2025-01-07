package com.kelmerdev.config;

import com.kelmerdev.exception.BadRequestException;
import com.kelmerdev.exception.ResourceNotFoundException;
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
public class HandlerRestException {

    private MessageSource mesaMessageSource;


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
                "La spliitud tiene unos errores de validación.");

        Set<String> errors = new HashSet<>();
        List<FieldError> fieldErrors = ex.getFieldErrors();

        for (FieldError fe : fieldErrors) {
            String message = mesaMessageSource.getMessage(fe, Locale.getDefault());
            errors.add(message);
        }

        problemDetail.setProperty("errors", errors);

        return problemDetail;
    }


    @ExceptionHandler(ResourceNotFoundException.class)
    public ProblemDetail handlerResourceNotFoundException(ResourceNotFoundException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND,
                "El recurso no ha sido encontrado.");
    }

    @ExceptionHandler(BadRequestException.class)
    public ProblemDetail handlerBadRequestException(BadRequestException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}
