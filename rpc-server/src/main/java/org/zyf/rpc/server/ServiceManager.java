package org.zyf.rpc.server;

import lombok.extern.slf4j.Slf4j;
import org.zyf.rpc.Request;
import org.zyf.rpc.ServiceDescriptor;
import org.zyf.rpc.common.utils.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author zhang
 * @Date 2023/11/9
 * @Description 管理rpc暴露的服务
 */
@Slf4j
public class ServiceManager {
    private Map<ServiceDescriptor, ServiceInstance> service;

    public ServiceManager() {
        this.service = new ConcurrentHashMap<>();
    }

    public <T> void register(Class<T> interfaceClass, T bean) {
        Method[] methods = ReflectionUtils.getPublicMethods(interfaceClass);
        for (Method method : methods) {
            ServiceInstance sis = new ServiceInstance(bean, method);
            ServiceDescriptor sdp = ServiceDescriptor.from(interfaceClass, method);
            service.put(sdp, sis);
            log.info("register service: {} {}", sdp.getClazz(), sdp.getParameterTypes());

        }
    }

    public ServiceInstance lookup(Request request) {
        ServiceDescriptor sdp = request.getService();
        return service.get(sdp);
    }

}
