<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>系统管理</title>
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="google-code-prettify/prettify.css">
	<link rel="stylesheet" type="text/css" href="google-code-prettify/docs.css">

	<style type="text/css">
		.jumbotron{
			background: linear-gradient(45deg, #020031 0%, #6d3353 100%) repeat scroll 0 0 rgba(0, 0, 0, 0);
		    box-shadow: 0 3px 7px rgba(0, 0, 0, 0.2) inset, 0 -3px 7px rgba(0, 0, 0, 0.2) inset;
		    color: #fff;
		    padding: 40px 0;
		    position: relative;
		    text-align: center;
		    text-shadow: 0 1px 3px rgba(0, 0, 0, 0.4), 0 0 30px rgba(0, 0, 0, 0.075);
			}
		.jumbotron h1 {
		    font-size: 80px;
		    font-weight: bold;
		    letter-spacing: -1px;
		    line-height: 1;
			}
		.jumbotron p {
		    font-size: 24px;
		    font-weight: 300;
		    line-height: 1.25;
		    margin-bottom: 30px;
			}
		.jumbotron a {
		    color: rgba(255, 255, 255, 0.5);
		    transition: all 0.2s ease-in-out 0s;
			}
		.jumbotron a:hover {
		    color: #fff;
		    text-shadow: 0 0 10px rgba(255, 255, 255, 0.25);
			}
		.jumbotron .container {
		    position: relative;
		    z-index: 2;
			}
		.jumbotron:after {
		    background: url("img/managebg.jpg.png") repeat scroll center center rgba(0, 0, 0, 0);
		    bottom: 0;
		    content: "";
		    display: block;
		    left: 0;
		    opacity: 0.4;
		    position: absolute;
		    right: 0;
		    top: 0;
			}
			@media not all, only screen and (min--moz-device-pixel-ratio: 2), not all {
			.jumbotron:after {
  			  background-size: 150px 150px;
			}
			}
		.subhead {
		    border-bottom: 1px solid #ddd;
		    text-align: left;
			}
		.subhead h1 {
		    font-size: 60px;
			}
		.subhead p {
		    margin-bottom: 20px;
			}
		.subhead .navbar {
   			 display: none;
			}
			.bs-docs-sidenav {
		    background-color: #fff;
		    border-radius: 6px;
		    box-shadow: 0 1px 4px rgba(0, 0, 0, 0.067);
		    margin: 30px 0 0;
		    padding: 0;
		    width: 228px;
			}
		.bs-docs-sidenav > li > a {
		    border: 1px solid #e5e5e5;
		    display: block;
		    margin: 0 0 -1px;
		    padding: 8px 14px;
			}
		.bs-docs-sidenav > li:first-child > a {
   			 border-radius: 6px 6px 0 0;
			}
		.bs-docs-sidenav > li:last-child > a {
   			 border-radius: 0 0 6px 6px;
			}
		.bs-docs-sidenav > .active > a {
		    border: 0 none;
		    box-shadow: 1px 0 0 rgba(0, 0, 0, 0.1) inset, -1px 0 0 rgba(0, 0, 0, 0.1) inset;
		    padding: 9px 15px;
		    position: relative;
		    text-shadow: 0 1px 0 rgba(0, 0, 0, 0.15);
		    z-index: 2;
			}
		.bs-docs-sidenav .icon-chevron-right {
		    float: right;
		    margin-right: -6px;
		    margin-top: 2px;
		    opacity: 0.25;
			}
		.bs-docs-sidenav > li > a:hover {
    		background-color: #f5f5f5;
			}
		.bs-docs-sidenav a:hover .icon-chevron-right {
    		opacity: 0.5;
			}
		.bs-docs-sidenav .active .icon-chevron-right, .bs-docs-sidenav .active a:hover .icon-chevron-right {
    		background-image: url("../img/glyphicons-halflings-white.png");
    		opacity: 1;
			}
		.bs-docs-sidenav.affix {
    		top: 40px;
			}
		.bs-docs-sidenav.affix-bottom {
    		bottom: 270px;
		    position: absolute;
		    top: auto;
			}
	</style>
	<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
</head>
<body>
		<!-- 顶栏 -->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<!-- <button class="btn btn-narbar"></button> -->
				<ul class="nav pull-right">
					<li>
						<a href="#" class="brand pull-right" data-toggle="dropdown">
							<span>
								<i class="icon-user icon-white"></i>
								admin
							</span>
						</a>
				 		<ul class="dropdown-menu pull-right">
				 			<li><a href="#">信息推送</a></li>
				 			<li class="divider"></li>
				 			<li><a href="#">用户信息</a></li>
				 			<li><a href="#">修改密码</a></li>
				 			<li class="divider"></li>
				 			<li><a href="#">退出</a></li>
				 		</ul>
					</li>
				</ul>
			</div>	
			
		</div>
	</div>

	<!-- 顶栏下方图片 -->
	<header id="overview" class="jumbotron subhead">
		<div class="container">
			<p></p><p></p><p></p>
			<h1>正大蛋业</h1>
			<p class="leader">后台管理系统</p>
		</div>		
	</header>

	<!-- 		正式内容区 		-->
	
	<div class="container">		
		<div class="row">
			<!-- 左侧列表导航栏 -->
			<div class="span3 bs-docs-sidebar">
				<ul class="nav nav-list bs-docs-sidenav affix-top">
					<li class="nav-header">商品信息</li>
					<li class="active">
						<a data-toggle="tab" href="#tab1">
							<i class="icon-chevron-right"></i>							
							商铺录入
						</a>
					</li>
					<li>
						<a data-toggle="tab" href="#tab2">
							<i class="icon-chevron-right"></i>							
							商铺管理
						</a>
					</li>
					<li class="nav-header">信息发布</li>
					<li>
						<a data-toggle="tab" href="#tab3">
							<i class="icon-chevron-right"></i>							
							消息录入
						</a>
					</li>
					<li>
						<a data-toggle="tab" href="#tab4">
							<i class="icon-chevron-right"></i>							
							消息管理
						</a>
					</li>
					<li class="nav-header">账户信息</li>
					<li>
						<a data-toggle="tab" href="#tab5">
							<i class="icon-chevron-right"></i>							
							用户录入
						</a>						
					</li>
					<li>
						<a data-toggle="tab" href="#tab6">
							<i class="icon-chevron-right"></i>							
							用户管理
						</a>						
					</li>
				</ul>
			</div>
			<!-- 右侧正文区 -->
			<div class="span1"></div>
			<div class="tab-content">
					<!-- 商铺位置信息录入 -->
					<div class="tab-pane active" id="tab1">
						<p class=""></p>
						
						<table class="table">
							<caption><b><h2></h2></b></caption>
						</table>
						<form class="form-horizontal" method="" action="">
							<div class="control-group">
								<label class="control-label" for="selectcity">商铺所在地：</label>
								<div class="controls docs-input-sizes">						
									<select class="span4" id="selectcity" name="city">
									
									
									
									<!-- 此处由jsp生成 -->
									<option>1</option>

									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputshopname">商铺名称：</label>
								<div class="controls">
									<input class="input-xlarge" type="text" id="inputshopname" name="shopname" placeholder="正大禽蛋北师店">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inpurtlongitude">经度：</label>
								<div class="controls">
									<input type="text" class="input-xlarge" id="inputlongitude" name="longitude" placeholder="116.39054">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inpurtlatitude">纬度：</label>
								<div class="controls">
									<input type="text" class="input-xlarge" id="inputlatitude" name="latitude" placeholder="39.968327">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inpurtshopaddress">商铺地址：</label>
								<div class="controls">
									<input type="text" class="input-xlarge" id="inputshopaddress" name="shopaddress" placeholder="北京市海淀区杏坛路56号">
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inpurtphone">联系方式：</label>
								<div class="controls">
									<input type="tel" class="input-xlarge" id="inputphone" name="phone" placeholder="010-7568297">
								</div>
							</div>							
							<div class="control-group">
								<div class="controls">									
									<div class="span3">
										<button class="btn btn-large btn-block btn-primary" type="submit">提交</button>
									</div>
									
								</div>
							</div>
						</form>
					</div>
					<!-- 商铺信息录入结束 -->
					<!-- 商铺信息管理 -->
					<div class="tab-pane fade" id="tab2">
						<p class=""></p>						
						<table class="table">
							<caption><b><h2></h2></b></caption>
						</table>
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>序号</th>
									<th>城市</th>
									<th>商铺名</th>
									<th>经度</th>
									<th>纬度</th>
									<th>地址</th>
									<th>联系电话</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<!-- 此处由jsp自动生成 -->
							</tbody>
						</table>
					</div>
					<!-- 商铺信息管理结束 -->
					<!-- 消息发布录入开始 -->
					<div class="tab-pane fade" id="tab3">
						<p class=""></p>
						
						<table class="table">
							<caption><b><h2></h2></b></caption>
						</table>
						<form class="form-horizontal" method="" action="">							
							<div class="control-group">
								<label class="control-label" for="inputtitle">标题</label>
								<div class="controls">									
										<input type="text" class="input-xlarge" id="inputtitle"name="title" placeholder="标题" >							
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputdescription">简介</label>
								<div class="controls">									
										<input type="text" class="input-xlarge" id="inputdescription" name="description" placeholder="内容简介" >							
								</div>
							</div>							
							<div class="control-group">
								<label class="control-label" for="inputtext">正文</label>
								<div class="controls">									
										<!-- <input type="text" class="input-xlarge" id="inputdescription" name="description" placeholder="内容简介" > -->	
									<textarea rows="20" cols="60" id="editor1" name="editor1" placeholder="输入正文">							
									</textarea>
									<script>
										CKEDITOR.replace('editor1');
									</script>						
								</div>
							</div>	
							<div class="control-group">
								<div class="controls">									
									<div class="span3">
										<button class="btn btn-large btn-block btn-primary" type="submit">提交</button>
									</div>
									
								</div>
							</div>
						</form>
					</div>
					<!-- 消息发布录入结束 -->
					<!-- 消息管理 -->
					<div class="tab-pane fade" id="tab4">
						
					</div>
					<!-- 消息管理结束 -->
					<!-- 用户录入 -->
					<div class="tab-pane fade" id="tab5">
						<p class=""></p>
						
						<table class="table">
							<caption><b><h2></h2></b></caption>
						</table>
						<form class="form-horizontal" method="" action="">
							<div class="control-group">
								<div>
									<label class="control-label" for="inputnewuser">用户名:</label>
									<div class="controls">									
											<input type="text" class="input-xlarge" id="inputnewuser" name="newusername" placeholder="New UserName" >							
									</div>
								</div>
							</div>
							<div class="control-group">
								<div>
									<label class="control-label" for="inputpassword">密码:</label>
									<div class="controls">									
											<input type="password" class="input-xlarge" id="inputpassword" name="userpassword" placeholder="Input Password" >							
									</div>
								</div>
							</div>	
							<div class="control-group">
								<div>
									<label class="control-label" for="reinputpassword">再次输入:</label>
									<div class="controls">									
											<input type="password" class="input-xlarge" id="reinputpassword" name="reuserpassword" placeholder="Input Password again" >							
									</div>
								</div>
							</div>
							<div class="control-group">
								<div>
									<label class="control-label" for="inputemail">邮箱:</label>
									<div class="controls">									
											<input type="email" class="input-xlarge" id="inputemail" name="email" placeholder="Email" >							
									</div>
								</div>
							</div>
							<div class="control-group">
								<div class="controls">									
									<div class="span3">
										<button class="btn btn-large btn-block btn-primary" type="submit">提交</button>
									</div>
									
								</div>
							</div>
						</form>			
					</div>
					<!-- 用户录入结束 -->
					<!-- 用户管理 -->
					<div class="tab-pane fade" id="tab6">
						<p class=""></p>
						
						<table class="table">
							<caption><b><h2></h2></b></caption>
						</table>
						<table class="table table-striped table-hover table-bordered">
							<thead>
								<tr>
									<th>序号</th>
									<th>用户名</th>
									<th>邮箱</th>
									<th>操作</th>									
								</tr>
							</thead>
							<tbody>
								<!-- 此处由jsp自动生成 -->
							</tbody>
						</table>
					</div>
					<!-- 用户管理结束 -->
			</div>
		</div>
	</div>

	<script type="text/javascript" src="bootstrap/js/jquery-1.11.0.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/holder.js"></script>
</body>
</html>