package com.algo.mc.model;

public class OptionData {
	
	private String optionType;
	private String strikePrice;
	private String ltp;
	private String changeInLtp;
	private String volume;
	private String oiChange;
	private String oi;
	public String getOptionType() {
		return optionType;
	}
	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}
	public String getStrikePrice() {
		return strikePrice;
	}
	public void setStrikePrice(String strikePrice) {
		this.strikePrice = strikePrice;
	}
	public String getLtp() {
		return ltp;
	}
	public void setLtp(String ltp) {
		this.ltp = ltp;
	}
	public String getChangeInLtp() {
		return changeInLtp;
	}
	public void setChangeInLtp(String changeInLtp) {
		this.changeInLtp = changeInLtp;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getOiChange() {
		return oiChange;
	}
	public void setOiChange(String oiChange) {
		this.oiChange = oiChange;
	}
	public String getOi() {
		return oi;
	}
	public void setOi(String oi) {
		this.oi = oi;
	}
	@Override
	public String toString() {
		return "OptionData [optionType=" + optionType + ", strikePrice=" + strikePrice + ", ltp=" + ltp
				+ ", changeInLtp=" + changeInLtp + ", volume=" + volume + ", oiChange=" + oiChange + ", oi=" + oi + "]";
	}
	
	
}
