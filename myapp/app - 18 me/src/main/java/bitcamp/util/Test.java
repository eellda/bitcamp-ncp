package bitcamp.util;

import java.util.Objects;

public class Test {

  int no;
  String name;
  String tel;

  public Test() {};

  public Test(int no, String name, String tel) {
    this.no = no;
    this.name = name;
    this.tel = tel;
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, no, tel);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Test other = (Test) obj;
    return Objects.equals(name, other.name) && no == other.no && Objects.equals(tel, other.tel);
  }

  Test m1 = new Test(1, "kest", "123");
  Test m2 = new Test(2, "kest", "123");
  Test m3 = new Test(3, "kest", "123");
  Test m4 = new Test(4, "kest", "123");


  public static void main(String[] args) {
  }
}
