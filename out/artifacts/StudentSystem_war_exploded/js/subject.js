

//查询全部数据
function findAllSubject(){
	$.get("findSubjectlist",{"pageNum":1},function(result){
		addTable(result.list);
        $("#page").pagination(result.rowCount,{
            callback:findPageList,//点击页码发起的分页查询请求
            items_per_page:result.maxResult,//每页显示多少记录
            next_text:">",//下一页图标
            prev_text:"<",//上一页图标
            num_display_entries:2,//中间的主体显示页数
            num_edge_entries:1//边缘显示页数
        });
		});
}
//分页查询方法 ,分页控件在调用这个方法时会传入一个当前页的下表进来
function findPageList(pageNum){
    $.get("findSubjectlist",{"pageNum":++pageNum},function(result){
        addTable(result.list);
    });
}
//添加表格到页面中
function addTable(list){
	$("#tab tr:not(:first)").empty();
	$.each(list,function(index, obj){
		$("table").append(
	"<tr>"+
		"<td><input type='checkbox' name='subid' value='"+obj.subid+"'></td>"+
		"<td>"+obj.subName +"</td>"+
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
			alert(result);
            findAllSubject();

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
				$.post("deleteSubjectServlet",params,function(result){
					alert(result);
                    findAllSubject();
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
			
			$.get("findSubjectByIdServlet",{"subid":subid}, function(result){
				$("#subid").val(result.subid);
					$("#subName").val(result.subName);

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
		$.post("updateSubjectServlet",params,function(result){
			alert(result);
            findAllSubject();

		})
	});
}
