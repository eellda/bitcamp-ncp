package study.chapter002;

import java.util.concurrent.TimeUnit;

public class Main {
  private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
      + "showed me that anything is possible and that you're never too young to think big. "
      + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
      + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
      + "computer science.";

  private static final String TEXT_CP = "😍 💕 I Ӝ love you Ӝ so much 😍";

  public static void main(Strings[] args) {
    System.out.println("Input text: \n" + TEXT + "\n");
    System.out.println("\n\n ASCII or 16 bits Unicod characters (less than 65,535 (0xFFFF)) examples:\n");
    System.out.println("Loop and break solution:");

    long startTimeV1 = System.nanoTime();
    char firstcharV1 = Strings.firstNonRepeateCharacterV1(TEXT);

    displayExecutionTime(System.nanoTime() - startTimeV1);
    System.out.println("Found character: " + firstcharV1);
  }

  private static void displayExecutionTime(long time) {
    System.out.println("Execution time: " + time + " ns" + " (" +
        TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
  }
}
