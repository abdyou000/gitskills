$(function() {

	// 在index.jsp的论文搜索里，对于论文发表者有个tooltip的效果
	$(".author_tooltip").on("mouseover", function(e) {
		$(this).tooltip('show');
	});
	//researcher.jsp
	// 触发词云生成
	$('#cloudword_btn').on("click", function(e) {
		loading("load_three");
		$('#cloudword_btn').fadeOut('slow');
		showWordCloud(undefined);
	});

    relatedSide();
	// 异步请求右侧相关学者列表
	$('#related_btn').on("click", function(e) {
		relatedSide();
	});


    $('#coauthor_btn').on("click", function(e) {
        showVisualization();
    });
});

function relatedSide() {
	var expertid = $("#expertid").val();
	var address = $("#address").val();
	if (expertid != null && address != null) {
		var url = "http://localhost:8080/expert/related?expertid="+expertid+"&address="+address;
		$.ajax({
			type : 'GET',
			url : url,
			dataType : 'json',
			success : function(data) {
				var list = data;
				var len = list.length;
				for ( var i = 0; i < len; i++) {
					$("#related_author").append("<p><a class='author_tooltip' data-toggle='tooltip' data-placement='right' href='/expert/"+list[i].expertId+
							"' data-original-title='"+list[i].expertJob+"'>"+list[i].expertName+"</a></p>");
				}
				
				$(".author_tooltip").on("mouseover", function(e) {
					$(this).tooltip('show');
				});
			},
			error : function(XmlHttpRequest, textStatus, errorThrown) {
				alert("Related ajax error!");
			}
		});
	}
}

function relatedSide2(data) {
    $("#first10Articles").show();
    var list = data;
    var len = list.length;
    for ( var i = 0; i < len; i++) {
        $("#related_author2").append("<p><a class='author_tooltip' data-toggle='tooltip' data-placement='right' href='"+list[i].articleAddress+
            "' data-original-title='"+list[i].articleDesc+"'>"+list[i].articleTitle+"</a></p>");
    }

    $(".author_tooltip").on("mouseover", function(e) {
        $(this).tooltip('show');
    });

}
function showWordCloud(user) {
    var the_url = "";
    if (user != undefined) {
        the_url =  "/wordcloud?user="+user;
    } else {
        the_url = "/expert/wordcloud/"+$("#expertid").val();
    }
    $.ajax({
        type : 'GET',
        url : the_url,
        dataType : 'json',
        success : function(data) {
            wordcloud(data);
        },
        error : function(XmlHttpRequest, textStatus, errorThrown) {
            alert("showWordCloud ajax error!");
        }
    });
}

// 真正wordcloud生成效果代码
function wordcloud(str) {
	var WIDTH = 850;
	var HEIGHT = 300;
	var ANGLE = 30;
	var fill = d3.scale.category20();

	d3.layout.cloud().size([WIDTH, HEIGHT]).words(str.map(function(d) {
        return {text: d, size: 20 + Math.random() * 50};
    })).rotate(function() { 
    	return ~~(Math.random() * 2) * ANGLE; 
    }).font("Impact").fontSize(function(d) { 
    	return d.size; 
    }).on("end", draw).start();
	
	$('#load_three').remove();
	$('#load_tag').remove();
	
	function draw(words) {
		d3.select(".wordcloud").append("svg").attr("width", WIDTH).attr("height", HEIGHT)
          .append("g").attr("transform", "translate(450,150)").selectAll("text").data(words)
          .enter().append("text").style("font-size", function(d) { return d.size + "px"; })
          .style("font-family", "Impact").style("fill", function(d, i) { return fill(i); })
          .attr("text-anchor", "middle").attr("transform", function(d) {
            return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
          }).text(function(d) { return d.text; });
	}
}
// 每次等待ajax传入数据时的那个loading图，用spinner这个工具实现
function loading(name) {
	var opts = {
		lines : 11, // The number of lines to draw
		length : 9, // The length of each line
		width : 4, // The line thickness
		radius : 7, // The radius of the inner circle
		rotate : 0, // The rotation offset
		color : '#000', // #rgb or #rrggbb
		speed : 1, // Rounds per second
		trail : 45, // Afterglow percentage
		shadow : false, // Whether to render a shadow
		hwaccel : false, // Whether to use hardware acceleration
		className : 'spinner', // The CSS class to assign to the spinner
		zIndex : 2e9, // The z-index (defaults to 2000000000)
		top : 'auto', // Top position relative to parent in px
		left : 'auto' // Left position relative to parent in px
	};
	var target = document.getElementById(name);
	new Spinner(opts).spin(target);
}


