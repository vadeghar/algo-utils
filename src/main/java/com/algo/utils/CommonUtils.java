package com.algo.utils;

import java.awt.Toolkit;
import java.util.List;

import com.algo.model.MyPosition;



public class CommonUtils {
	
	public static void beep() {
		for(int i= 0; i<5;i++) {
			try {
				Toolkit.getDefaultToolkit().beep();
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public static Double priceDiffInPerc(Double p1, Double p2) {
		Double big = p1 > p2 ? p1  : p2;
		Double small = p1 < p2 ? p1  : p2;
		Double perc = (big - small) / big * 100;
		return perc;
	}
	
	public static Double getNetPremiumCollected(List<MyPosition> netPositions) {
		Double netPremium = 0.0;
		for(MyPosition p : netPositions) {
			if(p.getNetQuantity() < 0)
				netPremium = p.getCurrentPrice() != null ? (netPremium + p.getCurrentPrice()) : 0.0;
		}
		return netPremium;
	}

}
