package com.algo.opstra.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpstOptionChain {
	
	@JsonProperty("atmstrike")
	private Long atmStrike;
	@JsonProperty("futuresprice")
	private Double futuresPrice;
	@JsonProperty("spotprice")
	private Double spotPrice;
	@JsonProperty("data")
	private List<OpstOptionData> data;
	
	public Long getAtmStrike() {
		return atmStrike;
	}
	public void setAtmStrike(Long atmStrike) {
		this.atmStrike = atmStrike;
	}
	public Double getFuturesPrice() {
		return futuresPrice;
	}
	public void setFuturesPrice(Double futuresPrice) {
		this.futuresPrice = futuresPrice;
	}
	public Double getSpotPrice() {
		return spotPrice;
	}
	public void setSpotPrice(Double spotPrice) {
		this.spotPrice = spotPrice;
	}
	public List<OpstOptionData> getData() {
		return data;
	}
	public void setData(List<OpstOptionData> data) {
		this.data = data;
	}
	
	
}
