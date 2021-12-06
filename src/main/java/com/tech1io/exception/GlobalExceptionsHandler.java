package com.tech1io.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionsHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    Object handleAuthException(UsernameNotFoundException e) {
        return convertToNew(e, 403);
    }

    private Exc convertToNew(Throwable throwable, int code) {
        Exc newExc = new Exc();
        newExc.setErrCode(code);
        newExc.setErrText(throwable.getMessage());
        return newExc;
    }

}
