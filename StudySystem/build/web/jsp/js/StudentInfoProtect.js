function findStudent()
{
	var subject=$("#yuanxi").val();
	var stuClass=$("#banji").val();
	$("[name=subject]").val(subject);
	$("[name=stuClass]").val(stuClass);	
	$("#findStudent").submit();

}