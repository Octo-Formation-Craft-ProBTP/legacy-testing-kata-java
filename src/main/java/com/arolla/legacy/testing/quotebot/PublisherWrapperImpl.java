package com.arolla.legacy.testing.quotebot;

import com.arolla.legacy.testing.thirdparty.quotebot.QuotePublisher;

public class PublisherWrapperImpl implements PublisherWrapper {
    public void publish(double proposal) {
        QuotePublisher.INSTANCE.publish(proposal);
    }
}
