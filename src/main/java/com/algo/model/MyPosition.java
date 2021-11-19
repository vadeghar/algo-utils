package com.algo.model;

public class MyPosition {
	
	private String tradingSymbol;
	private String positionType;
	private String symbol;
	private String expiry;
	private String strikePrice;
	private String optionType;
	private Double sellPrice;
	private Double buyPrice;
	private Double currentPrice;
	private Integer netQuantity;
	private Integer sellQuantity;
	private Integer buyQuantity;
	private Double positionPnl;
	private String startDate;
	private String endDate;
	
	public String getTradingSymbol() {
		return tradingSymbol;
	}
	public void setTradingSymbol(String tradingSymbol) {
		this.tradingSymbol = tradingSymbol;
	}
	public String getPositionType() {
		return positionType;
	}
	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}
	public Double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(Double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public Double getBuyPrice() {
		return buyPrice;
	}
	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}
	public Double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(Double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public Integer getNetQuantity() {
		return netQuantity;
	}
	public void setNetQuantity(Integer netQuantity) {
		this.netQuantity = netQuantity;
	}
	public Double getPositionPnl() {
		return positionPnl;
	}
	public void setPositionPnl(Double positionPnl) {
		this.positionPnl = positionPnl;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public String getStrikePrice() {
		return strikePrice;
	}
	public void setStrikePrice(String strikePrice) {
		this.strikePrice = strikePrice;
	}
	public String getOptionType() {
		return optionType;
	}
	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}
	public Integer getSellQuantity() {
		return sellQuantity;
	}
	public void setSellQuantity(Integer sellQuantity) {
		this.sellQuantity = sellQuantity;
	}
	public Integer getBuyQuantity() {
		return buyQuantity;
	}
	public void setBuyQuantity(Integer buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	

}
