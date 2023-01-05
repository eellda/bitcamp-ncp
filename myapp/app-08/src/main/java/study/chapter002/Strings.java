package study.chapter002;

public final class Strings {
  private static final int EXTENDED_ASCII_CODES = 256;

  private Strings() {
    throw new AssertionError("Cannot be instantiated");
  }

  public static char firstNonRepeateCharacterV1(String str) {
    if (str == null || str.isBlank()) {
      return Character.MIN_VALUE;
    }

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      int count = 0;
      for (int j = 0; j < str.length(); j++) {
        if (ch == str.charAt(j) && i != j) {
          count++;
          break;
        }
      }

      if (count == 0) {
        return ch;
      }
    }

    return Character.MIN_VALUE;
  }
}
