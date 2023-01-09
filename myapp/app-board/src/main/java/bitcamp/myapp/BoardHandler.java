package bitcamp.myapp;

import java.sql.Date;

public class BoardHandler {
  static final int SIZE = 100;
  int count;
  String n;
  int viewCount = 0;

  Board[] boards = new Board[SIZE];

  BoardHandler(String n) {
    this.n = n;
  }

  void inputBoard() {
    Board b = new Board();
    b.no = Prompt.inputInt("번호? ");
    b.title = Prompt.inputString("제목? ");
    b.content = Prompt.inputString("내용? ");
    b.passwd = Prompt.inputInt("비밀번호? ");
    b.createdDate = new Date(System.currentTimeMillis()).toString();

    boards[this.count++] = b;
  }

  void listBoards() {
    System.out.println("번호\t제목\t\t작성일\t\t조회수");

    for (int i = 0; i < this.count; i++) {
      Board b = boards[i];
      System.out.printf("%d\t%s\t%s\t%d\n", b.no, b.title, b.createdDate, b.viewCount);
    }
  }

  void listOfBoard() {
    int boardNo = Prompt.inputInt("책 번호? ");
    Board b = findByNo(boardNo);

    if (b == null) {
      System.out.println("해당 번호의 개시글은 없습니다.");
      return;
    }


    System.out.printf("   제목: %s\n", b.title);
    System.out.printf("   내용: %s\n", b.content);
    System.out.printf("작성일: %s\n", b.createdDate);
    System.out.printf("조회수: %s\n", ++b.viewCount);
  }

  void modifyBoard() {
    int boardNo = Prompt.inputInt("게시글 번호? ");

    Board old = this.findByNo(boardNo);

    if (old == null) {
      System.out.println("해당 번호의 게시글이 없습니다.");
      return;
    }

    // 변경할 데이터를 저장할 인스턴스 준비
    Board b = new Board();
    b.no = old.no;
    b.createdDate = old.createdDate;
    b.title = Prompt.inputString(String.format("제목(%s)? ", old.title));
    b.content = Prompt.inputString(String.format("내용(%s)? ", old.content));


    String str = Prompt.inputString("정말 변경하시겠습니까?(y/N) ");
    if (str.equalsIgnoreCase("Y")) {
      int passwdNo = Prompt.inputInt("비밀번호 기억남? ");
      Board p = findByPasswd(passwdNo);

      if (p == null) {
        System.out.println("비밀번호가 틀렸습니다.");
        return;
      }
      this.boards[this.indexOf(old)] = b;
      System.out.println("변경했습니다.");
    } else {
      System.out.println("변경 취소했습니다.");
    }

  }

  void deletBoard() {
    int boardNo = Prompt.inputInt("삭제할 책 번호? ");
    Board b = findByNo(boardNo);

    if (b == null) {
      System.out.println("해당 번호의 개시글은 없습니다.");
      return;
    }

    String del = Prompt.inputString("정말 삭제 하시겠습니까? (y/N");
    if (!del.equalsIgnoreCase("Y")) {
      System.out.println("삭제를 취소하였습니다.");
      return;
    }

    for (int i = this.indexOf(b) + 1; i < this.count; i++) {
      this.boards[i - 1] = this.boards[i];
    }
    this.boards[--this.count] = null;
    System.out.println("삭제 완료.");
  }

  Board findByNo (int no) {
    for (int i = 0; i < this.count; i++) {
      if (this.boards[i].no == no) {
        return this.boards[i];
      }
    }
    return null;
  }

  Board findByPasswd (int passwd) {
    for (int i = 0; i < this.count; i++) {
      if (this.boards[i].passwd == passwd) {
        return this.boards[i];
      }
    }
    return null;
  }

  int indexOf(Board b) {
    for (int i = 0; i < this.count; i ++) {
      if (this.boards[i].no == b.no) {
        return i;
      }
    }
    return -1;
  }

  void service() {
    while (true) {
      System.out.printf("[ %s ]\n", this.n);
      System.out.println("1. 입력");
      System.out.println("2. 목록");
      System.out.println("3. 조회");
      System.out.println("4. 변경");
      System.out.println("5. 삭제");
      System.out.println("0. 이전");
      int menuNo = Prompt.inputInt(String.format("%s >>", this.n));

      switch (menuNo) {
        case 0: return;
        case 1: this.inputBoard(); break;
        case 2: this.listBoards(); break;
        case 3: this.listOfBoard(); break;
        case 4: this.modifyBoard(); break;
        case 5: this.deletBoard(); break;
        default:
          System.out.println("번호를 다시 입력해 주세요.");
      }
    }
  }
}
