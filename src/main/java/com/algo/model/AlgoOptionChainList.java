package com.algo.model;

import java.util.List;

public class AlgoOptionChainList {
	@Override
	public String toString() {
		return "AlgoOptionChainList [optionChainList=" + optionChainList + "]";
	}

	private List<AlgoOptionChain> optionChainList;

	public List<AlgoOptionChain> getOptionChainList() {
		return optionChainList;
	}

	public void setOptionChainList(List<AlgoOptionChain> optionChainList) {
		this.optionChainList = optionChainList;
	}
	
}
