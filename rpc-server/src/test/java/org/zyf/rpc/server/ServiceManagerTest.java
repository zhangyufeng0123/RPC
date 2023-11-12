package org.zyf.rpc.server;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.zyf.rpc.Request;
import org.zyf.rpc.ServiceDescriptor;
import org.zyf.rpc.common.utils.ReflectionUtils;

import java.lang.reflect.Method;

import static junit.framework.TestCase.assertNotNull;

public class ServiceManagerTest extends TestClass {
    ServiceManager sm;

    @Before
    public void init(){
        sm = new ServiceManager();
    }

    @Test
    public void testRegister() {

        TestInterface bean = new TestClass();

        sm.register(TestInterface.class, bean);
    }

    @Test
    public void testLookup() {

        testRegister();
        Method method = ReflectionUtils.getPublicMethods(TestInterface.class)[0];
        ServiceDescriptor sdp = ServiceDescriptor.from(TestInterface.class, method);

        Request request = new Request();
        request.setService(sdp);

        ServiceInstance sis =  sm.lookup(request);
        assertNotNull(sis);
    }
}