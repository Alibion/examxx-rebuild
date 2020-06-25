<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<base href="<%=basePath%>">

<!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
		Remove this if you use the .htaccess -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Exam++</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="apple-mobile-web-app-capable" content="yes">
<link rel="shortcut icon"
	href="<%=basePath%>resources/images/favicon.ico" />
<link href="resources/bootstrap/css/bootstrap-huan.css" rel="stylesheet">
<link href="resources/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="resources/css/exam.css" rel="stylesheet" type="text/css">
<link href="resources/css/style.css" rel="stylesheet">

<style type="text/css">
.question-body {
	padding: 30px 30px 20px 30px;
	background: #FFF;
}

ul#exampaper-body {
	margin-bottom: 0px;
}

ul#exampaper-body li {
	padding-bottom: 0px;
}

.question-body {
	min-height: 300px;
}

.rightBubble {
	width: 170px;
	height: 90px;
	margin: 0 auto;
	margin-top: 35px;
	position: relative;
	border: 2px solid;
	border-radius: 4px;
	border-color: transparent transparent transparent transparent;
}

/* .rightBubble::before {
	content: "";
	width: 0;
	height: 0;
	border: 10px solid;
	position: absolute;
	top: 10px;
	left: -20px;
	border-color: transparent #000 transparent transparent;
}

.rightBubble::after {
	content: "";
	width: 0;
	height: 0;
	border: 8px solid;
	position: absolute;
	top: 12px;
	left: -16px;
	border-color: transparent #fff transparent transparent;
} */
.leftBubble {
	width: 210px;
	height: 100px;
	margin: 0 auto;
	margin-top: 35px;
	position: relative;
	border: 2px solid;
	border-radius: 4px;
	border-color: transparent transparent transparent transparent;
}

/* .leftBubble::before {
	content: "";
	width: 0;
	height: 0;
	border: 10px solid;
	position: absolute;
	top: 50px;
	left: 197px;
	border-color: transparent transparent transparent #000;
}

.leftBubble::after {
	content: "";
	width: 0;
	height: 0;
	border: 8px solid;
	position: absolute;
	top: 52px;
	left: 196px;
	border-color: transparent transparent transparent #fff;
} */
.backgroundImage {
	background-image: url(resources/images/background.png);
	background-repeat: repeat;
}
</style>
<script type="text/javascript">
	function change_div(id) {
		/* var clickindex = $("a.question-navi-item").index(this);
		alert(clickindex); */
		if (id == 'J') {
			document.getElementById("questionJ1").style.display = 'inline-block';
			document.getElementById("answerJ1").style.display = 'inline-block';
			document.getElementById("questionC1").style.display = 'none';
			document.getElementById("answerC1").style.display = 'none';
			document.getElementById("questionJ2").style.display = 'inline-block';
			document.getElementById("answerJ2").style.display = 'inline-block';
			document.getElementById("questionC2").style.display = 'none';
			document.getElementById("answerC2").style.display = 'none';
		} else {
			document.getElementById("questionJ1").style.display = 'none';
			document.getElementById("answerJ1").style.display = 'none';
			document.getElementById("questionC1").style.display = 'inline-block';
			document.getElementById("answerC1").style.display = 'inline-block';
			document.getElementById("questionJ2").style.display = 'none';
			document.getElementById("answerJ2").style.display = 'none';
			document.getElementById("questionC2").style.display = 'inline-block';
			document.getElementById("answerC2").style.display = 'inline-block';
		}
	}
