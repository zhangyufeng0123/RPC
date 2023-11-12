package org.zyf.rpc.client;

import org.zyf.rpc.codec.rpc.codec.Decoder;
import org.zyf.rpc.codec.rpc.codec.Encoder;
import org.zyf.rpc.common.utils.ReflectionUtils;
import org.zyf.rpc.transport.TransportClient;

import java.lang.reflect.Proxy;

/**
 * @Author zhang
 * @Date 2023/11/10
 * @Description
 */
public class RpcClient {
    private RpcClientConfig config;
    private Encoder encoder;
    private Decoder decoder;
    private TransportSelector selector;

    public RpcClient() {
        this (new RpcClientConfig());

        this.encoder = ReflectionUtils.newInstance(this.config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(this.config.getDecoderClass());
        this.selector = ReflectionUtils.newInstance(this.config.getSelectorClass());

        this.selector.init(this.config.getServers(), this.config.getConnectCount(), this.config.getTransportClass());
    }

    public RpcClient(RpcClientConfig config) {
        this.config = config;
    }

    public <T> T getProxy(Class<T> clazz) {
        return (T)Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[] {clazz},
                new RemoteInvoker(clazz, encoder, decoder, selector)
        );
    }
}
