$("#btnUpdate").click(function(){
	//alert('수정')
	//val은 input안에 있어서 String이 아니고 value이기 때문에 val이라고 해야한다.
	var dataParam = {
		"id" :$("#id").val(),
		"name":$("#name").val(),
		"password":$("#password").val(),
		"email":$("#email").val(),
		"addr":$("#addr").val(),
		"memo":$("#memo").val()
	}
	$.ajax({
		type:'PUT',
		url:"/update/",
		data:JSON.stringify(dataParam),
		contentType:"application/json;charset=utf-8"
	})
	
	.done(function(resp){
		alert(resp+" : 수정성공")
		location.href="/list"
	})
	.fail(function(e){
		alert(e + "수정실패")
	})
})