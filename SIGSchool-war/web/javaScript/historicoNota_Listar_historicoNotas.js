
function valida(campo){
    jQuery("#msg_"+campo).hide();
    if(jQuery("#"+campo).val()=='')
    {
        jQuery("."+campo+"_error").show();
        jQuery("."+campo+"_success").hide();
    }
    else
    {
        jQuery("."+campo+"_error").hide();
        jQuery("."+campo+"_success").show();
    }
}

//Arquivo javaScript para tela de cadastro de professor
jQuery(document).ready(function() {
    
    jQuery("#nome").blur(
        function(){
            valida("nome");
        });

    //Mascaras
    jQuery("#cpf").mask("999.999.999-99");   
    jQuery("#telRes").mask("(99)9999-9999");   
    jQuery("#telCel").mask("(99)9999-9999");   
});

$(function(){
      
    $('table > tbody > tr:odd').addClass('odd');
      
    $('table > tbody > tr').hover(function(){
        $(this).toggleClass('hover');
    });
      
    $('#marcar-todos').click(function(){
        $('table > tbody > tr > td > :checkbox')
        .attr('checked', $(this).is(':checked'))
        .trigger('change');
    });
      
    $('table > tbody > tr > td > :checkbox').bind('click change', function(){
        var tr = $(this).parent().parent();
        if($(this).is(':checked')) $(tr).addClass('selected');
        else $(tr).removeClass('selected');
    });
      
    $('form').submit(function(e){
        e.preventDefault();
    });
      
    $('#pesquisar').keydown(function(){
        var encontrou = false;
        var termo = $(this).val().toLowerCase();
        $('table > tbody > tr').each(function(){
            $(this).find('td').each(function(){
                if($(this).text().toLowerCase().indexOf(termo) > -1) encontrou = true;
            });
            if(!encontrou) $(this).hide();
            else $(this).show();
            encontrou = false;
        });
    });
      
    $("table") 
    .tablesorter({
        dateFormat: 'uk',
        headers: {
            0: {
                sorter: false
            },
            5: {
                sorter: false
            }
        }
    }) 
    .tablesorterPager({
        container: $("#pager")
        })
    .bind('sortEnd', function(){
        $('table > tbody > tr').removeClass('odd');
        $('table > tbody > tr:odd').addClass('odd');
    });
      
});