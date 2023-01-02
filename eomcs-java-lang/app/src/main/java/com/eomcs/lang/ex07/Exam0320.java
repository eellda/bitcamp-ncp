package com.eomcs.lang.ex07;

//# 메서드 : call by reference
//
public class Exam0320 {

  static void swap(int[] arr) {
    System.out.printf("swap(): arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]); // 100 200
    int temp = arr[0];  // temp = 100
    arr[0] = arr[1];    // 100 => 200
    arr[1] = temp;      // 200 => temp = 100
    System.out.printf("swap(): arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]); // 200 100
  }

  public static void main(String[] args) {
    //int[] arr = new int[] {100, 200};
    int[] arr = {100, 200};
    swap(arr); // 배열 인스턴스(메모리)를 넘기는 것이 아니다.
    // 주소를 넘기는 것이다.
    // 그래서 "call by reference" 라 부른다.
    System.out.printf("main(): arr[0]=%d, arr[1]=%d\n", arr[0], arr[1]);
  }
}
// 주소를 call(호출) 한다 = call by reference