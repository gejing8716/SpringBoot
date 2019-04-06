<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
	$(function() {
		var totalPage = parseInt($("#totalPage").val());
	var pageNo = parseInt($("#cpageNo").val());
	if(pageNo == 1 && totalPage == 1){
		$("#fir").hide();
		$("#pre").hide();
		$("#next").hide();
		$("#last").hide();
	}else if(pageNo == 1 && totalPage > pageNo){
		$("#fir").hide();
		$("#pre").hide();
		$("#next").show();
		$("#last").show();
	}else if(pageNo > 1 && totalPage > pageNo){
		$("#fir").show();
		$("#pre").show();
		$("#next").show();
		$("#last").show();
	}else if(pageNo > 1 && totalPage == pageNo){
		$("#fir").show();
		$("#pre").show();
		$("#next").hide();
		$("#last").hide();
	}
	$("#next").click(function(){
		$("#pageNo").val(pageNo + 1);
		$("form:first").submit();
	})
	$("#pre").click(function(){
		$("#pageNo").val(pageNo - 1);
		$("form:first").submit();
	})
	$("#fir").click(function(){
		$("#pageNo").val(1);
		$("form:first").submit();
	})
	$("#last").click(function(){
		$("#pageNo").val(totalPage);
		$("form:first").submit();
	})
	$("#jump").click(function(){
		var selectPageNo = $("#selectPage").val();
		var reg = /^\d{0,}$/;
		if(!reg.test(selectPageNo)){
			alert("请输入1到"+totalPage+"数字");
		}else{
			var selectPageNoNum = parseInt(selectPageNo);
			if(selectPageNoNum > totalPage || selectPageNoNum < 1){
				alert("请输入1到"+totalPage+"之间的数字");
			}else{
				$("#pageNo").val(selectPageNo);
				$("form:first").submit();
			}
			
		} 
	})
	});
</script>
<br />
<table width="100%" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td width="51%">&nbsp; 
		<input type="hidden" id="totalPage" value="<s:property value="#page.totalPage"/>"> 
		<input type="hidden" id="cpageNo" value="<s:property value="#page.pageNo"/>">
		<input type="hidden" id="pageNo" name="query.pageNo" value="<s:property value="#page.pageNo"/>">
		</td>
		<td width="13%">共 <s:property value="#page.totalCount" />条记录
		<td width="6%"><input id="fir" type="button" value="首页"></td>
		<td width="6%"><input id="pre" type="button" value="上一页"></td>
		<td width="6%"><input id="next" type="button" value="下一页"></td>
		<td width="6%"><input id="last" type="button" value="末页"></td>
		<td ><input id="selectPage" type="text" size="1" value="<s:property value="#page.pageNo"/>"></td>
		<td ><input id="jump" type="button" value="跳转"></td>
		<td width="12%">当前第<span style="color:red;"><s:property
					value="#page.pageNo" /></span>/<s:property value="#page.totalPage" />页
		</td>
	</tr>
</table>
