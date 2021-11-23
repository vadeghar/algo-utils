package com.algo.grow.model;

public class GrOhlc {
	private String  type;
	private String symbol;
	private double open;
	private double high;
	private double low;
	private double close;
	private double ltp;
	private long volume;
	private long tsInMillis;
	private double lowPriceRange;
	private double highPriceRange;
	private long totalBuyQty;
	private long totalSellQty;
	private double dayChange;
	private double dayChangePerc;
	private long openInterest;
	private long lastTradeQty;
	private long lastTradeTime;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
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
	public long getVolume() {
		return volume;
	}
	public void setVolume(long volume) {
		this.volume = volume;
	}
	public long getTsInMillis() {
		return tsInMillis;
	}
	public void setTsInMillis(long tsInMillis) {
		this.tsInMillis = tsInMillis;
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
	public long getTotalBuyQty() {
		return totalBuyQty;
	}
	public void setTotalBuyQty(long totalBuyQty) {
		this.totalBuyQty = totalBuyQty;
	}
	public long getTotalSellQty() {
		return totalSellQty;
	}
	public void setTotalSellQty(long totalSellQty) {
		this.totalSellQty = totalSellQty;
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
	public long getOpenInterest() {
		return openInterest;
	}
	public void setOpenInterest(long openInterest) {
		this.openInterest = openInterest;
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
	
	
}
