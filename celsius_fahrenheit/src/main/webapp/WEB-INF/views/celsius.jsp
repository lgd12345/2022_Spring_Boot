<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>섭씨 화씨 변경</title>
</head>
<body>
<h1>섭씨 온도를 입력해주세요 화씨로 전환하겠습니다.</h1>
<form action="celsius" method="post">
<p>섭씨: <input type="text" id="Celsius" name="Celsius" required="required" >&nbsp;<button>입력</button></p>
</form>
<hr/>
<c:if test="${Celsius ne null}"><a><h2>섭씨 ${Celsius} 에 대한 화씨는 ${fahrenheit} 다</h2></a></c:if>
<a href="/">홈으로</a>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
    $(document).ready(function() {
        let message = "${msg}";
        
        if (message != "") {
            alert(message);
        }
    })
</script>
</body>
</html>