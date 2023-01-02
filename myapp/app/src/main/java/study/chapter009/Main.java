package study.chapter009;

import java.util.concurrent.TimeUnit;

public class Main {
  // 구분자로 여러 문자열 합치기
  private static final String TEXT_1 = "Illinois";
  private static final String TEXT_2 = "Mathematics";
  private static final String TEXT_3 = "and";
  private static final String TEXT_4 = "Science";
  private static final String TEXT_5 = "Academy";

  public static void main(String[] args) {

    System.out.println("Join multiple string via Java 8, String.join():");

    long startTimeV1 = System.nanoTime();
    String stringV1 = String.join(" ", TEXT_1, TEXT_2, TEXT_3, TEXT_4, TEXT_5);
    displayExecutionTime(System.nanoTime() - startTimeV1);
    System.out.println("String: " + stringV1);

    System.out.println();
    System.out.println("Join multiple string via StringBuilder:");

    long startTimeV2 = System.nanoTime();
    String stringV2 = Strings.joinByDelimiterV1(' ', TEXT_1, TEXT_2, TEXT_3, TEXT_4, TEXT_5);
    displayExecutionTime(System.nanoTime() - startTimeV2);
    System.out.println("String: " + stringV2);

  }

  private static void displayExecutionTime(long time) {
    System.out.println("Execution time: " + time + " ns" + " (" +
        TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
  }
}
