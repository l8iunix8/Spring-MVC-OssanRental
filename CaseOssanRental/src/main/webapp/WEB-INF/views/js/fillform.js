$(document).ready(function(){
	$("#fillformsubmit").click(function(){
		if($("#userid").val()==""){
            alert("你尚未填寫帳號");      
        }
        else if($("#password").val()==""){
            alert("你尚未填寫密碼");
     
        }
        else if($("#username").val()==""){
            alert("你尚未填寫真實姓名");       
        }
        else if($("#personalid").val()==""){
            alert("你尚未填寫身分證字號");
      
        }
        else if($("#birth").val()==""){
            alert("你尚未填寫生日");
      
        }
        else if($("#address").val()==""){
            alert("你尚未填寫地址");
       
        }
        else if($("#phone").val()==""){
            alert("你尚未填寫連絡電話");
      
        }
    });
});