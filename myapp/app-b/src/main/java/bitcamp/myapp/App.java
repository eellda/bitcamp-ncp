package bitcamp.myapp;

public class App {

  public static void main(String[] args) {
    goMainTo();
    System.out.println("Good Bye~");
    Prompt.close();
  }

  private static void goMainTo() {
    while (true) {
      System.out.println("Main menu");
      System.out.println();
      System.out.println("1. Member management");
      System.out.println("9. Exit");
      int iNum = Prompt.inputInt("input number >>");

      if (iNum == 1) {
        MemberHandler.service();
      } else if (iNum == 9) {
        break;
      } else {
        System.out.println("Number is weird..!");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
      }
    }
  }
}










