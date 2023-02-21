
<%@ page import="bitcamp.myapp.vo.Student"%>
<%@ page import="java.util.List"%>
<%@ page import="bitcamp.myapp.dao.StudentDao"%>
<%@ page import="bitcamp.myapp.dao.MemberDao"%>
<%@ page import="bitcamp.util.TransactionManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%! 
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
%>


<%
    int studentNo = Integer.parseInt(request.getParameter("no"));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>비트캠프 - NCP 1기</title>
</head>
<body>
<h1>회원(JSP)</h1>
<%
    txManager.startTransaction();
    try {
      if (studentDao.delete(studentNo) == 1 &&
          memberDao.delete(studentNo) == 1) {
        txManager.commit();
%>
    <p>삭제했습니다.</p>
<%
      } else {
%>
    <p>해당 번호의 회원이 없습니다.</p>
<%
      }
    } catch (Exception e) {
      txManager.rollback();
%>
  <p>삭제 실패입니다.</p>
<%
      e.printStackTrace();
    }
%>
</body>
</html>
<%
    response.setHeader("Refresh", "1;url=list.jsp");
%>