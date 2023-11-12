package org.zyf.rpc.codec.rpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * @Author zhang
 * @Date 2023/11/8
 * @Description 基于Json的序列化实现
 */
public class JSONEncoder implements Encoder{
    @Override
    public byte[] encode(Object obj) {
        return JSON.toJSONBytes(obj);
    }
}
