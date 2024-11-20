package com.sopt.carrot_server.global.common;

import com.sopt.carrot_server.global.common.code.FailureCode;
import com.sopt.carrot_server.global.common.dto.ErrorResponse;
import com.sopt.carrot_server.global.common.exception.ApiException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> handleDiaryException(ApiException e) {
        log.error(e.getMessage());

        FailureCode failureCode = e.getFailureCode();
        return ResponseEntity
                .status(failureCode.getHttpStatus())
                .body(ErrorResponse.of(
                        failureCode.getHttpStatus().value(),
                        failureCode.getMessage()
                ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("[MethodArgumentNotValidException] 발생 : {}", e.getMessage());

        FailureCode failureCode = FailureCode.INVALID_VALUE;
        return ResponseEntity
                .status(failureCode.getHttpStatus())
                .body(ErrorResponse.of(
                        failureCode.getHttpStatus().value(),
                        failureCode.getMessage(),
                        e.getBindingResult()
                ));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> handleValidationFailure(MissingServletRequestParameterException e) {
        log.error("[MissingParameterException] 발생 : {}", e.getMessage());

        FailureCode failureCode = FailureCode.MISSING_PARAMETER;
        return ResponseEntity
                .status(failureCode.getHttpStatus())
                .body(ErrorResponse.of(
                        failureCode.getHttpStatus().value(),
                        failureCode.getMessage()
                ));
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        log.error("[Exception] 발생 : {}", e.getMessage());

        FailureCode failureCode = FailureCode.INTERNAL_SERVER_ERROR;
        return ResponseEntity
                .status(failureCode.getHttpStatus())
                .body(ErrorResponse.of(
                        failureCode.getHttpStatus().value(),
                        failureCode.getMessage()
                ));
    }
}
