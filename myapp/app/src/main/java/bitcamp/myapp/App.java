package bitcamp.myapp;

public class App {

  public static void main(String[] args) {
    goMainMenu();
    System.out.println("안녕히 가세요!");

    // 프로그램이 사용한 자원 해제하기
    Prompt.close();
  } // main()

  private static void goMainMenu() {

    MemberHandler generalMemberHandler = new MemberHandler("일반 학생");
    // 일반 회원 목록을 저장할 목록을 준비한다.
    MemberHandler supportedMemberHandler = new MemberHandler("국비 지원 학생");
    // 국비 지원 학생 목록을 저장할 메모리를 준비한다.
    MemberHandler companyMemberHandler = new MemberHandler("위탁 교육생");
    // 기업 위탁 교육생 목록을 저장할 메모리를 준비한다.
    while (true) {
      System.out.println("1. 일반 학생 관리");
      System.out.println("2. 국비 지원 학생 관리");
      System.out.println("2. 위탁 교육생 관리");
      System.out.println("9. 종료");
      int menuNo = Prompt.inputInt("메뉴> ");

      if (menuNo == 1) {
        generalMemberHandler.service();
      } else if (menuNo == 2) {
        supportedMemberHandler.service();
      } else if (menuNo == 3) {
        companyMemberHandler.service();
      } else if (menuNo == 9) {
        break;
      } else {
        System.out.println("잘못된 메뉴 번호 입니다.");
      }
    }
  }
}









