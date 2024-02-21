package com.arolla.legacy.testing.quotebot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BlogAuctionTaskTest {

  @Test
  void idiot_Test_Un() {

    double proposal = BlogAuctionTask.getProposal("", 0, 0);
    Assertions.assertEquals(0,proposal);
  }
  @ParameterizedTest
  @CsvSource({"SLOW, 315.0","MEDIUM, 630.0"})
  void idiot_Mode_Slow(String mode, String expected) {

    double proposal = BlogAuctionTask.getProposal(mode, 0, 50);
    Assertions.assertEquals(Double.valueOf(expected),proposal);
  }


}