package behoh.desafio.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import behoh.desafio.entidades.Evento;


@Repository
public interface EventoDAO extends JpaRepository<Evento, Long>{
	
	Evento findByNome(String nome);

}
