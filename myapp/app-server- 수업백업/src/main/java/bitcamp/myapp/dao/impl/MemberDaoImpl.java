package bitcamp.myapp.dao.impl;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;
import bitcamp.util.ConnectionFactory;

public class MemberDaoImpl implements MemberDao {

  ConnectionFactory conFactory;

  public MemberDaoImpl(ConnectionFactory conFactory) {
    this.conFactory = conFactory;
  }

  @Override
  public void insert(Member m) {
    try (Statement stmt = conFactory.getConnection().createStatement()) {

      String sql = String.format(
          "insert into app_member(name, email, pwd, tel)"
              + " values('%s', '%s', sha2('%s',256), '%s')",
              m.getName(),
              m.getEmail(),
              m.getPassword(),
              m.getTel());

      stmt.executeUpdate(
          sql,
          Statement.RETURN_GENERATED_KEYS // insert 실행 후 자동 증가된 PK 값을 리턴 받겠다고 선언한다.
          );

      // 1) insert 후에 자동 생성된 PK 값을 꺼내올 도구를 준비한다.
      try (ResultSet keyRs = stmt.getGeneratedKeys()) {

        // 2) keyRs 도구를 이용하여 서버에서 PK 값을 가져온다.
        keyRs.next();

        // 3) 가져온 PK 레코드에서 PK 값을 꺼낸다.
        int autoGeneratedMemberId = keyRs.getInt(1); // PK 컬럼에 한 개이기 때문에 PK 레코드에도 한 개의 컬럼만 있다.

        // 4) DBMS에서 insert 할 때 자동 생성한 member_id 값을 Member 객체에 리턴한다.
        m.setNo(autoGeneratedMemberId);
      }

    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public List<Member> findAll() {
    try (Statement stmt = conFactory.getConnection().createStatement();
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
    try (Statement stmt = conFactory.getConnection().createStatement();
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
    try (Statement stmt = conFactory.getConnection().createStatement()) {

      String sql = String.format(
          "update app_member set "
              + " name='%s', email='%s', pwd=sha2('%s',256), tel='%s'"
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
    try (Statement stmt = conFactory.getConnection().createStatement()) {

      String sql = String.format(
          "delete from app_member"
              + " where member_id=%d", no);

      return stmt.executeUpdate(sql);

    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  public static void main(String[] args) throws Exception {
    //    Connection con = DriverManager.getConnection(
    //        "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
    //
    //    MemberDaoImpl dao = new MemberDaoImpl(con);

    //    Member m = new Member();
    //    m.setName("aaa22");
    //    m.setEmail("aaa22@test.com");
    //    m.setPassword("1111");
    //    m.setTel("1111");
    //
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
    //    m.setName("xxxx");
    //    m.setEmail("xxx@test.com");
    //    m.setPassword("2222");
    //    m.setTel("101010");
    //    System.out.println(dao.update(m));

    //    System.out.println(dao.delete(3));

    //    conFactory.getConnection().close();
  }
}























