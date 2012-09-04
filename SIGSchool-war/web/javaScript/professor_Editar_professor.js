function validar(campos) {
    var valid = true;
    var cor_fundo = "#FFFF99"; // cor de fundo para os inputs validados
    var mensagem = "O campo ? é obrigatório, favor preencher!"; // Mensagem para validação, o "?" é o parametro que será alterado dinamicamente
    var mensagem2 = "O valor informado no campo ? é inválido, favor verificar!"; // Mensagem para validação, o "?" é o parametro que será alterado dinamicamente
    var msg = "";
    var obj_focus;
    // Adicione aqui os inputs que deseja valida, colocando o name e o título(label) que deseja !
    // Atenção: informe corretamente o id da array para o for do javascript (exemplo: 0,1,2...)
    // Observação: A array com os campos para a validação podem ser passados pelo parametro "campos" da função
    var valids = new Array();
    if (campos) {
        valids = campos;
    } else {
        valids[0] = "form_descricao|Decrição";
    }
    for(i=0;i<valids.length;i++) {
        var elements = document.getElementsByName(valids[i].split("|")[0]);
        valid = true;
        if (!elements.length) {
            alert("ATENÇÃO: Não foi localizado nenhum elemento com name = "+valids[i].split("|")[0]+"!");
            valid = false;
        }
        for(i2=0;i2<elements.length;i2++) {

            if(elements[i2].disabled){
                continue;
            }
            
            // Verificando elementos conforme seu tipo
            if ((elements[i2].tagName.toUpperCase() == "INPUT") && (elements[i2].type.toUpperCase() == "TEXT") && (!elements[i2].value))
                valid = false;
            else if ((elements[i2].tagName.toUpperCase() == "INPUT") && (elements[i2].type.toUpperCase() == "FILE") && (!elements[i2].value))
                valid = false;
            else if ((elements[i2].tagName.toUpperCase() == "INPUT") && (elements[i2].type.toUpperCase() == "PASSWORD") && (!elements[i2].value))
                valid = false;
            else if ((elements[i2].tagName.toUpperCase() == "INPUT") && (elements[i2].type.toUpperCase() == "CHECKBOX") && (!elements[i2].checked))
                valid = false;
            else if ((elements[i2].tagName.toUpperCase() == "SELECT") && (!elements[i2].value))
                valid = false;
            else if ((elements[i2].tagName.toUpperCase() == "TEXTAREA") && (!elements[i2].value))
                valid = false;

            // Procedimento se NÃO ESTIVER preenchido
            if (!valid) {
                elements[i2].style.background = cor_fundo;
                msg = msg+mensagem.replace("?",valids[i].split("|")[1])+"\n";
                if (!obj_focus)
                    obj_focus = elements[i2];
            } else { // Procedimento se ESTIVER preenchido
                elements[i2].style.background = "none";

                if ((elements[i2].tagName.toUpperCase() == "INPUT") && (elements[i2].type.toUpperCase() == "TEXT") && valid){
                    if (valids[i].split("|")[2] == 'data'){
                        if (!val_date(elements[i2].value)) {
                            valid = false;
                            elements[i2].style.background = cor_fundo;
                            msg = msg+mensagem2.replace("?",valids[i].split("|")[1])+"\n";
                            if (!obj_focus)
                                obj_focus = elements[i2];
                        }
                    } else if (valids[i].split("|")[2] == 'int'){
                        if (StrToInt(elements[i2].value) <= 0) {
                            valid = false;
                            elements[i2].style.background = cor_fundo;
                            msg = msg+mensagem2.replace("?",valids[i].split("|")[1])+"\n";
                            if (!obj_focus)
                                obj_focus = elements[i2];
                        }
                    } else if (valids[i].split("|")[2] == 'float'){
                        if (StrToFloat(elements[i2].value) <= 0) {
                            valid = false;
                            elements[i2].style.background = cor_fundo;
                            msg = msg+mensagem2.replace("?",valids[i].split("|")[1])+"\n";
                            if (!obj_focus)
                                obj_focus = elements[i2];
                        }
                    } else if (valids[i].split("|")[2] == 'email'){
                        if (!val_email(elements[i2])) {
                            valid = false;
                            elements[i2].style.background = cor_fundo;
                            msg = msg+mensagem2.replace("?",valids[i].split("|")[1])+"\n";
                            if (!obj_focus)
                                obj_focus = elements[i2];
                        }
                    }
                }
            }
        }
    }
    valid = true;
    if (msg) {
        valid = false;
        alert("ATENÇÃO!\n\n"+msg);
    //obj_focus.focus();
    }
    return valid;
}

function valida_form(oForm) {    
    
    var validacao = new Array();
    var valid = true;		
		
    if(!$("#form_editar_professor").val()){
        //Professor
        validacao[validacao.length] = "nome|Nome";
        validacao[validacao.length] = "matricula|Matricula";
        validacao[validacao.length] = "cpf|Cpf";
        validacao[validacao.length] = "rg|Rg";
        validacao[validacao.length] = "sexo|Sexo";
        validacao[validacao.length] = "email|Email";
        validacao[validacao.length] = "telRes|Telefone Residencial";
        validacao[validacao.length] = "telCel|Telefone Celular";
        validacao[validacao.length] = "dataNasc|Data de Nascimento";
        
        //Endereço
        validacao[validacao.length] = "logradouro|Logradouro";
        validacao[validacao.length] = "numero|Número";
        validacao[validacao.length] = "bairro|Bairro";
        validacao[validacao.length] = "cidade|Cidade";
        validacao[validacao.length] = "uf|Uf";
        validacao[validacao.length] = "cep|Cep";
    }
	
    valid = validar(validacao);
	
    return valid;
}

//Valida Campos
function valida(campo){
    jQuery("#msg_"+campo).hide();
    if(jQuery("#"+campo).val()==''||jQuery("#"+campo).val()=='___.___.___-__'||jQuery("#"+campo).val()=='(__)____-____'||jQuery("#"+campo).val()=='__/__/____')
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
    
    jQuery(".mf").blur(
    function(){
            valida($(this).attr('name'));
    });

    //Mascaras
    jQuery("#cpf").mask("999.999.999-99");   
    jQuery("#telRes").mask("(99)9999-9999");   
    jQuery("#telCel").mask("(99)9999-9999");  
    jQuery("#dataNasc").mask("99/99/9999");  
    
    //dataNasc
});