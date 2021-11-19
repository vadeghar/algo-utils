package com.algo.opstra.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OpstOptionData {
	
	@JsonProperty("CallDelta")
	private String callDelta;
	@JsonProperty("CallGamma")
	private String callGamma;
	@JsonProperty("CallIV")
    private String callIV;
	@JsonProperty("CallLTP")
    private String callLTP;
	@JsonProperty("CallTheta")
    private String callTheta;
	@JsonProperty("CallVega")
    private String callVega;
	@JsonProperty("PutDelta")
    private String putDelta;
	@JsonProperty("PutGamma")
    private String putGamma;
	@JsonProperty("PutIV")
    private String putIV;
	@JsonProperty("PutLTP")
    private String putLTP;
	@JsonProperty("PutTheta")
    private String putTheta;
	@JsonProperty("PutVega")
    private String putVega;
	@JsonProperty("StrikePrice")
    private String strikePrice;
	
	public String getCallDelta() {
		return callDelta;
	}
	public void setCallDelta(String callDelta) {
		this.callDelta = callDelta;
	}
	public String getCallGamma() {
		return callGamma;
	}
	public void setCallGamma(String callGamma) {
		this.callGamma = callGamma;
	}
	public String getCallIV() {
		return callIV;
	}
	public void setCallIV(String callIV) {
		this.callIV = callIV;
	}
	public String getCallLTP() {
		return callLTP;
	}
	public void setCallLTP(String callLTP) {
		this.callLTP = callLTP;
	}
	public String getCallTheta() {
		return callTheta;
	}
	public void setCallTheta(String callTheta) {
		this.callTheta = callTheta;
	}
	public String getCallVega() {
		return callVega;
	}
	public void setCallVega(String callVega) {
		this.callVega = callVega;
	}
	public String getPutDelta() {
		return putDelta;
	}
	public void setPutDelta(String putDelta) {
		this.putDelta = putDelta;
	}
	public String getPutGamma() {
		return putGamma;
	}
	public void setPutGamma(String putGamma) {
		this.putGamma = putGamma;
	}
	public String getPutIV() {
		return putIV;
	}
	public void setPutIV(String putIV) {
		this.putIV = putIV;
	}
	public String getPutLTP() {
		return putLTP;
	}
	public void setPutLTP(String putLTP) {
		this.putLTP = putLTP;
	}
	public String getPutTheta() {
		return putTheta;
	}
	public void setPutTheta(String putTheta) {
		this.putTheta = putTheta;
	}
	public String getPutVega() {
		return putVega;
	}
	public void setPutVega(String putVega) {
		this.putVega = putVega;
	}
	public String getStrikePrice() {
		return strikePrice;
	}
	public void setStrikePrice(String strikePrice) {
		this.strikePrice = strikePrice;
	}
	@Override
	public String toString() {
		return "OpstOptionData [callDelta=" + callDelta + ", callIV=" + callIV + ", callLTP=" + callLTP + ", putDelta="
				+ putDelta + ", putIV=" + putIV + ", putLTP=" + putLTP + ", strikePrice=" + strikePrice + "]";
	}
	
	
}
