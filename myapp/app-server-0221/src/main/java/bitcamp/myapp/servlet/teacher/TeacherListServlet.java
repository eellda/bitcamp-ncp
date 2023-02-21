package bitcamp.myapp.servlet.teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.TeacherDao;
import bitcamp.myapp.vo.Teacher;
import bitcamp.util.TransactionManager;

@WebServlet("/teacher/list")
public class TeacherListServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private TransactionManager txManager;
  private MemberDao memberDao;
  private TeacherDao teacherDao;

  @Override
  public void init() {

    ServletContext ctx = getServletContext();
    teacherDao = (TeacherDao) ctx.getAttribute("teacherDao");

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>비트캠프 - NCP 1기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>강사</h1>");

    out.println("<div><a href='form'>새 강사</a></div>");

    out.println("<table border='1'>");
    out.println("<tr>");
    out.println("  <th>번호</th> <th>이름</th> <th>전화</th> <th>학위</th> <th>전공</th> <th>시강료</th>");
    out.println("</tr>");

    List<Teacher> students = this.teacherDao.findAll();

    for (Teacher student : students) {
      out.println("<tr>");
      out.printf("  <td>%d</td> <td><a href='view?no=%d'>%s</a></td> <td>%s</td> <td>%s</td> <td>%s</td> <td>%d</td>\n",
          student.getNo(),
          student.getNo(),
          student.getName(),
          student.getTel(),
          getDegreeText(student.getDegree()),
          student.getMajor(),
          student.getWage());
      out.println("</tr>");
    }
    out.println("</table>");

    out.println("</body>");
    out.println("</html>");
  }

  private static String getDegreeText(int degree) {
    switch (degree) {
      case 1: return "고졸";
      case 2: return "전문학사";
      case 3: return "학사";
      case 4: return "석사";
      case 5: return "박사";
      default: return "기타";
    }
  }
}
