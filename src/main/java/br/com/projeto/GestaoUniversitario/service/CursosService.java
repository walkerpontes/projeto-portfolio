package br.com.projeto.GestaoUniversitario.service;

import br.com.projeto.GestaoUniversitario.modelo.Cursos;
import br.com.projeto.GestaoUniversitario.modelo.Salas;
import br.com.projeto.GestaoUniversitario.repository.CursosRepository;
import br.com.projeto.GestaoUniversitario.repository.SalasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class CursosService {
    private Cursos cursos;
    private Boolean system = true;

    private final CursosRepository repository;
    public CursosService(CursosRepository repository){this.repository = repository;}

    public void iniciar(Scanner scanner){
        while(system){
            System.out.println("Curso");
            System.out.println("O que deseja fazer na Área do Curso" +
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
        System.out.println("Coloque o nome");
        String curso = scanner.next();
        System.out.println("Coloque o titulo");
        String titulo = scanner.next();

        Cursos criarCurso = new Cursos();
        criarCurso.setNome(curso);
        criarCurso.setTitulo(titulo);
        repository.save(criarCurso);
    }

    private void atualizar(Scanner scanner){

        System.out.println("Atualizar Curso");
        System.out.println("Digite o id");
        int id = scanner.nextInt();
        System.out.println("digite o novo curso");
        String curso = scanner.next();
        System.out.println("digite o novo titulo");
        String titulo = scanner.next();

        Cursos cursos = new Cursos();
        cursos.setId(id);
        cursos.setNome(curso);
        cursos.setTitulo(titulo);

        repository.save(cursos);
        System.out.println("Alterado");




    }

    private void procurar(Scanner scanner){
        System.out.println("coloque o curso");
        String curso = scanner.next();
        List<Cursos> procura = repository.findByNome(curso);
        procura.forEach(System.out::println);
    }

    private void deletar(Scanner scanner){
        System.out.println("Qual é o id do Curso");
        int id = scanner.nextInt();
        repository.deleteById(id);
        System.out.println("deletado");
    }
}
