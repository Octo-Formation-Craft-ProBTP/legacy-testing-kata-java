package com.arolla.legacy.testing.quotebot;

import java.util.Collection;

public class AutomaticQuoteBot {

	public void sendAllQuotes(String mode) {
		new Filtre(new AdSpace(new BlogsProviderImpl(), new CacheInstanceImpl()));
		Collection<String> blogs = AdSpace.getAdSpaces();
		for (String blog : blogs) {
			BlogAuctionTask auctionTask = new BlogAuctionTask();
			auctionTask.PriceAndPublish(blog, mode);
		}
	}
}
