const paginas = document.querySelector('.cjt-paginas');
const searchParams = new URLSearchParams(window.location.search)
const categoria = window.location.pathname.split("/").at(1);
let params = searchParams.get("pagina");
let paginaAtual = parseInt(params);

let totalDePaginas = parseInt(paginas.getAttribute('data-paginas'));
function paginasIniciais() {
    for (let contadorDePaginas = 1; contadorDePaginas <= totalDePaginas; contadorDePaginas++) {
        if (contadorDePaginas <= 5) {
            const numeros = document.createElement("a");
            numeros.innerHTML = `${contadorDePaginas}`
            numeros.classList.add("paginas");
            params != null && contadorDePaginas == paginaAtual ? numeros.classList.add("activePgn") : "";
            numeros.setAttribute("href", `/${categoria}?pagina=${contadorDePaginas}`)
            paginas.appendChild(numeros);
        }
    }
    if (totalDePaginas>5) {
        paginas.innerHTML += `
            <a class="paginas">...</a>
            <a class="paginas" href="/${categoria}?pagina=${totalDePaginas}">${totalDePaginas}</a>
        `
    }
}

function paginasLongas(){
    paginas.innerHTML= `
        <a class="paginas" href="/${categoria}?pagina=1">1</a>
        <a class="paginas" href="/${categoria}?pagina=2">2</a>
        <a class="paginas">...</a>
        <a class="paginas" href="/${categoria}?pagina=${paginaAtual-1}">${paginaAtual-1}</a>
        <a class="paginas activePgn" href="/${categoria}?pagina=${paginaAtual}">${paginaAtual}</a>
    `
    if (totalDePaginas>paginaAtual){
        paginas.innerHTML += `
            <a class="paginas" href="/${categoria}?pagina=${paginaAtual+1}">${paginaAtual+1}</a>
        `
        if (paginaAtual+3<=totalDePaginas){
            paginas.innerHTML += `
            <a class="paginas">...</a>
            <a class="paginas" href="/${categoria}?pagina=${totalDePaginas}">${totalDePaginas}</a>
        `
        }else if (paginaAtual+2 ==totalDePaginas){
            paginas.innerHTML += `
            <a class="paginas" href="/${categoria}?pagina=${paginaAtual+2}">${paginaAtual+2}</a>
        `
        }

    }
}
function stylePaginas(){
    params != null && paginaAtual > 4? paginasLongas():paginasIniciais();
}

stylePaginas();

