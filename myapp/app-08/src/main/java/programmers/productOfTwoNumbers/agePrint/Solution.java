package programmers.productOfTwoNumbers.agePrint;

public class Solution {

  public static void main(String[] args) {
    //출생 년도 구하기
    int age = 40;
    System.out.printf("2022 년 기준 %d 살 이므로 %d 년생 입니다.", age, solution(age));
  }
  public static int solution(int age) {
    return 2022 - (age - 1);
  }
}
