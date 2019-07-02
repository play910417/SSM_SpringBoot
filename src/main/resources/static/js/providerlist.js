var providerObj;

//供应商管理页面上点击删除按钮弹出删除框
function deleteProvider(obj){
	$.ajax({
		type:"GET",
		url:"/providerdelete",
		data:{id:obj.find("img").attr("id")},
		dataType:"json",
		success:function(data){
			if(data.message == "true"){//删除成功：移除删除行
                changeDLGContent("删除供应商【"+obj.find("img").attr("name")+"】成功");
				//cancleBtn();
				obj.parents("tr").remove();
			}else if(data.message == "false"){//删除失败
				//alert("对不起，删除供应商【"+obj.attr("proname")+"】失败");
				changeDLGContent("对不起，删除供应商【"+obj.find("img").attr("name")+"】失败");
			}else if(data.message == "notexist"){
				//alert("对不起，供应商【"+obj.attr("proname")+"】不存在");
				changeDLGContent("对不起，供应商【"+obj.find("img").attr("name")+"】不存在");
			}else{
				//alert("对不起，该供应商【"+obj.attr("proname")+"】下有【"+data.delResult+"】条订单，不能删除");
				changeDLGContent("对不起，该供应商【"+obj.find("img").attr("name")+"】下有【"+data.num+"】条订单，不能删除");
			}
		},
		error:function(data){
			//alert("对不起，删除失败");
			changeDLGContent("对不起，删除失败");
		}
	});
}

function openYesOrNoDLG(){
	$('.zhezhao').css('display', 'block');
	$('#removeProv').fadeIn();
}

function cancleBtn(){
	$('.zhezhao').css('display', 'none');
	$('#removeProv').fadeOut();
}
function changeDLGContent(contentStr){
	var p = $(".removeMain").find("p");
	p.html(contentStr);
}
$(function(){

	$('#no').click(function () {
		cancleBtn();
	});
	
	$('#yes').click(function () {
		deleteProvider(providerObj);
	});

	$(".deleteProvider").on("click",function(){
		providerObj = $(this);
		changeDLGContent("你确定要删除供应商【"+providerObj.find("img").attr("name")+"】吗？");
		openYesOrNoDLG();
	});
});