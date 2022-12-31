package bitcamp.myapp;

import java.sql.Date;

public class MembersHandler {

  static final int SIZE = 100; // 중간에 size 변경을 막기 위해 final 을 써줌
  static int count = 0;
  static int[] no = new int[SIZE]; // 선언과 동시에 배열 크기 할당
  static String[] tel = new String[SIZE];
  static String[] name = new String[SIZE];
  static String[] postNo = new String[SIZE];
  static String[] basicAdress = new String[SIZE];
  static String[] detailAdress = new String[SIZE];
  static String[] createdDate = new String[SIZE];
  static boolean[] working = new boolean[SIZE];
  static char[] gender = new char[SIZE];
  static byte[] level = new byte[SIZE];

  static void inputMembers() {

    for (int i = 0; i < SIZE; i++) {
      no[i] = Prompt.inputInt("count? ");

      name[i] = Prompt.inputString("name? ");

      tel[i] = Prompt.inputString("phone number? ");

      postNo[i] = Prompt.inputString("Post Number? ");

      basicAdress[i] = Prompt.inputString("Adress1? ");

      detailAdress[i] = Prompt.inputString("Adress2? ");

      working[i] = Prompt.inputInt("0. No working \n1. im working\nAre you working? ") == 1;

      gender[i] = Prompt.inputInt("0. Man \n1. Girl \nWhat is your gender? ") == 0 ? 'M' : 'W';

      level[i] = (byte) Prompt.inputInt("0. no Base \n1. learning \n2. master \nUniversity? ");

      Date today = new Date(System.currentTimeMillis());
      createdDate[i] = today.toString();

      count++;

      String str = Prompt.inputString("계속 하시겠습니까? (Y/n)");
      if(!str.equalsIgnoreCase("Y") && str.length() != 0) {
        // equalsIgnoreCase 는 대소문자를 구분하지 않을 뿐더러 문자열 자체를 비교함
        break;
      }
    }
    Prompt.close();
  }
  static void printMembers() {
    for (int i = 0; i < count; i++) {
      System.out.printf("번호: %d\n", no[i]);
      System.out.printf("이름: %s\n", name[i]);
      System.out.printf("전화번호: %s\n", tel[i]);
      System.out.printf("우편번호: %s\n", postNo[i]);
      System.out.printf("Adress1: %s\n", basicAdress[i]);
      System.out.printf("Adress2: %s\n", detailAdress[i]);
      System.out.printf("creat date: %s\n", createdDate[i]);
      System.out.printf("Job: %s\n", working[i]);
      System.out.printf("sex: %s\n", gender[i]);
      System.out.printf("Job: %s\n", working[i] ? 'N' : 'Y');
      System.out.printf("sex: %s\n", gender[i] == 'M' ? "Man" : "Girl");

      String levelTitle;
      switch (level[i]) {
        case 0: levelTitle = "noBase"; break;
        case 1: levelTitle = "learning"; break;
        default: levelTitle = "master";
      }
      System.out.printf("level: %s\n", levelTitle);

      System.out.println("---------------------------");
    }
  }
}
