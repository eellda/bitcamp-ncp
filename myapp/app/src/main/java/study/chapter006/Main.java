package study.chapter006;

import java.util.concurrent.TimeUnit;

// 문자 빈도수 세기

public class Main {
  private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
      + "showed me that anything is possible and that you're never too young to think big. "
      + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
      + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
      + "computer science.";
  private static final char CHAR_TO_COUNT = 'u';
  private static final String TEXT_CP = "😍 I love 💕 you Ӝ so much 💕 😍";
  private static final String CHAR_TO_COUNT_CP = "Ӝ";
  private static final String CHAR_TO_COUNT_CPS = "😍";

  public static void main(String[] args) {
    System.out.println("Input text: \n" + TEXT + "\n");
    System.out.println("\n\n ASCII or 16 bits Unicode characters (less than 65.535 (0xFFFF)) examplse:\n");
    System.out.println("replace() based solution: ");

    long startTimeV1 = System.nanoTime();

    int countV1 = Strings.countOccurrencesOfACertainCharacterV1(TEXT, CHAR_TO_COUNT);
    displayExecutionTime(System.nanoTime() - startTimeV1);
    System.out.println("Character '" +CHAR_TO_COUNT + "' occured " + countV1 + " time(s)");

    System.out.println();
    //System.out.println("charAt() based solution:");
  }

  private static void displayExecutionTime(long time) {
    System.out.println("Execution time: " + time + " ns" + " (" + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
  }
}
