package br.com.projeto.GestaoUniversitario.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.GestaoUniversitario.model.Cursos;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Cacheable("cursoRepository")
public interface CursosRepository extends PagingAndSortingRepository<Cursos,Integer>, JpaSpecificationExecutor<Cursos> {
    List<Cursos> findByNomeAllIgnoreCase(String nome);

    List<Cursos> findAll();

}
