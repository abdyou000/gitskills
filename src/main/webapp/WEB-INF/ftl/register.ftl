<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>注册</title>
<link rel="shortcut icon" href="../img/favicon.ico" />
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/gloab.css" rel="stylesheet">
<link href="../css/register.css" rel="stylesheet">
<script src="../js/jquery.min.js"></script>
<script src="../js/register.js"></script>
</head>
<body class="bgf4">
<div class="login-box f-mt10 f-pb50">
	<div class="main bgf">    
    	<div class="reg-box-pan display-inline">  
        	
        	<div class="reg-box" id="verifyCheck" style="margin-top:20px;">
        		<form action="${request.contextPath}/user/register" method="POST" id="form1">
	            	<div class="part1">                	
	                    <div class="item col-xs-12">
	                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>用户名：</span>    
	                        <div class="f-fl item-ifo">
	                            <input name="username" type="text" maxlength="20" class="txt03 f-r3 required" tabindex="1" data-valid="isNonEmpty||between:3-20||isUname" data-error="用户名不能为空||用户名长度3-20位||只能输入中文、字母、数字、下划线，且以中文或字母开头" id="adminNo" />                            <span class="ie8 icon-close close hide"></span>
	                            <label class="icon-sucessfill blank hide"></label>
	                            <label class="focus"><span>3-20位，中文、字母、数字、下划线的组合，以中文或字母开头</span></label>
	                            <label class="focus valid"></label>
	                        </div>
	                    </div>
	                    <div class="item col-xs-12">
	                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>手机号：</span>    
	                        <div class="f-fl item-ifo">
	                            <input type="text" name="phoneNumber" class="txt03 f-r3 required" keycodes="tel" tabindex="2" data-valid="isNonEmpty||isPhone" data-error="手机号码不能为空||手机号码格式不正确" maxlength="11" id="phone" /> 
	                            <span class="ie8 icon-close close hide"></span>                           
	                            <label class="icon-sucessfill blank hide"></label>
	                            <label class="focus">请填写11位有效的手机号码</label>
	                            <label class="focus valid"></label>
	                        </div>
	                    </div>
	                    <div class="item col-xs-12">
	                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>密码：</span>    
	                        <div class="f-fl item-ifo">
	                            <input type="password" name="pwd" id="password" maxlength="20" class="txt03 f-r3 required" tabindex="3" style="ime-mode:disabled;" onpaste="return  false" autocomplete="off" data-valid="isNonEmpty||between:6-20||level:2" data-error="密码不能为空||密码长度6-20位||该密码太简单，有被盗风险，建议字母+数字的组合" /> 
	                            <span class="ie8 icon-close close hide" style="right:55px"></span>
	                            <span class="showpwd" data-eye="password"></span>                        
	                            <label class="icon-sucessfill blank hide"></label>
	                            <label class="focus">6-20位英文（区分大小写）、数字、字符的组合</label>
	                            <label class="focus valid"></label>
	                            <span class="clearfix"></span>
	                            <label class="strength">
	                            	<span class="f-fl f-size12">安全程度：</span>
	                            	<b><i>弱</i><i>中</i><i>强</i></b>
	                            </label>    
	                        </div>
	                    </div>
	                    <div class="item col-xs-12">
	                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>确认密码：</span>    
	                        <div class="f-fl item-ifo">
	                            <input type="password" maxlength="20" class="txt03 f-r3 required" tabindex="4" style="ime-mode:disabled;" onpaste="return  false" autocomplete="off" data-valid="isNonEmpty||between:6-16||isRepeat:password" data-error="密码不能为空||密码长度6-16位||两次密码输入不一致" id="rePassword" />
	                            <span class="ie8 icon-close close hide" style="right:55px"></span>
	                            <span class="showpwd" data-eye="rePassword"></span>
	                            <label class="icon-sucessfill blank hide"></label>
	                            <label class="focus">请再输入一遍上面的密码</label> 
	                            <label class="focus valid"></label>                          
	                        </div>
	                    </div>
	                    <div class="item col-xs-12">
	                        <span class="intelligent-label f-fl"><b class="ftx04">*</b>验证码：</span>    
	                        <div class="f-fl item-ifo">
	                            <input type="text" maxlength="6" name="verifyNo" id="verifyNo" class="txt03 f-r3 f-fl required" tabindex="4" style="width:167px" data-valid="isNonEmpty||isInt" data-error="验证码不能为空||请输入6位数字验证码" /> 
	                           	<span class="btn btn-gray f-r3 f-ml5 f-size13" id="time_box" disabled style="width:97px;display:none;">发送验证码</span>
	                            <span class="btn btn-gray f-r3 f-ml5 f-size13" id="verifyYz" style="width:97px;">发送验证码</span>
	                            <span class="ie8 icon-close close hide" style="right:130px"></span>
	                            <label class="icon-sucessfill blank hide"></label>
	                            <label class="focus"><span>请查收手机短信，并填写短信中的验证码（此验证码3分钟内有效）</span></label>   
	                            <label class="focus valid"></label>                        
	                        </div>
	                    </div>
	                    <div class="item col-xs-12" style="height:auto">
	                        <span class="intelligent-label f-fl">&nbsp;</span>  
	                        <p class="f-size14 required"  data-valid="isChecked" data-error="请先同意条款"> 
	                        	<input type="checkbox" checked /><a href="javascript:showoutc();" class="f-ml5">我已阅读并同意条款</a>
	                        	<input type="button" class="btn btn-link" id="loginBtn" value="去登录">
	                        </p>     
	                                         
	                        <label class="focus valid"></label> 
	                    </div> 
	 
	                    <div class="item col-xs-12">
	                        <span class="intelligent-label f-fl">&nbsp;</span>    
	                        <div class="f-fl item-ifo">
	                           <a href="javascript:;" class="btn btn-blue f-r3" id="btn_part1">注册</a>                         
	                        </div>
	                    </div> 
	                </div> 
                </form> 
                <div class="part2 text-center" style="display:none">
                	<h3>恭喜<span id="uname"></span>，您已注册成功，现在开始您的搜索之旅吧！</h3>
                    <p class="c-666 f-mt30 f-mb50">页面将在 <strong id="times" class="f-size18">10</strong> 秒钟后，跳转到 <a href="http://localhost:8080/user/toLogin" class="c-blue">登录页面</a></p>
                </div>         
            </div>
        </div>
    </div>
