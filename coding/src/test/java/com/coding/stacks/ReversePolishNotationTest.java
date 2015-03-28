package com.coding.stacks;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ReversePolishNotationTest {

  @Test
  public void complexTest() {
    assertEquals((Integer)101, ReversePolishNotation.evaluate("1 2 3 + 4 5 * * +"));
  }
}
