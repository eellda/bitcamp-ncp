package com.eomcs.basic.ex02;

public class Test {

  public static void main(String[] args) {
    String s1 = new String();
    char[] chars = {'h', 'e'};
    String s2 = new String(chars);
    System.out.println(s1);
    System.out.println(s1.hashCode());
    System.out.println(s1.getClass());
    System.out.println(s1.length());
    System.out.println(s2);
    System.out.println(s2.hashCode());
    System.out.println(s2.getClass());
    System.out.println(s2.length());
  }
}
