package com.algo.grow.model;

public class GrOptionChain {
	private Integer strikePrice;
	private GrOptionData callOption;
	private GrOptionData putOption;
	
	public Integer getStrikePrice() {
		return strikePrice;
	}
	public void setStrikePrice(Integer strikePrice) {
		this.strikePrice = strikePrice;
	}
	public GrOptionData getCallOption() {
		return callOption;
	}
	public void setCallOption(GrOptionData callOption) {
		this.callOption = callOption;
	}
	public GrOptionData getPutOption() {
		return putOption;
	}
	public void setPutOption(GrOptionData putOption) {
		this.putOption = putOption;
	}
	
	
}
