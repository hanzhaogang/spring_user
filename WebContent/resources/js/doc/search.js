	$(function(){
	$("#search_btn").click(function(){
		
		var name = $("#search_name").val();
		var creater= $("#search_creater").val();
		var createTime= $("#search_createrTime").val();
		var type= $("#search_type").val();

		if(name==""||name=="name..") {
			alert("你需要输入要检索文檔的名稱");
		}
		
		if(creater==""||creater=="creater..") {
			alert("你需要输入要检索文檔的創建者");
		}
		
		if(createTime==""||createTime=="create time..") {
			alert("你需要输入要检索文檔的創建時間");
		}

		if(type==""||type=="type..") {
			alert("你需要输入要检索文檔的類型");
		}
	
	
	});
	});
