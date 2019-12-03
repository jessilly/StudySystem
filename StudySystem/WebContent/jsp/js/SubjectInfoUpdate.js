
//页面加载函数
$(document).ready(function(){
   var subjectName=$("[name=subjectName]").val();
    //根据值让学院option选中
   $("#suoshuyuanxi option[value='"+subjectName+"']").attr("selected","selected"); 
});