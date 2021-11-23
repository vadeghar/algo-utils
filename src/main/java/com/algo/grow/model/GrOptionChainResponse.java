package com.algo.grow.model;

import java.util.List;

public class GrOptionChainResponse {

	private List<GrOptionChain> optionChains;
	private GrExpiryDetails expiryDetailsDto;
	private GrOhlc livePrice;
	public GrOhlc getLivePrice() {
		return livePrice;
	}
	public void setLivePrice(GrOhlc livePrice) {
		this.livePrice = livePrice;
	}
	public List<GrOptionChain> getOptionChains() {
		return optionChains;
	}
	public void setOptionChains(List<GrOptionChain> optionChains) {
		this.optionChains = optionChains;
	}
	public GrExpiryDetails getExpiryDetailsDto() {
		return expiryDetailsDto;
	}
	public void setExpiryDetailsDto(GrExpiryDetails expiryDetailsDto) {
		this.expiryDetailsDto = expiryDetailsDto;
	}
	
	
}
