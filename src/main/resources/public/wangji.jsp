<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/commons.jspf" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <title>忘记密码</title>
    <link rel="icon" href='images/logoIcon.png' type="image/x-icon">
    <link rel="stylesheet" href="css/iconfont.css">
    <link rel="stylesheet" href="css/iconfont02.css">
    <link rel="stylesheet" href="css/wangji.css">
</head>
<body> 
<!--主体-->
<div class="bigWrap">
    <!--中心-->
    <div class="big">
        <!--忘记密码-->
        <p class="title">忘记密码</p>
        <!--修改流程-->
        <div class="processWrap">
            <!--123-->
            <div class="process">
                <!--横线-->
                <p class="striping0"></p>
                <p class="striping01"></p>
                <p class="striping1">1</p>
                <p class="striping2">2</p>
                <p class="striping3">3</p>
                <p class="striping4">验证手机号</p>
                <p class="striping5">设置新密码</p>
                <p class="striping6">完成</p>
            </div>
            <!--验证流程-->
            <div class="stepWrap">
                <!--验证手机号-->
                <div class="stepWrap01">
                    <input type="text" class="number numberOne" maxlength="11" onblur="num()" placeholder="请输入手机号码">
                    <p class="error">手机号码有误！</p>
                    <input type="text" class="number01 number01One addShu" onblur="num01()" placeholder="请输入验证码">
                    <input type="button" id="btn" value="发送验证码" onclick="settime(this)" class="verification" />
                    <p class="error01">验证码有误！</p>
                    <p class="step step01 addPointer">下一步</p>
                </div>
                <!--设置新密码-->
                <div class="stepWrap02">
                    <input type="password" class="number numberTwo" placeholder="请输入新密码">
                    <p class="keJian keJian01 iconfont icon-bukejian icon-kejian"></p>
                    <p class="error02">密码为6-16位，由字母和数字组成！</p>
                    <input type="password" class="number01 number01Two addShu" placeholder="请再次输入新密码">
                    <p class="keJian keJian02 iconfont icon-bukejian icon-kejian addKjian"></p>
                    <p class="error03">密码输入不一致！</p>
                    <p class="error04">未通过验证或验证已过期，请重新验证！</p>
                    <p class="step step02 addPointer">下一步</p>
                </div>
                <!--完成-->
                <div class="stepWrap03">
                    <p class="counterImg iconfont icon-duihao"></p>
                    <p class="counterTetx">提交成功！</p>
                    <p class="step step03">返回登录页</p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js "></script>
<script src="js/ajax.js"></script>
<script src="js/wangji.js"></script>
</html>