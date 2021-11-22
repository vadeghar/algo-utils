package com.algo.opstra.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpstraSpotResponse {
	
	@JsonProperty("SpotPrice")
	private Long spotPrice;
	@JsonProperty("futuresPrice")
	private Double futuresPrice;
	@JsonProperty("iv")
	private Double iv;
	@JsonProperty("ivPercentile")
	private Double ivPercentile;
	@JsonProperty("lotsize")
	private Integer lotsize;
	@JsonProperty("strikes")
	private List<Integer> strikes;
	public Long getSpotPrice() {
		return spotPrice;
	}
	public void setSpotPrice(Long spotPrice) {
		this.spotPrice = spotPrice;
	}
	public Double getFuturesPrice() {
		return futuresPrice;
	}
	public void setFuturesPrice(Double futuresPrice) {
		this.futuresPrice = futuresPrice;
	}
	public Double getIv() {
		return iv;
	}
	public void setIv(Double iv) {
		this.iv = iv;
	}
	public Double getIvPercentile() {
		return ivPercentile;
	}
	public void setIvPercentile(Double ivPercentile) {
		this.ivPercentile = ivPercentile;
	}
	public Integer getLotsize() {
		return lotsize;
	}
	public void setLotsize(Integer lotsize) {
		this.lotsize = lotsize;
	}
	public List<Integer> getStrikes() {
		return strikes;
	}
	public void setStrikes(List<Integer> strikes) {
		this.strikes = strikes;
	}
	
}
