//圖片類型驗證  
function verificationPicFile(file) {
	var fileTypes = [ ".jpg", ".png" ];
	var filePath = file.value;
	if (filePath) {
		var isNext = false;
		var fileEnd = filePath.substring(filePath.indexOf("."));
		for (var i = 0; i < fileTypes.length; i++) {
			if (fileTypes[i] == fileEnd) {
				isNext = true;
				break;
			}
		}
		if (!isNext) {
			alert('不接受此文件類型');
			file.value = "";
			return false;
		}
	} else {
		return false;
	}
}
// 圖片大小驗證
function verificationPicFile(file) {
	var fileSize = 0;
	var fileMaxSize = 1024;// 1M
	var filePath = file.value;
	if (filePath) {
		fileSize = file.files[0].size;
		var size = fileSize / 1024;
		if (size > fileMaxSize) {
			alert("文件大小不大於25M！");
			file.value = "";
			return false;
		} else if (size <= 0) {
			alert("文件大小不能為0M！");
			file.value = "";
			return false;
		}
	} else {
		return false;
	}
}
$(document).ready(function() {
	$("#uploadarticleImage").change(function() {
		readArticleImage(this);
		
	});

});
function readArticleImage(input) {
	
	if (input.files && input.files[0]) {
		
		var FR = new FileReader();
		FR.onload = function(e) {
			// e.target.result = base64 format picture
			$('#articleImage3').attr("src", e.target.result);			
		}
		FR.readAsDataURL(input.files[0]);
	}
}