function showVisualization(val) {
    var url = "/article/"+$("#expertid").val();
    $.ajax({
        type : 'GET',
        url : url,
        dataType : 'json',
        success : function(data) {
            histogram(data);
            relatedSide2(data);
            $("#coauthor_btn").hide();
        },
        error : function(XmlHttpRequest, textStatus, errorThrown) {
            alert("showHistogram ajax error!");
        }
    });
}

function histogram(articles) {
    var width = 1000;
    var height = 600;
    var dataset = articles.map(function (article,index,arr) {
        return article.browseQuantity;
    });
    var titles = articles.map(function (article,index,arr) {
        // var title = blog.blogTitle;
        // title = title.length > 15 ? title.substring(0,16) : title;
        return article.articleId;
    });
    console.log(titles);
    var svg = d3.select("#load_one").append("svg")
        .attr("width",width)
        .attr("height",height);

    //画布周边的空白
    var padding = {left:100, right:30, top:20, bottom:100};

    //x轴的比例尺
    var xScale = d3.scale.ordinal()
        .domain(titles)
        .rangeRoundBands([0, width - padding.left - padding.right]);

    //y轴的比例尺
    var yScale = d3.scale.linear()
        .domain([0,d3.max(dataset)])
        .range([height - padding.top - padding.bottom, 0]);
    //定义x轴
    var xAxis = d3.svg.axis()
        .scale(xScale)
        .orient("bottom");

    //定义y轴
    var yAxis = d3.svg.axis()
        .scale(yScale)
        .orient("left");

    //矩形之间的空白
    var rectPadding = 40;

    var color = d3.scale.category10();

    //添加矩形元素
    var rects = svg.selectAll(".MyRect")
        .data(dataset)
        .enter()
        .append("rect")
        .attr("class","MyRect")
        .style("fill",function(d,i) {
            return color(i);
        })
        .attr("transform","translate(" + padding.left + "," + padding.top + ")")
        .attr("x", function(d,i){
            return xScale.rangeBand() * i + rectPadding/2;
        } )
        .attr("y",function(d){
            return yScale(d);
        })
        .attr("width", xScale.rangeBand() - rectPadding )
        .attr("height", function(d){
            return height - padding.top - padding.bottom - yScale(d);
        });

    //添加文字元素
    var texts = svg.selectAll(".MyText")
        .data(dataset)
        .enter()
        .append("text")
        .attr("class","MyText")
        .attr("transform","translate(" + padding.left + "," + padding.top + ")")
        .attr("x", function(d,i){
            return xScale.rangeBand() * i + rectPadding/2;
        } )
        .attr("y",function(d){
            return yScale(d);
        })
        .attr("dx",function(){
            return (xScale.rangeBand() - rectPadding)/2;
        })
        .attr("dy",function(d){
            return 20;
        })
        .text(function(d){
            return d;
        });

    //添加x轴
    svg.append("g")
        .attr("class","axis")
        .attr("transform","translate(" + padding.left + "," + (height - padding.bottom) + ")")
        .call(xAxis)
        .append("text")
        .text("博客ID")
        .attr("transform","translate("+(width-padding.left-padding.right-10)+",10)");

    //添加y轴
    svg.append("g")
        .attr("class","axis")
        .attr("transform","translate(" + padding.left + "," + padding.top + ")")
        .call(yAxis)
        .append("text")
        .text("浏览量")
        .attr("transform","translate(-30,-10)");
}
