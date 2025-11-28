package com.team03.monew.common.exception;

public class UserNotFoundException extends BusinessException {

    public UserNotFoundException(){
        super(ErrorCode.USER_NOT_FOUND);
    }

    public UserNotFoundException(String message){
        super(ErrorCode.USER_NOT_FOUND, message);
    }
}
