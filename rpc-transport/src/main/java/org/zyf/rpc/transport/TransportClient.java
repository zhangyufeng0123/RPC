package org.zyf.rpc.transport;

import org.zyf.rpc.Peer;

import java.io.InputStream;

/**
 * @Author zhang
 * @Date 2023/11/8
 * @Description
 * 1. 创建链接
 * 2. 发送数据，并且等待响应
 * 3. 关闭连接
 */
public interface TransportClient {
    void connect (Peer peer);   // 连接网络端点

    InputStream write(InputStream data);

    void close();
}
