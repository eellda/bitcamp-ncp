package bitcamp.myapp;
import java.util.Scanner;



public class App {
  public static void main(String[] args) {

    // 키보드에서 입력을 받는 도구 준비
    Scanner keyScanner = new java.util.Scanner(System.in);

    System.out.print("이름? : ");
    String name = keyScanner.nextLine();
    System.out.print("번호? : ");
    String tel = keyScanner.nextLine();
    System.out.print("우편번호? : ");
    String postNo = keyScanner.nextLine();
    System.out.print("주소? : ");
    String basicAdress = keyScanner.nextLine();
    System.out.print("상세주소? : ");
    String detailAdress = keyScanner.nextLine();
    System.out.print("가입일? (예: 2022-12-12 ): ");
    String createdDate = keyScanner.nextLine();

    System.out.print("숫자? : ");
    int no = Integer.parseInt(keyScanner.nextLine());
    System.out.print("백수? : ");
    boolean isWorking = Boolean.parseBoolean(keyScanner.nextLine());
    System.out.print("성별? : ");
    char gender = keyScanner.nextLine().charAt(0); // W - woman, M - man
    System.out.println("0: 백수");
    System.out.println("1: 등골");
    System.out.println("2: 굳");

    System.out.print("전공? : ");
    byte level = Byte.parseByte(keyScanner.nextLine()); // 0 - 비전공자, 1 - 준전공자, 2 - 전공

    System.out.printf("번호 = %d\n", no); // 컴팩터 네이션 // 실행 과정에서 임시로 문자열이 생성됨
    System.out.printf("이름 = %s\n", name);
    System.out.printf("전화번호 = %s\n", tel);
    System.out.printf("우편 = %s\n", postNo);
    System.out.printf("기본 주소 = %s\n", basicAdress);
    System.out.printf("상세 주소= %s\n", detailAdress);
    System.out.printf("날짜 =  %s\n", createdDate);

    //    String workingLabel;
    //    if (isWorking) {
    //      workingLabel = "예";
    //    } else {
    //      workingLabel = "아니요";
    //    }
    //    System.out.printf("재직자 = %s\n", workingLabel);

    System.out.printf("재직 = %s\n", isWorking ? "yes" : "no");
    System.out.printf("성별 = %s\n", gender == 'M' ? "남자" : "여자");

    String levelTitle;
    switch (level) {
      case 0: levelTitle = "비전공자"; break;
      case 1: levelTitle = "준전공자"; break;
      default: levelTitle = "전공자";
    }


    System.out.printf("전공 = %s\n", levelTitle);


    // system 이라는 도구함에 out 이라는 변수에 console 에 대한 정보가 저장 되어있다.
    // println 은어디에 있는거고 뭘 println 할거냐?
  }
}
// 프리머티브 타입