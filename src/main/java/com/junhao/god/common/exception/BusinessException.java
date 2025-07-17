package com.junhao.god.common.exception;

public class BusinessException extends RuntimeException {
    //类当中需要加序列化语句 的场景：
//    	  •	你要把异常对象通过 Redis / MQ / 文件 / 网络 序列化传输。
//        •	项目中对异常做了 Serializable 接口相关处理（比如统一返回结构中直接暴露异常）。
//        •	项目用到了某些要求所有 POJO 都实现 Serializable 的框架（罕见）。

    private Integer code;  // 可选，业务异常码
    private String message;  // 异常描述信息

    public BusinessException(String message) {
        super(message);
        this.message = message;
        this.code = 500;
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(String message, Throwable cause) {
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
