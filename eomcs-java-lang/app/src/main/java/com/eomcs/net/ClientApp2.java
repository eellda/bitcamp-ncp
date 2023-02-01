package com.eomcs.net;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

public class ClientApp2 {
  public static void main(String[] args) throws Exception {

    System.out.println("클라 실행중 ~");

    Socket socket = new Socket("192.168.0.27", 8888);
    System.out.println("server 연결중");

    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
    DataInputStream in = new DataInputStream(socket.getInputStream());

    File file = new File("sad.jpeg");

    // 전송할 파일의 이름
    out.writeUTF(file.getName());
    // 전송할 파일의 크기
    out.writeLong(file.length());
    FileInputStream fileIn = new FileInputStream(file);
    int b;
    while ((b = fileIn.read()) != -1) {
      out.write(b);
    }
    fileIn.close();

    out.close();
    in.close();
    socket.close();

    System.out.println("클라 종료");

  }
}
