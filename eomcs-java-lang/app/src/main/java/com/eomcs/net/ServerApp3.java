package com.eomcs.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ServerApp3 {

  public static String calc(String exp) {
    StringTokenizer st = new StringTokenizer(exp, " ");
    if(st.countTokens() != 3) return "error";

    String res = "";
    int op1 = Integer.parseInt(st.nextToken());
    String opcode = st.nextToken();
    int op2 = Integer.parseInt(st.nextToken());
    switch(opcode){
      case "+": res = Integer.toString(op1 + op2);
      break;
      case "-": res = Integer.toString(op1 - op2);
      break;
      case "*": res = Integer.toString(op1 * op2);
      break;
      case "/": res = Integer.toString(op1 / op2);
      break;
      case "^": res = String.valueOf(Math.pow(op1, op2));
      break;
      default : res = "error";
    }

    return res;
  }

  public static void main(String[] args) throws Exception {

    Scanner keyScan = new Scanner(System.in);

    System.out.println("서버 실행중~");
    ServerSocket serverSocket = new ServerSocket(8888);

    Socket socket = serverSocket.accept();
    System.out.println("클라이언트와 연결 됨 ㅋ");

    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

    try {

      while(true) {
        String inputMessage = in.readLine();
        if(inputMessage.equalsIgnoreCase("q")) {
          System.out.println("Client 에서 연결 종료 ㅋㅋ");
          break;
        }
        System.out.println("클라 : "+inputMessage);
        String outputMessage = calc(inputMessage);
        out.write(outputMessage+"\n");
        out.flush();
      }
    } catch(IOException e) {
      System.out.println(e.getMessage());
    }
    finally {
      try {
        keyScan.close();
        socket.close();
      } catch(IOException e) {
        System.out.println("채팅 중 오류가 발생");
      }
    }

    serverSocket.close();
    System.out.println("사바 종료요");

  }
}
