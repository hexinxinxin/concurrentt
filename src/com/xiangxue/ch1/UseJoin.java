/*********************************************
 * Copyright (c) 2019 LI-RTP.
 * All rights reserved.
 * Created on 2019年8月4日
 *
 * Contributors:
 *     rtp - initial implementation
 *********************************************/

/**
 * 
 */
package com.xiangxue.ch1;

import com.xiangxue.tools.SleepTools;

/**
 * @author 15208
 *
 */
public class UseJoin {
	//
    static class JumpQueue implements Runnable {
        private Thread thread;//用来插队的线程

        public JumpQueue(Thread thread) {
            this.thread = thread;
        }

        public void run() {
        	try {
        		System.out.println(thread.getName()+" will be join before "
        				+Thread.currentThread().getName());
				thread.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	System.out.println(Thread.currentThread().getName()+" terminted.");
        }
    }

    public static void main(String[] args) throws Exception {
        Thread previous = Thread.currentThread();//现在是主线程
        for (int i = 0; i < 10; i++) {
            //i=0,previous 是主线程，i=1;previous是i=0这个线程
            Thread thread =
                    new Thread(new JumpQueue(previous), String.valueOf(i));
            System.out.println(previous.getName()+" jump a queue the thread:"
                    +thread.getName());
            thread.start();
            previous = thread;
        }

        SleepTools.second(2);//让主线程休眠2秒
        System.out.println(Thread.currentThread().getName() + " terminate.");
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }
}
