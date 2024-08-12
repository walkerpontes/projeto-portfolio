package br.com.projeto.GestaoUniversitario.controller;

import br.com.projeto.GestaoUniversitario.model.*;
import br.com.projeto.GestaoUniversitario.repository.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class Seed {


    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private CursosRepository cursosRepository;
    @Autowired
    private SalasRepository salasRepository;
    @Autowired
    private ForumRepository forumRepository;


    @RequestMapping("/seed")
    public String seed() {

        if (repository.findByEmailAllIgnoreCase("walker@email").isEmpty()) {

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            // CRIAÇÃO DOS USUARIOS e PERMISSÕES
            Usuario user = new Usuario("fulano@email", encoder.encode("fulano"));
            Usuario user2 = new Usuario("beltrano@email", encoder.encode("beltrano"));
            Usuario user3 = new Usuario("ciclano@email", encoder.encode("ciclano"));
            Usuario user4 = new Usuario("walker@email", encoder.encode("walker"));
            user.setNome("Fulano");
            user2.setNome("Beltrano");
            user3.setNome("Ciclano");
            user4.setNome("Walker");

            repository.save(user);
            repository.save(user2);
            repository.save(user3);
            repository.save(user4);


            Role visitante = new Role(RoleType.ROLE_VISITANTE);
            Role usuario = new Role(RoleType.ROLE_USUARIO);
            Role admin = new Role(RoleType.ROLE_ADMIN);

            roleRepository.save(visitante);
            roleRepository.save(usuario);
            roleRepository.save(admin);

            repository.usuarioRoleVisitante(repository.findByEmailAllIgnoreCase("fulano@email").get().getId());
            repository.usuarioRoleVisitante(repository.findByEmailAllIgnoreCase("beltrano@email").get().getId());
            repository.usuarioRoleUser(repository.findByEmailAllIgnoreCase("ciclano@email").get().getId());
            repository.usuarioRoleAdmin(repository.findByEmailAllIgnoreCase("walker@email").get().getId());


            // CRIAÇÃO DE CURSOS
            Cursos cursos = new Cursos("Java", "Java para iniciante");
            Cursos cursos1 = new Cursos("Php", "Php para iniciante");
            Cursos cursos2 = new Cursos("Pyton", "Pyton para iniciante");
            Cursos cursos3 = new Cursos("C", "C para iniciante");
            Cursos cursos4 = new Cursos("Node.js", "Node.js para iniciante");
            Cursos cursos5 = new Cursos("JavaScript", "JavaSript para iniciante");
            Cursos cursos6 = new Cursos("Go", "Go para iniciante");
            Cursos cursos7 = new Cursos("Html", "Html para iniciante");
            Cursos cursos8 = new Cursos("Css", "Css para iniciante");
            Cursos cursos9 = new Cursos("Sql", "Sql para iniciante");


            cursosRepository.save(cursos);
            cursosRepository.save(cursos1);
            cursosRepository.save(cursos2);
            cursosRepository.save(cursos3);
            cursosRepository.save(cursos4);
            cursosRepository.save(cursos5);
            cursosRepository.save(cursos6);
            cursosRepository.save(cursos7);
            cursosRepository.save(cursos8);
            cursosRepository.save(cursos9);

            //CRIAÇÃO DE SALAS

            Salas salas = new Salas("Java", "Java para iniciante");
            Salas salas1 = new Salas("Php", "Php para iniciante");
            Salas salas2 = new Salas("Pyton", "Pyton para iniciante");
            Salas salas3 = new Salas("C", "C para iniciante");
            Salas salas4 = new Salas("Node.js", "Node.js para iniciante");
            Salas salas5 = new Salas("JavaScript", "JavaSript para iniciante");
            Salas salas6 = new Salas("Go", "Go para iniciante");
            Salas salas7 = new Salas("Html", "Html para iniciante");
            Salas salas8 = new Salas("Css", "Css para iniciante");
            Salas salas9 = new Salas("Sql", "Sql para inicianSalas");

            salasRepository.save(salas);
            salasRepository.save(salas1);
            salasRepository.save(salas2);
            salasRepository.save(salas3);
            salasRepository.save(salas4);
            salasRepository.save(salas5);
            salasRepository.save(salas6);
            salasRepository.save(salas7);
            salasRepository.save(salas8);
            salasRepository.save(salas9);

            // ASSOCIAR AS SALAS COM O USUARIO DEFAULT
            Optional<Usuario> padrao = repository.findByEmailAllIgnoreCase("walker@email");
            salasRepository.findAll().forEach(sala -> salasRepository.cadastrarCurso(padrao.isEmpty()? 1: padrao.get().getId(),sala.getId()));

            //CRIAÇÃO DOS FORUNS


            Forum forum = new Forum("Java é bom?", "Java para iniciante");
            Forum forum1 = new Forum("Php é bom?", "Php para iniciante");
            Forum forum2 = new Forum("Pyton é bom?", "Pyton para iniciante");
            Forum forum3 = new Forum("C é bom?", "C para iniciante");
            Forum forum4 = new Forum("Node.js é bom?", "Node.js para iniciante");
            Forum forum5 = new Forum("JavaScript é bom?", "JavaSript para iniciante");
            Forum forum6 = new Forum("Go é bom?", "Go para iniciante");
            Forum forum7 = new Forum("Html é bom?", "Html para iniciante");
            Forum forum8 = new Forum("Css é bom?", "Css para iniciante");
            Forum forum9 = new Forum("Sql é bom?", "Sql para inicianSalas");


            forumRepository.save(forum);
            forumRepository.save(forum1);
            forumRepository.save(forum2);
            forumRepository.save(forum3);
            forumRepository.save(forum4);
            forumRepository.save(forum5);
            forumRepository.save(forum6);
            forumRepository.save(forum7);
            forumRepository.save(forum8);
            forumRepository.save(forum9);





        } else {
            System.out.println("Banco de dados já foi populado");
        }

        return "redirect:login";
    }
}