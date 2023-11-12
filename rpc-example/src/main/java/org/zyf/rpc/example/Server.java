package org.zyf.rpc.example;

import org.zyf.rpc.server.RpcServer;
import org.zyf.rpc.server.RpcServerConfig;

/**
 * @Author zhang
 * @Date 2023/11/10
 * @Description
 */
public class Server {
    public static void main(String[] args) {
        RpcServer server = new RpcServer();
        server.register(CalcService.class, new CalcServiceImpl());
        server.start();
    }
}
