package bitcamp.myapp.dao;

import java.sql.Date;
import bitcamp.myapp.vo.Teacher;
import bitcamp.util.List;

public class TeacherDao {

  List list;
  int lastNo;

  public TeacherDao(List list) {
    this.list = list;
  }

  public void insert(Teacher t) {
    t.setNo(++lastNo);
    t.setCreatedDate(new Date(System.currentTimeMillis()).toString());
    list.add(t);
  }

  public Teacher[] findAll() {

    Teacher[] teachers = new Teacher[list.size()];
    Object[] arr =list.toArray();

    for (int i = 0; i < teachers.length; i++) {
      teachers[i] = (Teacher) arr[i];
    }
    return teachers;
  }

  public Teacher findByNo(int no) {

    Teacher t = new Teacher();
    t.setNo(no);
    int index = list.indexOf(t);

    if (index == -1) {
      return null;
    }
    return (Teacher) list.get(list.indexOf(t));
  }

  public void update(Teacher b) {
    int index = list.indexOf(b);
    list.set(index, b);
  }

  public boolean delete(Teacher b) {
    return list.remove(b);
  }
}







