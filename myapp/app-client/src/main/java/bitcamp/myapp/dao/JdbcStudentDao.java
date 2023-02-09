package bitcamp.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import bitcamp.myapp.vo.Student;

public class JdbcStudentDao implements StudentDao {
	@Override
	public void insert(Student b) {
		try (Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
				Statement stmt = con.createStatement()) {
			String sql = String.format(
					"insert into app_student(name, tel, pst_no, bas_addr, det_addr, work, gender, level) values('%s', '%s', '%s', '%s', '%s', %b, '%s', %d)",
					b.getName(),
					b.getTel(),
					b.getPostNo(),
					b.getBasicAddress(),
					b.getDetailAddress(),
					b.isWorking(),
					b.getGender(),
					b.getLevel());
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Student[] findAll() {
		try (Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select student_id, name, tel, work, level from app_student order by student_id desc")) {
			LinkedList<Student> list = new LinkedList<>();

			while (rs.next()) {
				Student s = new Student();
				s.setNo(rs.getInt("student_id"));
				s.setName(rs.getString("name"));
				s.setTel(rs.getString("tel"));
				s.setWorking(rs.getBoolean("work"));
				s.setLevel(rs.getByte("level"));
				list.add(s);
			}
			return list.toArray(new Student[] {});
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Student findByNo(int no) {
		try (Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(
						"select student_id, name, tel, pst_no, bas_addr, det_addr, work, gender, level, created_date from app_student where student_id=" + no)) {

			while (rs.next()) {
				Student s = new Student();
				s.setNo(rs.getInt("student_id"));
				s.setName(rs.getString("name"));
				s.setTel(rs.getString("tel"));
				s.setPostNo(rs.getString("pst_no"));
				s.setBasicAddress(rs.getString("bas_addr"));
				s.setDetailAddress(rs.getString("det_addr"));
				s.setWorking(rs.getBoolean("work"));
				s.setGender(rs.getString("gender").charAt(0));
				s.setLevel(rs.getByte("level"));
				s.setCreatedDate(rs.getString("created_date"));
				return s;
			}
			return null;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void update(Student b) {
		try (Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
				Statement stmt = con.createStatement()) {
			String sql = String.format(
					"update app_student set name='%s', tel='%s', pst_no='%s', bas_addr='%s', det_addr='%s', work=%s, gender='%s', level=%s where student_id=%d",
					b.getName(),
					b.getTel(),
					b.getPostNo(),
					b.getBasicAddress(),
					b.getDetailAddress(),
					b.isWorking(),
					b.getGender(),
					b.getLevel(),
					b.getNo());
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public boolean delete(Student b) {
		try (Connection con =
				DriverManager.getConnection(
						"jdbc:mariadb://localhost:3306/studydb", "study", "1111");
				Statement stmt = con.createStatement()) {
			String sql = String.format(
					"delete from app_student where student_id=%d",
					b.getNo());
			return stmt.executeUpdate(sql) == 1;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
}

























