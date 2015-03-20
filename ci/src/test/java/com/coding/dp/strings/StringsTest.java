package com.coding.dp.strings;

import org.junit.Test;

import static com.coding.dp.strings.Strings.*;
import static org.junit.Assert.*;

public class StringsTest {

  @Test
  public void isInterleaveTest() {
    assertFalse(isInterleave("bc", "ab", "bbac"));
  }

  @Test
  public void isMatchTest(){
    assertTrue("('aaa', 'ab*ac*a') -> true", isMatch("aaa", "ab*ac*a"));
    assertTrue("('aaa', 'ab*a*c*a') -> true", isMatch("aaa", "ab*a*c*a"));
    assertFalse("('aaba', 'ab*a*c*a') -> false", isMatch("aaba", "ab*a*c*a"));
    assertTrue("('aa', '.*') -> true", isMatch("aa", ".*"));
    assertTrue("('aaa', '.*') -> true", isMatch("aaa", ".*"));
  }

  @Test
  public void minEditDistance_simpleSamples() {

  }

  @Test
  public void minEditDistance_realSamples() {
    assertEquals("балія - калій = 2", minDistance("балія", "калій"), 2);
    assertEquals("балія - магія = 2", minDistance("балія", "магія"), 2);
    assertEquals("балія - шавлія = 2", minDistance("балія", "шавлія"), 2);
    assertEquals("балія - нація = 2", minDistance("балія", "нація"), 2);
    assertEquals("балія - залік = 2", minDistance("балія", "залік"), 2);

    assertEquals("світність - вічність = 2", minDistance("світність", "вічність"), 2);
    assertEquals("світність - спішність = 2", minDistance("світність", "спішність"), 2);
    assertEquals("світність - овіяність = 2", minDistance("світність", "овіяність"), 2);

    assertEquals("доручання - моржування = 3", minDistance("доручання", "моржування"), 3);
    assertEquals("дорадити - торочити = 3", minDistance("дорадити", "торочити"), 3);
  }

  @Test
  public void lcs_checkCorrectnessForNulls() {
    String message = "The result should be NULL if some of parameters is NULL.";
    assertEquals(message, lcs("a", null), null);
    assertEquals(message, lcs(null, "a"), null);
    assertEquals(message, lcs(null, null), null);
  }

  @Test
  public void lcs_checkCorrectnessForEmptyString() {
    String message = "The result should be empty string if some of parameters is empty.";
    assertEquals(message, lcs("a", ""), "");
    assertEquals(message, lcs("", "a"), "");
    assertEquals(message, lcs("", ""), "");
  }

//  @Test
  public void lcs_checkCorrectnessForSimpleCases() {
    assertEquals("the same strings", lcs("a", "a"), "a");
    assertEquals("nothing in common", lcs("a", "b"), "");
    assertEquals("simple common part", lcs("ab", "bc"), "b");
  }
}