package com.arolla.legacy.testing.quotebot;

import com.arolla.legacy.testing.thirdparty.quotebot.MarketStudyVendor;

public class DataRetrieverImpl implements DataRetriever {

	MarketStudyVendor marketDataRetriever = new MarketStudyVendor();
	@Override public double getAveragePrice(String blog) {
		return marketDataRetriever.averagePrice(blog);
	}
}
