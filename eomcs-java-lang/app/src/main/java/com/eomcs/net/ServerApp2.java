package com.eomcs.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp2 {

  public static void main(String[] args) throws Exception {


    System.out.println("서버 실행중~");
    ServerSocket serverSocket = new ServerSocket(8888);
    Socket socket = serverSocket.accept();

    System.out.println("클라이언트와 연결 됨 ㅋ");

    DataInputStream in = new DataInputStream(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

    // 클라가 보낸 파일의 이름을 읽음
    String filename = in.readUTF();

    // 클라가 보낸 파일의 크기 읽음
    long length = in.readLong();

    // 클라가 보낸 사진바이트를 파일로 출력함.
    FileOutputStream fileOut = new FileOutputStream(filename);
    for (long i = 0; i < length; i++) {
      int b = in.read();
      fileOut.write(b);
    }
    fileOut.close();

    out.writeUTF("완료");
    socket.close();
    serverSocket.close();
    System.out.println("사바 종료요");

  }
}
