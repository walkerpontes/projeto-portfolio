package br.com.projeto.GestaoUniversitario.repository;


import br.com.projeto.GestaoUniversitario.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UsuarioRepository extends PagingAndSortingRepository<Usuario,Integer>, JpaSpecificationExecutor<Usuario> {
    @Modifying
    @Query(value = "update usuario u SET u.curso_id = :curso WHERE u.id = :id",nativeQuery = true)
    void cadastroCurso(Integer curso, Integer id );

    @Modifying
    @Query(value = "update usuario u SET u.forum_id = :forum u.id = :id",nativeQuery = true)
    void cadastroForum(Integer forum, Integer id );

    @Modifying
    @Query(value = "update usuario u SET u.salas_id = :forum WHERE u.id = :id",nativeQuery = true)
    void cadastroSalas(Integer forum, Integer id );

//    @Modifying
//    @Query(value = "UPDATE usuario u SET u.forum.getRespostaForum.setResposta = :resposta WHERE u.id = :id AND u.forum_id = :forum")
//    void responderForum(String resposta,Integer id,Integer forum);


}
