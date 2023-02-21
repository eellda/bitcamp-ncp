package bitcamp.myapp.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.dao.StudentDao;
import bitcamp.myapp.vo.Student;
import bitcamp.util.TransactionManager;

@WebServlet("/student/update")
public class StudentUpdateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private TransactionManager txManager;
  private MemberDao memberDao;
  private StudentDao studentDao;

  @Override
  public void init() {

    ServletContext ctx = getServletContext();
    studentDao = (StudentDao) ctx.getAttribute("studentDao");
    memberDao = (MemberDao) ctx.getAttribute("memberDao");
    txManager = (TransactionManager) ctx.getAttribute("txManager");

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Student student = new Student();
    student.setNo(Integer.parseInt(request.getParameter("no")));
    student.setName(request.getParameter("name"));
    student.setEmail(request.getParameter("email"));
    student.setPassword(request.getParameter("password"));
    student.setTel(request.getParameter("tel"));
    student.setPostNo(request.getParameter("postNo"));
    student.setBasicAddress(request.getParameter("basicAddress"));
    student.setDetailAddress(request.getParameter("detailAddress"));
    student.setWorking(request.getParameter("working") != null);
    student.setGender(request.getParameter("gender").charAt(0));
    student.setLevel(Byte.parseByte(request.getParameter("level")));

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>비트캠프 - NCP 1기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원</h1>");


    txManager.startTransaction();
    try {
      if (memberDao.update(student) == 1 &&
          studentDao.update(student) == 1) {
        txManager.commit();
        out.println("<p>변경했습니다.</p>");

      } else {
        out.println("<p>해당 번호의 회원이 없습니다.</p>");
      }
    } catch (Exception e) {
      txManager.rollback();
      out.println("<p>변경 실패입니다.</p>");
      e.printStackTrace();
    }

    out.println("</body>");
    out.println("</html>");

    response.setHeader("Refresh", "1;url=list");
  }

}