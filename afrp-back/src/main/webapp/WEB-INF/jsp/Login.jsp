<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<title>login form</title>
<script type = "text/javascript">
        function goJoinForm(){
            location.href="joinform";
        }
</script>
</head>
<body>
	<h3>로그인</h3>
	<hr>
	<form name="fo" action="/login" method="post">
		<label>사용자 ID: <input name="id" type="text" size=15><br>
			<label>사용자 PW: <input name="password" type="password"
				size="15" value=""> <br /> <input type="submit"
				value="Login"> <br /> <input type="button" value="회원가입"
				onclick="goJoinForm()">
	</form>

</body>
</html>