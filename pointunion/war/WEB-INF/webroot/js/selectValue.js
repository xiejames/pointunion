function setSelectedText(box, value){
  var boxText = '';
  for(var i=0; i<box.options.length; i++){
       if(box.options[i].value == value){
           box.options[i].selected = true;
	   }
  }
}