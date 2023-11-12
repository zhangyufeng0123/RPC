package org.zyf.rpc.server;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.zyf.rpc.Request;
import org.zyf.rpc.Response;
import org.zyf.rpc.codec.rpc.codec.Decoder;
import org.zyf.rpc.codec.rpc.codec.Encoder;
import org.zyf.rpc.common.utils.ReflectionUtils;
import org.zyf.rpc.transport.RequestHandler;
import org.zyf.rpc.transport.TransportServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Ref;

/**
 * @Author zhang
 * @Date 2023/11/10
 * @Description
 */
@Slf4j
public class RpcServer {
    private RpcServerConfig config;
    private TransportServer net;
    private Encoder encoder;
    private Decoder decoder;
    private ServiceManager serviceManager;
    private ServiceInvoker serviceInvoker;

    public RpcServer() {
        this(new RpcServerConfig());
    }

    public RpcServer(RpcServerConfig config) {
        this.config = config;

        // 创建网络模块
        this.net = ReflectionUtils.newInstance(config.getTransportClass());
        this.net.init(config.getPort(), this.handler);

        // 序列化
        this.encoder = ReflectionUtils.newInstance(config.getEncoderClass());

        // 反序列化
        this.decoder = ReflectionUtils.newInstance(config.getDecoderClass());

        // 服务
        this.serviceManager = new ServiceManager();
        this.serviceInvoker = new ServiceInvoker();
    }

    public <T> void register(Class<T> interfaceClass, T bean) {
        serviceManager.register(interfaceClass, bean);
    }

    public void start() {
        this.net.start();
    }

    public void stop() {
        this.net.stop();
    }

    private RequestHandler handler = new RequestHandler() {
        @Override
        public void onRequest(InputStream receive, OutputStream toResp) {
            Response resp = new Response();

            try{
                byte[] inBytes = IOUtils.readFully(receive, receive.available());
                Request request = decoder.decode(inBytes, Request.class);

                log.info("get request: {}", request);

                ServiceInstance sis = serviceManager.lookup(request);
                Object ret = serviceInvoker.invoke(sis, request);
                resp.setData(ret);

            } catch (Exception e) {
                log.warn(e.getMessage(), e);
                resp.setCode(1);
                resp.setMessage("RPC Server got error: " + e.getClass().getName() + ": " + e.getMessage());
            } finally {
                try {
                    byte[] outBytes = encoder.encode(resp);
                    toResp.write(outBytes);

                    log.info("response client");
                } catch (IOException e) {
                    log.warn(e.getMessage(), e);
                }
            }
        }
    };
}
