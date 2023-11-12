package org.zyf.rpc.server;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * @Author zhang
 * @Date 2023/11/9
 * @Description 表示一个具体服务
 */
@Data
@AllArgsConstructor
public class ServiceInstance {
    private Object target;
    private Method method;

}
