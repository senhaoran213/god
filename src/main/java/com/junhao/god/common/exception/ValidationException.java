package com.junhao.god.common.exception;

public class ValidationException extends RuntimeException {
    private Integer code;  // 可选，业务异常码
    private String message;  // 异常描述信息
    /**
     * 参数校验异常
     * 用于处理前端请求参数格式或必填字段错误
     */
    public ValidationException(String message) {
        super(message);
        this.message = message;
        this.code = 400;
    }
    public ValidationException(String message, Integer code) {
        super(message);
        this.message = message;
        this.code = code;
    }
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
