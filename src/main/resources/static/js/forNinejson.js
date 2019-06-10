$(document).ready(function(){
  $.get("/listofuser", function(data){
  var m="m";
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

          '<button type="button" class="btn btn-success b3"  value="' +
        x.username+
        '">' +
        'تایید' +
        '</button>\n' +
          '      <button type="button" class="btn btn-secondary b2" value="' +
        x.username+
        '"' +
        '>' +
        'غیرفعال' +
        '</button>\n' +
          '      <input type="button" value="ویرایش پروفایل" class="btn btn-info" data-toggle="modal" data-target="#' +
          m +
          '">\n' +
          '      <button type="button" class="btn btn-danger b1" value="' +
        x.username+
        '"' +
        '>' +
        'حذف' +
        '</button>\n' +
        '   <p class="text-right text-success t">انجام شد </p>\n' +

          '      </div>\n' +
          '    </div>\n' +
          '  </div>\n' +
          '</div>'
       );

      $('.person_info_container').append(s);
      $('.b3').click(function() {
        $.post("/confrimed",$(this).val() ,function(d){});
        $('.t').show()

        $('.t').hide(4000);

      });
      $('.b2').click(function() {
        $.post("/deactive",$(this).val() ,function(d){});

        $('.t').show()

        $('.t').hide(4000);


      });
      $('.b1').click(function() {
        $.post("/unconfrimed",$(this).val() ,function(d){});

        $('.t').show()

        $('.t').hide(4000);


      });
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
          '              <form  method="post" action="/managerprofileset" ' +
        'class="form-group form-horizontal f"\n' +
        '          data-bv-feedbackicons-valid="glyphicon glyphicon-ok"\n' +
        '          data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"\n' +
        '          data-bv-feedbackicons-validating="glyphicon glyphicon-refresh" >\n' +
          '                <div class="form-group">\n' +
          '                  <label >نام و نام خانوادگی:</label>\n' +
          '                  <input type="text" id="name" name="name" class="form-control"\n' +
        'placeholder="نام و نام خانوادگی خود را وارد کنید"\n' +
        '               data-bv-notempty="true"\n' +
        '               data-bv-notempty-message="نام و نام خانودگی نمی تواند خالی باشد!"/>\n' +
          '\n' +
          '                  <br>\n' +
          '                </div>\n' +
          '                <div class="form-group">\n' +
          '                  <label >نام کاربری:</label>\n' +
          '                  <input type="text" id="username" name="username" class="form-control"' +
        '               data-bv-notempty="true"\n' +
        '               data-bv-notempty-message=" نام کاربری نمی تواند خالی باشد! "\n' +
        '\n' +
        '               data-bv-stringlength="true"\n' +
        '               data-bv-stringlength-min="6"\n' +
        '               data-bv-stringlength-max="30"\n' +
        '               data-bv-stringlength-message="   نام کاربری باید بیشتز از شش و کمتر از 30 کاراکتر باشد!"\n' +
        '\n' +
        '\n' +
        '               data-bv-different="true"\n' +
        '               data-bv-different-field="password"\n' +
        '               data-bv-different-message=" نام کاربری و رمز نمی تواند یکسان باشد!  "\n' +
          '                         placeholder="نام کاربری "/>\n' +
          '\n' +
          '                  <br>\n' +
          '                </div>\n' +
          '                <div class="form-group">\n' +
          '                  <label >پست الکترونیکی:</label>\n' +
          '                  <input type="email" id="email" name="email" class="form-control"' +
        ' data-bv-notempty="true"\n' +
        '               data-bv-notempty-message=" ایمیل نمی تواند خالی باشد! "\n' +
        '\n' +
        '               data-bv-emailaddress="true"\n' +
        '               data-bv-emailaddress-message=" ادرس ایمیل معتبر نیست! "\n' +
          '                         placeholder="پست الکترونیکی "/>\n' +
          '\n' +
          '                  <br>\n' +
          '                </div>\n' +
          '                <div class="form-group">\n' +
          '                  <label for="new_password_edit_profile">رمز عبور جدید:</label>\n' +
          '                  <input type="password" id="password" name="password" class="form-control"\n' +
        '               data-bv-notempty="true"\n' +
        '               data-bv-notempty-message=" رمز نمی تواند خالی باشد! "\n' +
        '\n' +
        '               data-bv-stringlength="true"\n' +
        '               data-bv-stringlength-min="8"\n' +
        '               data-bv-stringlength-message=" رمز باید حداقل هشت کاراکتر باشد! "\n' +
        '\n' +
        '               data-bv-different="true"\n' +
        '               data-bv-different-field="username"\n' +
        '               data-bv-different-message=" نام کاربری و رمز نمی تواند یکسان باشد! "/>\n' +
          '\n' +

          '\n' +
          '                </div>\ <input type="hidden" id="old" name="old" value="' +
        x.email+
        '">' +
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

        $('.f').bootstrapValidator();
    }


  });
});
