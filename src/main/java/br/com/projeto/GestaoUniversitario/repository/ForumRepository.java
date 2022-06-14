package br.com.projeto.GestaoUniversitario.repository;

import br.com.projeto.GestaoUniversitario.modelo.Forum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ForumRepository extends CrudRepository<Forum,Integer> {
}
