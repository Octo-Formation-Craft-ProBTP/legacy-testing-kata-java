package com.arolla.legacy.testing.quotebot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BlogAuctionTaskTest {

  @Test
  void idiot_Test_Un() {

    double proposal = BlogAuctionTask.getProposalOddPrices("", 0);
    Assertions.assertEquals(0,proposal);
  }
  @ParameterizedTest
   @CsvSource({"SLOW, 6.28","MEDIUM, 6.28", "FAST, 6.28", "ULTRAFAST, 6.28", "\"\",6.28" })
  void Test_TousMode_mms(String mode, String expected) {

    double proposal = BlogAuctionTask.getProposalEvenPrices(2);
    Assertions.assertEquals(Double.valueOf(expected),proposal);
  }

  @ParameterizedTest
  @CsvSource({"SLOW, 315.0","MEDIUM, 630.0", "FAST, 1260.0", "ULTRAFAST, 2047.4999999999998", "\"\",157.5" })
  void Test_TousMode_avgprice(String mode, String expected) {
    MyPublisherWrapper publisherWrapper = new MyPublisherWrapper();
    BlogAuctionTask blogAuctionTask = new BlogAuctionTask(new MyDataRetriever(), new MyITimeProvider(),
            publisherWrapper);
    blogAuctionTask.priceAndPublish("",mode);
    Assertions.assertEquals(Double.valueOf(expected),publisherWrapper.proposal);
  }

  private static class MyDataRetriever implements DataRetriever {
    @Override public double getAveragePrice(String blog) {
      return 1;
    }
  }

  private static class MyITimeProvider implements ITimeProvider {
    @Override public long getMilliseconds() {
      return 50;
    }
  }

  private static class MyPublisherWrapper implements PublisherWrapper {
    double proposal;
    @Override public void publish(double proposal) {
      this.proposal = proposal;
    }
  }
}
