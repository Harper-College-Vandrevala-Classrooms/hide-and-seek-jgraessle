package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFuzzyFinder {

  FuzzyFinder finder;
  FuzzyListGenerator generator;

  @BeforeEach
  void setUp() {
    finder = new FuzzyFinder();
    generator = new FuzzyListGenerator();
  }
  @Test
  void RandomLinearTest() {
    ArrayList<Fuzzy> fuzzies = generator.randomizedRainbowFuzzies();
    assertEquals(3500, finder.LinearFuzzySearch(finder.stringfuzzies, "gold"), 3500);
  }
  @Test
  void RandomBinaryTest() {
    ArrayList<Fuzzy> fuzzies = generator.randomizedRainbowFuzzies();
    assertEquals(-1, finder.BinaryFuzzySearch(finder.stringfuzzies, "gold"));
  }
  @Test
  void SortedLinearTest() {
    ArrayList<Fuzzy> fuzzies = generator.randomizedRainbowFuzzies();
    assertEquals(1000, finder.LinearFuzzySearch(finder.stringfuzzies2, "gold"));
  }
  @Test
  void SortedBinaryTest() {
    ArrayList<Fuzzy> fuzzies = generator.randomizedRainbowFuzzies();
    assertEquals(1000, finder.BinaryFuzzySearch(finder.stringfuzzies2, "gold"));
  }

 
}
