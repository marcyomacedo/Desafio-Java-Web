package behoh.desafio.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import behoh.desafio.entidades.Evento;
import behoh.desafio.entidades.Inscricao;
import behoh.desafio.entidades.Usuario;
import behoh.desafio.repositorios.EventoDAO;
import behoh.desafio.repositorios.InscricaoDAO;
import behoh.desafio.repositorios.UsuarioDAO;

@Service
public class ServicoInscricao {
	
	@Autowired
	private InscricaoDAO repositorioInscricao;
	
	@Autowired
	private EventoDAO repositorioEvento;
	
	@Autowired
	private UsuarioDAO repositorioUsuario;
	
	
	public Inscricao realizarInscricao(String nomeUsuario, String nomeEvento) {
		
		Inscricao inscricao = new Inscricao();
		inscricao.setEvento(repositorioEvento.findByNome(nomeEvento));
		inscricao.setUsuario(repositorioUsuario.findByNome(nomeUsuario));
		
		Evento evento = repositorioEvento.findByNome(nomeEvento);
		evento.setVagas(evento.getVagas() - 1);
		repositorioEvento.save(evento);
		
		
		repositorioInscricao.save(inscricao);
		
		return inscricao;
		
	}
	
	public Inscricao cancelarInscricao(String nomeUsuario, String nomeEvento) {
		
		Evento evento = repositorioEvento.findByNome(nomeEvento);
		Usuario usuario = repositorioUsuario.findByNome(nomeUsuario);
		Inscricao inscricao = repositorioInscricao.findByUsuarioAndEvento(usuario, evento);
		
		evento.setVagas(evento.getVagas() + 1);
		repositorioEvento.save(evento);
		
		repositorioInscricao.delete(inscricao);
		
		return inscricao;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public ServicoInscricao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
