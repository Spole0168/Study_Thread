package com.thread.currentThreads.chapter5.future;

import java.util.concurrent.Callable;

/**
 * Created by 13 on 2017/5/8.
 */
public class JdkFuture implements Callable<String> {
    private String data;

    public JdkFuture(String data) {
        this.data = data;
    }

    @Override
    public String call() throws Exception {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            stringBuffer.append(data);
            Thread.sleep(100);
        }

        return stringBuffer.toString();
    }
}
