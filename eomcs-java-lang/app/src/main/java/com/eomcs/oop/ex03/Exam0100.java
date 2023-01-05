// # 변수의 종류
//
package com.eomcs.oop.ex03;

public class Exam0100 {

  static int a;
  // static field = class field(변수)
  // 클래스를 로딩할 때 method area 영역에 생성됨
  // 클래스는 단 한번만 로딩됨
  // 따라서 스태틱 변수도 한번만 생성됨
  // JVM 을 종료할 때 메모리에서  한꺼번에 제거됨

  int b;
  // non-static field = instance field
  // new 연산자를 실행할 때 heap 영역에 생성
  // new 연산자를 실행할 때마다 생성
  // garbage-collector 에 의해 인스턴스가 해제될 때 제거됨

  public static void main(String[] args /*파라미터 = 로컬변수*/) {

    int c;
    c = 100;
    // local 변수
    // 메소드가 호출될 때 JVM stack 영역에 생성
    // 메소드 호출이 끝나면 제거


    // <--- 현재 실행 시점 --->
    // method area: a 변수 존재
    // JVM Stack: args, c 변수 존재
    // heap: 아직 객체 없음

    Exam0100 obj; // obj는 main() 을 호출할 때 시작 시점에 JVM Stack에 생성된 상태

    obj = new Exam0100();

    // <--- 현재 실행 시점 --->
    // method area: a 변수 존재
    // JVM Stack: args, c 변수 존재
    // heap: b 변수 존재

    System.out.println(c);
  }
}


