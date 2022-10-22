package br.com.projeto.GestaoUniversitario.repository;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.GestaoUniversitario.model.Usuario;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public  interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    @Modifying
    @Query(value = "INSERT INTO usuario_roles (usuario_id, roles_id) VALUES (?,1)",nativeQuery = true)
    void usuarioRoleVisitante(@Param("idU") Integer idUsuario);

    @Modifying
    @Query(value = "INSERT INTO usuario_roles (usuario_id, roles_id) VALUES (?,2)",nativeQuery = true)
    void usuarioRoleUser(@Param("idU") Integer idUsuario);

    @Modifying
    @Query(value = "INSERT INTO usuario_roles (usuario_id, roles_id) VALUES (?,3)",nativeQuery = true)
    void usuarioRoleAdmin(@Param("idU") Integer idUsuario);

    List<Usuario> findBySenha(String senha);

    Optional<Usuario> findByEmailAllIgnoreCase(String username);

}
