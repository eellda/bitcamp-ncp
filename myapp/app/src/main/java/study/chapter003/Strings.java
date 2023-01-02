package study.chapter003;

import java.util.regex.Pattern;

public final class Strings {
  private static final Pattern PATTERN = Pattern.compile(" +");
  private static final String WHITESPACE = " ";

  private Strings() {
    throw new AssertionError("Cannot be instantiated");
  }

  public static String reverseWordsV1(String str) {

    if (str == null || str.isBlank()) {
      // or throw IllegalArgumentException
      return "";
    }

    String[] words = str.split(WHITESPACE);
    StringBuilder reversedString = new StringBuilder();
    for (String word : words) {
      StringBuilder reverseWord = new StringBuilder();
      for (int i = word.length() - 1; i >= 0; i--) {
        reverseWord.append(word.charAt(i));
      }
      reversedString.append(reverseWord).append(WHITESPACE);
    }
    return reversedString.toString();
  }
}