</div>
<div class="m-sPopBg" style="z-index:998;"></div>
<script>
$(function(){	
	$("#loginBtn").click(function() {
		location.href="http://localhost:8080/user/toLogin";
	});
	$("#btn_part1").click(function(){						
		if(!verifyCheck._click()) return;
		$.ajax({
			type : 'POST',
			url : "http://localhost:8080/user/register",
			dataType : 'json',
			data: $("#form1").serialize(),
			success : function(data) {
				if(data.status == 200) {
					$(".part1").hide();
					$(".part2").show();
					$("#uname").text($("#username").val());
					countdown({
						maxTime:10,
						ing:function(c){
							$("#times").text(c);
						},
						after:function(){
							window.location.href="http://localhost:8080";		
						}
					});								
				} else {
					//注册失败
					var status = data.status;
					//400:用户名重复 401:手机号重复 402:验证码错误
					if(status == 400) {
						$("#adminNo").siblings("label.icon-sucessfill.blank").addClass("hide");
						$("#adminNo").siblings("label.focus.valid").text("用户名已存在");
					} else if(status == 401) {
						$("#phone").siblings("label.icon-sucessfill.blank").addClass("hide");
						$("#phone").siblings("label.focus.valid").text("手机号已存在");
					} else if(status == 402) {
						$("#verifyNo").siblings("label.icon-sucessfill.blank").addClass("hide");
						$("#verifyNo").siblings("label.focus.valid").text("验证码错误");
					}
					
				}
			},
			error : function(XmlHttpRequest, textStatus, errorThrown) {
				alert("Register ajax error!");
			}
		});
	});
	
});
function showoutc(){$(".m-sPopBg,.m-sPopCon").show();}
function closeClause(){
	$(".m-sPopBg,.m-sPopCon").hide();		
}
</script>
</body>
</html>
