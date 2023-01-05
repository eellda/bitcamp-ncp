package study.chapter005;

import java.util.concurrent.TimeUnit;

public class Main {

  private static final String TEXT = " ... Illinois Mathematics & Science Acadamy ... ";

  public static void main(String[] args) {

    System.out.println("Input text: \n" + TEXT + "\n");
    System.out.println("String.charAt() soluction:");
    long startTimeV1 = System.nanoTime();

    Pair pairV1 = Strings.countVowelsAndConsonantsV1(TEXT);

    displayExecutionTime(System.nanoTime() - startTimeV1);
    System.out.println("Vowels:" + pairV1.vowels);
    System.out.println("Consonants: " + pairV1.consonants);
  }
  private static void displayExecutionTime(long time) {
    System.out.println("Execution time: " + time + " ns" + " (" +
        TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
  }
}
