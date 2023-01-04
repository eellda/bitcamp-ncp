package com.eomcs.oop.ex02.test;

import com.eomcs.oop.ex02.test.vo.Score;

public class ScoreTest1 {
  public static void main(String[] args) {

    class Score {
      String name;
      int kor;
      int eng;
      int math;
      int sum;
      float aver;
    }

    Score s1 = new Score();

    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 85;

  }
  static void scorePrint(Score s) {
    s.sum =  s.kor +  s.eng +  s.math;
    s.aver = (float)  s.sum / 3;
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n",  s.name,  s.kor,  s.eng,  s.math,  s.sum,  s.aver);
  }

}
