package com.pragma.foodcourt.infrastructure.exceptionhandler;

import com.pragma.foodcourt.domain.exception.DomainException;
import com.pragma.foodcourt.infrastructure.exception.NoDataFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

import static com.pragma.foodcourt.domain.util.DomainConstants.*;

@ControllerAdvice
public class ControllerAdvisor {
    private static final String MESSAGE = "message";

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoDataFoundException(
            NoDataFoundException ignoredNoDataFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<Map<String, String>> handleDomainException(DomainException ex) {
        HttpStatus status = mapStatusFromDomainMessage(ex.getMessage());
        return ResponseEntity.status(status).body(
                Map.of(
                        "code", ex.getMessage()
                )
        );
    }

    private HttpStatus mapStatusFromDomainMessage(String message) {
        return switch (message) {
            case OWNER_NOT_ALLOWED -> HttpStatus.FORBIDDEN;
            case DISH_NOT_FOUND -> HttpStatus.NOT_FOUND;
            case DISH_PRICE_REQUIRED,
                 DISH_PRICE_POSITIVE,
                 DISH_DESCRIPTION_REQUIRED -> HttpStatus.BAD_REQUEST;

            default -> HttpStatus.BAD_REQUEST;
        };
    }

}