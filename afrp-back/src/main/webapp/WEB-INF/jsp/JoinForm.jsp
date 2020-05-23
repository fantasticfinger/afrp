<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>ȸ������</title>
</head>
<body>
	<form name="joinform" id="joinform" action="/joinform/create.do" method="post">
		<table>
			<tr>
				<td>�̸�</td>
				<td><input type="text" name="user_name" /></td>
				<td></td>
			</tr>
			<tr>
				<td>���̵�</td>
				<td><input type="text" id="user_id" name="user_id"
					onkeyup="duplicateCheck()" /></td>
				<div id="result_box"></div>
			</tr>
			<tr>
				<td>��й�ȣ</td>
				<td><input type="password" name="user_pw" /></td>
			</tr>
			<tr>
				<td>��й�ȣ Ȯ��</td>
				<td><input type="password" name="user_pw2" /></td>
			</tr>
			<tr>
				<td>�ڵ���</td>
				<td><input type="text" name="user_phone" /></td>
			</tr>
			<tr>
				<td>E-Mail</td>
				<td><input type="text" name="user_email" /></td>
			</tr>
			<tr>
				<td>��/����</td>
				<td><select name="user_type">
						<option value="ROLE_PLAYER">����</option>
						<option value="ROLE_COACH">����</option>
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="button" value="�Ϸ�" onclick="checkValue()" /> 
				<input type="button" value="���" onclick="goFirstForm()"/></td>
			</tr>
		</table>


	</form>


<script type="text/javascript">
	var result = "1";
	// ���̵� �ߺ�üũ ȭ��open
	function duplicateCheck() {
		var user_id = document.getElementById('user_id').value;
		console.log("�Է��� ���̵�", user_id);

		// 1. XHR �����ϱ�
		var xhr = new XMLHttpRequest(); // ũ��, IE7 +, ���ĸ�, ����� ����

		// 2. XHR���� ��û URL
		xhr.open("GET", "http://localhost:8080/joinform/check?user_id="+ user_id);

		// 3. �������� ��û�� ������
		// * Get����϶��� null �� ����
		// * Post����϶��� ���� �Է���
		xhr.send(null);

		// 4. XHR���� �̺�Ʈ �߻��� ������ �ݹ��Լ� ����ϱ�
		xhr.onreadystatechange = function() {
			//  console.log(xhr.readyState);
			if (xhr.readyState == 4 && xhr.status == 200) {
				result = xhr.responseText;
				console.log("�ߺ����� :", result);

				var box = document.getElementById("result_box");

				if(result !="1" && user_id == ""){
					box.innerHTML = "<p> </p>"
					return;
				}
					
				
				
				if (result == "N") {
					box.innerHTML = "<p class='text-info'> ���԰����� ���̵� �Դϴ� </p>"
				} else if (result == "Y") {
					box.innerHTML = "<p class='text-danger'> ������� ���̵� �Դϴ� </p>"					
				}
			}
		}
	}

	function checkValue() {
		var form = document.joinform;

		if (!form.user_id.value) {
			alert("���̵� �Է��ϼ���.");
			return false;
		}

		if (result != "N") {
			alert("���̵� �ߺ��� �ߺ��Դϴ�.");
			return false;
		}

		if (!form.user_pw.value) {
			alert("��й�ȣ�� �Է��ϼ���.");
			return false;
		}

		// ��й�ȣ�� ��й�ȣ Ȯ�ο� �Էµ� ���� �������� Ȯ��
		if (form.user_pw.value != form.user_pw2.value) {
			alert("��й�ȣ�� �����ϰ� �Է��ϼ���.");
			return false;
		}

		if (!form.user_name.value) {
			alert("�̸��� �Է��ϼ���.");
			return false;
		}

		if (!form.user_email.value) {
			alert("���� �ּҸ� �Է��ϼ���.");
			return false;
		}

		if (!form.user_phone.value) {
			alert("��ȭ��ȣ�� �Է��ϼ���.");
			return false;
		}
		
		if (!form.user_type.value) {
			alert("������ �����ϼ���");
			return false;
		}
		
		console.log("����")
		document.joinform.submit();
	}

	function goFirstForm() {
		location.href = "login";
	}
</script>









</body>
</html>