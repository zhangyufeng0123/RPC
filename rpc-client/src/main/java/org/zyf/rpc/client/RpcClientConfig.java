package org.zyf.rpc.client;

import lombok.Data;
import org.zyf.rpc.Peer;
import org.zyf.rpc.codec.rpc.codec.Decoder;
import org.zyf.rpc.codec.rpc.codec.Encoder;
import org.zyf.rpc.codec.rpc.codec.JSONDecoder;
import org.zyf.rpc.codec.rpc.codec.JSONEncoder;
import org.zyf.rpc.transport.HTTPTransportClient;
import org.zyf.rpc.transport.TransportClient;

import java.util.Arrays;
import java.util.List;

/**
 * @Author zhang
 * @Date 2023/11/10
 * @Description
 */
@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClass = HTTPTransportClient.class;

    private Class<? extends Encoder> encoderClass = JSONEncoder.class;

    private Class<? extends Decoder> decoderClass = JSONDecoder.class;

    private Class<? extends TransportSelector> selectorClass = RandomTransportSelector.class;

    private int connectCount = 1;

    private List<Peer> servers = Arrays.asList(
            new Peer("127.0.0.1", 3000)
    );
}
