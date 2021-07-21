package behoh.desafio.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import behoh.desafio.entidades.Evento;
import behoh.desafio.entidades.Inscricao;
import behoh.desafio.entidades.Usuario;

@Repository
public interface InscricaoDAO extends JpaRepository<Inscricao, Long>{
	
	Inscricao findByUsuarioAndEvento(Usuario usuario, Evento evento);
	List<Inscricao> findByUsuario(Usuario usuario);
	List<Inscricao> findByEvento(Evento evento);
}
