function salvarContato() {
    $.ajax({              
        method: "POST",
        url: "../../contatos",
        data: JSON.stringify({
            id: null,
            nome: $("#nome").val(),
            email: $("#email").val(),
            comentario: $("#comentarios").val(),
            rua: $("#rua").val(),
            numero: $("#numero").val(),
            bairro: $("#bairro").val(),
            cep: $("#cep").val(),
            telefone: $("#telefone").val(),
            cidadeId: $("#cidade").val()
        }),
        contentType: "application/json; charset=utf-8",
        success: function (response) {
            alert("Contato salvo!" + response)
        }
    }).fail(function (xhr, status, errorThrow) {
        alert("Erro ao cadastrar o contato! Erro:" + errorThrow)
    });
}
