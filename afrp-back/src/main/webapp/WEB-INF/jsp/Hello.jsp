<%@ page language="java" contentType="text/html; charset=EUC-KR"
pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset= "utf-8">
    </head>
    <body>
        <h3>로그인성공!</h3>
        <input type="button" value="돌아가기" onclick="goFirstForm()"/>
        <input type="button" value="Logout" onclick="doLogout()"/>
        <script>
        	function goFirstForm() {
				location.href = "login";
			}
        	function doLogout(){
        		
        		location.href = "logout.do"
        	}
        	</script>
    </body>
</html>