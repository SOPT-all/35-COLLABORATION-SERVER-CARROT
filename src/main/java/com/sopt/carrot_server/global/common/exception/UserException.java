package com.sopt.carrot_server.global.common.exception;


import com.sopt.carrot_server.global.common.code.FailureCode;

public class UserException extends ApiException {

    private final FailureCode failureCode;

    public FailureCode getFailureCode() {
        return failureCode;
    }

    public UserException(FailureCode failureCode) {
        super(failureCode, "[UserException]");
        this.failureCode = failureCode;
    }
}
