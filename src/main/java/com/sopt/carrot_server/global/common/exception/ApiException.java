package com.sopt.carrot_server.global.common.exception;


import com.sopt.carrot_server.global.common.code.FailureCode;

public class ApiException extends RuntimeException {

    private final FailureCode failureCode;
    private final String errorMessage;

    public FailureCode getFailureCode() {
        return failureCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public ApiException(FailureCode failureCode, String errorMessage) {
        super(errorMessage + ": " + failureCode.getMessage());
        this.failureCode = failureCode;
        this.errorMessage = errorMessage;
    }
}
