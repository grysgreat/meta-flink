package com.example.metaflink.exception;

/**
 * @author binghe
 * @version 1.0.0
 * @description 连接器异常类
 */
public class ConnectorException extends RuntimeException{
    private static final long serialVersionUID = -6937770738525831946L;
    public ConnectorException(String message) {
        super(message);
    }

    public ConnectorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectorException(Throwable cause) {
        super(cause);
    }

    protected ConnectorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
