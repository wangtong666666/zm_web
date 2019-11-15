<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/commons.jspf" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>智麻系统</title>
    <link rel="icon" href='images/logoIcon.png' type="image/x-icon">
    <link rel="stylesheet" href="css/iconfont.css">
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<!--大背景-->
<div class="big">
    <!--安全区-->
    <div class="safeArea">
        <!--教学系统-->
        <div class="system"> 
            <!--图片-->
            <img src="images/login.png" alt="" class="systemImg">
            <!--登陆部分-->
            <div class="landing">
            
           		<!--提示-->
           		
           		<div class="hint">
           			<b class="hint-b"></b>
           			
           			
           		
           		<p class="hint-msg">登录失败,用户名或密码有误！</p>
           		
           		
           		</div>
           		
               
            
                <!--标题-->
                <a href="javascript:void(0)" class="headline"></a>
                <!--账号-->
                <div class="ID">
                    <p class="IDImg iconfont icon-yonghu"></p>
                    <input type="text" class="IDInput IDInputOne" placeholder="账号">
                </div>
                <!--密码-->
                <div class="ID">
                    <p class="IDImg code iconfont icon-mima"></p>
                    <input type="password" class="IDInput IDInputTwo" placeholder="密码">
                </div>

                <p class="verify-wrap" id="verify-wrap"></p>
                
                <!--登陆-->
                <a href="javascript:void(0)" class="login">登录</a>
                <!--忘记密码-->
                <p class="forget">
                    <span class="forgetText">忘记密码>></span>
                </p>
            </div>
        </div>
    </div>
</div>
</body>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="js/jquery-1.12.4.js"></script>
<script src="js/ajax.js?z=<%=System.currentTimeMillis()%>"></script>
<script src="js/login.js?z=<%=System.currentTimeMillis()%>"></script>
<script src="js/jq-slideVerify.js" type="text/javascript" charset="utf-8"></script>
</html>
