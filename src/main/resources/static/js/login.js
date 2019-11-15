
$(function(){

	var SlideVerifyPlug = window.slideVerifyPlug;
	var slideVerify = new SlideVerifyPlug('#verify-wrap',{ 
		wrapWidth:'400',//设置 容器的宽度 ，默认为 350 
        initText:'拖动滑块验证',  //设置  初始的 显示文字
        sucessText:'验证通过',//设置 验证通过 显示的文字
        getSucessState:function(res){
       		//当验证完成的时候 会 返回 res 值 true，只留了这个应该够用了
       	}
	});

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
		if(slideVerify.slideFinishState == false){
		    $(".hint-msg").html("请拖动滑块进行验证！");
		    $(".hint").show();
			return;
		}
	    $(".login").html("正在登录...");
	    if (postFlag) {
	        return false; //如果正在提交则结束
	    }else {
	    	//获取登录信息
	    	postFlag = true;
	    	login_ajax(Aurl+'login/selectLoginMessage.action',true,"loginName="+$(".IDInputOne").val(),successFun,errorFun);
	    	function errorFun(data) {
	    		$(".hint-msg").html("获取登录信息失败！");
    			$(".hint").show();
	    		$(".login").html("登录")
				slideVerify.resetVerify(); 
                postFlag = false; //传送失败或不是想要的值后，将postFlag重归为false
	    	}
	  
	    	function successFun(data) {
	    		 if(data.code == 1){
	    			 localVerify = data.result.localVerify;
	    			 videoUrl = data.result.videoHttpUrl;
	    			 /* console.log(videoUrl)
	    			 alert(videoUrl) */
	    			 //如果开启本地验证
	    			 if(localVerify == 1){
	    			//	 alert(localVerify == 1);
	    				 //获取登录秘钥
	    				 login_ajax(videoUrl+'attestation/getAttestation',false,"",successFun2,errorFun2);
	    				 function successFun2(data) {
	    		    		 if(data.status == 200){
	    		    			 secretKey = data.data; //登录秘钥
	    		    		 }else{
	    		    			 $(".hint-msg").html(data.message);
	    		    			 $(".hint").show();
	    		    			 $(".login").html("登录")
	    		    			 slideVerify.resetVerify();
	    		    			 postFlag = false; //传送失败或不是想要的值后，将postFlag重归为false
	    		    			 return;
	    		    		 }
	    				 }
	    				 function errorFun2(data) {
	    			    		
	    			    		$(".hint-msg").html("获取本地登录秘钥失败！");
	    		    			$(".hint").show();
	    			    		$(".login").html("登录")
	    						slideVerify.resetVerify(); 
	    		                postFlag = false; //传送失败或不是想要的值后，将postFlag重归为false
	    			    	}
	    			 }
	    			 
	    			 
	    			 if(postFlag == false){
	    				 return;
	    			 }
	    			 //登录
	    			 login_ajax(Aurl+'login/main.action',false,"loginName="+$(".IDInputOne").val()+"&loginPwd="+$(".IDInputTwo").val()+"&secretKey="+secretKey,successFun3,errorFun3);
	    			 function errorFun3(data) {
						 console.log(data)
	    		    		$(".hint-msg").html("登录失败！");
	    	    			$(".hint").show();
	    		    		$(".login").html("登录")
	    					slideVerify.resetVerify(); 
	    	                postFlag = false; //传送失败或不是想要的值后，将postFlag重归为false
	    			 }
	    			 function successFun3(result) {
 		                if (result.code != "0") { //我这里设置result.errorCode == 0为传送成功或获得想要
 		                    $(".login").html("登录") ;
 		                    localStorage['UsertypeSelect']=JSON.stringify(result);
 		                	if(result.result.roleKey == 110){
 		                		window.location.href="/zm/pages/principal/totalAccount.jsp";
 		                	}else if(result.result.roleKey == 111){
 		                		window.location.href="/zm/pages/principal/superAccount.jsp";
 		                	}else if (result.code == "2"){
 		                		dog();
 		                		//调查询咨询记录
 								ajax_datatypeByJsonCon("post", "pmsstudentadvisoryrecord/selectLastStudentRecord.action", "", myfunc02ka50);
 		                        function myfunc02ka50(only){
 		                        	if(only.result.length != 0){
 			                            if (only.result[0].remark==""){
 			                                window.location.href="/zm/indexMine.jsp";
 			                            }
 			                            else {
 			                               window.location.href="/zm/zixunbiao.jsp";
 			                            }
 		                        	}else{
 		                        		window.location.href="/zm/zixunbiao.jsp";
 		                        	}
 		                        }
 		                		
 		                		//
 		                	}else{
 		                		dog();
 		                		window.location.href="/zm/indexMine.jsp";
 		                	}
 		                    
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
	    		 }else if(data.code == 0){
	    			 $(".hint-msg").html(data.msg);
	    			 $(".hint").show();
	    			 $(".login").html("登录")
	    			 slideVerify.resetVerify();
	    			 postFlag = false; //传送失败或不是想要的值后，将postFlag重归为false
	    			 return;
	    		 }
	    	}
	    	
	  
	  
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