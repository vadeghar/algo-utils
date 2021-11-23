package com.algo.grow.model;

import java.util.List;

public class GrExpiryDetails {
	List<String> expiryDates;
	private String currentExpiry;
	private int expiryLotSize;
	
	public List<String> getExpiryDates() {
		return expiryDates;
	}
	public void setExpiryDates(List<String> expiryDates) {
		this.expiryDates = expiryDates;
	}
	public String getCurrentExpiry() {
		return currentExpiry;
	}
	public void setCurrentExpiry(String currentExpiry) {
		this.currentExpiry = currentExpiry;
	}
	public int getExpiryLotSize() {
		return expiryLotSize;
	}
	public void setExpiryLotSize(int expiryLotSize) {
		this.expiryLotSize = expiryLotSize;
	}
	
	
}	
