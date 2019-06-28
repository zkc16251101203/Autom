 package com.six.twentytwo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 锻炼写程序的能力
 * @author Administrator
 *
 * zkc
 */
public class QiuZhaoTest {
	private static int count = 0;
public static void main(String[] args) {
	ExecutorService fixThread = Executors.newFixedThreadPool(2000);
	CountDownLatch countDownLatch = new CountDownLatch(10);
	for(int i = 0; i < 2000 ; i++) {
		fixThread.execute(new Runnable() {
			
			@Override
			public void run() {
				QiuZhaoTest.addcount();
				countDownLatch.countDown();
			}
		});
	}
	try {
		countDownLatch.await();
	} catch (InterruptedException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	System.out.println("所有线程执行完毕 count的数字是 " + count);
	fixThread.shutdown();
	System.out.println("线程池是否关闭" + fixThread.isShutdown());
	System.out.println("线程池是否终止" + fixThread.isTerminated());
}
public  synchronized static void addcount() {
	
	count++;
	
}
}
