package com.tt.utils.rusult;

import javax.validation.constraints.NotNull;

/**
 * 返回给前台的类
 */
public class Result<T> {

    private Integer errorCode;

    private String msg;

    private T data;

    public Result(@NotNull Result.ResultEnum resultEnum, T data) {
        this.setData(data);
        this.setErrorCode(resultEnum.getErrorCode());
        this.setMsg(resultEnum.getMsg());
    }

    public Result(@NotNull Result.ResultEnum resultEnum) {
        this(resultEnum, null);
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 返回错误码的枚举类
     */
    public enum ResultEnum {

        SUCCESS(0, "成功"),
        FAILED(-1, "失败"),
        NOT_FOUND(404, "请求地址错误"),
        UNKNOW(100, "未知错误");

        private Integer errorCode;

        private String msg;

        ResultEnum(Integer errorCode, String msg) {
            this.errorCode = errorCode;
            this.msg = msg;
        }

        public Integer getErrorCode() {
            return errorCode;
        }

        public String getMsg() {
            return msg;
        }
    }

}
