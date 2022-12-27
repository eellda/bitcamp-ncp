// 계산기 서버 만들기 - 3단계: 안내 메시지 전송 코드를 별도의 메서드로 분리한다.
// - 클라이언트가 접속했을 때 안내하는 문구를 보내는 코드를 별도의 메서드로 분리한다.
package com.eomcs.net.ex11.step03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {
  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중...");

      try (Socket socket = serverSocket.accept();
          BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          PrintStream out = new PrintStream(socket.getOutputStream());) {

        sendIntroMessage(out);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static void sendIntroMessage(PrintStream out) throws Exception {
    out.println("[비트캠프 계산기]");
    out.println("계산기 서버에 오신 걸 환영합니다!");
    out.println("계산식을 입력하세요!");
    out.println("예) 23 + 7");
    out.println(); // 응답의 끝을 표시하는 빈 줄을 보낸다.
    out.flush();
  }
}
