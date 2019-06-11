//圖片類型驗證  
function verificationPicFile(file) {    
    var fileTypes = [".jpg", ".png"];    
    var filePath = file.value;      
    if(filePath){    
        var isNext = false;    
        var fileEnd = filePath.substring(filePath.indexOf("."));    
        for (var i = 0; i < fileTypes.length; i++) {    
            if (fileTypes[i] == fileEnd) {    
                isNext = true;    
                break;   
            }    
        }    
        if (!isNext){    
            alert('不接受此文件類型');    
            file.value = "";    
            return false;    
        }    
    }else {    
        return false;    
    }    
}
//圖片大小驗證
function verificationPicFile(file) {    
    var fileSize = 0;    
    var fileMaxSize = 1024;//1M    
    var filePath = file.value;    
    if(filePath){   
        fileSize =file.files[0].size;    
        var size = fileSize / 1024;    
        if (size > fileMaxSize) {    
            alert("文件大小不大於25M！");    
            file.value = "";    
            return false;    
        }else if (size <= 0) {    
            alert("文件大小不能為0M！");    
            file.value = "";    
            return false;    
        }    
    }else{    
        return false;    
    }    
}   
// //圖片尺寸驗證
// function verificationPicFile(file) {    
//     var filePath = file.value;    
//     if(filePath){    
//         //讀取圖片數據  
//         var filePic = file.files[0];    
//         var reader = new FileReader();    
//         reader.onload = function (e) {    
//             var data = e.target.result;    
//             //載入圖片寬高 
//             var image = new Image();    
//             image.onload=function(){    
//                 var width = image.width;    
//                 var height = image.height;    
//                 if (width == 720 | height == 1280){    
//                     alert("文件尺寸符合！");    
//                 }else {    
//                     alert("文件尺寸應為：720*1280！");    
//                     file.value = "";    
//                     return false;    
//                 }    
//             };    
//             image.src= data;    
//         };    
//         reader.readAsDataURL(filePic);    
//     }else{    
//         return false;    
//     }    
// } 
//圖片顯示
$(document).ready(function(){
    $("#uploadImage").change(function(){
      readImage( this );
    }); 
    function readImage(input) {
      if ( input.files && input.files[0] ) {
        var FR= new FileReader();
        FR.onload = function(e) {
          //e.target.result = base64 format picture
          $('#img').attr( "src", e.target.result );
        };       
        FR.readAsDataURL( input.files[0] );
      }
    }

    $("#uploadarticleImage").change(function(){
      readArticleImage( this );
    }); 
    function readArticleImage(input) {
      if ( input.files && input.files[0] ) {
        var FR= new FileReader();
        FR.onload = function(e) {
          //e.target.result = base64 format picture
          $('#articleImage').attr( "src", e.target.result );
        };       
        FR.readAsDataURL( input.files[0] );
      }
    }

    $('#listpersonalinfo').click(function(){
        $('#infocontent01').css('display','block');
        $('#infocontent02').css('display','none');
        $('#infocontent03').css('display','none');
        $('#infocontent04').css('display','none');
        $('#infocontent05').css('display','none');
        $('#infocontent06').css('display','none');
        $('#infocontent07').css('display','none');
    });
    
    $('#listuploadimage').click(function(){
        $('#infocontent01').css('display','none');
        $('#infocontent02').css('display','block');
        $('#infocontent03').css('display','none');
        $('#infocontent04').css('display','none');
        $('#infocontent05').css('display','none');
        $('#infocontent06').css('display','none');
        $('#infocontent07').css('display','none');
    });
    $('#listpayinfo').click(function(){
        $('#infocontent01').css('display','none');
        $('#infocontent02').css('display','none');
        $('#infocontent03').css('display','block');
        $('#infocontent04').css('display','none');
        $('#infocontent05').css('display','none');
        $('#infocontent06').css('display','none');
        $('#infocontent07').css('display','none');
    });
    $('#listarticlemanage').click(function(){
        $('#listarticlemanagelist').css('display','block');
    });
    $('#listchangepassword').click(function(){
        $('#infocontent01').css('display','none');
        $('#infocontent02').css('display','none');
        $('#infocontent03').css('display','none');
        $('#infocontent04').css('display','none');
        $('#infocontent05').css('display','none');
        $('#infocontent06').css('display','block');
        $('#infocontent07').css('display','none');
    });
    $('#transactionrecord').click(function(){
        $('#infocontent01').css('display','none');
        $('#infocontent02').css('display','none');
        $('#infocontent03').css('display','none');
        $('#infocontent04').css('display','none');
        $('#infocontent05').css('display','none');
        $('#infocontent06').css('display','none');
        $('#infocontent07').css('display','block');
    });
    $('#listarticlemanagelist01').click(function(){
        $('#infocontent01').css('display','none');
        $('#infocontent02').css('display','none');
        $('#infocontent03').css('display','none');
        $('#infocontent04').css('display','block');
        $('#infocontent05').css('display','none');
        $('#infocontent06').css('display','none');
        $('#infocontent07').css('display','none');
    });
    $('#listarticlemanagelist02').click(function(){
        $('#infocontent01').css('display','none');
        $('#infocontent02').css('display','none');
        $('#infocontent03').css('display','none');
        $('#infocontent04').css('display','none');
        $('#infocontent05').css('display','block');
        $('#infocontent06').css('display','none');
        $('#infocontent07').css('display','none');
    });


    $('#listpersonalinfo').mouseover(changeColor);
    $('#listpersonalinfo').mouseout(changeBack);
    $('#listuploadimage').mouseover(changeColor);
    $('#listuploadimage').mouseout(changeBack);
    $('#listpayinfo').mouseover(changeColor);
    $('#listpayinfo').mouseout(changeBack);
    $('#listarticlemanage').mouseover(changeColor);
    $('#listarticlemanage').mouseout(changeBack);
    $('#listarticlemanage').mouseover(showblock);
    $('#listarticlemanage').mouseout(hideblock);
    $('#listchangepassword').mouseover(changeColor);
    $('#listchangepassword').mouseout(changeBack);
    $('#transactionrecord').mouseover(changeColor);
    $('#transactionrecord').mouseout(changeBack);
    $('#listarticlemanagelist').mouseover(showblock)
    $('#listarticlemanagelist').mouseout(hideblock)
    $('#listarticlemanagelist01').mouseover(changeColor)
    $('#listarticlemanagelist01').mouseout(changeBack)
    $('#listarticlemanagelist02').mouseover(changeColor)
    $('#listarticlemanagelist02').mouseout(changeBack)
    $('#listarticlemanagelist').mouseover(listarticlemanageChangeColor)
    $('#listarticlemanagelist').mouseout(listarticlemanageChangeBack)
   
    
    
        
    

});
function listarticlemanageChangeColor(){
    $('#listarticlemanage').css('background-color','#ccc')
}
function listarticlemanageChangeBack(){
    $('#listarticlemanage').css('background-color','#f5f5f5')
}
function changeColor(){
    $(this).css('background-color','#ccc');
}
function changeBack(){
    $(this).css('background-color','#f5f5f5');
}
function showblock(){
    $('#listarticlemanagelist').css('display',"block");
}
function hideblock(){
    $('#listarticlemanagelist').css('display',"none");
}