$(document).ready(function () {
  $('#submit1').click(function(){
   if($('.t1').value==""){
     $('#submit1').next().show()
   }
 });
  $('#submit2').click(function(){
    if($('.t2').value==""){
      $('.e7').show()
    }
    if(true){
      $('.ee7').show()
    }
  });
});
