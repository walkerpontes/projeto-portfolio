package br.com.projeto.GestaoUniversitario.repository;

import br.com.projeto.GestaoUniversitario.model.Forum;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Cacheable("forumRepository")
@Transactional
public interface ForumRepository extends PagingAndSortingRepository<Forum,Integer>, JpaSpecificationExecutor<Forum> {
    List<Forum> findByRespostas_IdAllIgnoreCase(Integer id);
    List<Forum> findByTemaAllIgnoreCase(String tema);

    @Modifying
    @Query(value = "INSERT INTO resposta (resposta,forum_id,usuario_id) VALUES (?,?,?)",nativeQuery = true )
    void cadastrarResposta(@Param("resposta") String resposta, @Param("idForum") int idForum,@Param("idUser") int idUser);

    List<Forum> findByPerguntaContainingIgnoreCase(String pergunta);
}
