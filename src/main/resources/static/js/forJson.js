/**
 * Created by zahra on 4/11/2019.
 */
$(document).ready(function(){
    var h;
    $.get("json/case.json", function(data){
        var modal="modal";

        for(var i=0;i<data.length;i++){
            var ebtn="i";
            ebtn=ebtn+i;
            modal=modal+i;
            var x=data[i];

            var type=""
            if(x.type==="shekayet"){
                type=' <span class="text-danger shekayattext">\n' +
            '\n' +
            '        شکایت\n' +
            '  &nbsp;&nbsp;\n' +
            '    </span>';}
            else if(x.type==="enteghad"){
                type='  <span class="text-warning enteghdtext">\n' +
                    ' انتقاد\n' +
                    '  &nbsp;&nbsp;\n' +
                    '    </span>';
            }
            else if(x.type==="phishnahad"){
                    type=' <span class="text-success pishnahadtext">\n' +
                        '  پیشهاد\n' +
                        '  &nbsp;&nbsp;\n' +
                        '    </span>';
            }
            else if(x.type==="darkhast"){
                type='<span class="text-info darkhasttext">\n' +
                    '  درخواست\n' +
                    '  &nbsp;&nbsp;\n' +
                    '    </span>';
            }
            var condition=""
            if(x.condition==="open"){
                condition=' <span class="text-danger open ">\n' +
                    'باز\n' +
                    '    </span>';
            }
            else if (x.condition==="close") {
                condition='<span class="text-success  "> بسته</span>';
            }
            else if (x.condition==="inqueue") {
                condition='<span class="text-info inqueue">\n' +
                    'در حال بررسی\n' +
                    '    </span>';
            }
            else if (x.condition==="delay") {
                condition='                    <span class="text-warning postponed">\n' +
                    'تعویق\n' +
                    '    </span>\n';
            }



            if(x.referTo=="زهرا محمدی"){
                var y=$('<div class=" morddisplay">\n' +
                    '            <div class="row ">\n' +
                    '                <div class="col-sm-9 mdec">\n' +
                    '                    <br>\n' +
                    '                    <div class="mdechead font-weight-bold text-right">\n' +
                    '            <span class="text-primary">\n' +
                    '                موضوع\n' +
                    '           : </span>\n' +
                    '            <span class="title">\n' +


                    x.topic+


                    '            </span>\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="dec text-right text-secondary tozihat">\n' +


                    x.description+

                    '\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="file-down text-right font-weight-bold">\n' +
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

                   x.section+

                    '\n' +
                    '    </span>\n' +
                    '                    <br><br>\n' +
                    '     <span class="text-left text-primary">\n' +
                    '    ارسال کننده\n' +
                    ' :</span>\n' +
                    '    <span class="sender">\n' +
                   x.sender+

                    '\n' +
                    '    </span>\n' +
                    '                    <br><br>\n' +
                    '     <span class="text-left text-primary">\n' +
                    '  ارجاع به\n' +
                    ' :</span>\n' +
                    '    <span class="referto">\n' +
                    x.referTo+
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
                    x.startdate+

                    '\n' +
                    '    </span>\n' +
                    '                    <br><br>\n' +
                    '                         <span class="text-left text-primary">\n' +
                    'تاریخ بسته شدن\n' +
                    ' :</span>\n' +
                    '    <span class="enddate">\n' +
                    x.enddate+

                    '\n' +
                    '    </span>\n' +
                    '\n' +
                    '\n' +
                    '\n' +
                    '                    <br><br>\n' +
                    '\n' +
                    '                    <a href="seven.html" class="text-white btn-primary btn btn-block egdam" egdam="' +
               ebtn+
                    '">\n' +
                    '                        اقدام\n' +
                    '                    </a>\n' +
                    '                    <br>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '        </div>\n' +
                    '   ');
                $('#my').append(y);


            }

            var mm="";
            for(var j=0;j<data[i].other.length;j++){
                mm=mm+'<div class="boxinmodal text-sm-right ">\n' +
                    '                            <p class="text-primary font-weight-bold">\n' +
                    data[i].other[j].name+
                    '\n' +
                    '                            </p>\n' +
                    '                            <p class="text-secondary">\n' +
                    data[i].other[j].des+
                    '\n' +
                    '                            </p>\n' +
                    '\n' +
                    '                            <br>\n' +
                    '\n' +
                    '                        </div>';

            }
                var z=$('<div class=" morddisplay">\n' +
                    '            <div class="row ">\n' +
                    '                <div class="col-sm-9 mdec">\n' +
                    '                    <br>\n' +
                    '                    <div class="mdechead font-weight-bold text-right">\n' +
                    '            <span class="text-primary">\n' +
                    '                موضوع\n' +
                    '           : </span>\n' +
                    '            <span class="title">\n' +


                    x.topic+


                    '            </span>\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="dec text-right text-secondary tozihat">\n' +


                    x.description+

                    '\n' +
                    '                    </div>\n' +
                    '                    <br>\n' +
                    '                    <div class="file-down text-right font-weight-bold">\n' +
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

                    x.section+

                    '\n' +
                    '    </span>\n' +
                    '                    <br><br>\n' +
                    '     <span class="text-left text-primary">\n' +
                    '    ارسال کننده\n' +
                    ' :</span>\n' +
                    '    <span class="sender">\n' +
                    x.sender+

                    '\n' +
                    '    </span>\n' +
                    '                    <br><br>\n' +
                    '     <span class="text-left text-primary">\n' +
                    '  ارجاع به\n' +
                    ' :</span>\n' +
                    '    <span class="referto">\n' +
                    x.referTo+
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
                    x.startdate+

                    '\n' +
                    '    </span>\n' +
                    '                    <br><br>\n' +
                    '                         <span class="text-left text-primary">\n' +
                    'تاریخ بسته شدن\n' +
                    ' :</span>\n' +
                    '    <span class="enddate">\n' +
                    x.enddate+

                    '\n' +
                    '    </span>\n' +
                    '\n' +
                    '\n' +
                    '\n' +
                    '                    <br><br>\n' +
                    '\n' +
                    '                    <a href="seven.html" class="text-white btn-primary btn btn-block egdam" egdam="' +
                   ebtn+
                    '">\n' +
                    '                        اقدام\n' +
                    '                    </a>\n' +
                    '                    <br>\n' +
                    '                </div>\n' +
                    '            </div>\n' +
                    '        </div>\n' +
                    '   ');
                $('#all').append(z);



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

            $('#bodysix').append(m);

            $(".down").click(function(){//six

                $(this).next().next().show()
                $(this).next().next().hide(3000)
            });
            // $('.egdam').click(function () {
            //     var l=$(this).attr('egdam');
            //     var g=l.charAt(1);
            //
            //
            //     h=' <div class=" morddisplay">\n' +
            //         '            <div class="row ">\n' +
            //         '                <div class="col-sm-9 mdec">\n' +
            //         '                    <br>\n' +
            //         '                    <div class="mdechead font-weight-bold text-right">\n' +
            //         '            <span class="text-primary">\n' +
            //         '                موضوع\n' +
            //         '           : </span>\n' +
            //         '            <span class="titel_egdam" >\n' +
            //         data[g].topic+
            //         '\n' +
            //         '            </span>\n' +
            //         '                    </div>\n' +
            //         '                    <br>\n' +
            //         '                    <div class="dec text-right text-secondary dec-eghdam">\n' +
            //         data[g].description+
            //         '\n' +
            //         '\n' +
            //         '                    </div>\n' +
            //         '                    <br>\n' +
            //         '                    <div class="file-down text-right font-weight-bold" style="margin-bottom: 1rem">\n' +
            //         '\n' +
            //         '                        <input type="submit" class="btn btn-info btn-sm down" value="دانلود فایل پیوست">\n' +
            //         '\n' +
            //         '\n' +
            //         '\n' +
            //         '                        <input type="submit" class="btn btn-sm btn-secondary" data-toggle="modal" data-target="#other" value="دیدن توضیحات سایرین">\n' +
            //         '\n' +
            //         '\n' +
            //         '\n' +
            //         '                    <p class="text-danger text-right downloadnone ">\n' +
            //         '                        <i class="fas fa-exclamation-triangle"></i>\n' +
            //         '                        فایلی برای دانلود وجود ندارد\n' +
            //         '                        ! </p>\n' +
            //         '\n' +
            //         '\n' +
            //         '                    </div>\n' +
            //         '\n' +
            //         '\n' +
            //         '                </div>\n' +
            //         '\n' +
            //         '                <div  class=" font-weight-bold col-sm-3 text-right header-mord">\n' +
            //         '                    <br>\n' +
            //         '  <span class="text-left text-primary">\n' +
            //         '      نوع مورد :\n' +
            //         '  </span>\n' +
            //         '    \n' +
            //         '                    <br><br>\n' +
            //         '     <span class="text-left text-primary">\n' +
            //         '   مربوط به بخش:\n' +
            //         ' </span>\n' +
            //         '    <span class="section-egdam">' +
            //         data[g].section+
            //         '</span>\n' +
            //         '                    <br><br>\n' +
            //         '     <span class="text-left text-primary">\n' +
            //         '    ارسال کننده\n' +
            //         ' :</span>\n' +
            //         '    <span class="sender-egdam">' +
            //         data[g].sender+
            //         '</span>\n' +
            //         '                    <br><br>\n' +
            //         '     <span class="text-left text-primary">\n' +
            //         '  ارجاع به\n' +
            //         ' :</span>\n' +
            //         '    <span class="referto-eghdam"></span>\n' +
            //         '                    <br><br>\n' +
            //         '     <span class="text-left text-primary">\n' +
            //         'وضعیت\n' +
            //         ' :</span>\n' +
            //         '\n' +
            //         '                    <br><br>\n' +
            //         '                                         <span class="text-left text-primary">\n' +
            //         'تاریخ ثبت\n' +
            //         ' :</span>\n' +
            //         '    <span >\n' +
            //         data[g].startdate+
            //         '\n' +
            //         '    </span>\n' +
            //         '                    <br><br>\n' +
            //         '                         <span class="text-left text-primary">\n' +
            //         'تاریخ بسته شدن\n' +
            //         ' :</span>\n' +
            //         '    <span >\n' +
            //         data[g].enddate+
            //         '    </span>\n' +
            //         '\n' +
            //         '\n' +
            //         '\n' +
            //         '                    <br><br>\n' +
            //         '\n' +
            //         '\n' +
            //         '                    <br>\n' +
            //         '                </div>\n' +
            //         '            </div>\n' +
            //         '        </div>';
            //
            //
            //
            // });





            }




    });


});

