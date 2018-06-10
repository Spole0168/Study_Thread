package com.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class WorkerAwait extends Thread {
	//��������
    private String name;
	//��һ�׶ι���ʱ��
	private long time;
	
	private CountDownLatch countDownLatch;
	
	public WorkerAwait(String name, long time, CountDownLatch countDownLatch) {
		this.name = name;
		this.time = time;
		this.countDownLatch = countDownLatch;
	}
	
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		try {
			System.out.println(name+"��һ�׶� Begin"+System.currentTimeMillis());
			Thread.sleep(time);
			System.out.println(name+"��һ�׶� END  "+System.currentTimeMillis());
			
			countDownLatch.await();
			System.out.println(name+"countDownLatch.await()"+System.currentTimeMillis());
			System.out.println(name+"�ڶ��׶�__��ʼ"+System.currentTimeMillis());
			
			Thread.sleep(2000); //����͹��Ҽ���ڶ��׶ι�������Ҫ2�����
			System.out.println(name+"�ڶ��׶�__����"+System.currentTimeMillis());
			
		} catch (InterruptedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}	
	}
}