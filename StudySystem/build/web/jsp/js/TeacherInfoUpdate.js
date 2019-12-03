//页面加载函数
$(document).ready(function(){
   var type=$("[name=type]").val();
    //根据值让学院option选中
   $("#suoshuyuanxi option[value='"+type+"']").attr("selected","selected"); 
   var sex=$("[name=sex]").val();
   //根据值让性别选中
   $(":radio[name='sex'][value='" + sex + "']").attr("checked", "checked");  
});