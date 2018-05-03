<html>
<head>
    <title>匆匆搜索</title>
    <script src="../js/jquery.min.js"></script>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="../img/favicon.ico" />
   	<link href="../css/index.css?v=8" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="wrapper">
    <div style="margin-top:10px;margin-left:1000px">
    	<#if Session.user?exists>
	    	<div class="top-nav-profile">
	    		<input type="hidden" value="${Session.user.userId}" id="userId">
				<a href="javascript:void(0)" class="zu-top-nav-userinfo " id=":0" role="button" aria-haspopup="true" aria-activedescendant="">
					<span class="name">${Session.user.username}</span>
					<img class="Avatar" src="${Session.user.userAvatar}" alt="${Session.user.username}">
				</a>
				<ul class="top-nav-dropdown" id="top-nav-profile-dropdown" aria-labelledby=":0">
					<li>
						<a href="http://localhost:8080/user/toCenter?userId=${Session.user.userId}" tabindex="-1" id=":1">
							<i class="zg-icon zg-icon-dd-home"></i>我的主页
						</a>
					</li>
					<li>
						<a href="http://localhost:8080/user/logout" tabindex="-1" id=":4">
							<i class="zg-icon zg-icon-dd-logout"></i>退出
						</a>
					</li>
				</ul>
			
			</div>
	    <#else>
	    	<button class="Button AppHeader-login" type="button">
	    		登录
	    	</button>
	    	<button class="Button Button--primary" type="button">
	    		注册
	    	</button>
	    </#if>
    </div>
    <div class="middle">
        <h1 class="title-init">匆匆搜索</h1>

        <form action="${request.contextPath}/query" method="post" id="form1" autocomplete="off">
            <table style="width:100%;border:none;">
                <tr>
                    <td>
                    	<input type="text" list="historyList" name="q" class="searchText"/>
                    	<datalist id="historyList">
						  
						</datalist>
                    	</td>
                    <td><input type="button" value="嗖的一下" class="searchBtn"/></td>
                </tr>
                <tr>
                    <td align="left">
                        <input type="radio" name="type" id="gs_hp_lr0" value="expert">
                        <label for="gs_hp_lr0">博主</label>
                        &nbsp;&nbsp;
                        <input type="radio" name="type" id="gs_hp_lr1" checked value="article">
                        <label for="gs_hp_lr1">文章</label>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<div class="push copyright">
    Copyright (c) 2018 18925517692@163.com
</div>
<br><br>
</div>
</body>
<script>
	$(function() {
		$(".searchText").keyup(function() {
			var userId = $("#userId").val();
			if(!userId) {
				return false;
			}
			var q = $(this).val();
			if(q != '') {
				$.ajax({
					url : "http://localhost:8080/user/searchHistory",
					type : "POST",
					data : {
						"userId" : userId,
						"content": q
					},
					dataType : "json",
					success : function(response) {
						if (response.status == 200) {
							//console.log(response.data);
							var historyList = response.data;
							var contentList = historyList.map(function(item) {
								return item.searchContent;
							});
							$("#historyList").empty();
							for(index in contentList) {
								$("#historyList").append("<option value='"+contentList[index]+"'>");
							}
							
						}
					},
					error : function() {
						console.log("Ajax error");
					}
			});
			}
		});
		$(".searchBtn").click(function() {
			var q = $(".searchText").val();
			if(q == "") {
				return false;
			}
			$("#form1").submit();
		});
		$(".Button.AppHeader-login").click(function() {
			window.location.href = "http://localhost:8080/user/toLogin";
		});
		$(".Button.Button--primary").click(function() {
			window.location.href = "http://localhost:8080/user/toRegister";
		});
		$(".top-nav-profile").mouseover(function() {
			$("#top-nav-profile-dropdown").show();
		});
		$(".top-nav-profile").mouseout(function() {
			$("#top-nav-profile-dropdown").hide();
		});
	});
</script>
</html>