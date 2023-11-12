package org.zyf.rpc.client;

import lombok.extern.slf4j.Slf4j;
import org.zyf.rpc.Peer;
import org.zyf.rpc.common.utils.ReflectionUtils;
import org.zyf.rpc.transport.TransportClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author zhang
 * @Date 2023/11/10
 * @Description
 */
@Slf4j
public class RandomTransportSelector implements TransportSelector{
    /**
     * 已经连接好的clients
     */
    private List<TransportClient> clients;

    public RandomTransportSelector() {
        clients = new ArrayList<>();
    }
    @Override
    public synchronized void init(List<Peer> peers, int count, Class<? extends TransportClient> clazz) {
        count = Math.max(count, 1);

        for (Peer peer : peers) {
            for (int i = 0; i < count; i++) {
                TransportClient client = ReflectionUtils.newInstance(clazz);
                client.connect(peer);
                clients.add(client);
            }
            log.info("connect server: {}", peer);
        }
    }

    @Override
    public synchronized TransportClient select() {
        int i = new Random().nextInt(clients.size());
        return clients.remove(i);
    }

    @Override
    public synchronized void release(TransportClient client) {
        clients.add(client);
    }

    @Override
    public synchronized void close() {
        for (TransportClient client : clients) {
            client.close();
        }
        clients.clear();
    }
}
