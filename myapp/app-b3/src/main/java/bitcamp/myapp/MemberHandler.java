package bitcamp.myapp;

import java.sql.Date;

public class MemberHandler {

  static final int SIZE = 100;
  static int count = 0;

  // 레퍼런스 배열 준비
  static Member[] members = new Member[SIZE];

  static void inputMember() {

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

    members[count++] = m;

  }

  static void printMembers() {
    System.err.printf("번호\t이름\t전화\t재직\t전공\t\t가입일\n");
    for (int i = 0; i < count; i++) {
      Member m = members[i];
      String levelTitle;
      switch (m.level) {
        case 0: levelTitle = "비전공자"; break;
        case 1: levelTitle = "준전공자"; break;
        default: levelTitle = "전공자";
      }
      System.err.printf("%d\t%s\t%s\t%s\t%s\t%s\n", m.no, m.name, m.tel, m.working, levelTitle, m.createdDate);
    }
  }

  static void service() {
    while (true) {
      System.out.println("회원 메뉴");
      System.out.println();
      System.out.println("1. 등록");
      System.out.println("2. 목록");
      System.out.println("3. 조회");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 종료");
      System.out.println();
      System.out.println();

      int menuNo2 = Prompt.inputInt("메뉴 선택 >>  ");

      if (menuNo2 == 0) {
        break;
      } else if (menuNo2 == 1) {
        inputMember();
      } else if (menuNo2 == 2) {
        printMembers();
      } else {
        System.out.println("번호를 다시 입력 하세요.");
      }
    }
  }
}
