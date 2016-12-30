

//查询全部数据
function findAll(){
	$.get("findStuList",{"pageNum":1},function(result){
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
	$.get("findStuList",{"pageNum":++pageNum},function(result){
		addTable(result.list);
		});
}
//添加表格到页面中
function addTable(list){
	$("#tab tr:not(:first)").empty();
	$.each(list,function(index, obj){
		var subjects = "";
		$.each(obj.subjects,function(index1,obj1){
			var type1 = obj1.subName==undefined ? "" : obj1.subName;
			subjects+=obj1.subName;
		})
		$("table").append(
	"<tr>"+
		"<td><input type='checkbox' name='sid' value='"+obj.sid+"'></td>"+
		"<td>"+obj.stuName +"</td>"+ 
		"<td>"+obj.age+"</td>"+
		"<td>"+obj.sex+"</td>"+
		"<td>"+obj.card.cardNum+"</td>"+
		"<td>"+obj.team.className+"</td>"+
		"<td>"+subjects+"</td>"+
		"<td><input  alt='"+obj.sid+"' type='button' class='btn btn-danger btn-sm' value='编辑'></td>"+
	"</tr>");
	
	}); 
	buttonClick()
	}

//给添加按钮绑定click事件
function add(){
	$("#add").on("click",function(){	
	$("#f1 :input").val("");
	//显示模式对话框
	$("#addview").modal("show");
	findTeamType();
	findSubjects();
	save();
});
}

//弹出对话框之前将类型信息查询出来绑定到下拉类表中
function findTeamType(){
	$.get("findTeamlist", function(result){
	 		$("#teamType").empty();
	 		$.each(result, function(key, obj){
  		 		$("#teamType").append("<option value="+obj.tid+">"+obj.className+"</option>");
	 		});
	 	});
}
//
function findSubjects(){
$.get("findSubjectlist", function(result){
		$("#sub").empty();
		$.each(result, function(key, obj){
		 		$("#sub").append("  <label><input type='checkbox' name='subjects' value="+obj.subid+">"+obj.subName+"</label>");
		});
	});}
//给保存按钮添加事件
function save(){
	$("#save").unbind("click").on("click",function(){
		//序列化表单
		var params=$("#f1").serialize();
		$.post("addStudentServlet",params,function(result){
			alert(result);
            findAll();
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
				$.post("deleteServlet",params,function(result){
					alert(result);
                    findAll();
				})
			}
	});
}

//给编辑按钮绑定事件
function buttonClick(){
	//编辑按钮的点击事件
	$("#tab :button").on("click", function(){

		var stuid = $(this).prop("alt");
		$.get("findStuById",{"stuid":stuid}, function(result){
				$("#sid3").val(result.sid);
				$("#stuName").val(result.stuName);
				$("#age").val(result.age);
				$("#sex").val(result.sex);
				$("#card").val(result.card.cardNum);
				var teamName = result.team.className;

	   		 	$.get("findTeamlist", function(result){
	   		 		$("#teamName").empty();
	   		 		$.each(result, function(key, obj){
	   	   		 		if(obj.className == teamName){
			   	   		 	$("#teamName").append("<option value="+obj.tid+" selected='selected'>"+obj.className+"</option>");
		   	   		 	}else{
			   	   		 	$("#teamName").append("<option value="+obj.tid+">"+obj.className+"</option>");

			   	   		 }

	   		 		});
	   		 	});

				var subject = result.subjects;


	   		 		$.get("findSubjectlist", function(result){
	   		 			$("#subject").empty();
	   					$.each(result, function(index, obj){
	   						var subName = obj.subName;
	   						var i = 0;
	   						$.each(subject, function(key, obj1){
	   							var subjectName = obj1.subName;
	   		   		 			if(subjectName == subName){
	   		   		 				$("#subject").append("  <label><input type='checkbox' checked='checked' name='subjects' value="+obj.subid+">"+obj.subName+"</label>");
	   		   		 				i=1;
	   		   		 			}
	   						});
	   						if(i != 1){
	   							$("#subject").append("  <label><input type='checkbox' name='subjects' value="+obj.subid+">"+obj.subName+"</label>");
	   						}
	   							
					   		
	   		 		});
				});

		});
		update();
		$("#updateview").modal("show");
	
	});
}


//给编辑事件的保存按钮添加事件
function update(){
	$("#update").off("click").on("click",function(){
		//序列化表单
		var params=$("#f2").serialize();
		//提交到后台更新
		$.post("updateStudent",params,function(result){
			alert(result);
            findAll();
		})
	});
}
