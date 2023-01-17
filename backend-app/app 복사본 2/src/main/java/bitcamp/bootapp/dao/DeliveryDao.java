package bitcamp.bootapp.dao;

import java.sql.Date;
import java.util.Arrays;
import org.springframework.stereotype.Repository;
import bitcamp.bootapp.vo.Delivery;

@Repository
public class DeliveryDao {
  private static final int SIZE = 100;

  private int no; // delivery 식별 번호
  private int count;
  private Delivery[] deliverys = new Delivery[SIZE];

  public void insert(Delivery d) {
    d.setNo(++no);
    d.setCreatedDate(new Date(System.currentTimeMillis()).toString());
    this.deliverys[this.count++] = d;
  }

  public Delivery[] findAll() {
    return Arrays.copyOf(deliverys, count);
  }

  public Delivery findByNo(int no) {
    for (int i = 0; i < this.count; i++) {
      if (this.deliverys[i].getNo() == no) {
        return this.deliverys[i];
      }
    }
    return null;
  }

  public void update(Delivery d) {
    this.deliverys[this.indexOf(d)] = d;
  }

  public void delete(Delivery d) {
    for (int i = this.indexOf(d); i < this.count; i++) {
      this.deliverys[i] = this.deliverys[i + 1];
    }
    this.deliverys[--this.count] = null; // 레퍼런스 카운트를 줄인다.
  }

  private int indexOf(Delivery d) {
    for (int i = 0; i < this.count; i++) {
      if (this.deliverys[i].getNo() == d.getNo()) {
        return i;
      }
    }
    return -1;
  }
}







