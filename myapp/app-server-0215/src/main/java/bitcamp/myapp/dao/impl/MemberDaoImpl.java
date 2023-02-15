package bitcamp.myapp.dao.impl;

import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.vo.Member;

public class MemberDaoImpl implements MemberDao {

  SqlSessionFactory sqlSessionFactory;

  public MemberDaoImpl(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  @Override
  public void insert(Member m) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      sqlSession.insert("MemberMapper.insert", m);
      sqlSession.commit();
    }
  }

  @Override
  public List<Member> findAll() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectList("MemberMapper.findAll");
    }
  }

  @Override
  public Member findByNo(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      return sqlSession.selectOne("MemberMapper.findByNo", no);
    }
  }

  @Override
  public int update(Member m) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int n = sqlSession.update("MemberMapper.update", m);
      sqlSession.commit();
      return n;
    }
  }

  @Override
  public int delete(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      int n = sqlSession.delete("MemberMapper.delete", no);
      sqlSession.commit();
      return n;
    }
  }

  public static void main(String[] args) throws Exception {
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(
        Resources.getResourceAsStream("bitcamp/myapp/config/mybatis-config.xml"));

    MemberDaoImpl dao = new MemberDaoImpl(sqlSessionFactory);
    //
    Member m = new Member();
    m.setName("학생용2");
    m.setEmail("hac3@test.com");
    m.setPassword("2222");
    m.setTel("010-2222-2222");
    dao.insert(m);
    System.out.println(m);


    //    List<Member> list = dao.findAll();
    //    for (Member m :list) {
    //      System.out.println(m);
    //    }


    //    Member m = dao.findByNo(41);
    //    System.out.println(m);


    //    Member m = new Member();
    //    m.setNo(40);
    //    m.setName("test11");
    //    m.setEmail("numbertest1@test.com");
    //    m.setPassword("1");
    //    m.setTel("1111");
    //    System.out.println(dao.update(m));


    //    System.out.println(dao.delete(41));
  }
}























