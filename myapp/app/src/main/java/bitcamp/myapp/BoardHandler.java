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

	static void listBoards() {
		System.out.println("번호\t제목\t\t작성일\t\t조회수");

		for (int i = 0; i < count; i++) {
			Board b = boards[i];
			System.out.printf("%d\t%s\t%s\t%d\n", b.no, b.title, b.createdDate, b.viewCount);
		}
	}

	static void detailBoard() {
		int boardNo = Prompt.inputInt("책 번호? ");
		Board b = findByNo(boardNo);
		if (b == null) {
			System.out.println("해당 번호의 책은 없습니다.");
			return;
		}
		System.out.printf("제목: %s\n", b.title);
		System.out.printf("내용: %s\n", b.content);
		System.out.printf("작성일: %s\n", b.createdDate);
		System.out.printf("조회수: %s\n", b.viewCount);
	}

	static Board findByNo (int no) {
		for (int i = 0; i < count; i++) {
			if (boards[i].no == no) {
				return boards[i];
			}
		}
		return null;
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
			case 2: listBoards(); break;
			case 3: detailBoard(); break;
			}
		}
	}
}
