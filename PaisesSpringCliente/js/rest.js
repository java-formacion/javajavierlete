$(function () {

    $.ajax({
        url: 'http://localhost:8080/paises',
        type: 'get',
        dataType: 'json',
    }).done(function (data) {

        const paises = data;
        console.log(paises);

        for (let i = 0; i < paises.length; i++) {
            const pais = paises[i];

            $("#paises-select").append($("<option />", {
                "text": pais.nombre,
                "data-continente": pais.continente
            }));
        }

        $("#continente-mostrar").click(function () {
            if ($("#paises-select").val() == "Selecciona un país") {
                $("#continente-text").val("No has seleccionado un país");
            } else {
                var continente = $("#paises-select :selected").data("continente");
                console.log(continente);

                $("#continente-text").val(continente);
            }
        });

    });

});