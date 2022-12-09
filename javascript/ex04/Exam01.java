class Exam01 {

  public static void main(String[] args) {
    System.out.println("hello");

    // 설계도
    class Student {
      String name;
      int age;
      boolean working;
    }
    
    // 설계도에 따라 객체 생성 (메모리 준비)
    Student obj = new Student();

    // 객체 프로퍼티에 값 저장
    obj.name = "아이유";
    obj.age = 28;
    obj.working = true;
    obj.tel = "02-123-1234";
    // 설계도에 없는 프로퍼티는 사용할 수 없다.

    // 객체 프로퍼티에 저장된 값 꺼내기
    System.out.println(obj.name);
    System.out.println(obj.age);
    System.out.println(obj.working);
  }
}