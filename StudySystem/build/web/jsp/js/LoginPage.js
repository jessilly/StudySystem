function doLogin(){
	
	var userName=$("[name='userName']").val();
	var password=$("[name='password']").val();
	var basePath=$("[name='basePath']").val();
	if(userName.length==0 || password.length==0)
	{
		alert("用户名或密码不能为空!!!");
		return false;
	}
	var type=$('input:radio[name="type"]:checked').val();
	if(type==null){
        alert("请选择角色!!");
        return false;
    }
	
	$.ajax({
		url: basePath+'/login',
		data: {
			'userName': userName,
			'password': password,
			'type': type,
			},			 
	})
	.success(function(data) {
		
		if(data==0)
		{
			alert("用户名或密码错误");
		}else{
			location.href=basePath+"/jsp/MainPage.jsp"
		}
		
	});
}