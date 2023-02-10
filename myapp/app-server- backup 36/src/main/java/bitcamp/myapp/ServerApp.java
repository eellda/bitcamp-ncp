package bitcamp.myapp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import bitcamp.myapp.dao.BoardDao;
import bitcamp.myapp.dao.StudentDao;
import bitcamp.myapp.dao.TeacherDao;
import bitcamp.myapp.servlet.BoardServlet;
import bitcamp.myapp.servlet.StudentServlet;
import bitcamp.myapp.servlet.TeacherServlet;
import bitcamp.myapp.vo.Board;
import bitcamp.myapp.vo.Student;
import bitcamp.myapp.vo.Teacher;

public class ServerApp {
  BoardDao boardDao = new BoardDao(new LinkedList<Board>());
  StudentDao studentDao = new StudentDao(new ArrayList<Student>());
  TeacherDao teacherDao = new TeacherDao(new ArrayList<Teacher>());
  StudentServlet studentServlet = new StudentServlet(studentDao);
  TeacherServlet teacherServlet = new TeacherServlet(teacherDao);
  BoardServlet boardServlet = new BoardServlet(boardDao);

  public static void main(String[] args) {

    new ServerApp().service(8888);
    System.out.println("서버 종료!");

  } // main()

  void service(int port) {
    System.out.println("서버 실행 중 ..");

    try (ServerSocket serverSocket = new ServerSocket(port)) {
      boardDao.load("board.json");
      studentDao.load("student.json");
      teacherDao.load("teacher.json");

      while (true) {
        //        RequestProcessorThread t = new RequestProcessorThread(serverSocket.accept());
        //        t.start();

        Socket socket = serverSocket.accept();
        new Thread(() -> processRequest(socket)).start();
        // 쓰레드를 만들어서 실행 하는데 Runnable 이란 조건을 따라서 run()을 실행한다.
      }
    } catch (Exception e) {
      System.out.println("서버 오류 발생");
      e.printStackTrace();
    }
  }

  void processRequest(Socket socket) {
    try (Socket socket2 = socket;
        DataInputStream in = new DataInputStream(socket.getInputStream()); // 날 것 그대로 쓰지 말자
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());) {
      InetAddress address = socket.getInetAddress();
      System.out.printf("%s 가 연결함ㄷㄷ\n", address.getHostAddress());

      //      while (true) { // stateful
      String dataName = in.readUTF();     // writeUTF가 올 때 까지 무한 대기
      switch (dataName) {
        case "board":
          boardServlet.service(in, out);  // 입출력 스트림을 그대로 넘겨준다
          boardDao.save("board.json");    // 효율성이 좋지는 않음
          break;
        case "student":
          studentServlet.service(in, out); // 입출력 스트림을 그대로 넘겨준다
          studentDao.save("student.json"); // 효율성이 좋지는 않음
          break;
        case "teacher":
          teacherServlet.service(in, out); // 입출력 스트림을 그대로 넘겨준다
          teacherDao.save("teacher.json"); // 효율성이 좋지는 않음
          break;
          //          case "quit":
          //            return;
      }
      //      }
    } catch (Exception e) {
      System.out.println("실행 오류!");
    }
  }
}










