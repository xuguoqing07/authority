<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/include/page.jsp" %>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<title>管理员列表 - sm</title>
		<%@ include file="/common/include/title.jsp" %>
	</head>
	<body>
		<%-- 包含 --%>
		<%@ include file="/common/include/head.jsp" %>
		<div class="container-fluid">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1 main">
					<h2 class="sub-header">用户列表</h2>
					<form action="${rootPath }/head/admins/adminsList.html" method="post" class="form-inline">
						<div class="form-group">
							<label for="keyword">关键字:</label>
							<input type="text" name="keyword" value="${requestScope.keyword }" class="form-control">
							<label for="keyword">状态:</label>
							<select name="status" class="form-control">
								<option value="">请选择</option>
								<option value="1" ${requestScope.status == '1' ? 'selected' : ''}>启用</option>
								<option value="0" ${requestScope.status == '0' ? 'selected' : ''}>禁用</option>
							</select>
							<label for="email">更新时间:</label>
							<input type="text" name="st" value="${requestScope.st }" readonly="true" class="form-control"
								onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
								class="Wdate" /> 
							--> 
							<input type="text" name="ed" value="${requestScope.ed }" readonly="true" class="form-control"
								onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
								class="Wdate" />
							<input type="submit" class="btn btn-primary" value="搜索">
							<a href="${rootPath }/head/admins/adminsInsert.html" class="btn btn-primary">添加</a>
						</div>
					</form>
					<div class="table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>序号</th>
									<th>Id</th>
									<th width="20%">角色</th>
									<th width="20%">邮箱</th>
									<th>状态</th>
									<th>创建时间</th>
									<th>更新时间</th>
								</tr>
							</thead>
							<tbody>
								<%--通过JSTL中的循环标签取出来
									items ==== l
									admins:admins
									varStatus = count
									
									int count = 0 ; 
									for(Iterator iter = l.iterator();i.hasNext();
									{
										AAdmins admins = i.next ;
										count ++ ; 
									}
									
									JSTL如何对时间进行格式化呢?
								 --%>
								<c:forEach items="${requestScope.adminsList }" var="admins" varStatus="stat">
									<tr>
										<td>${stat.count }</td>
										<td>${admins.id}</td>
										<td>${admins.role.name }</td>
										<td>
											${admins.email}-->
											<%--
												~先获取到@下标值
												~截取从0到@-3的字符串
												~加***
												~截取从@到结尾的字符串
												~字符串相加
											 --%>
											 ${fn:indexOf(admins.email, "@")}-->
											 <c:set var="index" value="${fn:indexOf(admins.email, '@')}"/>
											 <c:set var="totalLength" value="${fn:length(admins.email)}"/>
											 ${fn:substring(admins.email, 0, index -3)}***
											 ${fn:substring(admins.email, index,totalLength)}
										</td>
										<td>
											<%-- ${admins.status == '0' ? '禁用' : '启用'} --%>
											<%-- <c:choose>
												<c:when test="${admins.status == 0 }">
													禁用
												</c:when>
												<c:when test="${admins.status == 1 }">
													启用
												</c:when>
												<c:otherwise>
													未知
												</c:otherwise>
											</c:choose> --%>
											${admins.statusStr}
										</td>
										<td><fmt:formatDate value="${admins.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
										<td><fmt:formatDate value="${admins.updateTime }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
	
						<form id="usersListPageForm"
							action="${rootPath }/head/admins/adminsList.html" method="post">
							
							<%--带上搜索条件 --%>
							<input type="hidden" name="keyword" value="${requestScope.keyword }">
							<input type="hidden" name="status" value="${requestScope.status }">
							<input type="hidden" name="st" value="${requestScope.st }">
							<input type="hidden" name="ed" value="${requestScope.ed }">
							<%--
								在点击首页,下一页翻页的时候,搜索条件也要带上
								能忍的同学可以一一的加到链接中
								${rootPath }/head/admins/adminsList.html?currentPage=1&pageSize=${requestScope.pageInfoUtil.pageSize }&keyword=aaa&status=afsf&st=&ed=
								
								解决方案:
								点击首页链接的时候,先修改当前页和每页多少条的值
								再让表单(GO)所在的表单提交
								
								让首页上一页和GO共用一个表单,在搜索的时候再也不考虑每个每页的链接加参数的问题,get方式提交容易出现乱码
								
								以上代码通过js实现
							 --%>
							<nav>
								<ul class="pager">
									<li><a href="" onclick="return pageForm('currentPage','1','pageSize','${requestScope.pageInfoUtil.pageSize }')"><span>首页</span></a></li>
									<li><a href="" onclick="return pageForm('currentPage','${requestScope.pageInfoUtil.prePage }','pageSize','${requestScope.pageInfoUtil.pageSize }')"><span>上一页</span></a></li>
									<li><a href="" onclick="return pageForm('currentPage','${requestScope.pageInfoUtil.nextPage }','pageSize','${requestScope.pageInfoUtil.pageSize }')"><span>下一页</span></a></li>
									<li><a href="" onclick="return pageForm('currentPage','${requestScope.pageInfoUtil.totalPage }','pageSize','${requestScope.pageInfoUtil.pageSize }')"><span>尾页</span></a></li>
									<li>共${requestScope.pageInfoUtil.totalPage }页,共${requestScope.pageInfoUtil.totalRecord }条</li>
									<li>
										第
										<input type="text" id="currentPage" name="currentPage" 
										value="${requestScope.pageInfoUtil.currentPage }" size="5" maxlength="5" />
										页
									</li>
									<li>
										每页<input type="text" id="pageSize" name="pageSize"
										value="${requestScope.pageInfoUtil.pageSize }" size="5" maxlength="5" />
										条</li>
									<li><input type="submit" value="GO" class="btn btn-primary" /></li>
								</ul>
							</nav>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- 提示信息 -->
		<div class="container">
			<div class="col-sm-8 col-sm-offset-1"></div>
		</div>
		<%@ include file="/common/include/footer.jsp" %>
	</body>
</html>