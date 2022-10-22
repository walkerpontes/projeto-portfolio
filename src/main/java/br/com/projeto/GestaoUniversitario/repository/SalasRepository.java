package br.com.projeto.GestaoUniversitario.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.projeto.GestaoUniversitario.model.Salas;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface SalasRepository extends PagingAndSortingRepository<Salas,Integer>, JpaSpecificationExecutor<Salas> {

    List <Salas> findByCursoAllIgnoreCase(String curso);
    List<Salas> findAll();

    Optional<Salas> findByIdAllIgnoreCase(Integer id);


    @Modifying
    @Query(value = "INSERT INTO mensagem(mensagem,salas_id,usuario_id) VALUES (?,?,?)",nativeQuery = true)
    void saveByMensagemAllIgnoreCase(@Param("mensagem") String mensagem, @Param("idSala") int idSala, @Param("idUser")int id);

    List<Salas> findByTituloContainingIgnoreCase(String titulo);
}
