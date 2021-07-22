package behoh.desafio.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import behoh.desafio.entidades.Entrada;
import behoh.desafio.entidades.Evento;
import behoh.desafio.entidades.Usuario;

@Repository
public interface EntradaDAO  extends JpaRepository<Entrada, Long>{
	
	Entrada findByUsuarioAndEvento(Usuario usuario, Evento evento);

}
