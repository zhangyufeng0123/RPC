package org.zyf.rpc.codec.rpc.codec;

/**
 * @Author zhang
 * @Date 2023/11/8
 * @Description 反序列化
 */
public interface Decoder {
    <T> T decode(byte[] bytes, Class<T> clazz);
}
