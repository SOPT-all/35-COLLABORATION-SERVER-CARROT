package com.sopt.carrot_server.global.common.exception;


import com.sopt.carrot_server.global.common.code.FailureCode;

public class ProductException extends ApiException {

    private final FailureCode failureCode;

    public FailureCode getFailureCode() {
        return failureCode;
    }

    public ProductException(FailureCode failureCode) {
        super(failureCode, "[DiaryException]");
        this.failureCode = failureCode;
    }

}
