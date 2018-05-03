<html>
<head>
    <title>匆匆搜索</title>
    <script src="../js/jquery.min.js"></script>
    <link href="../css/style.css" rel="stylesheet" type="text/css"/>
    <link href="../css/article_result.css" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="../img/favicon.ico" />    
</head>
<body>
<div class="wrapper">

    <div class=".middle-search">
    	
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
                    	</td>
                    <td><input type="submit" value="嗖的一下" class="searchBtn"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td>
                        <span>
                            <input type="radio" name="type" id="gs_hp_lr0" value="expert">
                            <label for="gs_hp_lr0">博主</label>
                            &nbsp;&nbsp;
                            <input type="radio" name="type" id="gs_hp_lr1" checked value="article">
                            <label for="gs_hp_lr1">博客</label>
                        </span>
                    </td>
                </tr>
            </table>
        </form>
    <#if page??>




        <div id="content_right" class="cr-offset">
        <table cellpadding="0" cellspacing="0">
            <tbody>
            <tr>
                <div>
                    <div class="cr-title c-gap-bottom opr-toplist-title">
                        博文浏览量前十
                    </div>
                    <table class="c-table opr-toplist-table">
                        <thead>
                        <tr>
                            <th>博文标题</th>
                            <th class="opr-toplist-right">浏览量</th>
                        </tr>
                        </thead>
                        <tbody style="display: table-row-group;">
                        	<#if articles??>
                            <#list articles as article>
                                <tr>
                                    <td>
                                        <span>
                                            <#if article_index+1==1>
                                                <span class="c-index  c-index-hot1 c-gap-icon-right-small">${article_index+1}</span>
                                            </#if>
                                            <#if article_index+1==2>
                                                <span class="c-index  c-index-hot2 c-gap-icon-right-small">${article_index+1}</span>
                                            </#if>
                                            <#if article_index+1==3>
                                                <span class="c-index  c-index-hot3 c-gap-icon-right-small">${article_index+1}</span>
                                            </#if>
                                            <#if article_index+1 gte 4>
                                                <span class="c-index c-gap-icon-right-small">${article_index+1}</span>
                                            </#if>
                                            <a
                                            target="_blank" title="${article.articleTitle}"
                                            href="${article.articleAddress}">
                                                <#if article.articleTitle?length gt 23>
                                                    ${article.articleTitle[0..22]+"..."}
                                                <#else>
                                                    ${article.articleTitle}
                                                </#if>
                                            </a>
                                        </span>
                                    </td>
                                    <td class="opr-toplist-right">${article.browseQuantity}</td>
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






        <div class="result-list">
            <div id="resultStats">找到相关结果约 ${page.total} 个</div>
            <#list page.list as info>
                <div class="result-item" data-hveid="27">
                    <h3 class="r"><a href="${info.url}" class="item-url" target="_blank">${info.title}</a></h3>

                    <div>
                        <span class="item-content">${info.desc}</span>
                    </div>
                    <div class="cite" style="white-space:nowrap">${info.url}</div>
                </div>
            </#list>
        </div>
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