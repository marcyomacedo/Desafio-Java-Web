package behoh.desafio.servicos;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import behoh.desafio.dtos.InscricaoDto;
import behoh.desafio.entidades.Entrada;
import behoh.desafio.entidades.Evento;
import behoh.desafio.entidades.Inscricao;
import behoh.desafio.entidades.Usuario;
import behoh.desafio.repositorios.EntradaDAO;
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
	
	@Autowired
	private EntradaDAO repositorioEntrada;
	
	
	public Inscricao realizarInscricao(InscricaoDto inscricaoDto) throws ServletException {
		
		String nomeEvento = inscricaoDto.getNomeEvento();
		String nomeUsuario = inscricaoDto.getNomeUsuario();
		Evento eventovaga = repositorioEvento.findByNome(nomeEvento);
		Date now = new Date();
		
		
		if(eventovaga.getVagas() > 0) {
			
			if(eventovaga.getDataHoraInicio().after(now)) {
				Inscricao inscricao = new Inscricao();
				inscricao.setEvento(repositorioEvento.findByNome(nomeEvento));
				inscricao.setUsuario(repositorioUsuario.findByNome(nomeUsuario));
				
				Evento evento = repositorioEvento.findByNome(nomeEvento);
				evento.setVagas(evento.getVagas() - 1);
				repositorioEvento.save(evento);				
				repositorioInscricao.save(inscricao);
				
				return inscricao;
			}
			
			throw new ServletException();
			
		}
		
		
		throw new ServletException();
		
	}
	
	public Inscricao cancelarInscricao(InscricaoDto inscricaoDto) throws ServletException {		
		
		String nomeEvento = inscricaoDto.getNomeEvento();
		String nomeUsuario = inscricaoDto.getNomeUsuario();

		Evento evento = repositorioEvento.findByNome(nomeEvento);
		Usuario usuario = repositorioUsuario.findByNome(nomeUsuario);
		Inscricao inscricao = repositorioInscricao.findByUsuarioAndEvento(usuario, evento);
		Entrada entrada = repositorioEntrada.findByUsuarioAndEvento(usuario, evento);
		Inscricao inscricaoEntrada = repositorioInscricao.findByUsuarioAndEvento(entrada.getUsuario(), entrada.getEvento());
		
		if(inscricao.equals(inscricaoEntrada)) {
			throw new ServletException();	
			
		}else{			
			
		evento.setVagas(evento.getVagas() + 1);
		repositorioEvento.save(evento);
		
		repositorioInscricao.delete(inscricao);
		
		return inscricao;
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public ServicoInscricao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
