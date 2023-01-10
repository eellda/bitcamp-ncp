package bitcamp.bootapp.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import bitcamp.bootapp.dao.BoardDao;
import bitcamp.bootapp.vo.Board;

@RestController
//  다음 클래스는 클라이언트 요청을 처리하는 일을 한다는 것을 SpringBoot 에게 알리는 표
// => SpringBoot 는 다음 클래스의 인스턴스를 생성해서 보관해 둔다.
// => "/hello" 라는 URL 로 클라이언트 요청이 들어오면 해당 메서드를 호출한다.
public class BoardController {

  BoardDao boardDao = new BoardDao();

  public BoardController() {
    Board b = new Board();
    b.setNo(1);
    b.setTitle("제목입니다.1");
    b.setContent("내용입니다.1");
    b.setPassword("111");
    b.setCreatedDate("2023-01-01");
    b.setViewCount(1);

    this.boardDao.insert(b);
  }

  @CrossOrigin(origins = "http://127.0.0.1:5500")
  @PostMapping("/boards")
  // 바운더리로써 어떻게 처리할지만 고민하면 됨.
  public Object addBoard( // springboot 가 호출한다.

      // 클라이언트가 보낼때 사용한 이름을 받는다.
      @RequestParam (required = false) String title,
      @RequestParam (required = false) String content,
      @RequestParam (required = false) String password) {

    Board b = new Board();
    b.setTitle(title);
    b.setContent(content);
    b.setPassword(password);
    b.setCreatedDate(new Date(System.currentTimeMillis()).toString());

    this.boardDao.insert(b);

    Map<String, Object> contentMap = new HashMap<>();
    // 응답 결과를 담을 맵 객체 준비
    contentMap.put("status", "success");


    return contentMap;
  } // 응답 영역 (springboot)

  @CrossOrigin(origins = "http://127.0.0.1:5500")
  @GetMapping("/boards")
  // 바운더리로써 어떻게 처리할지만 고민하면 됨.
  public Object getBoards() {

    Board[] boards = this.boardDao.findAll();

    Map<String, Object> contentMap = new HashMap<>();

    contentMap.put("status", "success");
    contentMap.put("data", boards);

    return contentMap;
  }

  @GetMapping("/boards/{boardNo}")
  // 바운더리로써 어떻게 처리할지만 고민하면 됨.
  public Object getBoard(@PathVariable int boardNo) {

    Board b = this.boardDao.findByNo(boardNo);

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


}
