package programmers.even;

public class Solution {
  public static void main(String[] args) {
    int n = 6;
    int result = 0;

    for (int i = 1; i <= n; i ++) {
      if ((i % 2) == 0) {
        result += i;
      }
    }
    System.out.printf("n = %s 일때 짝수만 더한값 = %s", n, result);
  }
}
