package br.com.projeto.GestaoUniversitario.controller;

import br.com.projeto.GestaoUniversitario.model.Forum;
import br.com.projeto.GestaoUniversitario.model.RespostaForum;
import br.com.projeto.GestaoUniversitario.model.Usuario;
import br.com.projeto.GestaoUniversitario.repository.ForumRepository;

import br.com.projeto.GestaoUniversitario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@Transactional
public class ForumController {

    @Autowired
    private ForumRepository repository;

    @Autowired
    private UsuarioRepository userRepository;

    @RequestMapping("/forum")
    public String forum(Model model,HttpServletRequest request,@RequestParam(value = "pagina",required = false,defaultValue = "0")int pagina){
        PageRequest paginas = PageRequest.of(pagina==0?0:pagina-1,10, Sort.Direction.DESC,"pergunta");
        Page<Forum> totalPaginas = repository.findAll(paginas);
        model.addAttribute("total",totalPaginas.getTotalPages());
        if (pagina==0){
            maisRespondidas(model);
            naoRespondidas(model);
            return "forum";
        }else {
            List<Forum> lista = totalPaginas.get().collect(Collectors.toList());
            model.addAttribute("lista",lista);
            return "searchForum";
        }

    }

    public void maisRespondidas(Model model){
        List<Forum> todos = (List<Forum>) repository.findAll();
        todos.sort((forum1, forum2) -> forum2.getRespostas().size() - forum1.getRespostas().size());
        List<Forum> maisAcessados = todos.stream().limit(5).collect(Collectors.toList());
        model.addAttribute("maisAcessado", maisAcessados);
    }
    public void naoRespondidas(Model model){
        List<Forum> listaAll = (List<Forum>) repository.findAll();
        List<Forum> lista = listaAll.stream().filter(forum -> forum.getRespostas().size() == 0).limit(5).collect(Collectors.toList());
        model.addAttribute("semResposta", lista);
    }


    @RequestMapping("/forum/search")
    public String searchByTema(@RequestParam String buscar,Model model){
        List<Forum> lista = repository.findByTemaContainsIgnoreCase(buscar);
        model.addAttribute("lista",lista);
        return "searchForum";
    }
    @RequestMapping("/forum/{id}")
    public String padraoForum(Model model,@PathVariable int id){
        Optional<Forum> pergunta = repository.findById(id);
        Forum forum= pergunta.get();
        List<RespostaForum> respostas = forum.getRespostas();
        model.addAttribute("forum",forum);
        model.addAttribute("respostas",respostas);
        return "padraoForum";
    }
    @PreAuthorize("hasRole('USUARIO')")
    @GetMapping("/forum/responder")
    public void responder(Model model, HttpServletResponse http, @RequestParam String resposta, @RequestParam int id) throws IOException {
        Usuario user = new Usuario();
        Optional<Usuario> email = userRepository.findByEmailAllIgnoreCase(user.logado());
        Usuario usuario = email.get();
        repository.cadastrarResposta(resposta,id,usuario.getId());
        http.sendRedirect("/forum/"+id);
    }
    @PreAuthorize("hasRole('USUARIO')")
    @GetMapping("/forum/new")
    public void criarNovoForum(HttpServletResponse http,@RequestParam String tema,@RequestParam String pergunta) throws IOException, InterruptedException {
        List<Forum> forum = repository.findByPerguntaContainingIgnoreCase(pergunta);
        Usuario user = new Usuario();
        Optional<Usuario> usuario = userRepository.findByEmailAllIgnoreCase(user.logado());
        if (!forumExistente(pergunta,tema)){
            Forum novoForum = new Forum(pergunta,tema);
            repository.save(novoForum);
            repository.cadastrarForum(usuario.get().getId(),idForum(pergunta));
           http.sendRedirect("/forum/"+idForum(pergunta));
        }else {
            http.sendRedirect("/forum/"+idForum(pergunta));
        }
    }
    public Integer idForum(String pergunta){
        return repository.findByPerguntaContainingIgnoreCase(pergunta).get(0).getId();
    }

    public boolean forumExistente(String pergunta,String tema){
        return !repository.findByPerguntaContainingIgnoreCase(pergunta).isEmpty() &&
                !repository.findByTemaContainsIgnoreCase(tema).isEmpty();
    }


    @PreAuthorize("hasRole('USUARIO')")
    @RequestMapping("/forum/cadastrar")
    public String criar(){
        return "forumCadastro";
    }

}
