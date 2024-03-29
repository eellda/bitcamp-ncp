package bitcamp.bootapp.dao;

import java.util.Arrays;
import bitcamp.bootapp.vo.Teacher;

public class TeacherDao {
  private static final int SIZE = 100;

  private int no;
  private int count;
  private Teacher[] teachers = new Teacher[SIZE];

  public void insert(Teacher teacher) {
    teacher.setNo(++no);
    this.teachers[this.count++] = teacher;
  }

  public Teacher[] findAll() {
    return Arrays.copyOf(teachers, count);
  }

  public Teacher findByNo(int no) {
    for (int i = 0; i < this.count; i++) {
      if (this.teachers[i].getNo() == no) {
        return this.teachers[i];
      }
    }
    return null;
  }

  public void update(Teacher teacher) {
    this.teachers[this.indexOf(teacher)] = teacher;
  }

  public void delete(Teacher teacher) {
    for (int i = this.indexOf(teacher) + 1; i < this.count; i++) {
      this.teachers[i - 1] = this.teachers[i];
    }
    this.teachers[--this.count] = null;
  }

  private int indexOf(Teacher m) {
    for (int i = 0; i < this.count; i++) {
      if (this.teachers[i].getNo() == m.getNo()) {
        return i;
      }
    }
    return -1;
  }
}
