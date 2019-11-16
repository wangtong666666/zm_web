layui.use('layer', function(){
    var layer = layui.layer;
});

$(function(){

	/*登陆*/
	var postFlag =false;
	$(".login").click(function () {

	    $(".login").html("正在登录...");
	    if (postFlag) {
	        return false; //如果正在提交则结束
	    }else {
	    	var userName = $(".IDInputOne").val()
			var password = $(".IDInputTwo").val()
            ajax_datatypeByData('POST',Aurl+'pub/login',"userName="+userName+"&password="+password,successFun);
            function successFun(data) {
				console.log(data);
				if(data.status == 200){
                    window.location.href = "authc/index";
				}else{
                    layer.alert(data.message,{icon:2});
                    $(".hint-msg").html(data.message);
                    $(".hint").show();
                    $(".login").html("登录")
                    postFlag = false; //传送失败或不是想要的值后，将postFlag重归为false
                    return false;
                }
            }

	    }
	        
	})



})

/*忘记密码*/
$(".forgetText").click(function () {	
    window.location.href="wangji.jsp";
});
/*回车登录*/
$(document).keydown(function (event) {
    if (event.keyCode == 13) {//回车键对应code值为13
        $(".login").click();//类选择器选择按钮
    }
});