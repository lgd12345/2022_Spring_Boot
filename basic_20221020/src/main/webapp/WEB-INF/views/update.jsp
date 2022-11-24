<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<body>
	id :
	<input type="text" id="id" name="id" value="${member.id}"
		readonly="readonly" /><br /> 
		Name :<input type="text" id="name" name="name" value="${member.name}" /><br />

	<p>
		Password: <input type="text" id="password" name="password">
	</p>
	<br />

	<p>Email : <input type="text" id="email" name="email"value="${member.email}">
	</p>
	<br />

	<p>
		Addr : <input type="text" id="addr" name="addr" size="30"value="${member.addr}">
	</p>
	<br />

	<p>
		Memo :<textarea rows="5" cols="50" id="memo" name="memo">${member.memo}</textarea>
	</p>
	<!--자바스크립트를 이용해서 할 것 임 근데 이번에 외부로 할 것이다. src로 -->
	<button type="button" id="btnUpdate">Submit</button>
	<script src="/js/member.js"></script>
</body>
</html>