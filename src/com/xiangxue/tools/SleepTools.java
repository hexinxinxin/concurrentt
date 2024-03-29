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
package com.xiangxue.tools;

import java.util.concurrent.TimeUnit;

/**
 * @author 15208
 *
 */
public class SleepTools {
	/**
	 * 按秒休眠
	 * @param seconds 秒数
	 */
    public static final void second(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
    
    /**
     * 按毫秒数休眠
     * @param seconds 毫秒数
     */
    public static final void ms(int seconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }
}
