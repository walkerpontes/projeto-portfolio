package br.com.projeto.GestaoUniversitario.repository;
import br.com.projeto.GestaoUniversitario.modelo.Salas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalasRepository extends CrudRepository<Salas,Integer> {
}
