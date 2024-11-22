package com.sopt.carrot_server.global.common.exception;

import com.sopt.carrot_server.global.common.code.FailureCode;

public class AddressException extends ApiException {
    private final FailureCode failureCode;

    public FailureCode getFailureCode() {
    return failureCode;
  }

    public AddressException(FailureCode failureCode) {
      super(failureCode, "[AddressException]");
      this.failureCode = failureCode;
    }
}

