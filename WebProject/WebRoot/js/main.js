function font_size() {
	var num = $("#textarea").val().length;
	if(num<=30){
		$(".title2").html('<span></span>/30');
		$(".title2 span").text(num);
	}
}

function setImagePreview() {
	var docObj = document.getElementById("docfile");
	// var imgObjPreview = document.getElementById("preview");
	console.log(docObj.files[0]);
	if (docObj.files && docObj.files[0]) {
		var reader = new FileReader();
		reader.readAsDataURL(docObj.files[0]);//发起异步请求
		reader.onload = function(){
			//读取完成后，数据保存在对象的result属性中
			console.log(this.result)
			// imgObjPreview.src=this.result;
			var data={img:this.result};
			$.ajax({
				type:"POST",
				url:"ajaxImg.do",
				data:data,
				dataType:"json",
				success:function(response){
					$("#textarea").val("");
					$("#textareaprint").val("");
					var content=response.resRegions;
					var index;
					for(index=0;index<content.length;index++){
						if(content[index].tranContent != "* ?"){
							var pr=$("#textareaprint").val();
							$("#textareaprint").val(pr+content[index].tranContent+"\r\n");
						}
					
					}
				}
			})
		}
	}
}

function setImagePreview2() {
	var docObj2 = document.getElementById("docfileVoice");
	// var imgObjPreview = document.getElementById("preview");
	console.log(docObj2.files[0]);
	if (docObj2.files && docObj2.files[0]) {
		var reader = new FileReader();
		reader.readAsDataURL(docObj2.files[0]);//发起异步请求
		reader.onload = function(){
			//读取完成后，数据保存在对象的result属性中
			// console.log(this.result)
			// imgObjPreview.src=this.result;
			var data2={voice:this.result};
			// console.log(this.result);
			console.log(data2);
			$.ajax({
				type:"post",
				url:"ajaxVoice.do",
				data:data2,
				dataType:"json",
				success:function(response){
					$("#textarea").val("");
					$("#textareaprint").val("");
					console.log(response);
					var content=response.translation;
					console.log(content);
					$("#textareaprint").val(content+"\r\n");
				}
			})
		}
	}
}

$(document).ready(function(){
	$("#delete").click(function(){
	var q=$("#textarea").val();
	console.log(q);
	$("#textarea").val("");
	$(".title2 span").text(0);
	});

	// console.log("lsw");

	$.ajax({
		type:"post",
		url:"ajaxGetCountry.do",
		data:{},
		dataType:"json",
		success:function(response){
			var index;
			var index2;
			for(index=0;index<response.length;index++){
				var option=$("<option>").val(response[index].id).text(response[index].country); 
				$("#incode").append(option);
				// $("#outcode").append(option);
			}
			for(index2=1;index2<response.length;index2++){
				
				var option=$("<option>").val(response[index2].id).text(response[index2].country); 
				$("#outcode").append(option);
			}
		}
	});

	// var data={incode:$("#incode option:selected").val(),outcode:$("#outcode option:selected").val(),text:$("#textarea").val()};
	// $("#incode").change(function(){
	// var inincode=$("#incode").find("option:selected").text();
	// console.log(inincode);
	// });

	$("#clickbutton").click(function(){
		var incode=$("#incode").find("option:selected").text();
		// console.log(incode);
		var outcode=$("#outcode").find("option:selected").text();
		// console.log(outcode);
		var text=$("#textarea").val();
		// console.log(text);

		var data={incode:incode,outcode:outcode,text:text};
		console.log(data);
		$.ajax({
			type:"post",
			url:"ajaxGetTranslate.do",
			data:data,
			dataType:"json",
			success:function(response){
				var translatecontext=response.trans_result
				console.log(response);
				console.log(translatecontext);
				console.log(translatecontext.dst);
				console.log(translatecontext[0]);
				console.log(translatecontext[0].dst);
				$("#textareaprint").val(translatecontext[0].dst);
			}
		})
	});
})
		
				
