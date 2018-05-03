<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8" />
<title>帐号和密码设置</title>
<script src="../js/jquery.min.js"></script>
<script src="../js/ajaxfileupload.js"></script>
<link rel="shortcut icon" href="../img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" href="../css/center1.css">
<link rel="stylesheet" href="../css/center2.css">
<link rel="stylesheet" href="../css/center3.css">
</head>

<body class="zhi ">

	<div class="zg-wrap zu-main clearfix no-sidebar" role="main">
		<div class="zu-main-content">
			<div class="zu-main-content-inner">
				<ul class="tab-navs">
					<li class="tab-nav active"><a href="javascript:void(0)">帐号和密码</a>
					</li>
				</ul>
				<div class="settings-acount-main">

					<div class="settings-intro">绑定手机和邮箱，并设置密码，帐号更安全。</div>

					<div class="settings-section">
						<div class="settings-item clearfix">
							<label for="fullname" class="settings-item-title">用户名</label>
							<div class="settings-item-content rename-section"
								id="rename-section">
								<span class="name">${user.username}</span> <a
									href="javascript:;" class="zu-edit-button rename-button"
									name="edit"><i class="zu-edit-button-icon"></i>修改</a>
								<div class="rename-tab hidden">
									<p>
										<input class="zg-form-text-input" type="text" name="fullname"
											placeholder="用户名">
									</p>
								</div>

							</div>
						</div>
						<div class="settings-item clearfix">
							<label class="settings-item-title">邮箱</label>
							<div class="settings-item-content form-container">
								<#if user.email??>
								<div class="group group-text">
									<span class="text phone">${user.email?substring(0,2)}****${user.email?substring(user.email?index_of('@'))}</span>
									<a href="#" class="js-expand" id="changeEmailBtn">修改</a>
								</div>
								<#else>
								<div class="group group-text hidden-expanded">
									<span class="text email"></span> <a href="javascript:void(0)"
										id="changeEmailBtn" class="js-expand">绑定邮箱</a>
								</div>
								</#if>
								<form class="form-basic panel hidden email-form" method="POST">
									<div class="group">
										<input required class="text" name="email" type="email"
											id="email" placeholder="输入邮箱">
									</div>
									<div class="group">
										<input required class="text digits" name="digits"
											id="verifyNo2" type="number" placeholder="4 位数验证码"> <a
											href="#" class="js-send-digits digits-button"
											id="sendEmailBtn">发送验证码</a>
									</div>
									<button type="button" class="next zg-btn-blue" id="sendEmail">确认</button>
									<span class="hint-label-container z-text-muted"></span>
								</form>
							</div>
						</div>

						<div class="settings-item clearfix">
							<label class="settings-item-title">手机</label>
							<div class="settings-item-content form-container">

								<div class="group group-text">
									<span class="text phone">${user.phoneNumber?substring(0,3)}****${user.phoneNumber?substring(7,11)}</span>
									<a href="#" class="js-expand" id="changePhoneBtn">修改</a>
								</div>

								<form class="form-basic panel hidden phone-form" method="POST">
									<div class="group">
										<div class="Input-selectWrapper CountryInput-selectWrapper">
											<select class="Input js-countries-selector" name="country">
												<option value="86" data-abbr="CN">中国 +86</option>
											</select> <span
												class="Input-selectArrow sprite-global-icon-select-arrow"></span>
										</div>
										<input required class="text" name="phone_no" type="tel"
											placeholder="输入新手机号">
									</div>
									<div id="verifyNoDiv" class="group">
										<input required class="text digits" name="digits"
											id="verifyNo" type="number" placeholder="4 位数验证码"> <a
											href="javascript:void(0)"
											class="js-send-digits digits-button" id="sendSmsBtn">发送验证码</a>
									</div>
									<button type="button" class="next zg-btn-blue" id="changePhone">确认</button>
									<span class="hint-label-container z-text-muted"></span>
								</form>
							</div>
						</div>

						<div class="settings-item clearfix">
							<label class="settings-item-title">帐号密码</label>
							<div class="settings-item-content form-container">
								<div class="group group-text hidden-expanded">

									<a class="js-expand" id="changePwdBtn" href="#">修改密码</a>


								</div>
								<form class="form-basic panel hidden password-form"
									method="POST">
									<div class="group">
										<input required class="text" type="password"
											placeholder="输入新密码" name="password" id="password">
									</div>
									<div class="group">
										<input required class="text" type="password"
											placeholder="再次输入" name="password_repeat"
											data-rule-equalto="#password">
									</div>
									<button type="button" class="next zg-btn-blue" id="changePwd">确定</button>
								</form>
							</div>
						</div>
						<div class="settings-item clearfix">
							<label class="settings-item-title">头像</label>
							<div class="settings-item-content form-container">
								<div class="UserAvatarEditor ProfileHeader-avatar"
									style="top: 4px;">
									<div class="UserAvatar">
										<img class="Avatar Avatar--large UserAvatar-inner" width="160" id="userAvatar"
											height="160" src="${user.userAvatar}">
									</div>
									<div class="Mask UserAvatarEditor-mask Mask-hidden">
										<div
											class="Mask-mask Mask-mask--black UserAvatarEditor-maskInner"></div>
										<div class="Mask-content">
											
											<svg class="Zi Zi--Camera UserAvatarEditor-cameraIcon"
												fill="currentColor" viewBox="0 0 24 24" width="36"
												height="36">
												<path
													d="M20.094 6S22 6 22 8v10.017S22 20 19 20H4.036S2 20 2 18V7.967S2 6 4 6h3s1-2 2-2h6c1 0 2 2 2 2h3.094zM12 16a3.5 3.5 0 1 1 0-7 3.5 3.5 0 0 1 0 7zm0 1.5a5 5 0 1 0-.001-10.001A5 5 0 0 0 12 17.5zm7.5-8a1 1 0 1 0 0-2 1 1 0 0 0 0 2z"
													fill-rule="evenodd">
												</path>
											</svg>

											<div class="UserAvatarEditor-maskInnerText">修改我的头像</div>
											
										</div>
									</div>
									<input type="file" accept="image/png,image/jpeg" id="fileupload" name="fileupload"
										style="display: none;">
								</div>
							</div>
						</div>
					</div>


				</div>
			</div>

			<div class="zu-main-sidebar" data-za-module="RightSideBar"></div>

		</div>
