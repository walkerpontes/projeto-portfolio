package br.com.projeto.GestaoUniversitario;

import br.com.projeto.GestaoUniversitario.repository.CursosRepository;
import br.com.projeto.GestaoUniversitario.repository.SalasRepository;
import br.com.projeto.GestaoUniversitario.repository.UsuarioRepository;
import br.com.projeto.GestaoUniversitario.service.CursosService;
import br.com.projeto.GestaoUniversitario.service.ForumService;
import br.com.projeto.GestaoUniversitario.service.SalasService;
import br.com.projeto.GestaoUniversitario.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class GestaoUniversitarioApplication implements CommandLineRunner {

	private final CursosService cursosService;
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

	}
}
