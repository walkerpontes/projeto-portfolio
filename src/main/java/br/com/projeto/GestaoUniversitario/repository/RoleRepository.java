package br.com.projeto.GestaoUniversitario.repository;

import br.com.projeto.GestaoUniversitario.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
