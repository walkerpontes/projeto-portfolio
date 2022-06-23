package br.com.projeto.GestaoUniversitario.service;

import br.com.projeto.GestaoUniversitario.modelo.Cursos;
//import br.com.projeto.GestaoUniversitario.modelo.Forum;
import br.com.projeto.GestaoUniversitario.modelo.Salas;
import br.com.projeto.GestaoUniversitario.modelo.Usuario;
import br.com.projeto.GestaoUniversitario.repository.CursosRepository;
//import br.com.projeto.GestaoUniversitario.repository.ForumRepository;
import br.com.projeto.GestaoUniversitario.repository.SalasRepository;
import br.com.projeto.GestaoUniversitario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CadastrosService {
    private CursosRepository cursosRepository;
//    private ForumRepository forumRepository;
    private UsuarioRepository usuarioRepository;
    private SalasRepository salasRepository;
    private Usuario usuario;
//    private Forum forum;
    private Salas salas;
    private Cursos cursos;
    private Boolean system = true;


    public CadastrosService(CursosRepository cursosRepository, UsuarioRepository usuarioRepository, SalasRepository salasRepository){
        this.cursosRepository = cursosRepository;
//        this.forumRepository = forumRepository;
        this.usuarioRepository = usuarioRepository;
        this.salasRepository = salasRepository;

    }
    public void iniciar(Scanner scanner){
        while(system){
            System.out.println("Login");
            System.out.println("O que deseja fazer na Área de Cadastro" +
                    "\n0 - Sair" +
                    "\n1 - Cadastrar em um forum" +
                    "\n2 - Cadastrar em um curso" +
                    "\n3 - Cadastrar em uma sala");

            int menu = scanner.nextInt();
            switch (menu){
                case 1: cadastroUsuarioForum(scanner);break;
                case 2: cadastroUsuarioCurso(scanner);break;
                case 3: cadastroUsuarioSalas(scanner);break;
                default:
                    system = false;
                    break;
            }
        }
    }


   private void cadastroUsuarioCurso(Scanner scanner){
        System.out.println("Qual é o seu id");
        int id = scanner.nextInt();
        System.out.println("Qual é o id do curso");
        int idCurso = scanner.nextInt();

        usuarioRepository.cadastroCurso(idCurso,id);
    }

   private void cadastroUsuarioForum(Scanner scanner){
        System.out.println("Qual é o seu id");
        int id = scanner.nextInt();
        System.out.println("Qual é o id do forum");
        int idForum = scanner.nextInt();
        usuarioRepository.cadastroForum(idForum,id);

    }


    void cadastroUsuarioSalas(Scanner scanner){
        System.out.println("Qual é o seu id");
        int id = scanner.nextInt();
        System.out.println("Qual é o id da Sala");
        int idSalas = scanner.nextInt();

        usuarioRepository.cadastroSalas(idSalas,id);
    }

//    void responderPergunta(Scanner scanner){
//        System.out.println("Qual é o seu id");
//        int id = scanner.nextInt();
//        System.out.println("Qual é o id do Forum");
//        int idForum = scanner.nextInt();
//        System.out.println("Qual a sua resposta");
//        String resposta = scanner.next();
//
//        usuarioRepository.responderForum(resposta,id,idForum);
//    }


}
