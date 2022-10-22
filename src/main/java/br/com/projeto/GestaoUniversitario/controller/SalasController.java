package br.com.projeto.GestaoUniversitario.controller;

import br.com.projeto.GestaoUniversitario.model.Mensagem;
import br.com.projeto.GestaoUniversitario.model.Salas;
import br.com.projeto.GestaoUniversitario.model.Usuario;
import br.com.projeto.GestaoUniversitario.repository.SalasRepository;
import br.com.projeto.GestaoUniversitario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@Transactional
public class SalasController {
    @Autowired
    SalasRepository repository;
    @Autowired
    UsuarioRepository repositoryUser;

    @GetMapping("/salas")
    public String sala(Model model){
        List<Salas> listaSalas = repository.findAll();

        model.addAttribute("listaSala",listaSalas);
        return "sala";
    }
    @PreAuthorize(value = "hasRole('ROLE_USUARIO')")
    @RequestMapping("/salas/{id}")
    public String salamensagem(Model model,@PathVariable int id){
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
        model.addAttribute("mensagem",textos);
        model.addAttribute("sala",sala);
    }
    @RequestMapping("/salas/search")
    public String searchSala(Model model,@RequestParam String buscar){
        List<Salas> listaSala = repository.findByTituloContainingIgnoreCase(buscar);
        model.addAttribute("listaSala",listaSala);
        return "sala";
    }
}
