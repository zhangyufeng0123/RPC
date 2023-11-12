package org.zyf.rpc.server;

import lombok.Data;
import org.zyf.rpc.codec.rpc.codec.Decoder;
import org.zyf.rpc.codec.rpc.codec.Encoder;
import org.zyf.rpc.codec.rpc.codec.JSONDecoder;
import org.zyf.rpc.codec.rpc.codec.JSONEncoder;
import org.zyf.rpc.transport.HTTPTransportServer;
import org.zyf.rpc.transport.TransportServer;

/**
 * @Author zhang
 * @Date 2023/11/9
 * @Description server配置
 */

@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HTTPTransportServer.class;

    private Class<? extends Encoder> encoderClass = JSONEncoder.class;

    private Class<? extends Decoder> decoderClass = JSONDecoder.class;

    private int port = 3000;

}
