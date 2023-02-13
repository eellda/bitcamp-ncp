package bitcamp.myapp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;

public class MemberDaoImpl implements MemberDao {

  Connection con;

  // 의존객체 Connection 을 생성자에서 받는다.
  public MemberDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void insert(Member m) {
    try (Statement stmt = con.createStatement()) {

      String sql = String.format(
          "insert into app_member(name, email, pwd, tel)"
              + " values('%s','%s',sha2('%s', 256),'%s')",
              m.getName(),
              m.getEmail(),
              m.getPassword(),
              m.getTel());

      stmt.executeUpdate(
          sql,
          Statement.RETURN_GENERATED_KEYS);      // insert 실행 후 자동 증가된 PK 값을 리턴 받겠다고요

      try (ResultSet keyRs = stmt.getGeneratedKeys()) {    // 1. insert 후에 자동 생성된 PK 값을 꺼내올 도구를 준비한다.
        keyRs.next();                                 // 2. keyRs 도구를 이용하여 서버에서 PK 값을 가져온다.
        int autoGeneratedMemberId = keyRs.getInt(1);  // 3. 가져온 PK record 에서 PK 값을 꺼낸다. PK 컬럼이 한 개이기 때문에 PK 레코드에도 한 개의 컬럼만 있다.
        m.setNo(autoGeneratedMemberId);               // 4. DBMS에서 insert 할 때 자동 생성한 member_id값을 Member 객체에 리턴한다.
      }
      // keyRs.close();                                // 5. keyRs 를 모두 사용 했으면 닫는다.

    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public List<Member> findAll() {
    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select member_id, name, email, created_date"
                + " from app_member"
                + " order by member_id desc")) {

      ArrayList<Member> list = new ArrayList<>();
      while (rs.next()) {
        Member m = new Member();
        m.setNo(rs.getInt("member_id"));
        m.setName(rs.getString("name"));
        m.setEmail(rs.getString("email"));
        m.setCreatedDate(rs.getDate("created_date"));

        list.add(m);
      }

      return list;

    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public Member findByNo(int no) {
    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select member_id, name, email, tel, created_date"
                + " from app_member"
                + " where member_id=" + no)) {

      if (rs.next()) {
        Member m = new Member();
        m.setNo(rs.getInt("member_id"));
        m.setName(rs.getString("name"));
        m.setEmail(rs.getString("email"));
        m.setTel(rs.getString("tel"));
        m.setCreatedDate(rs.getDate("created_date"));

        return m;
      }

      return null;

    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public int update(Member m) {
    try (Statement stmt = con.createStatement()) {

      String sql = String.format(
          "update app_member set "
              + " name='%s', email='%s', pwd=sha2('%s', 256), tel='%s'"
              + " where member_id=%d",
              m.getName(),
              m.getEmail(),
              m.getPassword(),
              m.getTel(),
              m.getNo());

      return stmt.executeUpdate(sql);

    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public int delete(int no) {

    try (Statement stmt = con.createStatement()) {

      String sql = String.format("delete from app_member"
          + " where member_id=%d", no);

      return stmt.executeUpdate(sql);

    } catch (Exception e) {
      throw new DaoException(e);
    }
  }









  public static void main(String[] args) throws Exception {
    Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", "study", "1111");

    MemberDaoImpl dao = new MemberDaoImpl(con);

    //    Member m = new Member();
    //    m.setName("aaa11");
    //    m.setEmail("aaa11@gmail.com");
    //    m.setPassword("1fn!#413f3");
    //    m.setTel("123456");
    //    dao.insert(m);
    //    System.out.println(m);

    //    List<Member> list = dao.findAll();
    //    for (Member m : list) {
    //      System.out.println(m);
    //    }

    //    Member m = dao.findByNo(2);
    //    System.out.println(m);

    //    Member m = new Member();
    //    m.setNo(2);
    //    m.setName("xvxv");
    //    m.setEmail("test@naver.com");
    //    m.setPassword("135@$vbfvef3");
    //    m.setTel("4321");
    //    System.out.println(dao.update(m));

    //    System.out.println(dao.delete(3));

    con.close();
  }
}






















