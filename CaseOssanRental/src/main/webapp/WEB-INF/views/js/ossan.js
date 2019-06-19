stage = 1;
$(document).ready(function(){
	
	
		$('#ajaxOssanBackground').click(function(){
			$(this).css('display','none');
			$('#ossanBlock').remove();
		});
		
	
})

function changePage(n) {
	
	var articleNo = n;
	console.log(n);
	$.ajax({
		type : 'GET',
		url : 'http://localhost:8080/CaseOssanRental/getOneArticle/'
				+ articleNo + '',
		cache : false,
		dataType : 'json',
		success : function(data) {
			console.log(data.ajaxTitle);
			stage = 2;
			$('#ajaxOssanArticle').append(
					'<section id="ossanBlock">' + '<div id="newBlock">'
							+ '<div id="imageBlock">'
							+ '<img src="" alt="" id="articleImg">' + '</div>'
							+ '<div id="ajaxArticleTitle">' + data.ajaxTitle
							+ '</div>' + data.ajaxContent +

							'<div style="clear: all;"></div>' + '</div>'
							+ '</section>'

			)
			$('#ajaxOssanBackground').css('display','block');
			$('#articleImg').attr("src",
					"data:image/jpeg;base64," + data.ajaxImage);

		},
		error : function() {
			alert('error');
		}

	})
}
