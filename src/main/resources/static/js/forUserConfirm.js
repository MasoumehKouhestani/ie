$(document).ready(function(){
  $.get("json/userAuthentication.json", function(data){
    for (var i = 0; i < data.length; i++) {
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
        '          <button type="submit" class="btn btn-success b1 b">تایید</button>\n' +
        '          <button type="submit" class="btn btn-danger b2 b">رد</button>\n'+
        '   <p class="text-right text-success t">تایید شد! </p>\n' +
        '          <p class="text-right text-danger r"> رد شد!</p>'+
        '        </form>\n' +
        '      </div>');
      $('.person_info_container').append(s);
      $('.b1').click(function() {
          $(this).next().next().next().hide();
        $(this).next().next().show();

          $(this).next().next().hide(4000);
      }
      )
      $('.b2').click(function() {
        $(this).next().hide();
        $(this).next().next().show();

        $(this).next().next().hide(4000);
        }
      )
      $('.b').click(function(e){
        e.preventDefault();
      });
    }

  });
});
