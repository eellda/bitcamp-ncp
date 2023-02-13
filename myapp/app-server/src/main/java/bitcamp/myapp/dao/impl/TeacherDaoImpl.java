package bitcamp.myapp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.dao.TeacherDao;
import bitcamp.myapp.vo.Teacher;

public class TeacherDaoImpl implements TeacherDao {

  Connection con;

  // 의존객체 Connection 을 생성자에서 받는다.
  public TeacherDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void insert(Teacher t) {

    try (Statement stmt = con.createStatement()) {

      String sql = String.format(
          "insert into app_teacher("
              + "member_id,"
              + " degree,"
              + " school,"
              + " major,"
              + " wage)"
              + " values('%s',%d,'%s','%s',%d)",
              t.getNo(),
              t.getDegree(),
              t.getSchool(),
              t.getMajor(),
              t.getWage());

      stmt.executeUpdate(sql);

    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public List<Teacher> findAll() {
    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select m.member_id,"
                + " m.name,"
                + " m.tel,"
                + " t.degree,"
                + " t.major,"
                + " t.wage"
                + " from app_teacher t"
                + "  inner join app_member m on t.member_id = m.member_id"
                + " order by"
                + " m.name desc")) {

      ArrayList<Teacher> list = new ArrayList<>();
      while (rs.next()) {
        Teacher t = new Teacher();
        t.setNo(rs.getInt("member_id"));
        t.setName(rs.getString("name"));
        t.setTel(rs.getString("tel"));
        t.setDegree(rs.getInt("degree"));
        t.setMajor(rs.getString("major"));
        t.setWage(rs.getInt("wage"));
        list.add(t);
      }

      return list;

    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public Teacher findByNo(int no) {
    try (Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select"
                + " m.member_id,"
                + " m.name,"
                + " m.tel,"
                + " m.created_date,"
                + " m.email,"
                + " t.degree,"
                + " t.school,"
                + " t.major,"
                + " t.wage"
                + " from app_teacher t"
                + "  inner join app_member m on t.member_id = m.member_id"
                + " where"
                + " t.member_id=" + no)) {

      if (rs.next()) {
        Teacher t = new Teacher();
        t.setNo(rs.getInt("member_id"));
        t.setName(rs.getString("name"));
        t.setTel(rs.getString("tel"));
        t.setCreatedDate(rs.getDate("created_date"));
        t.setEmail(rs.getString("email"));
        t.setDegree(rs.getInt("degree"));
        t.setSchool(rs.getString("school"));
        t.setMajor(rs.getString("major"));
        t.setWage(rs.getInt("wage"));
        return t;
      }

      return null;

    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public int update(Teacher t) {
    try (Statement stmt = con.createStatement()) {

      String sql = String.format(
          "update app_teacher set "
              + " degree=%d,"
              + " school='%s',"
              + " major='%s',"
              + " wage=%d "
              + " where member_id=%d",
              t.getDegree(),
              t.getSchool(),
              t.getMajor(),
              t.getWage(),
              t.getNo());

      return stmt.executeUpdate(sql);

    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public int delete(int no) {
    try (Statement stmt = con.createStatement()) {

      String sql = String.format(
          "delete from app_teacher"
              + " where"
              + " member_id=%d", no);

      return stmt.executeUpdate(sql);

    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  public static void main(String[] args) throws Exception {
    Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", "study", "1111");

    TeacherDaoImpl dao = new TeacherDaoImpl(con);

    //    Teacher t = new Teacher();
    //    t.setNo(17);
    //    t.setDegree(3);
    //    t.setSchool("삭제용");
    //    t.setMajor("메이저321");
    //    t.setWage(5250);
    //    dao.insert(t);

    //    List<Teacher> list = dao.findAll();
    //    for (Teacher t : list) {
    //      System.out.println(t);
    //    }

    //    Teacher t = dao.findByNo(16);
    //    System.out.println(t);

    //    Teacher t = new Teacher();
    //    t.setNo(16);
    //    t.setDegree(4);
    //    t.setSchool("버클리 음악 대학교");
    //    t.setMajor("실용 음악과");
    //    t.setWage(33000);
    //    System.out.println(dao.update(t));

    System.out.println(dao.delete(17));

    con.close();
  }
}























