$(document).ready(function() {
  $('#email_login').focus(function(){
    $('.wemail').hide();
  })
  $('#password_login').focus(function(){
    $('.wpass').hide();
  })
  $('.warning2').focus(function(){
    $(this).next().hide();
  })
  $('.warning3').focus(function(){
    $(this).next().hide();
  })
});
