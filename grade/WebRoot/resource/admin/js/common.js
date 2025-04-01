//清空本按钮所在的表单的所有控件
function formReset(obj){
	var $form = $(obj).parents("form");
	$form.find(":text").val("");//清空文本框
	$form.find(":checkbox").attr("checked",false);//清空多选框
	
	//清空下拉框
	var $firstOptin;
	var $a;
	$form.find("select").each(function(){
		$firstOptin = $(this).children().eq(0);
		$firstOptin.attr("selected",true);//还原下拉框的值
	});
}



$(function(){
	
	/** 
	 *  a标签扩展，改为提交所在表单的方式，需要引js/common.js
	 * (1) action请求的地址 
	 * (2) param请求的参数，多个参数用逗号间隔
	 * (3) title 确认信息
	 */
	$("a[action]").click(function(){
		
		//需要确认操作
		var message = $(this).attr("title");
		
		//form表单对象
		var $myform =$(this).parents("form");
		
		//批量操作
		if($(this).attr("type") == "moreTodo"){
			var checks = $myform.find(":checkbox[name='" + $(this).attr("rel") + "']:checked");
			if(checks.length == 0){
				alert("请选择信息");
				return ;
			}
			
			if(!confirm(message)){
				return ;
			}
				
			if($(this).attr("postType") == "string"){//逗号分隔形式
				
				var ids = "";
			
				checks.each(function(){
					ids += $(this).val() + ",";
				});
				
				ids = ids.substring(0,ids.length - 1);
				
				checks.removeAttr("name");
				
				$myform.append("<input type='hidden' name='ids' value='" + ids + "'/>");
			}
			
		}else{ //普通提交表单
			if(message){
				if(!confirm(message)){
					return ;
				}
			}
		}
		
		//如果有参数
		if($(this).attr("param")){
			$.each(eval("(" + $(this).attr("param") + ")"),function(k,v){
				$myform.append("<input type='hidden' name='" + k + "' value='" + v + "'/>");
			});
		}
		
		//如果需要拼参数
		if($(this).attr("spellParam") == "true"){
			var param = "";
			var $objs = $myform.find(":text,:hidden,select");
			$objs.each(function() {//文本框，下拉框
				if( $(this).attr("name") != undefined && $(this).attr("name") != "") {//有name属性
					param = param + $(this).attr("name") + "@<,@" + $(this).val() + "#,>#";
				}
			});
			
			var $param = $(":hidden[name='params']");
			if($param.length > 0){//有此隐藏域，直接赋值
				$param.val(param);
			}else {//如果无此隐藏域，则添加一个隐藏域
				$myform.append("<input type='hidden' name='params' value='" + param + "'/>");
			}
		}
	
		$myform.attr("action",$(this).attr("action")).submit();
	});
	
	/**
	 *全选，反选 
	 *必须添加属性 class="checkboxCtrl"  group="你的多选框name属性值"
	 *【反选】需额外增加属性 selectType="invert"
	 */
	$("a.checkboxCtrl").click(function(){
		var $checks = $(":checkbox[name='" + $(this).attr("group") + "']");//获取相应的多选框
		
		if($(this).attr("selectType") == "invert"){//反选
			$checks.each(function(){
				$(this).attr("checked",!$(this).attr("checked"));
			});
		}else{
			$checks.attr("checked",true);
		}
	});
	
	//带"请选择的"下拉框的name属性操作
	$("select[rel='choose']").change(function(){
		if($(this).val() == "choose"){
			$(this).removeAttr("name");
		}else {
			$(this).attr("name", $(this).attr("relName"));
		}
	});
	
	//如果有值，则显示name属性
	var $selectObj = $("select[rel='choose']");//可能会有多个下拉框框
	$("select[rel='choose']").each(function() {
		if($(this).val() != "choose"){
			$(this).attr("name", $(this).attr("relName"));
		}
	});
	
});