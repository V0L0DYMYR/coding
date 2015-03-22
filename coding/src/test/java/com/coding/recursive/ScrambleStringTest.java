package com.coding.recursive;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScrambleStringTest {

  @Test
  public void isScrambleTest() {
    assertThat(new ScrambleString().isScramble("abc", "cba"), is(true));
  }
}
