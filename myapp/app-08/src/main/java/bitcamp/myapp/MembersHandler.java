package bitcamp.myapp;

import java.sql.Date;

public class MembersHandler {

  static final int SIZE = 100; // 중간에 size 변경을 막기 위해 final 을 써줌
  static int count = 0;

  static Member[] members = new Member[SIZE]; // 레퍼런스의 배열임

  static int[] no = new int[SIZE]; // 선언과 동시에 배열 크기 할당
  static String[] tel = new String[SIZE];
  static String[] name = new String[SIZE];
  static String[] postNo = new String[SIZE];
  static String[] basicAdress = new String[SIZE];
  static String[] detailAdress = new String[SIZE];
  static String[] createdDate = new String[SIZE];
  static boolean[] working = new boolean[SIZE];
  static char[] gender = new char[SIZE];
  static byte[] level = new byte[SIZE];

  static void inputMember() {

    Member m = new Member();

    m.no = Prompt.inputInt("count? ");
    m.name = Prompt.inputString("name? ");
    m.tel = Prompt.inputString("phone number? ");
    m.postNo = Prompt.inputString("Post Number? ");
    m.basicAdress = Prompt.inputString("Adress1? ");
    m.detailAdress = Prompt.inputString("Adress2? ");
    m.working = Prompt.inputInt("0. No working \n1. im working\nAre you working? ") == 1;
    m.gender = Prompt.inputInt("0. Man \n1. Girl \nWhat is your gender? ") == 0 ? 'M' : 'W';
    m.level = (byte) Prompt.inputInt("0. no Base \n1. learning \n2. master \nUniversity? ");
    m.createdDate = new Date(System.currentTimeMillis()).toString();

    members[count++] = m;
  }

  static void printMembers() {
    System.out.println("count\t name\t tel\t level\t job");
    for (int i = 0; i < count; i++) {

      Member m = members[i];
      String levelTitle;
      switch (m.level) {
        case 0: levelTitle = "noBase"; break;
        case 1: levelTitle = "learning"; break;
        default: levelTitle = "master";
      }
      System.out.printf("%d\t%s\t%s\t%s\t%s\n",
          m.no, m.name, m.tel,
          m.working ? 'N' : 'Y', levelTitle);

      //System.out.println("---------------------------");
    }
  }

  static void service() {
    while (true) {
      System.out.println("<회원 관리>");
      System.out.println();
      System.out.println("1. 등록 하기");
      System.out.println("2. 목록 조회");
      System.out.println("3. 조회 하기");
      System.out.println("4. 변경 하기");
      System.out.println("5. 삭제 하기");
      System.out.println("0. 이전");
      System.out.println();
      int menuNo = Prompt.inputInt("회원 관리>> ");

      if (menuNo == 0) {
        break;
      } else if (menuNo == 1) {
        inputMember();
      } else if (menuNo == 2){
        printMembers();
      } else if (menuNo >= 3 && menuNo <= 5) {
        System.out.println("작업 실행~");
      } else {
        System.out.println("잘못된 메뉴 번호야.");
      }
    }
  }
}
