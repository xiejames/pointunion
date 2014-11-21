var TOTAL_CKECK_FLAG = true; //
/**
	 * 验证输入得参数是否满足要求
	 * @param param  参数
	 * @param paramDesc  描述
	 * @param type 种类
	 * @param mixLength 最小长度
	 * @param maxLength 最大长度
	 * @param nullable 该参数是否可以为空
	 * @return 如果满足要求,返回null,否则返回对错误的描述
*/
function validate(nodeName, paramDesc, strType, minLen, maxLen, nullable) {
		param = nodeName.value.replace(/^\s+|\s+$/g,'');
		if(!nullable && isNull(param)){
			alert( paramDesc + "不可为空"  );
			return false;	
		}
		
		if(nullable && isNull(param)){
			return true;	
		}
		
		switch(strType) {
			case "number":
				if(!isNumber(param)){
					alert( paramDesc + "必须是数字" );
					nodeName.focus();
					return false;	
				}
				break;
			case "email":
				if(!isEmail(param)){
					alert( paramDesc + "不是正确的邮件地址" );
					nodeName.focus();
					return false;	
				}
				break;
			case "date":
				if(!isDate(param)){
					alert( paramDesc + "不是正确的日期格式" );
					nodeName.focus();
					return false;	
				}
				break;
			case "identifier":
				if(!isIdentifier(param)){
					alert( paramDesc + "只能由字母、数字、下划线或点号组成，且开头只能是下划线或字母" );
					nodeName.focus();
					return false;	
				}
				break;
			case "chinese":
				if(!isIdentifier(param)){
					alert( paramDesc + "只允许中文" );
					nodeName.focus();
					return false;	
				}
				break;				
			default:
				break;				
        }
		
		if(maxLen==minLen){
		     if(getLen(param) != minLen ){
				alert( paramDesc + "的长度必须为" + minLen );
				return false;
			}
		}
		
		if(getLen(param) < minLen){
			alert( paramDesc + "的最小长度为" + minLen );
			return false;
		}
		
		if(getLen(param) > maxLen){			
			alert( paramDesc + "的最大长度为" + maxLen );
			return false;
		}
		return true;
}

function myAlert(str){
   alert(str);
}


function isEmail(str){
   return(new RegExp(/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/).test(str));
}

function isNumber(str){
   return(new RegExp(/^\d+$/).test(str));
}

function isNull(str){
	return (str.replace(/^\s+|\s+$/g,'')=='');
}

function isDate(str){
   var r = str.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
   if(r==null){
      return false;
    }
    var d= new Date(r[1], r[3]-1, r[4]);
    return (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4]);
}

function isIdentifier(str){
    return(new RegExp(/^([a-zA-z_]{1})([\w]*)$/).test(str));
}

function isChinese(str){
    return(new RegExp(/^[\u0391-\uFFE5]+$/).test(str));
}

function isBothNull(str1, str2){
	return isNull(str1)&&isNull(str2);
}

function getLen(str)
{
	return str.length;
	//return str.replace(/[^\x00-\xff]/g,"**").length;
}

 function trim(str){
	 return str.replace(/(^\s*)|(\s*$)/g, "");
 }





