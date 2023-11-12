package org.zyf.rpc.transport;

/**
 * @Author zhang
 * @Date 2023/11/8
 * @Description
 * 1. 启动、监听
 * 2. 接受请求
 * 3. 关闭监听
 */
public interface TransportServer {
    void init(int port, RequestHandler handler);

    void start();

    void stop();
}
