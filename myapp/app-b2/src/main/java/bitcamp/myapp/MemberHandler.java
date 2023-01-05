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
      members[count++] = m;
  }

  static void printMembers() {
	  System.out.println("번호\t이름\t전화\t우편\t주소\t가입일");
    for (int i = 0; i < count; i++) {
    	Member m = members[i];
      System.out.printf("%d\t%s\t%s\t%s\t%s\t%s\n", m.no, m.name, m.tel, m.postNo, m.basicAddress, m.createdDate);
    }
  }

static void goFirstMenu() {
	while (true) {
		  System.out.println("<<---회원 관리--->>");
		  System.out.println();
		  System.out.println("1. 등록");
		  System.out.println("2. 목록");
		  System.out.println("3. 조회");
		  System.out.println("4. 변경");
		  System.out.println("5. 삭제");
		  System.out.println("0. 이전");
		  System.out.println();
		  System.out.println();
		  System.out.println();
		  System.out.println();
		  System.out.println();
		  int menu2 = Prompt.inputInt("내가 고를 메뉴는... >");
		  
		  if (menu2 == 0) {
			  break;
		  } else if (menu2 == 1) {
			  inputMembers();
		  } else if (menu2 == 2) {
			  printMembers();
		  } else if (3 <= menu2 && menu2 <= 5) {
			  System.out.println("현재 오픈 예정 입니다.");
		  } else {
			  System.out.println("메뉴를 재대로 선택해 주세요!");
		  }
	  }
}

static void goMainMenu() {
	while (true) {
		  System.out.println("<<---메인 화면--->>");
		  System.out.println();
		  System.out.println("1. 회원 관리");
		  System.out.println("9. 종료");
		  System.out.println();
		  System.out.println();
		  System.out.println();
		  System.out.println();
		  System.out.println();
		  int menu = Prompt.inputInt("내가 고를 메뉴는... >");
		  
		  if (menu == 1) {
			  goFirstMenu();
		  } else if (menu == 9) {
			  System.out.println("안녕히 가세요~!");
			  break;
		  } else {
			  System.out.println("메뉴를 재대로 선택해 주세요!");
		  }
	  }
}
}
