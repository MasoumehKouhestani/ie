$(document).ready(function(){
    $.get("/eghdam", function(data){



        modal="m"+i;
        var type=""
        if(data.type==="s"){
            type=' <span class="text-danger shekayattext">\n' +
                '\n' +
                '        شکایت\n' +
                '  &nbsp;&nbsp;\n' +
                '    </span>';}
        else if(data.type==="e"){
            type='  <span class="text-warning enteghdtext">\n' +
                ' انتقاد\n' +
                '  &nbsp;&nbsp;\n' +
                '    </span>';
        }
        else if(data.type==="p"){
            type=' <span class="text-success pishnahadtext">\n' +
                '  پیشهاد\n' +
                '  &nbsp;&nbsp;\n' +
                '    </span>';
        }
        else if(data.type==="d"){
            type='<span class="text-info darkhasttext">\n' +
                '  درخواست\n' +
                '  &nbsp;&nbsp;\n' +
                '    </span>';
        }
        var condition=""
        if(data.condition==="o"){
            condition=' <span class="text-danger open ">\n' +
                'باز\n' +
                '    </span>';
        }
        else if (data.condition==="c") {
            condition='<span class="text-success  "> بسته</span>';
        }
        else if (data.condition==="i") {
            condition='<span class="text-info inqueue">\n' +
                'در حال بررسی\n' +
                '    </span>';
        }
        else if (data.condition==="d") {
            condition='                    <span class="text-warning postponed">\n' +
                'تعویق\n' +
                '    </span>\n';
        }
            var y=$('<div class=" morddisplay">\n' +
                '            <div class="row ">\n' +
                '                <div class="col-sm-9 mdec">\n' +
                '                    <br>\n' +
                '                    <div class="mdechead font-weight-bold text-right">\n' +
                '            <span class="text-primary">\n' +
                '                موضوع\n' +
                '           : </span>\n' +
                '            <span class="title">\n' +


                data.topic+


                '            </span>\n' +
                '                    </div>\n' +
                '                    <br>\n' +
                '                    <div class="dec text-right text-secondary tozihat">\n' +


                data.description+

                '\n' +
                '                    </div>\n' +
                '                    <br>\n' +
                '                    <div class="file-down text-right font-weight-bold" style="margin-bottom: 1rem">\n' +
                '\n' +
                '                        <input type="submit" class="btn btn-info btn-sm down" value="دانلود فایل پیوست">\n' +
                '\n' +
                '\n' +
                '\n' +
                '                        <input type="submit" class="btn btn-sm btn-secondary" data-toggle="modal" data-target="#' +
                modal+
                '" value="دیدن توضیحات سایرین">\n' +
                '\n' +
                '                    <p class="text-danger text-right downloadnone">\n' +
                '\n' +
                '                        <i class="fas fa-exclamation-triangle"></i>\n' +
                '                        فایلی برای دانلود وجود ندارد\n' +
                '                        ! </p>\n' +
                '                    </div>\n' +
                '\n' +
                '\n' +
                '\n' +
                '\n' +
                '\n' +
                '\n' +
                '                </div>\n' +
                '\n' +
                '                <div  class=" font-weight-bold col-sm-3 text-right header-mord">\n' +
                '                    <br>\n' +
                '  <span class="text-left text-primary">\n' +
                '      نوع مورد :\n' +
                '  </span>\n' +

                type+
                '                    <br><br>\n' +
                '     <span class="text-left text-primary">\n' +
                '   مربوط به بخش:\n' +
                ' </span>\n' +
                '    <span class="section">\n' +

                data.section+

                '\n' +
                '    </span>\n' +
                '                    <br><br>\n' +
                '     <span class="text-left text-primary">\n' +
                '    ارسال کننده\n' +
                ' :</span>\n' +
                '    <span class="sender">\n' +
                data.sender+

                '\n' +
                '    </span>\n' +
                '                    <br><br>\n' +
                '     <span class="text-left text-primary">\n' +
                '  ارجاع به\n' +
                ' :</span>\n' +
                '    <span class="referto">\n' +
                data.referTo+
                '\n' +
                '    </span>\n' +
                '                    <br><br>\n' +
                '     <span class="text-left text-primary">\n' +
                'وضعیت\n' +
                ' :</span>\n' +

                condition+
                '                    <br><br>\n' +
                '                                         <span class="text-left text-primary">\n' +
                'تاریخ ثبت\n' +
                ' :</span>\n' +
                '    <span class="startdate" >\n' +
                data.startdate+

                '\n' +
                '    </span>\n' +
                '                    <br><br>\n' +
                '                         <span class="text-left text-primary">\n' +
                'تاریخ بسته شدن\n' +
                ' :</span>\n' +
                '    <span class="enddate">\n' +
                data.enddate+

                '\n' +
                '    </span>\n' +
                '\n' +
                '\n' +
                '\n' +
                '                    <br><br>\n' +
                '\n' +

                '                    <br>\n' +
                '                </div>\n' +
                '            </div>\n' +
                '        </div>\n' +
                '   ');
            $('#mordegdam').append(y);




        var mm="";
        for(var j=0;j<data.comments.length;j++){
            mm=mm+'<div class="boxinmodal text-sm-right ">\n' +
                '                            <p class="text-primary font-weight-bold">\n' +
                data.other[j].name+
                '\n' +
                '                            </p>\n' +
                '                            <p class="text-secondary">\n' +
                data.other[j].des+
                '\n' +
                '                            </p>\n' +
                '\n' +
                '                            <br>\n' +
                '\n' +
                '                        </div>';

        }
        var m=$('<div class="modal" id="' +
            modal+
            '">\n' +
            '    <div class="modal-dialog modal-dialog-centered modal-lg ">\n' +
            '        <div class="modal-content">\n' +
            '            <div class="modal-header">\n' +
            '                <h5 class="modal-title">\n' +
            '                    توضیحات سایرین\n' +
            '                </h5>\n' +
            '            </div>\n' +
            '\n' +
            '            <div class="modal-body">\n' +
            '                <div class="row bg-white">\n' +
            '                    <div class="col-sm">\n' +

            mm+


            '\n' +
            '                        <br>\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '            </div>\n' +
            '        </div>\n' +
            '        <div class="modal-footer">\n' +
            '            <button type="button" class="btn btn-danger" data-dismiss="modal">\n' +
            '                بستن\n' +
            '            </button>\n' +
            '        </div>\n' +
            '    </div>\n' +
            '</div>'
        );

        $('body').append(m);

        $(".down").click(function(){//six

            $(this).next().next().show()
            $(this).next().next().hide(3000)
        });


    })
});
