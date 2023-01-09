package bitcamp.bootapp;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
//  다음 클래스는 클라이언트 요청을 처리하는 일을 한다는 것을 SpringBoot 에게 알리는 표
// => SpringBoot 는 다음 클래스의 인스턴스를 생성해서 보관해 둔다.
// => "/hello" 라는 URL 로 클라이언트 요청이 들어오면 해당 메서드를 호출한다.
public class BoardController {

  static final int SIZE = 100;

  int count;
  Board[] boards = new Board[SIZE];
  String title;

  public BoardController() {
    Board b = new Board();
    b.setNo(1);
    b.setTitle("제목입니다.1");
    b.setContent("내용입니다.1");
    b.setPassword("111");
    b.setCreatedDate("2023-01-01");
    b.setViewCount(1);

    this.boards[this.count++] = b;
  }

  @GetMapping("/boards/{boardNo}")
  public Object getBoard(@PathVariable int boardNo) {

    Board b = this.findByNo(boardNo);

    Map<String, Object> contentMap = new HashMap<>();
    // 응답 결과를 담을 맵 객체 준비

    if (b == null) {
      contentMap.put("status", "failure");
      contentMap.put("message", "해당 번호의 게시글이 없습니다.");
    } else {
      contentMap.put("success", "success");
      contentMap.put("message", b);
    }

    return contentMap;
  }

  Board findByNo(int no) {
    for (int i = 0; i < this.count; i++) {
      if (this.boards[i].getNo() == no) {
        return this.boards[i];
      }
    }
    return null;
  }
}
