<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비트 은행</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<div>
    <h2>환영합니다</h2>
    <table border = '1'>
    	<tr>
    		<td>로그인</td>
    		<td><input id="btn"   type="button"  value="Login" /></td>
    	</tr>
    	<tr>
    		<td>회원가입</td>
    		<td><a id="lbtn" href="#">SIgn in</a></td>
    	</tr>
    </table>
    
</div>
<script>
	$('#btn').click(function(){
		alert('버튼 클릭!!');
		location.assign('<%=request.getContextPath()%>/customer.do?page=login');
	});
	
	$('#lbtn').click(function(){
		alert('회원가입 클릭');
		location.assign('<%=request.getContextPath()%>/customer.do?page=join ');
	});
</script>
</body>
</html>