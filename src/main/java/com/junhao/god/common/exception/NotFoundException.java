package com.junhao.god.common.exception;
/**
 * 资源未找到异常
 * 用于处理：用户、订单、文件等资源不存在的情况
 */
public class NotFoundException extends RuntimeException {

    private Integer code;
    private String message;

    // 只传 message，默认 404 错误码
    public NotFoundException(String message) {
        super(message);
        this.message = message;
        this.code = 404;
    }

    // 传自定义 code 和 message
    public NotFoundException(Integer code, String message) {
        super(message);
        this.message = message;
        this.code = code;
    }

    // 带 cause（底层异常），方便追踪问题
    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.code = 404;
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
