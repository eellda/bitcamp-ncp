package bitcamp.myapp.controller;

import bitcamp.myapp.service.StudentService;
import bitcamp.myapp.vo.Student;
import bitcamp.util.RestResult;
import bitcamp.util.RestStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

  Logger log = LogManager.getLogger(getClass());

  {
    log.trace("StudentController 생성됨!");
  }

  @Autowired private StudentService studentService;

  @PostMapping
  public Object insert(@RequestBody Student student) {
    studentService.add(student);
    return new RestResult()
        .setStatus(RestStatus.SUCCESS);
  }

  @GetMapping
  public Object list(String keyword) {
    return new RestResult()
        .setStatus(RestStatus.SUCCESS)
        .setData(studentService.list(keyword));
  }

  @GetMapping("{no}")
  public Object view(@PathVariable int no) {
    return new RestResult()
        .setStatus(RestStatus.SUCCESS)
        .setData(studentService.get(no));
  }

  @PutMapping("{no}")
  public Object update(
      @PathVariable int no,
      @RequestBody Student student) {

    log.debug(student);

    //보안을 위해 URL  번호를 게시글 번호로 설정한다
    student.setNo(no);
    studentService.update(student);
    return new RestResult()
        .setStatus(RestStatus.SUCCESS);
  }

  @DeleteMapping("{no}")
  public Object delete(@PathVariable int no) {
    studentService.delete(no);
    return new RestResult()
        .setStatus(RestStatus.SUCCESS);
  }

}
