package br.com.projeto.GestaoUniversitario.repository;

import br.com.projeto.GestaoUniversitario.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Integer> {
}
