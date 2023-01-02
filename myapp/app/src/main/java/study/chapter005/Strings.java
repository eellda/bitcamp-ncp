package study.chapter005;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class Strings {
  private static final Set<Character> allVowels = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u'));

  private Strings() {
    throw new AssertionError("Cannot be instantiated");
  }

  public static Pair<Integer, Integer> countVowelsAndConsonantsV1(String str) {
    if (str == null || str.isBlank()) {
      return Pair.of(-1, -1);
    }
    str = str.toLowerCase();

    int vowels = 0;
    int consonants= 0;

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (allVowels.contains(ch)) {
        vowels++;
      } else if ((ch >= 'a' && ch <= 'z')) {
        consonants++;
      }
    }
    return Pair.of(vowels, consonants);
  }
}
