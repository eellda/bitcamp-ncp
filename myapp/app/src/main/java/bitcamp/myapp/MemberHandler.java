package bitcamp.myapp;

import java.sql.Date;

public class MemberHandler {

	static final int SIZE = 100;
	static int count = 0;

	static Member[] members = new Member[SIZE];

	static void inputMembers() {

		for (int i = 0; i < SIZE; i++) {
			Member m = new Member();
			m.no = Prompt.inputInt("번호? ");
			m.name = Prompt.inputString("이름? ");
			m.tel = Prompt.inputString("전화번호? ");
			m.postNo = Prompt.inputString("우편번호? ");
			m.basicAddress = Prompt.inputString("기본주소? ");
			m.detailAddress = Prompt.inputString("상세주소? ");
			m.working = Prompt.inputInt("0. 백수\n1. 재직\n직업? ") == 1;
			m.gender =  Prompt.inputInt("0. 남자\n1. 여자\n성별? ") == 0 ? 'M' :  'W';
			m.level = (byte) Prompt.inputInt("0. 비전공자\n1. 준전공자\n2. 전공자\n전공? ");

			Date today = new Date(System.currentTimeMillis());
			m.createdDate = today.toString();

			members[i] = m;
			count++;

			String str = Prompt.inputString("계속 입력할거임? (Y/n)");
			if (!str.equalsIgnoreCase("Y") && str.length() != 0) {
				break;
			}
		}
		Prompt.close();
		System.out.println();
	}

	static void printMembers() {
		for (int i = 0; i < count; i++) {
			Member m = members[i];
			System.out.printf("번호: %d\n", m.no);
			System.out.printf("이름: %s\n", m.name);
			System.out.printf("전화: %s\n", m.tel);
			System.out.printf("우편번호: %s\n", m.postNo);
			System.out.printf("주소1: %s\n", m.basicAddress);
			System.out.printf("주소2: %s\n", m.detailAddress);
			System.out.printf("재직자: %s\n", m.working ? "예" : "아니오");
			System.out.printf("성별: %s\n", m.gender == 'M' ? "남자" : "여자");

			String levelTitle;
			switch (m.level) {
			case 0: levelTitle = "비전공"; break;
			case 1: levelTitle = "준전공"; break;
			default:
				levelTitle = "전공자";
			}

			System.out.printf("전공: %s\n", levelTitle);
			System.out.printf("생성일: %s\n", m.createdDate);
			System.out.println("--------------------------------------");
		}
	}
}
