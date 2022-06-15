package br.com.projeto.GestaoUniversitario.service;

import br.com.projeto.GestaoUniversitario.modelo.Salas;
import br.com.projeto.GestaoUniversitario.modelo.Usuario;
import br.com.projeto.GestaoUniversitario.repository.SalasRepository;
import br.com.projeto.GestaoUniversitario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class SalasService {
    private Salas salas;
    private Boolean system = true;

    private final SalasRepository repository;
    public SalasService(SalasRepository repository){this.repository = repository;}

    public void iniciar(Scanner scanner){
        while(system){
            System.out.println("Sala");
            System.out.println("O que deseja fazer na Área da Sala" +
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
        String curso = scanner.next();
        System.out.println("Coloque o titulo");
        String titulo = scanner.next();

        Salas criarSala = new Salas();
        criarSala.setCurso(curso);
        criarSala.setTitulo(titulo);
        repository.save(criarSala);
    }

    private void atualizar(Scanner scanner){

        System.out.println("Atualizar Sala");
        System.out.println("Digite o id");
        int id = scanner.nextInt();
        System.out.println("digite o novo curso");
        String curso = scanner.next();
        System.out.println("digite o novo titulo");
        String titulo = scanner.next();

        Salas salas = new Salas();
        salas.setId(id);
        salas.setCurso(curso);
        salas.setTitulo(titulo);

        repository.save(salas);
        System.out.println("Alterado");




    }

    private void procurar(Scanner scanner){
        System.out.println("coloque o curso");
        String curso = scanner.next();
        List<Salas> procura = repository.findByCurso(curso);
        procura.forEach(System.out::println);
    }

    private void deletar(Scanner scanner){
        System.out.println("Qual é o id da Sala");
        int id = scanner.nextInt();
        repository.deleteById(id);
        System.out.println("deletado");
    }
}
