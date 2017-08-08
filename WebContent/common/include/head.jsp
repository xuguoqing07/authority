<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 网页头部开始 -->
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">LOGO</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">首页</a></li>
				<c:choose>
					<c:when test="${sessionScope.admins != null }">
						<li><a href="${rootPath }/head/admins/adminsList.html">管理员列表</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="true"> 配置(${sessionScope.admins.email }) <span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="info.html">个人信息</a></li>
								<li><a href="insert.html">修改信息</a></li>
								<li role="separator" class="divider"></li>
								<li><a href="list.html">用户列表</a></li>
							</ul></li>
						<li><a href="login.html" onclick="return confirm('确认退出吗?')">退出</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${rootPath }/login.html">登陆</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
			<form class="navbar-form navbar-right visible-sm">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
</nav>
<!-- 网页头部结束 -->