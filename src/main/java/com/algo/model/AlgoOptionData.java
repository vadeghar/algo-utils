package com.algo.model;

public class AlgoOptionData {
	public double getDelta() {
		return delta;
	}
	public void setDelta(double delta) {
		this.delta = delta;
	}
	public double getGamma() {
		return gamma;
	}
	public void setGamma(double gamma) {
		this.gamma = gamma;
	}
	public double getIv() {
		return iv;
	}
	public void setIv(double iv) {
		this.iv = iv;
	}
	public double getTheta() {
		return theta;
	}
	public void setTheta(double theta) {
		this.theta = theta;
	}
	public double getVega() {
		return vega;
	}
	public void setVega(double vega) {
		this.vega = vega;
	}
	@Override
	public String toString() {
		return "AlgoOptionData [high=" + high + ", low=" + low + ", close=" + close + ", ltp=" + ltp + ", volume="
				+ volume + ", totalBuyQty=" + totalBuyQty + ", totalSellQty=" + totalSellQty + ", openInterest="
				+ openInterest + ", tradingSymbol=" + tradingSymbol + "]";
	}
	private double open;
    private double high;
    private double low;
    private double close;
    private double ltp;
    private double dayChange;
    private double dayChangePerc;
    private double lowPriceRange;
    private double highPriceRange;
    private long volume;
    private double totalBuyQty;
    private double totalSellQty;
    private long openInterest;
    private long prevOpenInterest;
    private long lastTradeQty;
    private long lastTradeTime;
    private String tradingSymbol;
    private double delta;
    private double gamma;
    private double iv;
    private double theta;
    private double vega;
    
    
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getHigh() {
		return high;
	}
	public void setHigh(double high) {
		this.high = high;
	}
	public double getLow() {
		return low;
	}
	public void setLow(double low) {
		this.low = low;
	}
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public double getLtp() {
		return ltp;
	}
	public void setLtp(double ltp) {
		this.ltp = ltp;
	}
	public double getDayChange() {
		return dayChange;
	}
	public void setDayChange(double dayChange) {
		this.dayChange = dayChange;
	}
	public double getDayChangePerc() {
		return dayChangePerc;
	}
	public void setDayChangePerc(double dayChangePerc) {
		this.dayChangePerc = dayChangePerc;
	}
	public double getLowPriceRange() {
		return lowPriceRange;
	}
	public void setLowPriceRange(double lowPriceRange) {
		this.lowPriceRange = lowPriceRange;
	}
	public double getHighPriceRange() {
		return highPriceRange;
	}
	public void setHighPriceRange(double highPriceRange) {
		this.highPriceRange = highPriceRange;
	}
	public long getVolume() {
		return volume;
	}
	public void setVolume(long volume) {
		this.volume = volume;
	}
	public double getTotalBuyQty() {
		return totalBuyQty;
	}
	public void setTotalBuyQty(double totalBuyQty) {
		this.totalBuyQty = totalBuyQty;
	}
	public double getTotalSellQty() {
		return totalSellQty;
	}
	public void setTotalSellQty(double totalSellQty) {
		this.totalSellQty = totalSellQty;
	}
	public long getOpenInterest() {
		return openInterest;
	}
	public void setOpenInterest(long openInterest) {
		this.openInterest = openInterest;
	}
	public long getPrevOpenInterest() {
		return prevOpenInterest;
	}
	public void setPrevOpenInterest(long prevOpenInterest) {
		this.prevOpenInterest = prevOpenInterest;
	}
	public long getLastTradeQty() {
		return lastTradeQty;
	}
	public void setLastTradeQty(long lastTradeQty) {
		this.lastTradeQty = lastTradeQty;
	}
	public long getLastTradeTime() {
		return lastTradeTime;
	}
	public void setLastTradeTime(long lastTradeTime) {
		this.lastTradeTime = lastTradeTime;
	}
	public String getTradingSymbol() {
		return tradingSymbol;
	}
	public void setTradingSymbol(String tradingSymbol) {
		this.tradingSymbol = tradingSymbol;
	}
    
    
}
