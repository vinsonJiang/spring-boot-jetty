package io.vinson.server.session;

/**
 * @author: jiangweixin
 * @date: 2019/8/23
 */
public class SerializerException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public SerializerException(Throwable cause) {
        super(cause.getMessage(), cause);
    }

    public SerializerException(String message) {
        super(message);
    }

    public SerializerException(String message, Throwable cause) {
        super(message, cause);
    }
}
