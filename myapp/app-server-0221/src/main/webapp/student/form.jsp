<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>비트캠프 - NCP 1기</title>
</head>
<body>
<h1>회원(JSP)</h1>
<form action='insert.jsp' method='post'>
<table border='1'>
<tr>
  <th>이름</th>
  <td><input type='text' name='name'></td>
</tr>

<tr>
  <th>이메일</th>
  <td><input type='email' name='email'></td>
</tr>

<tr>
  <th>암호</th>
  <td><input type='password' name='password'></td>
</tr>

<tr>
  <th>전화</th>
  <td><input type='tel' name='tel'></td>
</tr>

<tr>
  <th>우편번호</th>
  <td><input type='text' name='postNo'></td>
</tr>

<tr>
  <th>기본주소</th>
  <td><input type='text' name='basicAddress'></td>
</tr>

<tr>
  <th>상세주소</th>
  <td><input type='tel' name='detailAddress'></td>
</tr>

<tr>
  <th>재직여부</th>
  <td><input type='checkbox' name='working'> 재직중</td>
</tr>

<tr>
  <th>성별</th>
  <td>
    <input type='radio' name='gender' value='M' checked> 남
    <input type='radio' name='gender' value='W'> 여
  </td>
</tr>

<tr>
  <th>전공</th>
  <td>
    <select name='level'>
        <option value='0'>비전공자</option>
        <option value='1'>준전공자</option>
        <option value='2'>전공자</option>
    </select>
  </td>
</tr>

</table>

<div>
  <button>등록</button>
  <button id='btn-cancel' type='button'>취소</button>
</div>

</form>

<script>
document.querySelector('#btn-cancel').onclick = function() {
  location.href = 'list.jsp';
}
</script>

</body>
</html>