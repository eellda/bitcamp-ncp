package bitcamp.util;

import java.sql.Connection;

public class ConnectionFactory {

  // thread 전용 변수
  // => 스레드 마다 별도로 존재하는 변수
  // => Connection 객체를 담는 변수
  ThreadLocal<Connection> conLocal = new ThreadLocal<>();
  ConnectionPool connectionPool;

  public ConnectionFactory(ConnectionPool connectionPool) {
    this.connectionPool = connectionPool;
  }

  public Connection getConnection() throws Exception {
    // 현재 이 명령을 실행하는 스레드에 마련된 conLocal 변수에서 값을 꺼낸다
    Connection con = conLocal.get();

    if (con == null) {  
      // 현재 스레드 변수에 Connection 객체가 들어 있지 않다면 ConnectionPool 에서 가져온다
      con = connectionPool.getConnection(); // 새로 Connection을 생성하거나 기존 Connection을 리턴한다.

      // 현재 스레드가 다음에도 사용할 수 있도록 Connection 객체를 스레드 변수에 보관한다
      conLocal.set(con);
    }

    System.out.printf("[%s] Connection 객체를 리턴함\n", Thread.currentThread().getName());
    // 현재 스레드를 위해 준비한 Connection 객체를 리턴한다
    return con;
  }

  public void closeConnection() {
    // 현재 스레드가 사용한 Connection 객체를 꺼내 ConnectionPool에 반납한다.
    Connection con = conLocal.get();
    if (con != null) connectionPool.returnConncection(con);

    System.out.printf("[%s] 커넥션 객체 반납.\n", Thread.currentThread().getName());
  }
}

