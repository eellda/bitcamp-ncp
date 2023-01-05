package bitcamp.myapp;

import java.sql.Date;

public class MemberHandler {

  static final int SIZE = 100;
  static int count = 0;

  // 레퍼런스 배열 준비
  static Member[] members = new Member[SIZE];

  static void inputMembers() {

    Member m = new Member();
    m.no = Prompt.inputInt("번호? ");
    m.name = Prompt.inputString("이름? ");
    m.tel = Prompt.inputString("전화? ");
    m.postNo = Prompt.inputString("우편번호? ");
    m.basicAddress = Prompt.inputString("주소1? ");
    m.detailAddress = Prompt.inputString("주소2? ");
    m.working = Prompt.inputInt("0. 미취업\n1. 재직중\n재직자? ") == 1;
    m.gender = Prompt.inputInt("0. 남자\n1. 여자\n성별? ") == 0 ? 'M' : 'W';
    m.level = (byte) Prompt.inputInt("0. 비전공자\n1. 준전공자\n2. 전공자\n전공? ");
    m.createdDate = new Date(System.currentTimeMillis()).toString();

    // 지금 금방 만든 객체에 사용자가 입력한 값을 저장한 후
    // 그 객체의 주소를 잃어버리지 않게 레퍼런스 배열에 보관해 둔다.
    members[count++] = m;

  }

  static void printMember() {

    System.out.println("count\t name\t tel\t level\t job");
    for (int i = 0; i < count; i++) {
      Member m = members[i];

      String levelTitle;
      switch (m.level) {
        case 0: levelTitle = "비전공자"; break;
        case 1: levelTitle = "준전공자"; break;
        default: levelTitle = "전공자";
      }

      System.out.printf("%d\t%s\t%s\t%s\t%s\n",
          m.no, m.name, m.tel, m.working ? "No" : "Yes", levelTitle);

      //System.out.printf("가입일: %s\n", m.createdDate);

      //System.out.println("---------------------------------------1");
    }

  }

  static void service() {
    while (true) {
      System.out.println("<< Member management >>");
      System.out.println();
      System.out.println("1. Member regist");
      System.out.println("2. Member list");
      System.out.println("3. Member inquire");
      System.out.println("4. Member change");
      System.out.println("0. Exit");
      int iNum2 = Prompt.inputInt("input number >>");

      if (iNum2 == 0) {
        break;
      } else if (iNum2 == 1) {
        inputMembers();
      } else if (iNum2 == 2) {
        printMember();
      } else {
        System.out.println("Number is weird..!");
        System.out.println();
        System.out.println();
      }
    }
  }
}
