<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>회원가입</title>
</head>
<body>
	<form name="joinform" id="joinform" action="/joinform/create.do" method="post">
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="user_name" /></td>
				<td></td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" id="user_id" name="user_id"
					onkeyup="duplicateCheck()" /></td>
				<div id="result_box"></div>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="user_pw" /></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="user_pw2" /></td>
			</tr>
			<tr>
				<td>핸드폰</td>
				<td><input type="text" name="user_phone" /></td>
			</tr>
			<tr>
				<td>E-Mail</td>
				<td><input type="text" name="user_email" /></td>
			</tr>
			<tr>
				<td>팀/권한</td>
				<td><select name="user_type">
						<option value="ROLE_PLAYER">선수</option>
						<option value="ROLE_COACH">감독</option>
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="button" value="완료" onclick="checkValue()" /> 
				<input type="button" value="취소" onclick="goFirstForm()"/></td>
			</tr>
		</table>


	</form>


<script type="text/javascript">
	var result = "1";
	// 아이디 중복체크 화면open
	function duplicateCheck() {
		var user_id = document.getElementById('user_id').value;
		console.log("입력한 아이디", user_id);

		// 1. XHR 생성하기
		var xhr = new XMLHttpRequest(); // 크롬, IE7 +, 사파리, 오페라 사용법

		// 2. XHR에게 요청 URL
		xhr.open("GET", "http://localhost:8080/joinform/check?user_id="+ user_id);

		// 3. 서버에게 요청을 보내기
		// * Get방식일때는 null 을 보냄
		// * Post방식일때는 값을 입력함
		xhr.send(null);

		// 4. XHR에서 이벤트 발생시 실행할 콜백함수 등록하기
		xhr.onreadystatechange = function() {
			//  console.log(xhr.readyState);
			if (xhr.readyState == 4 && xhr.status == 200) {
				result = xhr.responseText;
				console.log("중복여부 :", result);

				var box = document.getElementById("result_box");

				if(result !="1" && user_id == ""){
					box.innerHTML = "<p> </p>"
					return;
				}
					
				
				
				if (result == "N") {
					box.innerHTML = "<p class='text-info'> 가입가능한 아이디 입니다 </p>"
				} else if (result == "Y") {
					box.innerHTML = "<p class='text-danger'> 사용중인 아이디 입니다 </p>"					
				}
			}
		}
	}

	function checkValue() {
		var form = document.joinform;

		if (!form.user_id.value) {
			alert("아이디를 입력하세요.");
			return false;
		}

		if (result != "N") {
			alert("아이디 중복가 중복입니다.");
			return false;
		}

		if (!form.user_pw.value) {
			alert("비밀번호를 입력하세요.");
			return false;
		}

		// 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
		if (form.user_pw.value != form.user_pw2.value) {
			alert("비밀번호를 동일하게 입력하세요.");
			return false;
		}

		if (!form.user_name.value) {
			alert("이름을 입력하세요.");
			return false;
		}

		if (!form.user_email.value) {
			alert("메일 주소를 입력하세요.");
			return false;
		}

		if (!form.user_phone.value) {
			alert("전화번호를 입력하세요.");
			return false;
		}
		
		if (!form.user_type.value) {
			alert("권한을 선택하세요");
			return false;
		}
		
		console.log("제출")
		document.joinform.submit();
	}

	function goFirstForm() {
		location.href = "login";
	}
</script>









</body>
</html>