package br.com.projeto.GestaoUniversitario.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.projeto.GestaoUniversitario.model.Cursos;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CursosRepository extends PagingAndSortingRepository<Cursos,Integer>, JpaSpecificationExecutor<Cursos> {
    List<Cursos> findByNomeAllIgnoreCase(String nome);
    List<Cursos> findByTituloAllIgnoreCase(String titulo);


    List<Cursos> findAll();
    @Modifying
    @Query(value = "INSERT INTO usuario_cursos (usuario_id,cursos_id) VALUES (?,?)",nativeQuery = true)
    void cadastrarCursoUsuario(@Param("idUser") int idUser, @Param("idCurso") int idCursos);
}
