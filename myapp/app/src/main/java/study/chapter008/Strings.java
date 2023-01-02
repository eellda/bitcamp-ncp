package study.chapter008;

public class Strings {
  private Strings() {
    throw new AssertionError("Cannot be instantiated");
  }

  public static String removeWhitespaces(String str) {
    if (str == null || str.isEmpty()) {
      return "";
    }
    return str.replaceAll("\\s", "");
  }
}
