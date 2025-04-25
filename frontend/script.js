document.querySelectorAll('.opcoes button').forEach(button => {
    button.addEventListener('click', () => {
        alert(`Você votou em: ${button.textContent}`);
    });
});