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
	<h3>�α���</h3>
	<hr>
	<form name="fo" action="/login" method="post">
		<label>����� ID: <input name="id" type="text" size=15><br>
			<label>����� PW: <input name="password" type="password"
				size="15" value=""> <br /> <input type="submit"
				value="Login"> <br /> <input type="button" value="ȸ������"
				onclick="goJoinForm()">
	</form>

</body>
</html>