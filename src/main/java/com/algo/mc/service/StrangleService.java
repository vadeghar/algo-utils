package com.algo.mc.service;

import java.util.List;

import com.algo.model.MyPosition;

public interface StrangleService {
	
	public List<MyPosition> getKiteNetPositions();
	
	public List<MyPosition> getPaperNetPositions();
	
	public MyPosition getNewSellPositionNearPremium(MyPosition posToClose, Double otherOptPrem);
	
	public void addStopLossToSheet(MyPosition posToKeep, MyPosition posToOpen);
	
	public void printAllPositionsFromSheet();
	
	public void updteTradeFile(boolean isNewLine);
	
	public void startAdjustment(MyPosition posToClose, MyPosition posToOpen);
	
	public boolean buy(String strikePrice, String symbol, String expiry, Integer qty, String ceOrPe);
	
	public boolean buy(String strikePrice, String symbol, String expiry, Integer qty, String ceOrPe, double price, boolean isClose);
		
	public boolean sell(String strikePrice, String symbol, String expiry, Integer qty, String ceOrPe);
	
	public boolean sell(String strikePrice, String symbol, String expiry, Integer qty, String ceOrPe, double price);
	
	public boolean checkTargetAndClosePositions(List<MyPosition> netPositions);
	
	public boolean checkSLAndClosePositions(List<MyPosition> netPositions);
	
	public void placeStrangleStrategy();
	
	public double getPositionPnl(MyPosition p1);
	
}
