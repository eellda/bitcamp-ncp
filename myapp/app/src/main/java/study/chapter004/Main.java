package study.chapter004;

import java.util.concurrent.TimeUnit;

public class Main {
  private static final String ONLY_DIGITS = "45566336754493420932877387482372374982374823"
      + "749823283974232237238472392309230923849023848234580383485342234287943943094"
      + "234745374657346578465783467843653748654376837463847654382382938793287492326";

  private static final String NOT_ONLY_DIGITS = "45566336754493420932877387482372374982374823"
      + "749823283974232237238472392309230923849023848234580383485342234287943943094"
      + "234745374657346578465783467843653748654376837463847654382382938793287492326A";

  public static void main(String[] args) {
    System.out.println("Input text with only digits: \n" + ONLY_DIGITS + "\n");
    System.out.println("Input text with other characters: \n" + NOT_ONLY_DIGITS + "\n");
    System.out.println("Character.isDigit() solution:");

    long startTimeV1 = System.nanoTime();

    boolean onlyDigitsV11 = Strings.containsOnlyDigitsV1(ONLY_DIGITS);
    boolean onlyDigitsV12 = Strings.containsOnlyDigitsV1(NOT_ONLY_DIGITS);
    System.out.println();

    displayExecutionTime(System.nanoTime() - startTimeV1);
    System.out.println("Contains only digits: " + onlyDigitsV11);
    System.out.println("Contains only digits: " + onlyDigitsV12);
    System.out.println();
  }
  private static void displayExecutionTime(long time) {
    System.out.println("Execution time: " + time + " ns" + " (" +
        TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
  }
}

