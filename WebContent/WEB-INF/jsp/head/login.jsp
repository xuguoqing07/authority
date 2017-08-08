<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/include/page.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
	<title>管理员列表 - sm</title>
	<%@ include file="/common/include/title.jsp"%>
	</head>
	<body>
		<%-- 包含 --%>
		<%@ include file="/common/include/head.jsp"%>
		<div class="container">
			<div class="col-sm-8 col-sm-offset-1">
				<form id="form" class="form-horizontal" method="post"
					action="${rootPath }/loginSubmit.html">
	
					<h2 class="col-sm-offset-1 form-signin-heading">登陆</h2>
					<div class="form-group">
						<label for="email" class="col-sm-2 control-label">邮箱</label>
						<div class="col-sm-8">
							<input id="email" name="email" class="form-control" value="${requestScope.email }"
								placeholder="邮箱" type="text">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-8">
							<input name="password" id="inputPassword" class="form-control"
								placeholder="密码" type="password">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-8 col-sm-offset-2">
							<div class="input-group">
								<div class="checkbox">
									<label> <input value="remember-me" type="checkbox">
										记住我
									</label>
								</div>
								<span class="input-group-addon"> <a href="forgetPass.html">忘记密码</a>
								</span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-8 col-sm-offset-2">
							<button class="btn btn-lg btn-primary" type="submit">登陆</button>
							<a href="regsiter.html" class="btn btn-lg btn-primary">注册</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="container">
			<div class="col-sm-8 col-sm-offset-1">
	
				<div class="alert alert-warning alert-dismissible fade in"
					role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					${info }
				</div>
			</div>
		</div>
		<%@ include file="/common/include/footer.jsp"%>
	</body>
</html>