<html>
<head>
    <title>匆匆搜索</title>
    <meta name="referrer" content="no-referrer" />
    <script src="../js/jquery.min.js"></script>
    <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="../img/favicon.ico" />
    <link href="../css/article_result.css" rel="stylesheet" type="text/css"/>
	 <style type="text/css">
        .queryForm {
            background-color: #f1f1f1;
            border-bottom: 1px solid #666;
            border-color: #e5e5e5;
            padding: 0 20px;
        }
        .searchText {
            width: 490px;
            height: 35px;
            line-height: 35px;
            font-size: 18px;
            padding: 5px 9px;
        }
        .searchText:hover {
            border-width: 1px;
            border-color: #a0a0a0 #b9b9b9 #b9b9b9 #b9b9b9 !important;
        }
        .searchBtn {
            width: 100px;
            height: 35px;
            line-height: 27px;
            -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
            background-color: #f8f8f8;
            border: 1px solid #c6c6c6;
            box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
            background-color: #38f;
            color: white;
            cursor: default;
            font-family: arial, sans-serif;
            font-size: 13px;
            font-weight: bold;
            margin: 11px 4px;
            min-width: 54px;
            padding: 0 16px;
            text-align: center;
        }
        .searchBtn:hover {
            background-color: #317ef3;
            border-bottom: 1px solid #2868c8;
            *border-bottom: none;
            box-shadow: 1px 1px 1px #ccc;
            cursor: pointer;
        }

        #tads a, #tadsb a, #res a, #rhs a, #taw a {
            text-decoration: none;
        }
        a:link {
            cursor: pointer;
        }
        #resultStats {
            line-height: 43px;
            -webkit-transition: all 220ms ease-in-out;
            color: #808080;
            padding: 0 8px 0 102px;
            font-size: small;
        }
        .copyright {
            color: #666;
            text-align: center;
            margin-bottom: 50px;
        }

        /*分页栏的样式设置*/
        #page {
            font: 14px arial;
            white-space: nowrap;
            padding: 0 0 0 102px;
            margin: 80px 0 40px
        }
        #page a, #page strong {
            display: inline-block;
            vertical-align: text-bottom;
            height: 34px;
            text-align: center;
            line-height: 34px;
            text-decoration: none;
            overflow: hidden;
            margin-right: 9px;
            background: #fff
        }
        #page a {
            cursor: pointer
        }
        #page a:hover {
            background: 0 0
        }
        #page .n:hover, #page a:hover .pc {
            background: #f2f8ff;
            border: 1px solid #38f
        }
        #page .n {
            height: 34px;
            padding: 0 18px;
            border: 1px solid #e1e2e3
        }
        #page span {
            display: block;
            background-color: white;
            color: blue;
        }
        #page .pc {
            width: 34px;
            height: 34px;
            border: 1px solid #e1e2e3;
            cursor: pointer
        }
        #page strong .pc {
            cursor: auto
        }
        #page strong .pc {
            border: 0;
            width: 34px;
            height: 34px;
            line-height: 34px
        }

        /*博文浏览量排行榜样式设置*/
        #content_right {
            border-left: 1px solid #e1e1e1;
            float: right;
            width: 434px;
            margin-top: 45px;
            margin-right: 100px;
        }
        .cr-offset {
            padding-left: 17px;
        }
        .cr-title {
            font-size: 14px;
            line-height: 1.29;
            font-weight: 700;
            margin-bottom: 10px;
        }
        .c-table {
            width: 80%;
            border-collapse: collapse;
            border-spacing: 0
        }
        .c-table th, .c-table td {
            padding-left: 0px;
            line-height: 1.54;
            font-size: 13px;
            border-bottom: 1px solid #f3f3f3;
            text-align: left
        }
        .cr-content .c-table th:first-child, .cr-content .c-table td:first-child {
            padding-left: 0
        }
        .c-table th {
            padding-top: 4px;
            padding-bottom: 4px;
            padding-left: 0px;
            font-weight: 400;
            color: #666;
            border-color: #f0f0f0;
            white-space: nowrap;
            background-color: #fafafa
        }
        .c-table td {
            padding-top: 6.5px;
            padding-bottom: 6.5px
        }
        .c-table-hasimg td {
            padding-top: 0px;
            padding-bottom: 10px
        }
        .c-table a, .c-table em {
            text-decoration: none
        }
        .c-table a:hover, .c-table a:hover em {
            text-decoration: underline
        }
        .c-table a.c-icon:hover {
            text-decoration: none
        }
        .c-table .c-btn:hover, .c-table .c-btn:hover em {
            text-decoration: none
        }
        .opr-toplist-table .opr-toplist-right {
            text-align: right;
            white-space: nowrap
        }
        .c-index {
            display: inline-block;
            padding: 1px 0;
            color: #fff;
            width: 14px;
            line-height: 100%;
            font-size: 12px;
            text-align: center;
            background-color: #8eb9f5
        }
        .c-index-hot1 {
            background-color: #f54545
        }
        .c-index-hot2 {
            background-color: #ff8547
        }
        .c-index-hot3 {
            background-color: #ffac38
        }
        .c-gap-icon-right-small {
            margin-right: 5px
        }

        /*按博客或博主查询单选样式设置*/
        input[type="radio"] {
            width: 15px;
            height: 15px;
        }
        label {
            padding-left: 1px;
            padding-top: 5px;
            padding-bottom: 8px;
        }
        /*博主搜索结果样式设置*/
        .cite {
            color: green;
            font-size: 13px;
        }
        .item-url {
            text-decoration: none;
            color: #2981a9;
        }
        .item-content {
            color: #545454;
            font-size: small;
            line-height: 16px;
        }
        .result-item {
            padding: 10px 600px 10px 102px;
            margin-bottom: 30px;
            margin-top: 10px;
        }
        .pic {
            display: block;
            float: left;
            margin-right: 10px;
        }
        .result {

        }


    </style>
