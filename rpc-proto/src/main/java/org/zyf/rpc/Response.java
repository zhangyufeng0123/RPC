package org.zyf.rpc;

import lombok.Data;

/**
 * @Author zhang
 * @Date 2023/11/8
 * @Description 表示RPC的返回
 */
@Data
public class Response {
    /**
     * 服务返回格式，0-成功，非0-失败
     */
    private int code = 0;
    /**
     * 具体的错误信息
     */
    private String message = "ok";
    /**
     * 返回的数据
     */
    private Object data;
}
