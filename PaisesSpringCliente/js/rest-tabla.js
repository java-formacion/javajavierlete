$(document).ready(function () {

    $.ajax({
        url: 'http://localhost:8080/paises',
        type: 'get',
        dataType: 'json',
    }).done(function (data) {

        const paises = data;
        //console.log(paises);

        for (let i = 0; i < paises.length; i++) {
            const pais = paises[i];

            $("tbody").append('<tr />').children('tr:last')
                .append("<td>" + pais.nombre + "</td>")
                .append("<td>" + pais.continente + "</td>");

        }

    });

});