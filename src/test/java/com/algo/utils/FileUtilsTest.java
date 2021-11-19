package com.algo.utils;
import java.util.ArrayList;
import java.util.List;

public class FileUtilsTest {
	
	
	
	public static void main(String...strings) throws InterruptedException {
		Double priceNear = 71.0;
		Double bufferRs = 5.0;
		Double priceFound = null;
		List<Double> puts = new ArrayList<>();
		puts.add(2920.0);
		puts.add(2830.0);
		puts.add(2780.0);
		puts.add(2316.85);
		puts.add(0.0);
		puts.add(2522.05);
		puts.add(0.0);
		puts.add(2446.55);
		puts.add(2420.0);
		puts.add(0.0);
		puts.add(1983.2);
		puts.add(0.0);
		puts.add(1939.75);
		puts.add(0.0);
		puts.add(2033.0);
		puts.add(1723.95);
		puts.add(1965.0);
		puts.add(1611.4);
		puts.add(1870.0);
		puts.add(1533.0);
		puts.add(1665.0);
		puts.add(1932.95);
		puts.add(1697.55);
		puts.add(1664.3);
		puts.add(1546.05);
		puts.add(1333.4);
		puts.add(1465.0);
		puts.add(1237.85);
		puts.add(1349.5);
		puts.add(1158.9);
		puts.add(1249.85);
		puts.add(1256.8);
		puts.add(1149.85);
		puts.add(1111.7);
		puts.add(1045.7);
		puts.add(1032.7);
		puts.add(950.95);
		puts.add(943.95);
		puts.add(882.0);
		puts.add(885.0);
		puts.add(818.1);
		puts.add(775.15);
		puts.add(675.55);
		puts.add(653.65);
		puts.add(589.6);
		puts.add(578.2);
		puts.add(509.0);
		puts.add(483.05);
		puts.add(433.3);
		puts.add(396.05);
		puts.add(358.5);
		puts.add(323.7);
		puts.add(294.65);
		puts.add(266.35);
		puts.add(238.0);
		puts.add(213.8);
		puts.add(188.7);
		puts.add(167.75);
		puts.add(147.05);
		puts.add(130.85);
		puts.add(111.45);
		puts.add(99.7);
		puts.add(83.9);
		puts.add(75.25);
		puts.add(61.9);
		puts.add(54.6);
		puts.add(44.75);
		puts.add(38.55);
		puts.add(32.95);
		puts.add(27.5);
		puts.add(23.05);
		puts.add(19.8);
		puts.add(16.65);
		puts.add(14.95);
		puts.add(13.6);
		puts.add(11.8);
		puts.add(10.3);
		puts.add(9.25);
		puts.add(8.25);
		puts.add(7.9);
		puts.add(7.5);
		puts.add(6.85);
		puts.add(6.65);
		puts.add(6.25);
		puts.add(6.55);
		puts.add(6.3);
		puts.add(5.4);
		puts.add(5.5);
		puts.add(5.15);
		puts.add(5.05);
		puts.add(4.95);
		puts.add(5.0);
		puts.add(4.7);
		puts.add(4.8);
		puts.add(4.0);
//		if (angle >= 90 && angle <= 180) {
		System.out.println("RANGE IS "+(priceNear-bufferRs)+" to "+(priceNear+bufferRs));
		for(Double d: puts) {
//			if(Double.valueOf(d) >= (priceNear-bufferRs) && Double.valueOf(d) <= (priceNear+bufferRs)) {
			//if(priceNear > (Double.valueOf(d) + bufferRs) && priceNear < (Double.valueOf(d) - bufferRs)) {
			if((Double.valueOf(d) + bufferRs) >= priceNear && (Double.valueOf(d) - bufferRs) <= priceNear) {
				priceFound = d;
			}
		}
		System.out.println(" Price Found "+priceFound);
	}
	
}
