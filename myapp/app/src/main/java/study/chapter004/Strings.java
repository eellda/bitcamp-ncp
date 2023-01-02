package study.chapter004;

public final class Strings {
  private Strings() {
    throw new AssertionError("Cannot be instantiated");
  }

  public static boolean containsOnlyDigitsV1(String str) {
    if (str == null || str.isBlank()) {
      return false;
    }

    for (int i = 0; i < str.length(); i++) {
      if (!Character.isDigit(str.charAt(i))) {
        return false;
      }
    }
    return true;
  }
}
