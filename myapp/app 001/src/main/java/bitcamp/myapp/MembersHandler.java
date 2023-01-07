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

    System.out.println("count\tname\ttel\tlevel\tjob");
    for (int i = 0; i < count; i++) {

      Member m = members[i];

      System.out.printf("%d\t%s\t%s\t%s\t%s\n",
          m.no, m.name, m.tel, m.working ? 'N' : 'Y', getLevelText(m.level));

      //System.out.println("---------------------------");
    }
  }

  static void printMember() {

    int memberNo = Prompt.inputInt("회원 번호? >> ");
    // 입력 받은 번호를 가지고 배열에서 회원 데이터를 찾는다.

    Member m = findByNo(memberNo);

    if (m == null) {
      System.out.println("해당 번호는 회원이 없습니다.");
      return;
    }

    System.out.printf("    이름: %s\n", m.name);
    System.out.printf("전화번호: %s\n", m.tel);
    System.out.printf("우편번호: %s\n", m.postNo);
    System.out.printf("기본주소: %s\n", m.basicAdress);
    System.out.printf("상세주소: %s\n", m.detailAdress);
    System.out.printf("재직여부: %s\n", m.working ? "예" : "아니요");
    System.out.printf("    성별: %s\n", m.gender == 'M' ? "남자" : "여자");
    System.out.printf("    전공: %s\n", getLevelText(m.level));
    System.out.printf("  가입일: %s\n", m.createdDate);
    // 찾은 회원 데이터를 출력한다.
  }

  static String getLevelText(int level) {
    switch (level) {
      case 0: return "noBase";
      case 1: return "learning";
      default: return "master";
    }
  }

  static void modifyMember() {

    int memberNo = Prompt.inputInt("회원 번호? >> ");
    // 입력 받은 번호를 가지고 배열에서 회원 데이터를 찾는다.

    Member old = findByNo(memberNo);

    if (old == null) {
      System.out.println("해당 번호는 회원이 없습니다.");
      return;
    }

    Member m = new Member();
    // 변경할 데이터를 저장할 인스턴스

    m.no = old.no;
    m.createdDate = old.createdDate;
    m.name = Prompt.inputString(String.format("이름(%s)? ", old.name));
    m.tel = Prompt.inputString(String.format("번호(%s)? ", old.tel));
    m.postNo = Prompt.inputString(String.format("번호(%s)? ", old.postNo));
    m.basicAdress = Prompt.inputString(String.format("기본주소(%s)? ", old.basicAdress));
    m.detailAdress = Prompt.inputString(String.format("상세주소(%s)? ", old.detailAdress));
    m.working = Prompt.inputInt(String.format(
        "0. 무직\n1. 재직중\n여부(%s)? ", old.working ? "재직중" : "백수")) == 1;
    m.gender = Prompt.inputInt(String.format(
        "0. Man \n1. Girl \n성별(%s)? ", old.gender == 'M' ? "남자" : "여자")) == 0 ? 'M' : 'W';
    m.level = (byte) Prompt.inputInt(String.format(
        "0. 비전공 \n1. 공부중 \n2. 전공자 \n전공(%s)? ", getLevelText(old.level)));
    // 찾은 회원 데이터를 출력한다.
    String str = Prompt.inputString("정말 변경 할거임? (y/N) ");
    if (str.equalsIgnoreCase("Y")) {
      members[indexOf(old)] = m;
      System.out.println("변경 했습니다.");
    } else {
      System.out.println("변경 취소했습니다.");
    }
  }

  static void deleteMember() {

    int memberNo = Prompt.inputInt("회원 번호? >> ");
    // 입력 받은 번호를 가지고 배열에서 회원 데이터를 찾는다.


    Member m = findByNo(memberNo);

    if (m == null) {
      System.out.println("해당 번호는 회원이 없습니다.");
      return;
    }

    String str = Prompt.inputString("정말 변경 삭제 하시겠습니까? (y/N) ");
    if (!str.equalsIgnoreCase("Y")) {
      System.out.println("삭제 취소 했습니다.");
      return;
    }

    for (int i = indexOf(m) + 1; i < count; i++) {
      members[i - 1] = members[i];
    }
    //count--;
    members[--count] = null; // 레퍼런스 카운트를 줄인다.
    System.out.println("삭제 했습니다.");
  }

  static Member findByNo (int no) {
    for (int i = 0; i <count; i++) {
      if (members[i].no == no) {
        return members[i];
      }
    }
    return null;
  }

  static int indexOf (Member m) {
    for (int i = 0; i <count; i++) {
      if (members[i].no == m.no) {
        return i;
      }
    }
    return -1;
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
      int menuNo = Prompt.inputInt("회원 관리 >> ");

      switch(menuNo) {
        case 0: return;
        case 1: inputMember(); break;
        case 2: printMembers(); break;
        case 3: printMember(); break;
        case 4: modifyMember(); break;
        case 5: deleteMember(); break;
        default:
          System.out.println("잘못된 메뉴 번호야.");
      }
    }
  }
}
