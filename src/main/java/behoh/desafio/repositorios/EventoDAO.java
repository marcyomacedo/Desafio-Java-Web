package behoh.desafio.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import behoh.desafio.entidades.Evento;

public interface EventoDAO extends JpaRepository<Evento, Long>{

}
