package bitcamp.myapp;

public class App {

  public static void main(String[] args) {

    goMainMenu();
    Prompt.close();
  } // main()

  private static void goMainMenu() {
    while (true) {
      System.out.println("메인 메뉴");
      System.out.println("1. 회원 메뉴");
      System.out.println("9. 종료");
      System.out.println();
      System.out.println();

      int menuNo = Prompt.inputInt("메뉴 선택 >>  ");

      if (menuNo == 1) {
        MemberHandler.service();
      } else if (menuNo == 9) {
        System.out.println("안녕히 가세요 ~!");
        break;
      } else {
        System.out.println("번호를 다시 입력 하세요.");
      }
    }
  }
} // class App




