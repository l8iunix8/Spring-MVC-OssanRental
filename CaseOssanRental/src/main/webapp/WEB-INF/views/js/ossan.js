stage = 1;
$(document).ready(function(){
	
	
		$('#ossanPersonal').click(function(){
			
			$('#ossanBlock').remove();
		});
		$('#topblock').click(function(){
			$('#ossanBlock').remove();
		});
		$('#information').click(function(){
			$('#ossanBlock').remove();
		});
		$('#copyright').click(function(){
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
			$('#articleImg').attr("src",
					"data:image/jpeg;base64," + data.ajaxImage);

		},
		error : function() {
			alert('error');
		}

	})
}
