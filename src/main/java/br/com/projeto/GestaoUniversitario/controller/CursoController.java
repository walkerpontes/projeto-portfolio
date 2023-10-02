package br.com.projeto.GestaoUniversitario.controller;

import br.com.projeto.GestaoUniversitario.model.Cursos;
import br.com.projeto.GestaoUniversitario.model.Usuario;
import br.com.projeto.GestaoUniversitario.repository.CursosRepository;
import br.com.projeto.GestaoUniversitario.repository.UsuarioRepository;
import io.micrometer.core.ipc.http.HttpSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Pageable;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.http.HttpRequest;
import java.security.KeyRep;
import java.util.*;
import java.util.stream.Collectors;


@Controller
@Transactional
public class CursoController {
    @Autowired
    CursosRepository repository;

    @Autowired
    UsuarioRepository userRepository;

    @GetMapping("/cursos")
    public String cursos (Model model, @RequestParam(value = "pagina",required = false,defaultValue = "0") int pagina){
        PageRequest paginacao = PageRequest.of(pagina==0?0:pagina-1,8, Sort.Direction.ASC,"nome");
        Page<Cursos> cursosPagina = repository.findAll(paginacao);
        int totalPaginas = cursosPagina.getTotalPages();
        List<Cursos> cursos = cursosPagina.get().collect(Collectors.toList());
        model.addAttribute("total",totalPaginas);
        model.addAttribute("cursos",cursos);
        return "cursos";
    }


    @RequestMapping("/cursos/{id}")
    public String entrarCurso(Model model, @PathVariable Integer id){
        Optional<Cursos> curso = repository.findById(id);
        Cursos padrao = curso.get();
        model.addAttribute("padrao",padrao);
        return "padraoCurso";
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/cursos/admin/cadastrar")
    public String cadastro(){
        return "cursosCadastro";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/cursos/admin/new")
    public void cadastrar(HttpServletResponse response, @RequestParam String nome, @RequestParam String titulo) throws IOException {
        Cursos novo = new Cursos(nome, titulo);
        repository.save(novo);
        List<Cursos> cursoAll = repository.findAll();
        List<Cursos> curso = cursoAll.stream().filter(cursos -> cursos.getNome() == nome && cursos.getTitulo() == titulo).collect(Collectors.toList());
        Usuario user = new Usuario();
        Optional<Usuario> idUser = userRepository.findByEmailAllIgnoreCase(user.logado());
        repository.cadastrarCursoUsuario(idUser.get().getId(),curso.get(0).getId());
        response.sendRedirect("/cursos/"+ curso.get(0).getId());
    }

    @RequestMapping("/cursos/search")
    public String search(Model model, @RequestParam(required = false,name = "buscar") String buscar){
        List<Cursos> listCursos = repository.findByNomeAllIgnoreCase(buscar);
        model.addAttribute("cursos",listCursos);
        return "cursos";
    }
}
