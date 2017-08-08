/* 分页提交表单 
	currentPageId:currentPage文本框的id
	currentPage:当前页的值
	pageSizeId:pageSize文本框的id
	pageSize:每页多少条的值
*/
function pageForm(currentPageId,currentPage,pageSizeId,pageSize)
{
	/* 获取当前页和每页多少条文本框的值 */
	/*$("#currentPage").val()*/
	/* 修改这个值 */
	/* $("#currentPage").val(23); */
	$("#" + currentPageId).val(currentPage);
	$("#" + pageSizeId).val(pageSize);
	
	/* jquery提交表单 */
	$("#usersListPageForm").submit();
	
	/*
	标签的默认行为:如果返回true就执行,如果返回false就不执行
	a链接 默认行为是打开href里面的内容,a链接的默认行为就不执行
	*/
	return false ; 
}
