package com.thread.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class WorkerAwait extends Thread {
	//��������
    private String name;
	//��һ�׶ι���ʱ��
	private long time;
	
	private CyclicBarrier cb;
	
	public WorkerAwait(String name, long time, CyclicBarrier cb) {
		this.name = name;
		this.time = time;
		this.cb = cb;
	}
	
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		try {
			System.out.println(name+"��һ�׶� Begin"+System.currentTimeMillis());
			Thread.sleep(time);
			System.out.println(name+"��һ�׶� END  "+System.currentTimeMillis());
			
			try {
				cb.await();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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