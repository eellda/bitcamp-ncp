package bitcamp.myapp.dao;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import bitcamp.myapp.vo.Board;

public class BoardDao {

  List<Board> list;
  int lastNo;

  public BoardDao(List<Board> list) {
    this.list = list;
  }

  public void insert(Board board) {
    board.setNo(++lastNo);
    board.setCreatedDate(new Date(System.currentTimeMillis()).toString());
    list.add(board);
  }

  public Board[] findAll() {
    Board[] boards = new Board[list.size()];
    Iterator<Board> i = list.iterator();
    int index = 0;
    while (i.hasNext()) {
      boards[index++] = i.next();
    }
    return boards;
  }

  public Board findByNo(int no) {
    Board b = new Board();
    b.setNo(no);

    int index = list.indexOf(b);
    if (index == -1) {
      return null;
    }

    return list.get(index);
  }

  public void update(Board b) {
    int index = list.indexOf(b);
    list.set(index, b);
  }

  public boolean delete(Board b) {
    return list.remove(b);
  }

  public void save(String filename) {
    try (FileWriter out = new FileWriter(filename)) {
      for (Board b : list)
        out.write(String.format("%d,%s,%s,%s,%s\n",
            b.getNo(), b.getTitle(), b.getPassword(), b.getViewCount(), b.getCreatedDate()));

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @SuppressWarnings("unchecked")
  public void load(String filename) {
    if (list.size() > 0) {
      return;
    }

    try (
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {

      list = (List<Board>) in.readObject();

      if (list.size() > 0) {
        //        int lastIndex = list.size() - 1;
        //        Board b = list.get(lastIndex);
        //        lastNo = b.getNo();
        lastNo = list.get(list.size() - 1).getNo();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}























