package br.com.projeto.GestaoUniversitario;

//import br.com.projeto.GestaoUniversitario.modelo.Forum;
//import br.com.projeto.GestaoUniversitario.modelo.RespostaForum;
import br.com.projeto.GestaoUniversitario.service.*;
//import br.com.projeto.GestaoUniversitario.service.ForumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Scanner;

@EnableJpaRepositories
@SpringBootApplication
public class GestaoUniversitarioApplication implements CommandLineRunner {

	private Boolean system = true;

	private final CursosService cursosService;
	@Autowired
	private final UsuarioService usuarioService;
	private final SalasService salasService;
	private final CadastrosService cadastros;
	private final ForumService forumService;


	public GestaoUniversitarioApplication(CursosService cursosService, UsuarioService usuarioService,
										  SalasService salasService, CadastrosService cadastros,ForumService forumService){
		this.cadastros = cadastros;
		this.cursosService = cursosService;
		this.usuarioService = usuarioService;
		this.forumService = forumService;
		this.salasService = salasService;
	}

	public static void main(String[] args) {
		SpringApplication.run(GestaoUniversitarioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while(system){
			System.out.println("O que deseja acessar" +
					"\n0 - Sair" +
					"\n1 - Login" +
					"\n2 - Salas" +
					"\n3 - Forum" +
					"\n4 - Cursos" +
					"\n5 - Cadastros");
			int menu = scanner.nextInt();
			switch (menu){
				case 1:usuarioService.iniciar(scanner);break;
				case 2:salasService.iniciar(scanner);break;
				case 3:/*forumService.iniciar(scanner)*/;break;
				case 4:cursosService.iniciar(scanner);break;
				case 5:cadastros.iniciar(scanner);
				default:system = false;
			}

		}

	}
}