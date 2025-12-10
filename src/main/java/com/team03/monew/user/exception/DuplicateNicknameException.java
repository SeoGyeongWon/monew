package com.team03.monew.user.exception;

public class DuplicateNicknameException extends BusinessException {

    public DuplicateNicknameException(){
        super(UserErrorCode.DUPLICATE_NICKNAME);
    }

    public DuplicateNicknameException(String message){
        super(UserErrorCode.DUPLICATE_NICKNAME, message);
    }
}

