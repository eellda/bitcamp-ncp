package bitcamp.myapp.dao;

import java.util.Arrays;

public abstract class ObjectDao {
  private static final int SIZE = 3;

  private int count;
  protected Object[] objects = new Object[SIZE];

  public void insert(Object object) {
    this.objects[this.count++] = object; // 이자리에 자식들도 올 수 있다= 다형적 형변환
  }

  public Object[] findAll() {
    return Arrays.copyOf(objects, count);
  }

  public void update(Object object) {
    if (count == SIZE) {
      throw new DaoException("저장 개수를 초과했습니다.");
    }
    this.objects[this.indexOf(object)] = object;
  }

  public void delete(Object object) {
    for (int i = this.indexOf(object) + 1; i < this.count; i++) {
      this.objects[i - 1] = this.objects[i];
    }
    this.objects[--this.count] = null; // 레퍼런스 카운트를 줄인다.
  }

  // 객체의 위치를 찾는 것은
  // 객체의 타입에 따라 다를 수 있기 때문에
  // 이 클래스를 정의 하지 말고
  // 서브 클래스에서 정의할 수 있도록
  // 그 구현의 책임을 위임해야 한다.
  protected abstract int indexOf(Object b);

  public int size() {
    return this.count; // 가능한 count는 그대로 두고 메서드로 공개
  }

  // 개발하는 중에 서브 클래스들이 공통으로 필요로 하는 것을 하는 기능을 발견하게 됨ㄷㄷ
  // 그런 상황이면 이렇게 super class 에 해당 메소드를 정의하면 된다.
  public Object get(int i) {
    if (i < 0 || i >= this.count) {
      throw new DaoException("인덱스가 무효합니다.");
    }
    return objects[i];
  }

}
