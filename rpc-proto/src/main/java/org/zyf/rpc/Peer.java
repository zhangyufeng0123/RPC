package org.zyf.rpc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author zhang
 * @Date 2023/11/8
 * @Description ： 表示网络传输的一个端点
 */
@Data
@AllArgsConstructor
public class Peer {
    private String host;    // 服务地址
    private int port;   // 端口
}
