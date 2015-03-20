package com.coding.base;

public class Pair<F, S> {

  private final F first;
  private final S second;

  public Pair(F first, S second) {
    if (first == null || second == null) {
      throw new NullPointerException();
    }
    this.first = first;
    this.second = second;
  }

  public static <F, S> Pair<F, S> of(F first, S second) {
    return new Pair<>(first, second);
  }

  public F getFirst() {
    return first;
  }

  public S getSecond() {
    return second;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Pair pair = (Pair) o;

    if (!first.equals(pair.first)) return false;
    if (!second.equals(pair.second)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = first.hashCode();
    result = 31 * result + second.hashCode();
    return result;
  }

  @Override
  public String toString() {
    return String.format("[%s, %s]", first.toString(), second.toString());
  }
}
