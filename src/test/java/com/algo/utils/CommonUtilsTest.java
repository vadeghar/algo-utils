package com.algo.utils;

import java.awt.Toolkit;

import org.junit.jupiter.api.Test;

public class CommonUtilsTest {
	public void beep() {
		for(int i= 0; i<10;i++) {
			try {
				Toolkit.getDefaultToolkit().beep();
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	@Test
	public void getOpstraStrikePriceTest() {
		System.out.println(CommonUtils.getSpecialExpiry("BANKNIFTY18NOV202118400CE", false));
	}

}
