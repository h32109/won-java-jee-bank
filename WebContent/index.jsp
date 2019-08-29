<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>은행관리프로그램</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<div>
    <h2>통장 만들기</h2>
     <form action=""></form>
     
     <form id = "join_form" action="<%=request.getContextPath()%>/account.do">
         입금액<input type="text" name ="money" /> <br/>
         <input type="submit" id="test" value = "전송">
    
    </form> 
</div>
<script>
$('#join_form').submit(function(){
    alert('테스트 클릭!!');
});
</script>

</body>
</html>