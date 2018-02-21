$(function()){
   let $tblBody = $("#tblBody");
    $.getJSON("Localhost:8080/taller/webapi/usuarios")
        .done(Function(usuarios)){
        
        
        $.each(usuarios, function(i, usuarios){
            let $tr = $('<tr/>');
            
            $tr.append($("<td>",{
                text: usuario.nombre
            }))
        })
        
        
    }
  }