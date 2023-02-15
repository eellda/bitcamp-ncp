package bitcamp.myapp.dao.impl;

import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import bitcamp.myapp.dao.StudentDao;
import bitcamp.myapp.vo.Student;

public class StudentDaoImpl implements StudentDao {

  SqlSessionFactory sqlSessionFactory;

  public StudentDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void insert(Student s) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      sqlSession.insert("StudentMapper.insert", s);
      sqlSession.commit();
    }
  }

  @Override
  public List<Student> findAll() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("MemberMapper.findAll");
    }
  }

  @Override
  public Student findByNo(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectOne("StudentMapper.findByNo", no);
    }
  }

  @Override
  public List<Student> findByKeyword(String keyword) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("BoardMapper.findByKeyword", keyword);
    }
  }

  @Override
  public int update(Student s) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int n = sqlSession.update("StudentMapper.update", s);
      sqlSession.commit();
      return n;
    }
  }

  @Override
  public int delete(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int n = sqlSession.delete("StudentMapper.delete", no);
      sqlSession.commit();
      return n;
    }
  }

  public static void main(String[] args) throws Exception {
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(
        Resources.getResourceAsStream("bitcamp/myapp/config/mybatis-config.xml"));

    //    StudentDaoImpl dao = new StudentDaoImpl(sqlSessionFactory);

    //    Student s = new Student();
    //    s.setNo(44);
    //    s.setPostNo("6274");
    //    s.setBasicAddress("강남구4");
    //    s.setDetailAddress("서초대로4");
    //    s.setWorking(false);
    //    s.setGender('W');
    //    s.setLevel((byte) 0);
    //    dao.insert(s);
    //    System.out.println(s);


    //    List<Student> list = dao.findAll();
    //    for (Student s :list) {
    //      System.out.println(s);
    //    }


    //    Student s = dao.findByNo(44);
    //    System.out.println(s);


    //    Student s = new Student();
    //    s.setNo(44);
    //    s.setPostNo("12332");
    //    s.setBasicAddress("강남구102");
    //    s.setDetailAddress("서초대로102");
    //    s.setWorking(false);
    //    s.setGender('W');
    //    s.setLevel((byte) 1);
    //    System.out.println(dao.update(s));

    //    System.out.println(dao.delete(27));

  }
}























