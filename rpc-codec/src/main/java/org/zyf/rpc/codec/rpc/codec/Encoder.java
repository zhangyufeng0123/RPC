package org.zyf.rpc.codec.rpc.codec;

/**
 * @Author zhang
 * @Date 2023/11/8
 * @Description 序列化
 */
public interface Encoder {
    byte[] encode(Object obj);
}
