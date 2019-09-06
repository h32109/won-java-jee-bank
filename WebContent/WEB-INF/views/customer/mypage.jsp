<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비트은행</title>
</head>
<body>
<h3>환영합니다 ${customer.name}님</h3>
<h3>아이디 ${customer.id}</h3>
<h3>비밀번호 ${customer.pw}</h3>
<h3>주민번호 ${customer.ssn}</h3>
<h3>신용등급 ${customer.credit}</h3>
<input type="hidden" name="action" value="mypage" />
</body>
</html>