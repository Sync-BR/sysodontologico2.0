document.getElementById("cep").addEventListener("blur", function () {
    const cep = this.value.replace(/\D/g, "");
    if (cep.length !== 8) return;

    fetch(`https://viacep.com.br/ws/${cep}/json/`)
        .then(response => response.json())
        .then(data => {
            if (data.erro) {
                alert("CEP não encontrado!");
                return;
            }

            // Preencher campos
            document.getElementById("address").value = data.logradouro || "";
            document.getElementById("city").value = data.localidade || "";
            document.getElementById("state").value = data.uf || "";
        })
        .catch(() => alert("Erro ao buscar o CEP!"));
});