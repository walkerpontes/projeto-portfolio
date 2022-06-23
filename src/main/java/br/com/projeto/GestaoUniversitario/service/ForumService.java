package br.com.projeto.GestaoUniversitario.service;

import br.com.projeto.GestaoUniversitario.modelo.Forum;
import br.com.projeto.GestaoUniversitario.repository.ForumRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Scanner;

@Service
public class ForumService {
    private Forum forum;
    private Boolean system = true;

    private final ForumRepository repository;
    public ForumService(ForumRepository repository){this.repository = repository;}

    public void iniciar(Scanner scanner){
        while(system){
            System.out.println("Forum");
            System.out.println("O que deseja fazer na Área do Forum" +
                    "\n0 - Sair" +
                    "\n1 - Criar" +
                    "\n2 - Atualizar" +
                    "\n3 - Procurar" +
                    "\n4 - Remover");
            int menu = scanner.nextInt();
            switch (menu){
                case 1: criar(scanner);break;
                case 2: atualizar(scanner);break;
                case 3: procurar(scanner);break;
                case 4: deletar(scanner);break;
                default:
                    system = false;
                    break;
            }
        }
    }


    private void criar(Scanner scanner){
        System.out.println("Coloque o curso");
        String pergunta = scanner.next();
        System.out.println("Coloque o titulo");
        String tema = scanner.next();

        Forum criarForum = new Forum();
        criarForum.setPergunta(pergunta);
        criarForum.setTema(tema);
        repository.save(criarForum);
    }

    private void atualizar(Scanner scanner){

        System.out.println("Atualizar Forum");
        System.out.println("Digite o id");
        int id = scanner.nextInt();
        System.out.println("digite a nova pergunta");
        String pergunta = scanner.next();
        System.out.println("digite o novo tema");
        String tema = scanner.next();

        Forum forum = new Forum();
        forum.setId(id);
        forum.setPergunta(pergunta);
        forum.setTema(tema);

        repository.save(forum);
        System.out.println("Alterado");




    }

    private void procurar(Scanner scanner){
        System.out.println("coloque o tema");
        String tema = scanner.next();
        List<Forum> procura = repository.findByTema(tema);
        procura.forEach(System.out::println);
    }

    private void deletar(Scanner scanner){
        System.out.println("Qual é o id do Forum");
        int id = scanner.nextInt();
        repository.deleteById(id);
        System.out.println("deletado");
    }
}
