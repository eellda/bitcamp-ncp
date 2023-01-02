package study.chapter006;

public class Strings {
  private Strings() {
    throw new AssertionError("Cannot be instantiated");
  }

  public static int countOccurrencesOfACertainCharacterV1(String str, char ch) {
    if (str == null || str.isEmpty()) {
      return -1;
    }
    return str.length() - str.replace(String.valueOf(ch), "").length();
  }
}
