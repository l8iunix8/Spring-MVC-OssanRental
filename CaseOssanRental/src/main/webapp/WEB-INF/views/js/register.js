
$(document).ready(function(){
	$('#checkbox').click(function(){
		if( $('#checkbox').is(':checked')){
		$('#registersubmitbutton').attr('disabled',false);
		}
		else{}
	});
	
});