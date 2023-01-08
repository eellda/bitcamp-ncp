package bitcamp.myapp;

import java.sql.Date;

public class BoardHandler {
	static final int SIZE = 100;
	static int count;

	static Board[] boards = new Board[SIZE];

	static void inputBoard() {
		Board b = new Board();
		b.no = Prompt.inputInt("번호? ");
		b.title = Prompt.inputString("제목? ");
		b.content = Prompt.inputString("내용? ");
		b.createdDate = new Date(System.currentTimeMillis()).toString();

		boards[count++] = b;
	}

	static void service() {
		while (true) {
			System.out.println("책 메뉴");
			System.out.println("1. 입력");
			System.out.println("2. 목록");
			System.out.println("3. 조회");
			System.out.println("4. 변경");
			System.out.println("5. 삭제");
			System.out.println("0. 이전");
			int menuNo = Prompt.inputInt("메뉴 번호? ");

			switch (menuNo) {
			case 0: return;
			case 1: inputBoard(); break;
			}
		}
	}
}
