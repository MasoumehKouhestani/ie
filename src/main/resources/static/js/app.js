/**
 * Created by zahra on 3/31/2019.
 */
$(document).ready(function() {
    $('#selall').hide();
    $('#filter').click(function(e){
        e.preventDefault();
    });
  $('.f').click(function(e){
    e.preventDefault();
  });

    $(".down").click(function(){//six

         $(this).next().next().show()
        $(this).next().next().hide(3000)
    });




    $('#filter').click(function(){//six
        if($('select option:selected').val()==='all'){
            $('#selmyself').hide()
            $('#selall').show()
        }
        else{
            $('#selmyself').show()
            $('#selall').hide()
        }
    })
  $('.var5').focus(function(){
    $(this).next().hide();
  })

});
