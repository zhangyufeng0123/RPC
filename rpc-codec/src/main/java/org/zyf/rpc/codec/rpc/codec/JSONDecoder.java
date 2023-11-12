package org.zyf.rpc.codec.rpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * @Author zhang
 * @Date 2023/11/8
 * @Description 基于Json的反序列化
 */
public class JSONDecoder implements Decoder{
    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes, clazz);
    }
}
