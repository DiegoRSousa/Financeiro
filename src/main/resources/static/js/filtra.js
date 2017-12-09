var campoFiltro = document.querySelector("#filtra-tabela");

campoFiltro.addEventListener("input", function() {
	var clientes = document.querySelectorAll(".cliente");
	
	if(this.value.length > 0) {
		for(var i = 0; i < clientes.length; i++) {
			var cliente = clientes[i];
			var nome = cliente.querySelector(".info-nome").textContent;
			
			var expressao = new RegExp(this.value, "i");
			if(expressao.test(nome)) {
				cliente.classList.remove("invisivel");
			} else {
				cliente.classList.add("invisivel");
			}
			
		}
	} else {
		for(var i = 0; i < clientes.length; i++) {
			var cliente = clientes[i];
			cliente.classList.remove("invisivel");
		}
	}
});