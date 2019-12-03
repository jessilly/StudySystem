
$(document).ready(function(){
	var courseType=$("[name=courseType]").val();
    //根据值让课程类型option选中
	$("#classKinds_add option[value='"+courseType+"']").attr("selected","selected"); 
   
});