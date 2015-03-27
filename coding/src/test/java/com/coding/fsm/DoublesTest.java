package com.coding.fsm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoublesTest {

  @Test
  public void integer() {
    assertEquals(123d, Doubles.tryParse("123"), Double.MIN_NORMAL);
  }

  @Test
  public void negativeInteger() {
    assertEquals(-12d, Doubles.tryParse("-12"), Double.MIN_NORMAL);
  }

  @Test
  public void realNumber() {
    assertEquals(23.53d, Doubles.tryParse("  +23.53  "), Double.MIN_NORMAL);
  }
}
