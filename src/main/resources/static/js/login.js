
$(function(){



	/* $("#resetBtn").on('click',function(){
		slideVerify.resetVerify();//可以重置 插件 回到初始状态
	}) */
	$("#getState").on('click',function(){
		   //这个可以拿到 当前验证状态  是否完成
	})	
	/*登陆*/
	var postFlag =false;
	var localVerify = 0;
	var videoUrl = '';
	var secretKey = '';
	$(".login").click(function () {

	    $(".login").html("正在登录...");
	    if (postFlag) {
	        return false; //如果正在提交则结束
	    }else {
	    	//获取登录信息
	    			 
	    			 if(postFlag == false){
	    				 return;
	    			 }
	    			 //登录
	    			 login_ajax(Aurl+'login/main.action',false,"loginName="+$(".IDInputOne").val()+"&loginPwd="+$(".IDInputTwo").val()+"&secretKey="+secretKey,successFun,errorFun);
	    			 function errorFun(data) {
						 console.log(data)
	    		    		$(".hint-msg").html("登录失败！");
	    	    			$(".hint").show();
	    		    		$(".login").html("登录")
	    					slideVerify.resetVerify(); 
	    	                postFlag = false; //传送失败或不是想要的值后，将postFlag重归为false
	    			 }
	    			 function successFun(result) {
 		                if (result.code != "0") { //我这里设置result.errorCode == 0为传送成功或获得想要
 		                    $(".login").html("登录") ;

 		                		window.location.href="/zm/indexMine.jsp";

 		                    
 		                    return false;
 		                }else{
 		                	$(".hint-msg").html(result.msg);
 		                    $(".hint").show();
 		                    $(".login").html("登录")
 							slideVerify.resetVerify();
 		                    postFlag = false; //传送失败或不是想要的值后，将postFlag重归为false
 							return false;
 		                }
 		            
    				 }
	    			 postFlag = true; 
	    }
	        
	})

   //账号密码有误时,重新编辑
   $(".IDInput").focus(function(){
   	 console.log("hihi")
   	 $(".hint").hide();
   	 slideVerify.resetVerify();//可以重置 插件 回到初始状态
   	 postFlag = false; 
   })


})

function login_ajax(url,async_boolean,text_data,success_fun,error_fun) {//data数据可以为空
    $.ajax({
        type: "post",             
        url: url,
        dataType:"json",
        async:async_boolean,
        data: text_data,
        beforSend: function () {
            // 禁用按钮防止重复提交
            $("#submit").attr({disabled: "disabled"});
        },
        error: function (data) {
            //请求失败时被调用的函数
        	error_fun(data);
        },
        success: function (data) {
        	success_fun(data);
        }
    });
}

function dog(){   
//	alert("login.js :114行报的错！");
	ajax_datatypeByScript("post", "pmsteachoutline/selectOultineOnHome.action", "isShow=1", mgkifunc1one);
//	alert("login.js :114行报的错！");
}
function mgkifunc1one(only){
	localStorage['outlineHome']=JSON.stringify(only);   
}
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