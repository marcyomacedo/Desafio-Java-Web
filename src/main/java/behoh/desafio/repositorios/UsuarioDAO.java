package behoh.desafio.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import behoh.desafio.entidades.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Long>{
	
	

}