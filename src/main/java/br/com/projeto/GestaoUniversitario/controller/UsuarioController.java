package br.com.projeto.GestaoUniversitario.controller;

import br.com.projeto.GestaoUniversitario.model.Role;
import br.com.projeto.GestaoUniversitario.model.Usuario;
import br.com.projeto.GestaoUniversitario.repository.UsuarioRepository;
import org.hibernate.LazyInitializationException;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@Transactional
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    /*---------Sistema de Login------------*/

    @RequestMapping("/")
    public String index(){
        return "home";
    }

    @RequestMapping ("/login")
    public String login (){
        return "login";
    }


    @RequestMapping("/login-erro")
    public String erroLogin(Model model){
        model.addAttribute("erro", true);
        return "login";
    }

    /*---------Sistema de Cadastro------------*/

    private Usuario user;

    @RequestMapping("/cadastro")
    public String cadastro(){
        return "cadastro";
    }

    @PostMapping("/cadastrar")
    public String Cadastrar(Usuario usuario){
        user = new Usuario(usuario.getEmail(),usuario.getSenha());
        user.setNome(usuario.getNome());
        System.out.println(user.getNome());
        System.out.println(user.getEmail());
        System.out.println(user.getSenha());
        repository.save(user);
        Optional<Usuario> visitante = repository.findByEmailAllIgnoreCase(user.getEmail());
        repository.usuarioRoleVisitante(visitante.get().getId());
        return "redirect:home";
    }

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    /*---------Sistema de Admin------------*/


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }


    @RequestMapping("/perfil")
    @LazyCollection(value = LazyCollectionOption.FALSE)
    public String perfil(Model model) throws LazyInitializationException{
        Usuario usuario = new Usuario();
        String email = usuario.logado();
        if (email.equals("anonymousUser")){
            model.addAttribute("noLogado",true);
        }else {
            Optional<Usuario> user = repository.findByEmailAllIgnoreCase(email);
            Usuario logado = user.get();
            model.addAttribute("inLogado",true);
            model.addAttribute("logado", logado);
            model.addAttribute("mensagemSize",logado.getMensagem().size());
            model.addAttribute("forumSize",logado.getForum().size());
            model.addAttribute("respostaSize",logado.getRespostas().size());
            model.addAttribute("cursosSize",logado.getCursos().size());
        }
        return "perfil";
    }
}
