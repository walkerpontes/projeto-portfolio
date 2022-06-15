package br.com.projeto.GestaoUniversitario.repository;
import br.com.projeto.GestaoUniversitario.modelo.Salas;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalasRepository extends PagingAndSortingRepository<Salas,Integer>, JpaSpecificationExecutor<Salas> {

    List <Salas> findByCurso(String curso);
}
