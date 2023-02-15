package bitcamp.myapp.dao.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import bitcamp.myapp.dao.TeacherDao;
import bitcamp.myapp.vo.Teacher;

public class TeacherDaoImpl implements TeacherDao {

  SqlSessionFactory sqlSessionFactory;

  public TeacherDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void insert(Teacher s) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      sqlSession.insert("TeacherMapper.insert", s);
    }
  }

  @Override
  public List<Teacher> findAll() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("TeacherMapper.findAll");
    }
  }

  @Override
  public Teacher findByNo(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectOne("TeacherMapper.findByNo", no);
    }
  }

  @Override
  public int update(Teacher t) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.update("TeacherMapper.update", t);
    }
  }

  @Override
  public int delete(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.delete("TeacherMapper.delete", no);
    }
  }

  //  public static void main(String[] args) throws Exception {
  //    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(
  //        Resources.getResourceAsStream("bitcamp/myapp/config/mybatis-config.xml"));
  //
  //    TeacherDaoImpl dao = new TeacherDaoImpl(sqlSessionFactory);
  //    Teacher s = new Teacher();
  //    s.setNo(46);
  //    s.setDegree(2);
  //    s.setSchool("세종대학교");
  //    s.setMajor("소프트웨어 공학과");
  //    s.setWage(25000);
  //    dao.insert(s);
  //    System.out.println(s);


  //    List<Teacher> list = dao.findAll();
  //    for (Teacher s :list) {
  //      System.out.println(s);
  //    }


  //    Teacher s = dao.findByNo(39);
  //    System.out.println(s);


  //    Teacher s = new Teacher();
  //    s.setNo(39);
  //    s.setDegree(2);
  //    s.setSchool("국민 대학교");
  //    s.setMajor("컴퓨터 보안 학과");
  //    s.setWage(22500);
  //    System.out.println(dao.update(s));

  //    System.out.println(dao.delete(39));
  //}
}























