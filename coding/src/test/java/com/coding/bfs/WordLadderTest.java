package com.coding.bfs;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WordLadderTest {

  @Test
  public void ladderLengthTest() {
    Set<String> dict = new HashSet<String>() {{
      add("hot");
      add("dog");
    }};
    assertThat(new WordLadder().ladderLength("hot", "dog", dict), is(0));
  }
}
