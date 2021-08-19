package com.bankino.training.exception;

import com.bankino.training.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.List;


@ControllerAdvice
//@Slf4j
public class RestExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);


    @ExceptionHandler(value = {BankinoBaseBusinessException.class})
    public ResponseEntity<List<ExceptionResponse>> handleBusinessEx(BankinoBaseBusinessException ex) {
        logger.error(ex.getMessage(), ex);
        return ResponseEntity.status(Integer.parseInt(ex.getMessage()))
                .body(Arrays.asList(new ExceptionResponse(ex.getMessage())));
    }

    @ExceptionHandler(value = {Throwable.class})
    public ResponseEntity<List<ExceptionResponse>> handleError(Throwable ex) {
        logger.error(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Arrays.asList(new ExceptionResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage())));
    }

}