</body>
<script>
		
	$(function() {
		//图片上传
		$(document).on("change","#fileupload",function() {
			var value = $("#fileupload").val();
			if(!value) {
				return false;
			}
			var userId = '${user.userId}';
			$.ajaxFileUpload({
				url : "http://localhost:8080/user/upload",
				type:"post",
				secureuri : false,//是否启用安全提交，默认为false
				fileElementId : "fileupload",//需要上传的文件域的ID，即<input type="file">的ID
				dataType : 'json',
				data: {"userId": userId},
				success : function(response) {
					//alert("上传成功");
					$("#userAvatar").attr("src",response.data);
				},
				error : function(response) {
					alert("Ajax error");
				}
			});
		});
		//点击修改头像
		$(".UserAvatarEditor.ProfileHeader-avatar").mouseover(function() {
			$(".Mask.UserAvatarEditor-mask").removeClass("Mask-hidden");
		});
		$(".UserAvatarEditor.ProfileHeader-avatar").mouseout(function() {
			$(".Mask.UserAvatarEditor-mask").addClass("Mask-hidden");
		});
		$(".Mask.UserAvatarEditor-mask").click(function() {
			$("#fileupload").click();
		});
		//点击修改绑定邮箱
		$("#changeEmailBtn").click(function() {
			$(this).hide();
			$(".form-basic.email-form").show();
		});
		//发送邮箱验证码
		$("#sendEmailBtn")
				.click(
						function() {
							var email = $("#email").val();
							if (email == '') {
								alert("邮箱为空");
								return false;
							}
							//^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$
							var param = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
							if (!param.test(email)) {
								alert("邮箱不合法");
								return false;
							}
							var username = '${user.username}';
							//发送验证码
							$.ajax({
								url : "http://localhost:8080/user/sendEmail",
								type : "POST",
								data : {
									"email" : email,
									"username" : username
								},
								dataType : "json",
								success : function(response) {
									if (response.status == 200) {
										$("#sendEmailBtn").text("验证码已发送");
										$("#sendEmailBtn").attr("disabled",
												"disabled");
									}
								},
								error : function() {
									alert("Ajax error");
								}
							});
						});
		//修改绑定邮箱
		$("#sendEmail")
				.click(
						function() {
							var email = $("#email").val();
							if (email == '') {
								alert("邮箱为空");
								return false;
							}
							//^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$
							var param = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
							if (!param.test(email)) {
								alert("邮箱不合法");
								return false;
							}
							var verifyNo2 = $("#verifyNo2").val();
							if (verifyNo2 == '') {
								alert("验证码为空");
								return false;
							}
							var userId = '${user.userId}';
							$
									.ajax({
										url : "http://localhost:8080/user/changeEmail",
										type : "POST",
										data : {
											"email" : email,
											"verifyNo" : verifyNo2,
											"userId" : userId
										},
										dataType : "json",
										success : function(response) {
											if (response.status == 200) {
												location.href = "http://localhost:8080/user/toCenter?userId="
														+ userId;
											} else if (response.status == 400) {
												alert("验证码错误");
												return false;
											}
										},
										error : function() {
											alert("Ajax error");
										}
									});

						});

		//点击修改绑定手机
		$("#changePhoneBtn").click(function() {
			$(this).hide();
			$(".form-basic.phone-form").show();
		});
		//发送手机验证码
		$("#sendSmsBtn").click(function() {
			var phoneNumber = $("input[name='phone_no']").val();
			if (phoneNumber == '') {
				alert("手机号为空");
				return false;
			}
			var param = /^1[34578]\d{9}$/;
			if (!param.test(phoneNumber)) {
				alert("手机号不合法");
				return false;
			}
			//发送验证码
			$.ajax({
				url : "http://localhost:8080/user/sendsms",
				type : "POST",
				data : {
					"phoneNumber" : phoneNumber
				},
				dataType : "json",
				success : function(response) {
					if (response.status == 200) {
						$("#sendSmsBtn").text("验证码已发送");
						$("#sendSmsBtn").attr("disabled", "disabled");
					}
				},
				error : function() {
					alert("Ajax error");
				}
			});
		});
		//修改绑定手机
		$("#changePhone")
				.click(
						function() {
							var phoneNumber = $("input[name='phone_no']").val();
							if (phoneNumber == '') {
								alert("手机号为空");
								return false;
							}
							var param = /^1[34578]\d{9}$/;
							if (!param.test(phoneNumber)) {
								alert("手机号不合法");
								return false;
							}
							var verifyNo = $("#verifyNo").val();
							if (verifyNo == '') {
								alert("验证码为空");
								return false;
							}
							var userId = '${user.userId}';
							$
									.ajax({
										url : "http://localhost:8080/user/changePhone",
										type : "POST",
										data : {
											"phoneNumber" : phoneNumber,
											"verifyNo" : verifyNo,
											"userId" : userId
										},
										dataType : "json",
										success : function(response) {
											if (response.status == 200) {
												location.href = "http://localhost:8080/user/toCenter?userId="
														+ userId;
											} else if (response.status == 400) {
												alert("验证码错误");
												return false;
											}
										},
										error : function() {
											alert("Ajax error");
										}
									});

						});
		//点击修改密码
		$("#changePwdBtn").click(function() {
			$(this).hide();
			$(".form-basic.password-form").show();
		});
		//修改密码
		$("#changePwd")
				.click(
						function() {
							var pwd = $("input[name='password']").val();
							var repwd = $("input[name='password_repeat']")
									.val();
							if (pwd == '') {
								alert("密码为空");
								return;
							}
							if (repwd == '') {
								alert("确认密码为空");
								return;
							}
							if (repwd != pwd) {
								alert("确认密码与密码不同");
								return false;
							}
							var userId = '${user.userId}';
							$
									.ajax({
										url : "http://localhost:8080/user/changePwd",
										type : "POST",
										data : {
											"userId" : userId,
											"newPwd" : pwd
										},
										dataType : "json",
										success : function(response) {
											if (response.status == 200) {
												location.href = "http://localhost:8080/user/toCenter?userId="
														+ userId;
											}
										},
										error : function() {
											alert("Ajax error");
										}
									});
						});
		//点击修改用户名
		$(".rename-button").click(function() {
			$(".rename-tab").show();
		});
		//修改用户名
		$(".zg-form-text-input").change(function() {
			var newName = $(this).val();
			if (newName == "") {
				alert("用户名不能为空");
				$(this).focus();
				return;
			}
			var userId = '${user.userId}';
			$.ajax({
				url : "http://localhost:8080/user/changeUsername",
				type : "POST",
				data : {
					"userId" : userId,
					"newName" : newName
				},
				dataType : "json",
				success : function(response) {
					if (response.status == 200) {
						$(".name").text(newName);
						$(".rename-tab").hide();
					}
				},
				error : function() {
					alert("Ajax error");
				}
			});
		});

	});
</script>
<br>
</html>