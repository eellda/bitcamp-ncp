package bitcamp.myapp.dao;

import java.sql.Date;
import bitcamp.myapp.vo.Board;

public class BoardDao extends ObjectDao {

  int lastNo;

  public Board findByNo(int no) {
    Board b = new Board();
    b.setNo(no);
    return (Board) this.get(this.indexOf(b));
  }

  @Override
  protected int indexOf(Object obj) {
    for (int i = 0; i < this.size(); i++) {
      if (((Board)this.get(i)).getNo() == ((Board)obj).getNo()) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public void insert(Object object) {
    ((Board) object).setNo(++lastNo);
    ((Board) object).setCreatedDate(new Date(System.currentTimeMillis()).toString());
    super.insert(object);
  }
}























