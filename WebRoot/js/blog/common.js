$(function(){
	$.ajax({
		url:'/myblog/siderbar',
		type:'GET',
		cache:false,
		dataType:'html',
		success:function(data){
			$("#siderbar").html(data);
		}
	});
})

