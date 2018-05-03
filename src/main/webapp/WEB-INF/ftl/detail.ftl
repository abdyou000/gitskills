<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta name="referrer" content="no-referrer" />
    <title>匆匆搜索</title>
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap/js/bootstrap.min.js"></script>
    <script src="../js/bootstrap/js/bootstrap-tooltip.js"></script>
    <script src="http://d3js.org/d3.v3.min.js"></script>
    <script src="../js/index.js?v=pp"></script>
    <script src="../js/cloud.js"></script>
    <script src="../js/spin.js"></script>
    <script src="../js/fisheye.js"></script>
    <link href="../js/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../css/detail.css?v=gg" rel="stylesheet" />
    <link rel="shortcut icon" href="../img/favicon.ico" />
</head>
<body>
<br>
<!-- 正文 -->
<div class="container-fluid">
    <div class="row-fluid">
        <!-- 左侧 -->
        <div class="span9">
            <div class="media well" >
                <a class="pull-left" href="#">
                    <img class="media-object" src="${expert.expertAvatar}" id="author_pic">
                </a>
                <div class="media-body">
                    <h3 class="media-heading">${expert.expertName}<i class="icon-user"></i></h3>
                    <dl class="dl-horizontal">
                        <dt><span class="label label-info">nickName</span></dt>
                        <dd>${expert.nickName}</dd>
                        <dt><span class="label label-warning">address</span></dt>
                        <dd>${expert.expertAddress}</dd>
                        <dt><span class="label label-important">job</span></dt>
                        <dd>${expert.expertJob}</dd>
                        <dt><span class="label label-info">sign</span></dt>
                        <dd>${expert.expertSign}</dd>
                    </dl>
                </div>
            </div>

            <a href="#" class="btn btn-large btn-inverse disabled" id="back_to_top">Top</a>

            <!-- wordcloud -->
            <div class="page-header">
                <h2>Keywords<small> from his/her papers</small></h2>
            </div>
            <div class="wordcloud"></div>
            <button class="btn btn-primary" type="button" id="cloudword_btn">Generate Cloud</button>
            <div id="load_three"></div>

            <!-- Coauthor -->
            <div class="page-header">
                <h2>Visualization</h2>
            </div>
            <button class="btn btn-primary" type="button" id="coauthor_btn">Generate Histogram</button>
            <div class="alert alert-info span3" style="display: none;margin-top:100px" id="first10Articles">
                <h3>Recommend</h3>
                <div id="related_author2"></div>
            </div>
            <div class="row-fluid">
                <div class="span6" id="coauthorOne">
                    <div id="load_one"></div>
                </div>

            </div>

        </div>

        <!-- 右侧 -->
        <div class="alert alert-info span3">
            <h3>Recommend</h3>
            <div id="related_author"></div>
<#--
            <button class="btn" type="button" id="related_btn">Click</button>
-->
        </div>

    </div>
</div>
<input id="expertid" type=hidden value="${expert.expertId}" />
<input id="dname" type=hidden value="${expert.expertName}" />
<input id="address" type=hidden value="${expert.expertAddress}" />
</body>
</html>