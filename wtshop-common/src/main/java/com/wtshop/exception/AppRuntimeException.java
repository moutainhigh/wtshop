package com.wtshop.exception;

import com.wtshop.constants.Code;

/**
 * Created by Administrator on 2017/5/23 0023.
 */
public class AppRuntimeException extends RuntimeException{

    private Integer code;

    public AppRuntimeException() {
    }

    public AppRuntimeException(String message) {
        super(message);
        this.code = Code.SUCCESS;
    }

    public AppRuntimeException(Integer code, String message) {
        super(message);
        this.code = code;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
