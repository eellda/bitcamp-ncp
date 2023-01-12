// 인스턴스 메서드 - 내장 변수 this
package com.eomcs.oop.ex03;

public class Exam0220 {

  static class A {

    int value;

    static void m1() {
      // 클래스 메서드는 인스턴스 주소 없이 호출되기 때문에
      // 인스턴스 주소를 받는 내장 변수가 없다.
      //      this.value = 100; // 컴파일 오류!
    }

    void m2() {
      // 인스턴스 메서드는 인스턴스 주소가 있어야만 호출되기 때문에
      // 인스턴스 주소를 받을 변수가 내장되어 있다.
      this.value = 100;
      // [pc: 0, pc: 8] local: this index: 0 type: com.eomcs.oop.ex03.Exam0220.A
    }

    void m3() {
      // 인스턴스 변수를 사용할 때 this를 생략할 수 있다.
      //this.value = 200;
      value = 200; // 앞에 자동으로 this가 붙는다.
    }

    void m4(int value) {
      // 로컬 변수의 이름이 인스턴스 이름과 같을 경우
      // this를 붙이지 않으면 로컬 변수를 가리킨다.
      value = 200; // 로컬 변수이다.

      this.value = 300; // 인스턴스 변수이다.
      // 따라서 로컬 변수가 아닌 인스턴스 변수를 가리키고 싶으면 this를 붙여야 한다.
    }
  }
  public static void main(String[] args) {
    // 클래스 메서드는 인스턴스 주소 없이 클래스 이름으로 호출한다.
    // 그래서 클래스 메서드는 this라는 내장 변수가 없는 것이다.
    A.m1();

    A obj1 = new A();

    // 인스턴스 메서드는 인스턴스 주소가 있어야만 호출할 수 있기 때문에
    // 인스턴스 메서드에는 인스턴스 주소를 받을 수 있는 내장 변수 this가 있다.
    obj1.m2();

    // 물론 클래스 메서드도 레퍼런스를 가지고 호출할 수 있지만,
    // 인스턴스 주소가 메서드에 전달되지 않는다.
    // 그래서 클래스 메서드는 내장 변수 this가 없다.
    obj1.m1();

    A obj2 = new A();

    // 인스턴스 메서드의 this 변수는 메서드를 호출할 때 전달한 인스턴스 주소 값을 가진다.
    // 그래서 메서드가 호출될 때 마다 this 변수의 값이 바뀐다.
    obj2.m2();
    obj2.m3();
    obj2.m4(100);

  }
}





