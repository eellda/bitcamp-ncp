package bitcamp.util;

// 객체 목록을 다루는 기능을 규정한다.
// modifiers = 변경자 = 제한자 = 성질을 바꾸는 거
public interface List {

  public abstract void add(Object value);
  abstract Object[] toArray();
  // 인터페이스 에서는 public abstract 생략 가능
  Object get(int index);
  Object set(int index, Object value);
  boolean remove(Object value);
  int indexOf(Object value);
  int size();

}

