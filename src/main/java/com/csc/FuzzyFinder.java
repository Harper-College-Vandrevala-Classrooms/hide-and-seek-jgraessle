package com.csc;

import java.util.ArrayList;

public class FuzzyFinder {
  FuzzyListGenerator listGenerator = new FuzzyListGenerator();
  ArrayList<Fuzzy> fuzzies = listGenerator.randomizedRainbowFuzzies();
  String[] stringfuzzies = new String[fuzzies.size()];
  ArrayList<Fuzzy> fuzzies2 = listGenerator.sortedRainbowFuzzies();
  String[] stringfuzzies2 = new String[fuzzies2.size()];
  public FuzzyFinder() {
    for (int i = 0; i < fuzzies.size(); i++) {
      stringfuzzies[i] = fuzzies.get(i).color;
  }
    for (int i = 0; i < fuzzies2.size(); i++) {
      stringfuzzies2[i] = fuzzies2.get(i).color;
  }
  }
  public int LinearFuzzySearch(String[] numbers, String numberToFind) {
    for (int i = 0; i < numbers.length; i++) {
      if(numbers[i].equals(numberToFind)) {
        return i;
      }
    }
    return -1;
  }
  public int BinaryFuzzySearch(String[] numbers, String numberToFind) {
    int low = 0;
    int high = numbers.length - 1;

    while (low <= high) {
      int middlePosition = (low + high) / 2;
      String middleNumber = numbers[middlePosition];
      int compare = numberToFind.compareTo(middleNumber);
      if (numberToFind.equals(middleNumber)) {
        return middlePosition;
      }
      if (compare < 0) {
        high = middlePosition - 1;
      }
      else {
        low = middlePosition + 1;
      }
    }
    return -1;
  }
  
  public static void main(String args[]) {
    System.out.println("In addition to your search functions, you can write a main function if you wish!");
    FuzzyFinder fuzzyFinder = new FuzzyFinder();
    int output = fuzzyFinder.LinearFuzzySearch(fuzzyFinder.stringfuzzies, "gold");
    System.out.println(output);
    int output2 = fuzzyFinder.BinaryFuzzySearch(fuzzyFinder.stringfuzzies, "gold");
    System.out.println(output2);
    int output3 = fuzzyFinder.LinearFuzzySearch(fuzzyFinder.stringfuzzies2, "gold");
    System.out.println(output3);
    int output4 = fuzzyFinder.BinaryFuzzySearch(fuzzyFinder.stringfuzzies2, "gold");
    System.out.println(output4);
    
  }
}
