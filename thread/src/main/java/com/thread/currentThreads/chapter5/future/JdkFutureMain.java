package com.thread.currentThreads.chapter5.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by 13 on 2017/5/8.
 */
public class JdkFutureMain {

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        //����FutureTask
        FutureTask<String> futureTask = new FutureTask<String>(new JdkFuture("a"));

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        //ִ��FutureTask,�൱��ǰһ�������е�client.request("a")��������
        //�����￪���߳̽���RealData��call()ִ��
        executorService.submit(futureTask);

        System.out.println("�������");

        try {
            //������Ȼ��������������ݲ���,ʹ��sleep��������ҵ���߼��Ĵ���
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //�൱��ǰһ�������е�data.getResult(),ȡ��call()�����ķ���ֵ
        //�����ʱcall()����û��ִ�����,����Ȼ��ȴ�
        System.out.println("����=" + futureTask.get());
    }
}
