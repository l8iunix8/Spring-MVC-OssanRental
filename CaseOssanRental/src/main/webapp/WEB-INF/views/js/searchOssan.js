$(document).ready(
		function() {
			keyword = $('#keyword').text();
//			console.log(keyword);
			if (keyword != null) {
				var content = $('#allOssan').html();
				var regExp = new RegExp(""+keyword+"","g");
				console.log(regExp);
				var newcontent = content.replace(regExp, '<span class="bg-y">'
						+ keyword + '</span>');
				console.log(content);
				
				console.log(newcontent);
				$('#allOssan').html(newcontent);
			}
		});
