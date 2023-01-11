package bitcamp.bootapp.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.bootapp.dao.StudentDao;
import bitcamp.bootapp.vo.Student;


@CrossOrigin(origins = {"http://localhost:5500", "http://127.0.0.1:5500"})
@RestController
public class StudentController {

	StudentDao studentDao = new StudentDao();

	@PostMapping("/students")
	public Object addStudent(
			int pay,
			byte level,
			String name,
			String tel,
			String email,
			String education,
			String university) {

		Student s = new Student();

		s.setPay(pay);
		s.setLevel(level);
		s.setName(name);
		s.setTel(tel);
		s.setEmail(email);
		s.setEducation(education);
		s.setUniversity(university);
		s.setCreatedDate(new Date(System.currentTimeMillis()).toString());
		this.studentDao.insert(s);

		Map<String, Object> contentMap = new HashMap<>();

		contentMap.put("status", "success");
		return contentMap;
	}

	@GetMapping("/students")
	public Object getStudents() {
		Student[] students = this.studentDao.findAll();

		Map<String, Object> contentMap =  new HashMap<>();
		contentMap.put("status", "success");
		contentMap.put("data", students);
		return contentMap;
	}

	@GetMapping("/students/{studentNo}")
	public Object getStudent(@PathVariable int studentNo) {
		Student s = this.studentDao.findByNo(studentNo);

		Map<String, Object> contentMap = new HashMap<>();

		if (s == null) {
			contentMap.put("status", "failure");
			contentMap.put("data", "해당 번호의 강사가 없습니다.");
		} else {
			contentMap.put("success", "success");
			contentMap.put("data", s);
		}
		return contentMap;
	}

	@PutMapping("/students/{no}")
	public Object updateStudent(Student student) {

		Map<String, Object> contentMap = new HashMap<>();

		Student old = this.studentDao.findByNo(student.getNo());
		if (old == null) {
			contentMap.put("status", "failure");
			contentMap.put("data", "학생이 없습니다.");
			return contentMap;
		}

		student.setCreatedDate(old.getCreatedDate());
		this.studentDao.update(student);

		contentMap.put("status", "success");
		return contentMap;
	}

	@DeleteMapping("/students/{studentNo}")
	public Object deleteStudent(@PathVariable int studentNo) {
		// 낱개로 받을때는 @PathVariable 애노테이션을 생략하면 안된다.

		Student s = this.studentDao.findByNo(studentNo);

		// 응답 결과를 담을 맵 객체 준비
		Map<String,Object> contentMap = new HashMap<>();

		if (s == null) {
			contentMap.put("status", "failure");
			contentMap.put("data", "강사가 없습니다.");

		} else {
			this.studentDao.delete(s);
			contentMap.put("status", "success");
		}

		return contentMap;
	}
}
