package br.com.projeto.GestaoUniversitario.service;

import br.com.projeto.GestaoUniversitario.modelo.Usuario;
import br.com.projeto.GestaoUniversitario.repository.CursosRepository;
import br.com.projeto.GestaoUniversitario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class UsuarioService {
    private Usuario usuario;
    private Boolean system = true;
    private CadastrosService cadastros;

    private final UsuarioRepository repository;
    private final CursosRepository cursosRepository;
    public UsuarioService(UsuarioRepository repository,CursosRepository cursosRepository){
        this.repository = repository;
        this.cursosRepository = cursosRepository;
    }

    public void iniciar(Scanner scanner){
        while(system){
            System.out.println("Login");
            System.out.println("O que deseja fazer na Área de login" +
                    "\n0 - Sair" +
                    "\n1 - Atualizar" +
                    "\n2 - Cadastrar em um curso" +
                    "\n3 - Cadastrar em uma sala" +
                    "\n4 - Responder" +
                    "\n5 - Remover conta");
            int menu = scanner.nextInt();
            switch (menu){
                case 1: atualizar(scanner);break;
                case 2:;break;
                case 3:;break;
                case 4: break;
                case 5: deletar(scanner);break;
                default:
                    system = false;
                    break;
            }
        }
    }


    private void login(Scanner scanner){
        System.out.println("Coloque o nome");
        String nome = scanner.next();
        System.out.println("Coloque o email");
        String email = scanner.next();
        System.out.println("Coloque o senha");
        String senha = scanner.next();

        Usuario usuarioLogin = new Usuario();
        usuarioLogin.setNome(nome);
        usuarioLogin.setEmail(email);
        usuarioLogin.setSenha(senha);
        repository.save(usuarioLogin);
    }

    private void atualizar(Scanner scanner){

        System.out.println("Atualizar login");
                    System.out.println("Digite o id");
                    int id = scanner.nextInt();
                    System.out.println("digite o novo nome");
                    String nome = scanner.next();
                    System.out.println("digite o novo email");
                    String email = scanner.next();
                    System.out.println("digite a nova senha");
                    String senha = scanner.next();

                    Usuario usuario = new Usuario();
                    usuario.setId(id);
                    usuario.setNome(nome);
                    usuario.setEmail(email);
                    usuario.setSenha(senha);
                    repository.save(usuario);
                    System.out.println("Alterado");




    }


    private void deletar(Scanner scanner){
        System.out.println("Qual é o seu id");
        int id = scanner.nextInt();
        repository.deleteById(id);
        System.out.println("deletado");
    }


}
