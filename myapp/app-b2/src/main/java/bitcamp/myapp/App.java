package bitcamp.myapp;

public class App {

  public static void main(String[] args) {
	  goMainMenu();
	  Prompt.close();
  }

private static void goMainMenu() {
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
			  MemberHandler.goFirstMenu();
		  } else if (menu == 9) {
			  System.out.println("안녕히 가세요~!");
			  break;
		  } else {
			  System.out.println("메뉴를 재대로 선택해 주세요!");
		  }
	  }
}
}









// 1. 먼저 회원 관리 리스트를 출력한다.
// 2. 메뉴 버튼을 골라야 하니 입력 기능을 만든다.
// 3. 메뉴를 고르면 그 메뉴의 리스트를 출력한다. ( 값 지정 )
// 4. 종료 기능 만들기 ( 탈출하기 위한 반복문 생성 )
// 5. 2번째 메뉴의 기능 구현하기.