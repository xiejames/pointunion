var TOTAL_CKECK_FLAG = true; //
/**
	 * ��֤����ò����Ƿ�����Ҫ��
	 * @param param  ����
	 * @param paramDesc  ����
	 * @param type ����
	 * @param mixLength ��С����
	 * @param maxLength ��󳤶�
	 * @param nullable �ò����Ƿ����Ϊ��
	 * @return �������Ҫ��,����null,���򷵻ضԴ��������
*/
function validate(nodeName, paramDesc, strType, minLen, maxLen, nullable) {
		param = nodeName.value.replace(/^\s+|\s+$/g,'');
		if(!nullable && isNull(param)){
			alert( paramDesc + "����Ϊ��"  );
			return false;	
		}
		
		if(nullable && isNull(param)){
			return true;	
		}
		
		switch(strType) {
			case "number":
				if(!isNumber(param)){
					alert( paramDesc + "����������" );
					nodeName.focus();
					return false;	
				}
				break;
			case "email":
				if(!isEmail(param)){
					alert( paramDesc + "������ȷ���ʼ���ַ" );
					nodeName.focus();
					return false;	
				}
				break;
			case "date":
				if(!isDate(param)){
					alert( paramDesc + "������ȷ�����ڸ�ʽ" );
					nodeName.focus();
					return false;	
				}
				break;
			case "identifier":
				if(!isIdentifier(param)){
					alert( paramDesc + "ֻ������ĸ�����֡��»��߻�����ɣ��ҿ�ͷֻ�����»��߻���ĸ" );
					nodeName.focus();
					return false;	
				}
				break;
			case "chinese":
				if(!isIdentifier(param)){
					alert( paramDesc + "ֻ��������" );
					nodeName.focus();
					return false;	
				}
				break;				
			default:
				break;				
        }
		
		if(maxLen==minLen){
		     if(getLen(param) != minLen ){
				alert( paramDesc + "�ĳ��ȱ���Ϊ" + minLen );
				return false;
			}
		}
		
		if(getLen(param) < minLen){
			alert( paramDesc + "����С����Ϊ" + minLen );
			return false;
		}
		
		if(getLen(param) > maxLen){			
			alert( paramDesc + "����󳤶�Ϊ" + maxLen );
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





