// script.js - Versão com localStorage
let usuarios = JSON.parse(localStorage.getItem('usuarios')) || [
    { id: 1, nome: "Admin", email: "admin@teste.com", senha: "123456" }
];

let enquetes = JSON.parse(localStorage.getItem('enquetes')) || [
    { 
        id: 1, 
        pergunta: "Qual seu filme favorito?", 
        opcoes: ["Ação", "Comédia", "Drama"],
        votos: [0, 0, 0]
    }
];

// Função para salvar dados no localStorage
function salvarDados() {
    localStorage.setItem('usuarios', JSON.stringify(usuarios));
    localStorage.setItem('enquetes', JSON.stringify(enquetes));
}

// Exemplo de como usar (adicione ao final das funções de cadastro/votação):
function handleCadastro() {
    const nome = document.getElementById("nome").value;
    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value;
    
    usuarios.push({ id: usuarios.length + 1, nome, email, senha });
    salvarDados(); // Salva no localStorage
    alert("Cadastro realizado!");
    window.location.href = "login.html";
}

function votar(opcaoIndex) {
    enquetes[0].votos[opcaoIndex]++;
    salvarDados(); // Salva no localStorage
    atualizarResultados();
}