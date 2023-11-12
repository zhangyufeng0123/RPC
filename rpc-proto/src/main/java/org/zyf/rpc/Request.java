package org.zyf.rpc;

import lombok.Data;

/**
 * @Author zhang
 * @Date 2023/11/8
 * @Description RPC的请求
 */
@Data
public class Request {
    private ServiceDescriptor service;
    private Object[] parameters;
}