</head>
<body>
<div class="wrapper">
    <div class=".middle-search">
        <#--搜索框显示-->
        <form class="queryForm" action="${request.contextPath}/query" method="post" autocomplete="off">
        <div style="padding-top:10px;margin-left:1000px">
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
            <table style="width:700px;border:none;">
                <tr>
                    <td><h3 class="title-init">匆匆搜索</h3></td>
                    <td>
                    	<input type="text" list="historyList" name="q" class="searchText" value="${q}"/>
                    	<datalist id="historyList">
						  
						</datalist>
                    	</td><td><input type="submit" value="嗖的一下" class="searchBtn"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <span>
                            <input type="radio" name="type" id="gs_hp_lr0" value="expert" checked>
                            <label for="gs_hp_lr0">博主</label>
                            &nbsp;&nbsp;
                            <input type="radio" name="type" id="gs_hp_lr1" value="blog">
                            <label for="gs_hp_lr1">博客</label>
                        </span>
                    </td>
                </tr>
            </table>
        </form>
    <#if page??>
        <#--浏览量排行榜-->
        <div id="content_right" class="cr-offset">
        <table cellpadding="0" cellspacing="0">
            <tbody>
            <tr>
                <div>
                    <div class="cr-title c-gap-bottom opr-toplist-title">
                        博客专家博文浏览量前十
                    </div>
                    <table class="c-table opr-toplist-table">
                        <thead>
                        <tr>
                            <th>专家名</th>
                            <th class="opr-toplist-right">浏览量</th>
                        </tr>
                        </thead>
                        <tbody style="display: table-row-group;">
                        	<#if experts??>
                            <#list experts as expert>
                            <tr>
                                <td>
                                        <span>
                                            <#if expert_index+1==1>
                                                <span class="c-index  c-index-hot1 c-gap-icon-right-small">${expert_index+1}</span>
                                            </#if>
                                            <#if expert_index+1==2>
                                                <span class="c-index  c-index-hot2 c-gap-icon-right-small">${expert_index+1}</span>
                                            </#if>
                                            <#if expert_index+1==3>
                                                <span class="c-index  c-index-hot3 c-gap-icon-right-small">${expert_index+1}</span>
                                            </#if>
                                            <#if expert_index+1 gte 4>
                                                <span class="c-index c-gap-icon-right-small">${expert_index+1}</span>
                                            </#if>
                                            <a
                                                    target="_blank" title="${expert.expertName}"
                                                    href="${expert.blogAddress}">
                                                ${expert.expertName}
                                            </a>
                                        </span>
                                </td>
                                <td class="opr-toplist-right">${expert.readingQuantity}</td>
                            </tr>
                            </#list>
                            </#if>
                        </tbody>
                    </table>

                </div>
            </tr>
            </tbody>
        </table>
    </div>
        <#--查询结果显示-->
        <div class="result-list">
            <div id="resultStats">找到相关结果约 ${page.total} 个</div>
            <#list page.list as info>

                
                <div class="result-item" data-hveid="27">
                    <img src="${info.image}" class="pic img-circle" >
                    <div class="result">
                        <h3 class="r"><a href="${request.contextPath}/expert/${info.expertid}" class="item-url" target="_blank">${info.name}</a></h3>

                        <div>
                            <span class="item-content">${info.sign}</span>
                        </div>
                        <div class="cite" style="white-space:nowrap">${info.url}</div>
                    </div>
                </div>

            </#list>
        </div>
        <#--分页栏显示-->
        <div id="page">
            <#if page.hasPreviousPage>
                <a href="${request.contextPath}/query?page=${page.prePage}&rows=10&q=${q}&type=${type}" class="n">前一页</a>
            </#if>
            <#list page.navigatepageNums as nav>
                <#if nav == page.pageNum>
                    <strong>
                        <span class="pc">${nav}</span>
                    </strong>
                </#if>
                <#if nav != page.pageNum>
                    <a href="${request.contextPath}/query?page=${nav}&rows=10&q=${q}&type=${type}">
                        <span class="pc">${nav}</span>
                    </a>
                </#if>
            </#list>
            <#if page.hasNextPage>
                <a href="${request.contextPath}/query?page=${page.nextPage}&rows=10&q=${q}&type=${type}" class="n">下一页</a>
            </#if>
        </div>
    </#if>
    </div>
    <br><br><br>
    <div class="push copyright">
        Copyright (c) 2018 18925517692@163.com
    </div>
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