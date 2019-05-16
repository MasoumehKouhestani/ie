 var submit_case = true;
function validate_confirm() {
  var referencePerson = document.forms["confirm_form"]["referenceperson"].value;
  var topicCase = document.forms["confirm_form"]["mozo"].value;
  var descriptionCase = document.forms["confirm_form"]["tozihatcase"].value;

  if(referencePerson == ""){
    $(".wrong_referenceperson").css("visibility","visible");
    submit_case = false;
  }else{
    $(".wrong_referenceperson").css("visibility","hidden");
    submit_case = true;
  }

  if(referencePerson == ""){
      $(".wrong_topic_case").css("visibility","visible");
      submit_case = false;
  }else{
      $(".wrong_topic_case").css("visibility","hidden");
      submit_case = true;
  }


   if(referencePerson == ""){
        $(".wrong_description_case").css("visibility","visible");
        submit_case = false;
   }else{
        $(".wrong_description_case").css("visibility","hidden");
        submit_case = true;
   }
   return submit_case;
}
