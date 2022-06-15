package br.com.projeto.GestaoUniversitario.repository;

import br.com.projeto.GestaoUniversitario.modelo.Cursos;
import br.com.projeto.GestaoUniversitario.modelo.Salas;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursosRepository extends PagingAndSortingRepository<Cursos,Integer>, JpaSpecificationExecutor<Cursos> {
    List<Cursos> findByNome(String nome);
}
