package com.arolla.legacy.testing.quotebot;

import com.arolla.legacy.testing.thirdparty.quotebot.MarketStudyVendor;

import java.util.Arrays;

public class BlogAuctionTask {

    private final DataRetriever marketDataRetriever;
    private ITimeProvider timeProvider;
    private PublisherWrapper publisherWrapper;

    public BlogAuctionTask() {
        this(new DataRetrieverImpl(),new TimeProvider(), new PublisherWrapperImpl());
    }

    public BlogAuctionTask(DataRetriever marketDataRetriever, ITimeProvider timeProvider, PublisherWrapper publisherWrapper) {
        this.marketDataRetriever = marketDataRetriever;
        this.timeProvider = timeProvider;
        this.publisherWrapper = publisherWrapper;
    }

    @SuppressWarnings("deprecation")
    public void PriceAndPublish(String blog, String mode) {
        priceAndPublish(blog, mode);
    }

    public void priceAndPublish(String blog, String mode) {
        double averagePrice = marketDataRetriever.getAveragePrice(blog);
        long milliseconds = timeProvider.getMilliseconds();
        double proposal = averagePrice + 2;
        if (isEven(proposal)) {
            proposal = getProposalEvenPrices(proposal);
        } else {
            proposal = getProposalOddPrices(mode, milliseconds);
        }
        publisherWrapper.publish(proposal);
    }


	public static double getProposalEvenPrices(double proposal) {
        return 3.14 * proposal;
    }

    private static boolean isEven(double proposal) {
        return proposal % 2 == 0;
    }

    public static double getProposalOddPrices(String mode, long milliseconds) {
        return 3.15
                * Mode.timeFactor(mode)
                * milliseconds;
    }


    public enum Mode {
        DEFAULT("", 1),
        SLOW("SLOW", 2),
        MEDIUM("MEDIUM", 4),
        FAST("FAST", 8),
        ULTRAFAST("ULTRAFAST", 13);

        String name;
        double timeFactor;

        Mode(String name, double timeFactor) {
            this.name = name;
            this.timeFactor = timeFactor;
        }

        static double timeFactor(String name) {
            return Arrays.stream(values())
                    .filter(mode -> mode.name.equals(name))
                    .findFirst()
                    .orElse(DEFAULT).timeFactor;
        }
    }
}
