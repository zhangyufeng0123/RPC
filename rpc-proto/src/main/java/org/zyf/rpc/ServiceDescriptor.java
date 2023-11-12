package org.zyf.rpc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author zhang
 * @Date 2023/11/8
 * @Description : 表示服务
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDescriptor {
    private String clazz;   // 类名
    private String method;  // 方法名
    private String returnType;  // 返回类型
    private String[] parameterTypes;    // 参数类型

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        ServiceDescriptor that = (ServiceDescriptor) obj;

        return this.toString().equals(that.toString());
    }

    @Override
    public String toString() {
        return "clazz=" + clazz
                + ", method=" + method
                + ", returnType=" + returnType
                + ", parameterTypes=" + Arrays.toString(parameterTypes);
    }

    public static ServiceDescriptor from(Class clazz, Method method) {
        ServiceDescriptor sdp = new ServiceDescriptor();
        sdp.setClazz(clazz.getName());
        sdp.setMethod(method.getName());
        sdp.setReturnType(method.getReturnType().getName());

        Class[] parameterClasses = method.getParameterTypes();
        String[] parameterTypes = new String[parameterClasses.length];

        for (int i = 0; i < parameterClasses.length; i++) {
            parameterTypes[i] = parameterClasses[i].getName();
        }
        sdp.setParameterTypes(parameterTypes);
        return sdp;
    }


}
