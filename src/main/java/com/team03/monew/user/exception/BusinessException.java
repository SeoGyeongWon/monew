package com.team03.monew.user.exception;

import com.team03.monew.common.customerror.ErrorCode;
import com.team03.monew.common.customerror.MonewException;

public class BusinessException extends MonewException {

    public BusinessException(ErrorCode errorCode) {
        super(errorCode);
    }

    public BusinessException(ErrorCode errorCode, String customMessage) {
        super(errorCode);
        this.addDetail("customMessage", customMessage);
    }
}
