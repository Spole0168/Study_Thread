package com.thread.currentThreads.chapter4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by 13 on 2017/5/6.
 */
public class AtomicRefrenceInt {

	public static class ChongZhiTask implements Runnable {
		AtomicReference<Long> money = null;

		public ChongZhiTask(AtomicReference<Long> money) {
			super();
			this.money = money;
		}

		public void run() {
			while (true) {
				Long m = money.get();
				if (m < 20) {
					if (money.compareAndSet(m, m + 20)) {
						System.out.println("���С��20Ԫ,��ֵ�ɹ�,���:" + money.get()
								+ "Ԫ");
						break;
					}
				} else {
					System.out.println("������20,�����ֵ");
					break;
				}
			}
		}
	}

	public static class XiaoFeiTask implements Runnable {
		AtomicReference<Long> money = null;

		public XiaoFeiTask(AtomicReference<Long> money) {
			super();
			this.money = money;
		}

		public void run() {
			while (true) {
				Long m = money.get();
				if (m > 10) {
					System.out.println("������10Ԫ");
					if (money.compareAndSet(m, m - 10)) {
						System.out.println("�ɹ�����10Ԫ,���:" + money.get() + "Ԫ");
						break;
					}
				} else {
					System.out.println("û���㹻�Ľ��");
					break;
				}
			}
		}
	}

	// �����п��ܲ�����������ᵽ�����
	public static void main(String args[]) {
		final AtomicReference<Long> money = new AtomicReference<Long>();
		money.set(19L);
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);
		ChongZhiTask chongZhiTask = new ChongZhiTask(money);
		XiaoFeiTask xiaoFeiTask = new XiaoFeiTask(money);
		for(int i =0;i<10;i++){
			fixedThreadPool.execute(chongZhiTask);
			fixedThreadPool.execute(xiaoFeiTask);
		}
		
	}

}
