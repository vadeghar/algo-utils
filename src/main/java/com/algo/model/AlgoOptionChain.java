package com.algo.model;

public class AlgoOptionChain {
	@Override
	public String toString() {
		return "AlgoOptionChain [strikePrice=" + strikePrice + ", callOption=" + callOption + ", putOption=" + putOption
				+ "]";
	}
	private Integer strikePrice;
	private AlgoOptionData callOption;
	private AlgoOptionData putOption;
	
	public Integer getStrikePrice() {
		return strikePrice;
	}
	public void setStrikePrice(Integer strikePrice) {
		this.strikePrice = strikePrice;
	}
	public AlgoOptionData getCallOption() {
		return callOption;
	}
	public void setCallOption(AlgoOptionData callOption) {
		this.callOption = callOption;
	}
	public AlgoOptionData getPutOption() {
		return putOption;
	}
	public void setPutOption(AlgoOptionData putOption) {
		this.putOption = putOption;
	}
	
	
}
