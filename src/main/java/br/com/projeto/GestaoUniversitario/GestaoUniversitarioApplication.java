package br.com.projeto.GestaoUniversitario;

import br.com.projeto.GestaoUniversitario.repository.CursosRepository;
import br.com.projeto.GestaoUniversitario.repository.SalasRepository;
import br.com.projeto.GestaoUniversitario.repository.UsuarioRepository;
import br.com.projeto.GestaoUniversitario.service.CursosService;
import br.com.projeto.GestaoUniversitario.service.ForumService;
import br.com.projeto.GestaoUniversitario.service.SalasService;
import br.com.projeto.GestaoUniversitario.service.UsuarioService;
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
	private final ForumService forumService;


	public GestaoUniversitarioApplication(CursosService cursosService,UsuarioService usuarioService,
										  SalasService salasService,ForumService forumService){
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
					"\n4 - Cursos");
			int menu = scanner.nextInt();
			switch (menu){
				case 1:usuarioService.iniciar(scanner);break;
				case 2:salasService.iniciar(scanner);break;
				case 3:forumService.iniciar(scanner);break;
				case 4:cursosService.iniciar(scanner);break;
				default:system = false;break;
			}
		}
	}
}