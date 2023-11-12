package org.zyf.rpc.common.utils;

import junit.framework.TestCase;
import org.junit.Test;

import java.lang.reflect.Method;
import java.sql.Ref;

public class ReflectionUtilsTest extends TestCase {

    @Test
    public void testNewInstance() {
        TestClass t = ReflectionUtils.newInstance(TestClass.class);
        assertNotNull(t);
    }

    @Test
    public void testGetPublicMethods() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
        assertEquals(1, methods.length);

        String mname = methods[0].getName();
        assertEquals("b", mname);
    }

    @Test
    public void testInvoke() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
        Method b = methods[0];

        TestClass t = new TestClass();
        Object r = ReflectionUtils.invoke(t, b);

        assertEquals("b", r);
    }
}