</script>
</head>
<body>
	<header>
		<div class="container">
			<div class="row">
				<div class="col-xs-5">
					<div class="logo">
						<h1>
							<a href="#"><img alt="" src="resources/images/logo.png"></a>
						</h1>
					</div>
				</div>
				<div class="col-xs-7" id="login-info">
					<c:choose>
						<c:when
							test="${not empty sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}">
							<div id="login-info-user">

								<a
									href="user-detail/${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}"
									id="system-info-account" target="_blank">${sessionScope.SPRING_SECURITY_CONTEXT.authentication.principal.username}</a>
								<span>|</span> <a href="j_spring_security_logout"><i
									class="fa fa-sign-out"></i> 退出</a>
							</div>
						</c:when>
						<c:otherwise>
							<a class="btn btn-primary" href="user-register">用户注册</a>
							<a class="btn btn-success" href="user-login-page">登录</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</header>
	<!-- Navigation bar starts -->

	<div class="navbar bs-docs-nav" role="banner">
		<div class="container">
			<nav class="collapse navbar-collapse bs-navbar-collapse"
				role="navigation">
				<ul class="nav navbar-nav">
					<li><a href="home"><i class="fa fa-home"></i>主页</a></li>

					<li><a href="student/analysis"><i class="fa fa-dashboard"></i>信息统计</a>
					</li>
					<li><a href="student/setting"><i class="fa fa-cogs"></i>个人设置</a>
					</li>
					<!-- <li class="active"><a><i class="fa fa-edit"></i>日语对话</a></li> -->
				</ul>
			</nav>
		</div>
	</div>
	<!-- Navigation bar ends -->

	<div class="content" style="margin-bottom: 100px;">
		<div class="container">
			<div class="row">
				<div class="col-xs-3"
					style="padding-right: 0px; padding-bottom: 15px;">
					<div class="def-bk" id="bk-exam-control">
						<div class="def-bk-content" id="exam-control">
							<div>
								<span style="color: #428bca;">会话类型：</span>
								<div>
									<span>${fieldName }</span>
								</div>
								<%-- 								<span style="color: #428bca;">会话数量：</span>
								<div>
									<span id="practice-type" class="pt-singlechoice">[ 共 <span
										class="pt-tno">${amount }</span> 个 ]<span class="pt-qcode"
										style="display: none;">qt-singlechoice</span>
									</span>
								</div> --%>
							</div>
							<div id="exam-info" style="display: none;">
								<span id="answer-hashcode"></span>
							</div>
						</div>

					</div>

				</div>
				<div class="col-xs-9" style="padding-right: 0px;">
					<div class="def-bk" id="bk-exampaper">
						<div class="expand-bk-content" id="bk-conent-exampaper">
							<div id="exampaper-header">
								<div id="exampaper-title" style="margin-bottom: 15px;">
									<i class="fa fa-paper-plane"></i> <span style="color: #428bca;">会话内容：</span>
									<%-- <span id="exampaper-title-name"> ${fieldName } - ${practiceName } </span> --%>
								</div>
							</div>
							<div class="backgroundImage" style="width: 700px; height: 400px;">
								<ul id="exampaper-body">
									${dialogStr }
<!-- 									<li class="question qt-multiplechoice">
										<div style="display: inline-block; width: 70px; height: 90px;"></div>
										<div id="questionJ1" class="leftBubble" style="display: inline-block;">内容1问日语</div>
										<div id="questionC1" class="leftBubble" style="display: none;">内容1问中文</div>
										<div style="display: inline-block; width: 140px; height: 1px;"></div>
										<div id="answerJ1" class="rightBubble" style="display: inline-block;">内容1答日语</div>
										<div id="answerC1" class="rightBubble" style="display: none;">内容1答中文</div>
										<div style="width: 10px; height: 50px;"></div>
									</li>
									<li class="question qt-multiplechoice">
										<div style="display: inline-block; width: 70px; height: 90px;"></div>
										<div id="questionJ2" class="leftBubble" style="display: inline-block;">内容2问日语</div>
										<div id="questionC2" class="leftBubble" style="display: none;">内容2问中文</div>
										<div style="display: inline-block; width: 140px; height: 1px;"></div>
										<div id="answerJ2" class="rightBubble" style="display: inline-block;">内容2答日语</div>
										<div id="answerC2" class="rightBubble" style="display: none;">内容2答中文</div>
										<div style="width: 10px; height: 50px;"></div>
									</li> -->
								</ul>
							</div>
							<div id="button">
								<ul>
									<li id="buttonA"><a onclick="change_div('J')">日语</a></li>
									<li id="buttonA"><a onclick="change_div('C')">中文</a></li>
								</ul>
							</div>
							<div id="exampaper-footer">
								<div id="question-switch">
									<button class="btn-success btn" id="previous-q-btn"
										style="width: 160px;">
										<i class="fa fa-chevron-circle-left"></i> 上一会话
									</button>
									<button class="btn-success btn" id="next-q-btn"
										style="margin-left: 60px; width: 160px;">
										下一会话 <i class="fa fa-chevron-circle-right"></i>
									</button>
								</div>
								<div id="question-navi">
									<div id="question-navi-controller">
										<i class="fa fa-arrow-circle-down"></i> <span>会话列表</span>
									</div>
									<div id="question-navi-content"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Slider Ends -->

	<!-- Javascript files -->
	<!-- jQuery -->
	<script type="text/javascript"
		src="resources/js/jquery/jquery-1.9.0.min.js"></script>
	<!-- Bootstrap JS -->
	<script type="text/javascript"
		src="resources/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="resources/js/all.js?v=0712"></script>
	<script type="text/javascript" src="resources/js/practice-improve.js"></script>
</body>
</html>
