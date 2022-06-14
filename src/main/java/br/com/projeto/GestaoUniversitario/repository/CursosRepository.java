package br.com.projeto.GestaoUniversitario.repository;

import br.com.projeto.GestaoUniversitario.modelo.Cursos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursosRepository extends CrudRepository<Cursos,Integer> {
}
