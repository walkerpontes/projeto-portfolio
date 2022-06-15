package br.com.projeto.GestaoUniversitario.repository;

import br.com.projeto.GestaoUniversitario.modelo.Forum;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumRepository extends PagingAndSortingRepository<Forum,Integer>, JpaSpecificationExecutor<Forum> {
    List<Forum> findByTema (String tema);
}
