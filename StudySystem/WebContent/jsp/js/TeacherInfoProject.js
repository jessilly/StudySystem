function findTeacher()
{
	var type=$("#yuanxi").val();
	$("[name=type]").val(type);
	$("#findTeacher").submit();
}