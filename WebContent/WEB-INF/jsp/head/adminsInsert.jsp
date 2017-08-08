<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/include/page.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<title>管理员添加 - sm</title>
		<%@ include file="/common/include/title.jsp" %>
	</head>
	<body>
		<%@ include file="/common/include/head.jsp" %>
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-8 col-sm-offset-1 main">
					<h2 class="sub-header">管理员添加</h2>
					<form id="form" class="form-horizontal" method="post"
						action="${rootPath }/head/admins/adminsInsertSubmit.html">
						<input type="hidden" name="operType" value="update">
						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">角色:</label>
							<div class="col-sm-8">
								<select name="roleId">
									<%--
										不要加上请选择
									 --%>
									<!-- <option value="">请选择</option> -->
									<c:forEach items="${requestScope.roleList }" var="role" varStatus="stat">
										<option value="${role.id }">${role.name }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">邮箱:</label>
							<div class="col-sm-8">
								<input type="text" id="email" name="email" value=""
									class="form-control" placeholder="email">
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">密码:</label>
							<div class="col-sm-8">
								<input type="password" id="password" name="password" value=""
									class="form-control" placeholder="密码">
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-sm-2 control-label">状态:</label>
							<div class="col-sm-8">
								<input type="radio" name="status" value="0" id="status0">
								<!-- 
									必须是label
									for填写的是点击字要选中的哪个单选框的id
								 -->
								<label for="status0">禁用</label>
								<input type="radio" name="status" value="1" id="status1" checked="checked">
								 <label for="status1">启用</label>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-8 col-sm-offset-2">
								<button class="btn btn-lg btn-primary" type="submit">提交</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- 提示信息 -->
		<div class="container">
			<div class="col-sm-8 col-sm-offset-1">
				${info }
			</div>
		</div>
		<%@ include file="/common/include/footer.jsp" %>
	</body>
</html>