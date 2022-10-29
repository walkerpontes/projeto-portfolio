package br.com.projeto.GestaoUniversitario.controller;

import br.com.projeto.GestaoUniversitario.model.Forum;
import br.com.projeto.GestaoUniversitario.model.RespostaForum;
import br.com.projeto.GestaoUniversitario.model.Usuario;
import br.com.projeto.GestaoUniversitario.repository.ForumRepository;

import br.com.projeto.GestaoUniversitario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    @GetMapping("/forum")
    public String forum(Model model){
        maisRespondidas(model);

        naoRespondidas(model);

        return "forum";
    }

    public void maisRespondidas(Model model){
        List<Forum> todos = (List<Forum>) repository.findAll();
        todos.sort((forum1, forum2) -> {
            return forum2.getRespostas().size() - forum1.getRespostas().size();
        });

        List<Forum> maisAcessados = todos.stream().limit(5).collect(Collectors.toList());

        model.addAttribute("maisAcessado", maisAcessados);
    }
    public void naoRespondidas(Model model){
        List<Forum> lista = (List<Forum>) repository.findAll();
        List<Forum> semRespostas = new ArrayList<>();
        for (Forum forum: lista){

            if (forum.getRespostas().size()==0){
                semRespostas.add(forum);
            }
        }
        model.addAttribute("semResposta", semRespostas);
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

    @GetMapping("/forum/responder")
    public void responder(Model model, HttpServletResponse http, @RequestParam String resposta, @RequestParam int id) throws IOException {
        Usuario user = new Usuario();
        Optional<Usuario> email = userRepository.findByEmailAllIgnoreCase(user.logado());
        Usuario usuario = email.get();
        repository.cadastrarResposta(resposta,id,usuario.getId());
        http.sendRedirect("/forum/"+id);
    }
}
