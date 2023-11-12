package org.zyf.rpc.codec.rpc.codec;

import junit.framework.TestCase;
import org.junit.Test;

public class JSONDecoderTest extends TestCase {

    @Test
    public void testDecode() {
        Encoder encoder = new JSONEncoder();

        TestBean bean = new TestBean();
        bean.setName("zyf");
        bean.setAge(18);

        byte[] bytes =  encoder.encode(bean);

        assertNotNull(bytes);
    }

    @Test
    public void testDecoder() {
        Encoder encoder = new JSONEncoder();

        TestBean bean = new TestBean();
        bean.setName("zyf");
        bean.setAge(18);

        byte[] bytes =  encoder.encode(bean);

        Decoder decoder = new JSONDecoder();
        TestBean bean1 = decoder.decode(bytes, bean.getClass());

        assertEquals(bean1.getName(),  bean.getName());
        assertEquals(bean1.getAge(), bean.getAge());
    }
}