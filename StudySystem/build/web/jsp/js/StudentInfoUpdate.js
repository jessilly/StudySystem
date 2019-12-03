//页面加载函数
$(document).ready(function(){
   var subject=$("[name=subject]").val();
    //根据值让学院option选中
   $("#suoshuyuanxi option[value='"+subject+"']").attr("selected","selected"); 
   var stuClass=$("[name=stuClass]").val();
   //根据值让班级option选中
   $("#suoshubanji option[value='"+stuClass+"']").attr("selected","selected");
   var sex=$("[name=sex]").val();
   //根据值让性别选中
   $(":radio[name='sex'][value='" + sex + "']").attr("checked", "checked");  
});