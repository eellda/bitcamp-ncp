package programmers.productOfTwoNumbers.compareOfTwoNumbers;

public class Solution {

  public static void main(String[] args) {
    // 숫자 비교
    System.out.println(solution(7, 99));
  }

  public static int solution(int num1, int num2) {
    if (num1 == num2) {
      return 1;
    }
    return -1;
  }
}
