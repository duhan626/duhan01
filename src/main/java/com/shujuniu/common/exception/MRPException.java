package com.shujuniu.common.exception;


import com.shujuniu.common.controller.StatusCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MRPException extends RuntimeException {

    private StatusCode statusCode;

    private String businessMessage;

    public MRPException(StatusCode statueCode) {
        super();
        this.statusCode = statueCode;
    }

    public MRPException(StatusCode statueCode, String businessMessage) {
        super();
        this.statusCode = statueCode;
        this.businessMessage = businessMessage;
    }

    public MRPException(Exception e, StatusCode statueCode) {
        super(e);
        this.statusCode = statueCode;
    }

    public MRPException(Exception e, StatusCode statueCode, String businessMessage) {
        super();
        this.statusCode = statueCode;
        this.businessMessage = businessMessage;
    }

    @Override
    public String getMessage() {
        return buildMessage(super.getMessage(), getCause());
    }

    /**
     * 为基本信息和根异常绑定消息
     */
    public static String buildMessage(String message, Throwable cause) {
        if (cause != null) {
            StringBuilder sb = new StringBuilder();
            if (message != null) {
                sb.append(message).append("; ");
            }
            sb.append("base exception is ").append(cause);
            return sb.toString();
        } else {
            return message;
        }
    }

    @Override
    public String toString() {
        return this == null ? "【ncexception is null】" :
                String.format("statusCode=%s,message=%s,businessMessage=%s",statusCode.getCode(),statusCode.getMessage(),businessMessage);
    }

}
