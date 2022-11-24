<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<!-- <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>독립적으로 넣고 내가 만든 건 따로 넣기..? 
제이쿼리는 웹사이트에 자바스크립트를 쉽게 활용할 수 있도록 도와주는 오픈소스 기반의 자바스크립트 라이브러리-->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<body>
	list
	<div id="memberDiv">
		<%-- <c:forEach items="${lists}" var="member"> 첫번째 리스트컨트롤러--%>
		<c:forEach items="${lists.content}" var="member">
		아이디:${member.id}<br />
		주소:${member.addr}<br />
		이메일:${member.email}<br />
		메모:${member.memo}<br />
			<a href="detail/${member.id}">상세보기</a>
			<a href="javascript:funDetail(${member.id})">상세보기_ajax</a>
			<!--button 타입 디폴트 서브밋 type을 butten으로 설정해준다. 오늘은 비동기 함수로 삭제 구현할 거임!! -->
			<button type="butten" onclick="funDelete(${member.id})">삭제</button>
			<button type="butten" class="btnDel" data-mid="${member.id}">삭제class</button>
			<br>
			<br />
			<!--"detail?/가 아닌 "detail/${member.id}" 주소인 레스트방식으로
			컨트롤러에서 이런식을 표현해야함 @GetMapping("/detail/{id}") -->
			<hr>
		</c:forEach>
	</div>
	
	<a href="?page=${lists.number-1}">이전</a>
	<a href="?page=${lists.number+1}">다음</a>
	<br>
	<a href="/join">insert</a>
	<br />
	<a href="/">home</a>
	<hr />
	
	<div id="detailDiv"></div>
	
	<script>
	function funDetail(id){
		/* alert(id) */
		$.ajax({
			type:'get',
			url:'/detail2/'+id
		})
		.done(function(resp){
			/* alert("성공:"+resp.name) */
			str=resp.name+"<br/>"
			str+=resp.email+"<br/>"
			str+=resp.memo+"<br/>"
			$("#detailDiv").html(str);
		})
		.fail(function(e){
			alert('실패')
		})
	}
	//같은말 밑에랑 변수에 함수를 담아서 실행되게 함 
	//resp+'번 삭제 성공' 리스폰스바디설명하려고 넣음 (몇번)삭제..
	var delfun = function(){
		$.ajax({
			type:'DELETE',
			url:'/delete/'+$(this).data('mid')
		})
		.done(function(resp){
			alert(resp+'번 삭제 성공')
			location.href='/list'
		})
		.fail(function(e){
			alert('삭제실패')
		})
	}
	$("#memberDiv").on("click",".btnDel",delfun)
	
	/*
	$("#memberDiv").on("click",".btnDel",function(){
		//alert($(this).attr('data-mid')) 밑에랑 같은 말
		//alert($(this).data('mid'))
		$.ajax({
			type:'DELETE',
			url:'/delete/'+$(this).data('mid')
		})
		.done(function(resp){
			alert(resp+'번 삭제 성공')
			location.href='/list'
		})
		.fail(function(e){
			alert('삭제실패')
		})
	})
	 */
		function funDelete(id) {
			//alert(id)
			$.ajax({
				type:'DELETE',
				url:'/delete/'+id
			})
			.done(function(resp){
				alert(resp+'번 삭제 성공')
				location.href='/list'
			})
			.fail(function(e){
				alert('삭제실패')
			})
		}
	</script>
</body>
</html>