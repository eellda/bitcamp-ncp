package com.eomcs.oop.ex05.n;

// 추상 클래스
// => 서브클래스에게 공통 기능을 상속해주는 목적으로 만든 클래스이다.
// => 직접 사용하지 않는 클래스이다.
// => 즉 개발자에게 이 클래스를 상속 받아 새 클래스를 만들어 쓰라는 의미다!
public abstract class Car {

  public Car() {
    super();
  }

  public void start() {
    System.out.println("시동 건다!");
  }

  public void shutdown() {
    System.out.println("시동 끈다!");
  }

  // 추상 메서드
  // => 서브 클래스에서 재정의할 메서드라면 굳이 수퍼 클래스에서 구현하지 말라!
  // => 또는 서브 클래스에서 반드시 구현하도록 강제하고 싶다면 추상 메서드로 선언한다.
  // => 추상 메서드를 상속 받는 서브클래스는 반드시 구현해야 한다.
  //    만약 구현하지 않으면 추상 메서드인채로 남아 있기 때문에
  //    서브클래스도 추상클래스가 되어야 한다.
  //    일반 클래스는 인스턴스를 생성하여 메서드를 호출하기 때문에
  //    구현되지 않은 메서드를 갖는 것은 오류이다.
  //    그래서 일반 클래스는 추상 메서드를 가질 수 없다.
  // => 왜? 추상 메서드가 있다는 것은 해당 메서드를 실행할 수 없다는 것이고
  //       실행할 수 없는 메서드를 갖는 클래스는
  //       인스턴스를 생성해서는 안되기 때문에
  //       추상메서드를 갖는 클래스는 반드시 추상클래스여야 한다.
  //       일반 클래스는 추상메서드를 가질 수 없다.
  //
  public abstract void run() ;

}






