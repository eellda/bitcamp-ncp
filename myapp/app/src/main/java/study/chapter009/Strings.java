package study.chapter009;

public class Strings {
  private Strings() {
    throw new AssertionError("Cannot be instantiated");
  }

  public static String joinByDelimiterV1(char delimiter, String... args) {
    if (args == null || args.length == 0) {
      // or throw IllegalArgumentException
      return "";
    }
    StringBuilder result = new StringBuilder();

    int i = 0;
    for (i = 0; i < args.length - 1; i++) {
      result.append(args[i]).append(delimiter);
    }
    result.append(args[i]);
    return result.toString();
  }
}
