package com.tt.utils.exception;

import com.tt.utils.rusult.Result;

/**
 * 自定义异常类
 */
public class TException extends RuntimeException {

    private Result.ResultEnum resultEnum;

    public TException(Result.ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.resultEnum = resultEnum;
    }

    public Result.ResultEnum getResultEnum() {
        return resultEnum;
    }
}
