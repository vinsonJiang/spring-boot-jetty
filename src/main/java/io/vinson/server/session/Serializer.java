package io.vinson.server.session;

/**
 * @author: jiangweixin
 * @date: 2019/8/23
 */
public interface Serializer {

    void start();

    void stop();

    String serialize(Object o) throws SerializerException;

    <T> T deserialize(String o, Class<T> targetType) throws SerializerException;
}