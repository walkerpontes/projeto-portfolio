package br.com.projeto.GestaoUniversitario.controller;

import br.com.projeto.GestaoUniversitario.model.Usuario;
import br.com.projeto.GestaoUniversitario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Seed {
    @Autowired
    private UsuarioRepository repository;
    @RequestMapping("/seed")
    public String seed(){

        Usuario user = new Usuario("fulano@email","fulano");
        Usuario user2 = new Usuario("beltrano@email","beltrano");
        Usuario user3 = new Usuario("ciclano@email","ciclano");
        Usuario user4 = new Usuario("walker@email","walker");

        repository.save(user);
        repository.save(user2);
        repository.save(user3);
        repository.save(user4);
        return "redirect:login";
    }

}
