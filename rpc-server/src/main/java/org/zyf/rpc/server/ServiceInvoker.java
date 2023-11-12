package org.zyf.rpc.server;

import org.zyf.rpc.Request;
import org.zyf.rpc.common.utils.ReflectionUtils;

/**
 * @Author zhang
 * @Date 2023/11/10
 * @Description
 */
public class ServiceInvoker {
    public Object invoke(ServiceInstance service, Request request) {
        return ReflectionUtils.invoke(service.getTarget(), service.getMethod(), request.getParameters());
    }
}
