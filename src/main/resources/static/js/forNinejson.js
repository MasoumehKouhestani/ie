$(document).ready(function(){
  $.get("json/userAuthentication.json", function(data){
  var m="m"
    for (var i = 0; i < data.length; i++) {
    m=m+i;
      var x = data[i];
      var s = $('<div class="person_info">\n' +
        '        <span class="label">نام و نام خانوادگی:</span>\n' +
        '        <span>' +
        x.name+
        '</span><br>\n' +
        '        <span class="label">پست الکترونیکی:</span>\n' +
        '        <span>' +
        x.email+
        '</span><br>\n' +
        '        <span class="label">سمت:</span>\n' +
        '        <span>' +
        x.position+
        '</span><br>\n' +
        '        <span class="label">بخش:</span>\n' +
        '        <span>' +
        x.section+
        '</span><br>\n' +
        '        <br>\n' +
        '        <form method="post">\n' +
          '<button type="submit" class="btn btn-success">تایید</button>\n' +
          '      <button type="submit" class="btn btn-secondary">غیرفعال</button>\n' +
          '      <input type="button" value="ویرایش پروفایل" class="btn btn-info" data-toggle="modal" data-target="#' +
          m +
          '">\n' +
          '      <button type="submit" class="btn btn-danger">حذف</button>\n' +
          '      </form>\n' +
          '      </div>\n' +
          '    </div>\n' +
          '  </div>\n' +
          '</div>'
       );

      $('.person_info_container').append(s);
      var l=$('<div class="modal" id="' +
          m+
          '">\n' +
          '  <div class="modal-dialog modal-dialog-centered modal-lg ">\n' +
          '    <div class="modal-content">\n' +
          '      <div class="modal-header">\n' +
          '        <h5 class="modal-title">\n' +
          '          ویرایش پروفایل کاربر انتخابی\n' +
          '        </h5>\n' +
          '      </div>\n' +
          '\n' +
          '      <div class="modal-body">\n' +
          '        <div class="row bg-white">\n' +
          '          <div class="col-sm">\n' +
          '            <div class="boxinmodal text-sm-right font-weight-bold">\n' +
          '              <form name="profile_edit_form" onsubmit="return validate_profile_edit()" method="post" class="form-group">\n' +
          '                <div class="form-group">\n' +
          '                  <label for="name_edit_profile">نام و نام خانوادگی:</label>\n' +
          '                  <input type="text" id="name_edit_profile" name="name_edit_profile" class="form-control"\n' +
          '                         placeholder="نام و نام خانوادگی "/>\n' +
          '\n' +
          '                  <br>\n' +
          '                </div>\n' +
          '                <div class="form-group">\n' +
          '                  <label for="username_edit_profile">نام کاربری:</label>\n' +
          '                  <input type="text" id="username_edit_profile" name="username_edit_profile" class="form-control"\n' +
          '                         placeholder="نام کاربری "/>\n' +
          '\n' +
          '                  <br>\n' +
          '                </div>\n' +
          '                <div class="form-group">\n' +
          '                  <label for="email_edit_profile">پست الکترونیکی:</label>\n' +
          '                  <input type="email" id="email_edit_profile" name="email_edit_profile" class="form-control"\n' +
          '                         placeholder="پست الکترونیکی "/>\n' +
          '\n' +
          '                  <br>\n' +
          '                </div>\n' +
          '                <div class="form-group">\n' +
          '                  <label for="new_password_edit_profile">رمز عبور جدید:</label>\n' +
          '                  <input type="password" id="new_password_edit_profile" name="new_password_edit_profile" class="form-control"\n' +
          '                         placeholder="رمز عبور جدید "/>\n' +
          '\n' +
          '                </div>\n' +
          '                <div class="form-group">\n' +
          '                  <label for="repeat_password_edit_profile">تکرار رمز عبور جدید:</label>\n' +
          '                  <input type="password" id="repeat_password_edit_profile" name="repeat_password_edit_profile"\n' +
          '                         class="form-control"\n' +
          '                         placeholder="تکرار رمز عبور جدید "/>\n' +
          '\n' +
          '                </div>\n' +
          '                <div id="edit_profile_btn_div" class="form-group">\n' +
          '                  <input id="edit_profile_btn" type="submit" class="form-control btn submit-btn btn-primary" value="اعمال تغییرات"/>\n' +
          '                </div>\n' +
          '              </form>\n' +
          '\n' +
          '      </div>\n' +
          '    </div>\n' +
          '        </div>\n' +
          '    <div class="modal-footer">\n' +
          '      <button type="button" class="btn btn-danger" data-dismiss="modal">\n' +
          '        بستن\n' +
          '      </button>\n' +
          '    </div>\n' +
          '  </div>\n' +
          '</div>\n' +
          '</div>\n' +
          '\n' +
          '\n' +
          '</div>')
        $('body').append(l);
    }


  });
});
