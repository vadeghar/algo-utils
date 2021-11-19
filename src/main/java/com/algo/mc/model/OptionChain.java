package com.algo.mc.model;

import java.util.List;

public class OptionChain {
	private List<OptionData> optionDataList;
	private String scriptName;
	private String expiry;
	private String atmStrike;
	private Long lastUpdated;
	
	public List<OptionData> getOptionDataList() {
		return optionDataList;
	}
	public void setOptionDataList(List<OptionData> optionDataList) {
		this.optionDataList = optionDataList;
	}
	public String getScriptName() {
		return scriptName;
	}
	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	public String getAtmStrike() {
		return atmStrike;
	}
	public void setAtmStrike(String atmStrike) {
		this.atmStrike = atmStrike;
	}
	public Long getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Long lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	
	
	
}
