function findSubject()
{
	var subjectName=$("#yuanxi").val();
	$("[name=subjectName]").val(subjectName);
	$("#findStudent").submit();

}