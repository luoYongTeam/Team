

//查询全部数据
function findAllSubject(){
	$.get("findSubjectlist",function(result){
		addTable(result);		
		});
}

//添加表格到页面中
function addTable(result){
	$("#tab tr:not(:first)").empty();
	$.each(result,function(index, obj){
		$("table").append(
	"<tr>"+
		"<td><input type='checkbox' name='subid' value='"+obj.subid+"'></td>"+
		"<td>"+obj.subName +"</td>"+ 
		"<td>"+obj.readme +"</td>"+ 
		"<td><input  alt='"+obj.subid+"' type='button' class='btn btn-danger btn-sm' value='编辑'></td>"+
	"</tr>");
	
	}); 
	buttonClick();
	}

//给添加按钮绑定click事件
function add(){
	$("#add").on("click",function(){	
	$("#f1 :input").val("");
	//显示模式对话框
	$("#addview").modal("show");
	save();
});
}

//给保存按钮添加事件
function save(){
	$("#save").unbind("click").on("click",function(){
		//序列化表单
		var params=$("#f1").serialize();
		$.post("addSubjectServlet",params,function(result){
			addTable(result);
		})
	});
}

//给删除按钮添加事件
function del(){
	$("#del").on("click",function(){
		if($("#tab :checkbox:checked").size()==0){
			alert("请选择删除项");}
			else{
				//执行删除操作
				var params=$("#tableForm").serialize();
				//使用ajax提交到后台
				$.post("deleteSubject",params,function(result){
					addTable(result);
				})
			}
	});
}

//给编辑按钮绑定事件
function buttonClick(){
	$("#tab :button").on("click",function(){
		$("#ttt").empty();
		$("#updateview").modal("show");
			var subid = $(this).prop("alt"); 
			
			$.get("findSubjectById",{"subid":subid}, function(result){
				$("#subid").val(result.subid);
					$("#subName").val(result.subName);
					$("#readme").val(result.readme);
			});	
		update();
		$("#updateview").modal("show");
	
	});
}


//给编辑事件的保存按钮添加事件
function update(){
	$("#updateSub").off("click").on("click",function(){
		//序列化表单
		var params=$("#f2").serialize();
		//提交到后台更新
		$.post("updateSubject",params,function(result){
			//更新列表数据
			addTable(result);
		})
	});
}
