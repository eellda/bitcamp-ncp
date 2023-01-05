package programmers.productOfTwoNumbers.protactor;

public class Solution {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    System.out.println(solution(161));

  }
  public static int solution(int angle) {

    if (angle == 180) {
      return 4;
    } else if (angle > 90) {
      return 3;
    } else if (angle == 90) {
      return 2;
    } else {
      return 1;
    }
  }
}
