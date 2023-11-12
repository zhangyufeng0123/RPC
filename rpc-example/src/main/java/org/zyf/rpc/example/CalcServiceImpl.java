package org.zyf.rpc.example;

/**
 * @Author zhang
 * @Date 2023/11/10
 * @Description
 */
public class CalcServiceImpl implements CalcService{
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int minus(int a, int b) {
        return a - b;
    }
}
