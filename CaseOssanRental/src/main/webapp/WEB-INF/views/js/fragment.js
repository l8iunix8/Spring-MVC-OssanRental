$(document).ready(function(){
	$('#searchossan').click(function(){
		$(this).css('display','none');
		$('#searchOssanLi').css('display','inline-block');
		$('#searchInput').trigger('focus');

	});
	$('section').click(function(){
		$('#searchossan').css('display','inline-block');
		$('#searchOssanLi').css('display','none');
	});
	$('#searchInput').focus(function(){
		$('#searchInput').keypress(function(e){
			code = (e.keyCode?e.keyCode:e.which);
			if(code == 13){
				$('#searchForm').submit()
			}
		})
	})
});