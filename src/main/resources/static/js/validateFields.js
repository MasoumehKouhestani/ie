var submit_login_or_not = true;

function validate_login() {
  var email_login = document.forms["login_form"]["email_login"].value;
  var pass_login = document.forms["login_form"]["password_login"].value;
  if (email_login == "") {
    $(".wrong_login_email").css("visibility", "visible");
    submit_login_or_not = false;
  } else {
    $(".wrong_login_email").css("visibility", "hidden");
    submit_login_or_not = true;
  }
  if (pass_login == "" || pass_login.toString().length < 8) {
    $(".wrong_login_pass").css("visibility", "visible");
    submit_login_or_not = false;
  } else {
    $(".wrong_login_pass").css("visibility", "hidden");
    submit_login_or_not = true;
  }
  return submit_login_or_not;
}

var submit_signup_or_not = true;

function validate_signup() {
  var name_signup = document.forms["sign_form"]["name_signup"].value;
  var username_signup = document.forms["sign_form"]["username_signup"].value;
  var email_signup = document.forms["sign_form"]["email_signup"].value;
  var password_signup = document.forms["sign_form"]["password_signup"].value;
  if (name_signup == "") {
    $(".wrong_sign_name").css("visibility", "visible");
    submit_login_or_not = false;
  } else {
    $(".wrong_sign_name").css("visibility", "hidden");
    submit_login_or_not = true;
  }
  if (username_signup == "") {
    $(".wrong_sign_username").css("visibility", "visible");
    submit_login_or_not = false;
  } else {
    $(".wrong_sign_username").css("visibility", "hidden");
    submit_login_or_not = true;
  }
  if (email_signup == "") {
    $(".wrong_sign_email").css("visibility", "visible");
    submit_login_or_not = false;
  } else {
    $(".wrong_sign_email").css("visibility", "hidden");
    submit_login_or_not = true;
  }
  if (password_signup == "" || password_signup.toString().length < 8) {
    $(".wrong_sign_pass").css("visibility", "visible");
    submit_login_or_not = false;
  } else {
    $(".wrong_sign_pass").css("visibility", "hidden");
    submit_login_or_not = true;
  }
  return submit_login_or_not;
}

var submit_profile_edit_or_not = true;

function validate_profile_edit() {
  var name_edit_profile = document.forms["profile_edit_form"]["name_edit_profile"].value;
  var username_edit_profile = document.forms["profile_edit_form"]["username_edit_profile"].value;
  var email_edit_profile = document.forms["profile_edit_form"]["email_edit_profile"].value;
  var present_password_edit_profile = document.forms["profile_edit_form"]["present_password_edit_profile"].value;
  var new_password_edit_profile = document.forms["profile_edit_form"]["new_password_edit_profile"].value;
  var repeat_password_edit_profile = document.forms["profile_edit_form"]["repeat_password_edit_profile"].value;
  if (name_edit_profile == "") {
    $(".wrong_edit_profile_name").css("visibility", "visible");
    submit_login_or_not = false;
  } else {
    $(".wrong_edit_profile_name").css("visibility", "hidden");
    submit_login_or_not = true;
  }
  if (username_edit_profile == "") {
    $(".wrong_edit_profile_username").css("visibility", "visible");
    submit_login_or_not = false;
  } else {
    $(".wrong_edit_profile_username").css("visibility", "hidden");
    submit_login_or_not = true;
  }
  if (email_edit_profile == "") {
    $(".wrong_edit_profile_email").css("visibility", "visible");
    submit_login_or_not = false;
  } else {
    $(".wrong_edit_profile_email").css("visibility", "hidden");
    submit_login_or_not = true;
  }
  if (present_password_edit_profile == "" || present_password_edit_profile.toString().length) {
    $(".wrong_edit_profile_present_pass").css("visibility", "visible");
    submit_login_or_not = false;
  } else {
    $(".wrong_edit_profile_present_pass").css("visibility", "hidden");
    submit_login_or_not = true;
  }
  if (new_password_edit_profile == "" || new_password_edit_profile.toString().length) {
    $(".wrong_edit_profile_new_pass").css("visibility", "visible");
    submit_login_or_not = false;
  } else {
    $(".wrong_edit_profile_new_pass").css("visibility", "hidden");
    submit_login_or_not = true;
  }
  if (repeat_password_edit_profile == "" || repeat_password_edit_profile.toString().length < 8) {
    $(".wrong_edit_profile_repeat_pass").css("visibility", "visible");
    submit_login_or_not = false;
  } else {
    $(".wrong_edit_profile_repeat_pass").css("visibility", "hidden");
    submit_login_or_not = true;
  }
  return submit_login_or_not;
}
