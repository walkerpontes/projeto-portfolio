package br.com.projeto.GestaoUniversitario.controller;

import br.com.projeto.GestaoUniversitario.model.Cursos;
import br.com.projeto.GestaoUniversitario.repository.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@Controller
@Transactional
public class CursoController {
    @Autowired
    CursosRepository repository;

    @RequestMapping("/cursos")
    public String cursos(Model model){
        List<Cursos> cursos = repository.findAll();
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
    @GetMapping("/cursos/cadastrar")
    public String cadastro(){
        return "cursoCadastro";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/cursos/cadastro")
    public String cadastrar(Model model, @RequestParam String nome, @RequestParam String titulo){
        Cursos novo = new Cursos(nome,titulo);
        repository.save(novo);
        return "redirect: ";
    }
    @RequestMapping("/cursos/search")
    public String search(Model model, @RequestParam String buscar){
        List<Cursos> listCursos = repository.findByNomeAllIgnoreCase(buscar);
        model.addAttribute("cursos",listCursos);
        return "cursos";
    }
}
