$(document).ready(function(){
	$("#index").mouseover(function(){
		$("#index").css({
			'background-color' : '#adadad',			
		});
		$("#index a").css({
			'color' : '#f5f5f5',
		})
	});
	$("#index").mouseout(function(){
		$("#index").css({
			'background-color' : '#fff',
		});
		$("#index a").css({
			'color' : '#adadad',
		})
	});
	$("#story").mouseover(function(){
		$("#story").css({
			'background-color' : '#adadad',			
		});
		$("#story a").css({
			'color' : '#f5f5f5',
		})
	});
	$("#story").mouseout(function(){
		$("#story").css({
			'background-color' : '#fff',
		});
		$("#story a").css({
			'color' : '#adadad',
		})
	});
	$("#join").mouseover(function(){
		$("#join").css({
			'background-color' : '#adadad',			
		});
		$("#join a").css({
			'color' : '#f5f5f5',
		})
	});
	$("#join").mouseout(function(){
		$("#join").css({
			'background-color' : '#fff',
		});
		$("#join a").css({
			'color' : '#adadad',
		})
	});
	$("#idea").mouseover(function(){
		$("#idea").css({
			'background-color' : '#adadad',			
		});
		$("#idea a").css({
			'color' : '#f5f5f5',
		})
	});
	$("#idea").mouseout(function(){
		$("#idea").css({
			'background-color' : '#fff',
		});
		$("#idea a").css({
			'color' : '#adadad',
		})
	});
	$("#searchossan").mouseover(function(){
		$("#searchossan").css({
			'background-color' : '#adadad',			
		});
		$("#searchossan a").css({
			'color' : '#f5f5f5',
		})
	});
	$("#searchossan").mouseout(function(){
		$("#searchossan").css({
			'background-color' : '#fff',
		});
		$("#searchossan a").css({
			'color' : '#adadad',
		})
	});
	$("#checkout").mouseover(function(){
		$("#checkout").css({
			'background-color' : '#adadad',			
		});
		$("#checkout a").css({
			'color' : '#f5f5f5',
		})
	});
	$("#checkout").mouseout(function(){
		$("#checkout").css({
			'background-color' : '#fff',
		});
		$("#checkout a").css({
			'color' : '#adadad',
		})
	});
	$("#login").mouseover(function(){
		$("#login").css({
			'width' : '100px',
			'height' : '50px',
			'line-height' :'50px',
			'font-size' : '16px'
		});
	});
	$("#login").mouseout(function(){
		$("#login").css({
			'width' : '90px',
			'height' : '40px',
			'line-height' :'40px',
			'font-size' : '14px'
		});
	});

	$('#ossanlist ol ul').mouseover(function(){
		$(this).css({
			'top' : '-2px',
			'left': '-2px',

		})		
	});
	$('#ossanlist ol ul').mouseout(function(){
		$(this).css({
			'top' : '0px',
			'left': '0px',

		})	
	});
	$('#ossanlist ol ul img').mouseover(function(){
		$(this).css({
			'top' : '0px',
			'left': '0px',
			'opacity' : '0.25',
		})	
	});
	$('#ossanlist ol ul img').mouseout(function(){
		$(this).css({
			'top' : '0px',
			'left': '0px',
			'opacity' : '1',
		})	
	});
	$('#ossanlist ol ul div').mouseover(function(){
		$(this).css({
			'z-index' : '10',
		})	
	});
	$('#ossanlist ol ul div').mouseout(function(){
		$(this).css({
			'z-index' : '1',
		})	
	});
    

    //$('.content').infiniteScroll({
	//   path: 'page{{#}}.html',
	//   append: '.post',
	//   history: false,
	// });
	// }
    $(window).resize()

});

