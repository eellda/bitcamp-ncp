package bitcamp.myapp.controller;

import bitcamp.myapp.service.StudentService;
import bitcamp.myapp.vo.Student;
import bitcamp.util.RestResult;
import bitcamp.util.RestStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

  Logger log = LogManager.getLogger(getClass());

  {
    log.trace("StudentController 생성됨!");
  }

  @Autowired private StudentService studentService;

  @GetMapping("/student/form")
  public void form() {
  }

  @PostMapping("/student/insert")
  public void insert(Student student, Model model) {
    studentService.add(student);
  }

  @GetMapping("students")
  @ResponseBody
  public Object list(String keyword, Model model) {
    return new RestResult()
        .setStatus(RestStatus.SUCCESS)
        .setData(studentService.list(keyword));
  }

  @GetMapping("/students/{no}")
  @ResponseBody
  public Object view(@PathVariable int no) {
    Student student = studentService.get(no);
    return new RestResult()
        .setStatus(RestStatus.SUCCESS)
        .setData(student);
  }

  @PostMapping("/student/update")
  public void update(Student student, Model model) {
    studentService.update(student);
  }

  @PostMapping("/student/delete")
  public void delete(int no, Model model) {
    studentService.delete(no);
  }
}
