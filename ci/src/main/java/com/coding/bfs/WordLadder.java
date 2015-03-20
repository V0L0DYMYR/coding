package com.coding.bfs;

import java.util.HashSet;
import java.util.Set;

public class WordLadder {
  char[] abc = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
      'u', 'v', 'w', 'x', 'y', 'z'};

  public int ladderLength(String start, String end, Set<String> dict) {
    int res = 0;

    if (!start.equals(end)) {
      res = 2;
      Set<String> visited = new HashSet<>();
      Set<String> words = new HashSet<>();
      words.add(start);


      while(!words.isEmpty()) {
        Set<String> nextWords = new HashSet<>();

        for(String word: words) {
          for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < abc.length; j++) {
              String newWord = word.substring(0, i) + abc[j] + word.substring(i+1);
              if (end.equals(newWord)) {
                return res;
              }
              if (dict.contains(newWord) && !visited.contains(newWord)) {
                nextWords.add(newWord);
              }
            }
          }
        }
        res++;
        visited.addAll(nextWords);
        words = nextWords;
      }
    }
    return 0;
  }
}
