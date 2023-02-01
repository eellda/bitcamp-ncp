package com.eomcs.net;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientApp {
  public static void main(String[] args) throws Exception {

    Scanner scanner = new Scanner(System.in);
    System.out.println("클라 실행중 ~");

    Socket socket = new Socket("192.168.0.5", 8888);
    System.out.println("server 연결중");

    PrintStream out = new PrintStream(socket.getOutputStream());
    Scanner in = new Scanner(socket.getInputStream());

    while (true) {
      System.out.println("입력 >> ");
      String message = scanner.nextLine();
      out.println(message);

      if (message.equals("quit")) {
        break;
      }

      //      System.out.println("서버에 메세지 보냄");

      // 서버에서 응답이 올 때까지 리턴하지 않음.
      String responese = in.nextLine();
      System.out.printf("응답 : %s\n", responese);
    }

    out.close();
    in.close();
    socket.close();

    System.out.println("클라 종료");
    scanner.close();

  }
}
