package com.algo.opstra.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpstraResponse {
	@JsonProperty("optioniv")
	private String optionIv;
	@JsonProperty("optionprice")
	private String optionPrice;
	
	public String getOptionIv() {
		return optionIv;
	}
	public void setOptionIv(String optionIv) {
		this.optionIv = optionIv;
	}
	public String getOptionPrice() {
		return optionPrice;
	}
	public void setOptionPrice(String optionPrice) {
		this.optionPrice = optionPrice;
	}
	
	
}
