package bitcamp.util;

// Iterable 구현체를 리턴받기 위해 호출할 메서드 규칙 정의
public interface Iterable {
  Iterator iterator();
}