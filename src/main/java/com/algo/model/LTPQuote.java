package com.algo.model;


/**
 * A wrapper for instrument token, OHLC data.
 */
public class LTPQuote {
	public LTPQuote(long instrumentToken, double lastPrice) {
		this.instrumentToken = instrumentToken;
		this.lastPrice = lastPrice;
	}
	public LTPQuote() {
		
	}
    public long instrumentToken;
    public double lastPrice;
    
	@Override
	public String toString() {
		return "LTPQuote [instrumentToken=" + instrumentToken + ", lastPrice=" + lastPrice + "]";
	}

}
