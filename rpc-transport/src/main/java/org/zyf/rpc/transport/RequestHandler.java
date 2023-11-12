package org.zyf.rpc.transport;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author zhang
 * @Date 2023/11/8
 * @Description 处理网络请求的handler
 */
public interface RequestHandler {
    void onRequest(InputStream receive, OutputStream toResp);
}
