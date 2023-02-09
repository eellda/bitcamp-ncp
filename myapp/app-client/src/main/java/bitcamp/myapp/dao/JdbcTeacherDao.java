package bitcamp.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;

import bitcamp.myapp.vo.Teacher;

public class JdbcTeacherDao implements TeacherDao {
	@Override
	public void insert(Teacher b) {
		try (Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
				Statement stmt = con.createStatement()) {
			String sql = String.format(
					"insert into app_teacher(name, tel, email, degree, school, major, wage) values('%s', '%s', '%s', '%s', '%s', '%s', '%s')",
					b.getName(),
					b.getTel(),
					b.getEmail(),
					b.getDegree(),
					b.getSchool(),
					b.getMajor(),
					b.getWage());
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Teacher[] findAll() {
		try (Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(
						"select teacher_id, name, tel, degree, major, wage from app_teacher order by teacher_id desc")) {
			LinkedList<Teacher> list = new LinkedList<>();

			while (rs.next()) {
				Teacher s = new Teacher();
				s.setNo(rs.getInt("teacher_id"));
				s.setName(rs.getString("name"));
				s.setTel(rs.getString("tel"));
				s.setDegree(rs.getInt("degree"));
				s.setMajor(rs.getString("major"));
				s.setWage(rs.getInt("wage"));
				list.add(s);
			}
			return list.toArray(new Teacher[] {});
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public Teacher findByNo(int no) {
		try (Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(
						"select teacher_id, name, tel, email, degree, school, major, wage, created_date from app_teacher where teacher_id=" + no)) {

			while (rs.next()) {
				Teacher t = new Teacher();
				t.setNo(rs.getInt("teacher_id"));
				t.setName(rs.getString("name"));
				t.setTel(rs.getString("tel"));
				t.setEmail(rs.getString("email"));
				t.setDegree(rs.getInt("degree"));
				t.setSchool(rs.getString("school"));
				t.setMajor(rs.getString("major"));
				t.setWage(rs.getInt("wage"));
				t.setCreatedDate(rs.getString("created_date"));
				return t;
			}
			return null;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void update(Teacher b) {
		try (Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
				Statement stmt = con.createStatement()) {
			String sql = String.format(
					"update app_teacher set name='%s', tel='%s', email='%s', degree='%s', school='%s', major='%s', wage='%s' where teacher_id=%d",
					b.getName(),
					b.getTel(),
					b.getEmail(),
					b.getDegree(),
					b.getSchool(),
					b.getMajor(),
					b.getWage(),
					b.getNo());
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}

	@Override
	public boolean delete(Teacher b) {
		try (Connection con =
				DriverManager.getConnection(
						"jdbc:mariadb://localhost:3306/studydb", "study", "1111");
				Statement stmt = con.createStatement()) {
			String sql = String.format(
					"delete from app_teacher where teacher_id=%d",
					b.getNo());
			return stmt.executeUpdate(sql) == 1;
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}
}
























