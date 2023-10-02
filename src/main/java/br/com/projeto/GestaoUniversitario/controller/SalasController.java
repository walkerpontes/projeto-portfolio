package br.com.projeto.GestaoUniversitario.controller;

import br.com.projeto.GestaoUniversitario.model.Mensagem;
import br.com.projeto.GestaoUniversitario.model.Salas;
import br.com.projeto.GestaoUniversitario.model.Usuario;
import br.com.projeto.GestaoUniversitario.repository.SalasRepository;
import br.com.projeto.GestaoUniversitario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.awt.print.Pageable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@Transactional
public class SalasController {
    @Autowired
    SalasRepository repository;
    @Autowired
    UsuarioRepository repositoryUser;

    @GetMapping("/salas")
    public String sala(Model model,@RequestParam(value = "pagina",required = false,defaultValue = "0")int pagina){
        PageRequest paginacao = PageRequest.of(pagina == 0 ? 0 : pagina-1, 9, Sort.Direction.ASC, "titulo");
        Page<Salas> paginaSalas = repository.findAll(paginacao);
        int totalPaginas = paginaSalas.getTotalPages();
        List<Salas> listaSalas = paginaSalas.get().collect(Collectors.toList());
        String nome = repositoryUser.findById(repository.pegarUsuario(19)).get().getNome();
        System.out.println(nome);
        model.addAttribute("sala",repository);
        model.addAttribute("user",repositoryUser);
        model.addAttribute("total",totalPaginas);
        model.addAttribute("listaSala",listaSalas);
        return "sala";
    }
    @PreAuthorize(value = "hasRole('ROLE_USUARIO')")
    @RequestMapping("/salas/{id}")
    public String salamensagem(Model model,@PathVariable int id){
        Optional<Salas> sala = repository.findById(id);
        model.addAttribute("sala",sala);
        procurarMensagem(model, id);
        return "padraoSala";
    }
    @PreAuthorize(value = "hasRole('ROLE_USUARIO')")
    @GetMapping("/salas/mensagem")
        public void mensagem (Model model, HttpServletResponse response, @RequestParam int id, @RequestParam String mensagem) throws IOException {
        Usuario usuario = new Usuario();
        Optional<Usuario> user = repositoryUser.findByEmailAllIgnoreCase(usuario.logado());
        Usuario logado = user.get();
        repository.saveByMensagemAllIgnoreCase(mensagem,id, logado.getId());
        procurarMensagem(model, id);
        response.sendRedirect("/salas/"+id);
    }

    private void procurarMensagem(Model model, int id) {
        Optional<Salas> search = repository.findByIdAllIgnoreCase(id);
        Salas sala = search.get();
        List<Mensagem> textos = sala.getMensagem();
        Usuario usuario = new Usuario();
        Optional<Usuario> user = repositoryUser.findByEmailAllIgnoreCase(usuario.logado());
        int logado = user.get().getId();
        model.addAttribute("logado", logado);
        model.addAttribute("mensagem",textos);
        model.addAttribute("sala",sala);
    }
    @RequestMapping("/salas/search")
    public String searchSala(Model model,@RequestParam String buscar){
        List<Salas> listaSala = repository.findByTituloContainingIgnoreCase(buscar);
        model.addAttribute("listaSala",listaSala);
        return "sala";
    }
    @PreAuthorize(value = "hasRole('USUARIO')")
    @RequestMapping("/salas/cadastrar")
    public String criar(){
        return "salasCadastro";
    }
    @PreAuthorize(value = "hasRole('USUARIO')")
    @GetMapping("/salas/new")
    public void cadastrar(HttpServletResponse http,@RequestParam("curso")String curso,@RequestParam("titulo")String titulo) throws IOException {
        if (!verificarExistencia(curso,titulo)) {
            Usuario user = new Usuario();
            Optional<Usuario> usuario = repositoryUser.findByEmailAllIgnoreCase(user.logado());
            Salas novaSala = new Salas(curso, titulo);
            repository.save(novaSala);
            int idSala = repository.findByTituloContainingIgnoreCase(titulo).get(0).getId();
            repository.cadastrarCurso(usuario.get().getId(),idSala);
            http.sendRedirect("/salas/"+idSala);
        } else {
            http.sendRedirect("/salas/"+repository.findByTituloContainingIgnoreCase(titulo).get(0).getId());
        }
    }

    public boolean verificarExistencia (String curso,String titulo){
        return !repository.findByCursoAllIgnoreCase(curso).isEmpty()&&!repository.findByTituloContainingIgnoreCase(titulo).isEmpty() ;
    }

}
