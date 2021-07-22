package behoh.desafio.servicos;

import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import behoh.desafio.dtos.InscricaoDto;
import behoh.desafio.entidades.Entrada;
import behoh.desafio.entidades.Evento;
import behoh.desafio.entidades.Usuario;
import behoh.desafio.repositorios.EntradaDAO;
import behoh.desafio.repositorios.EventoDAO;
import behoh.desafio.repositorios.UsuarioDAO;

@Service
public class ServicoEntrada {
	

	
	@Autowired
	private EventoDAO repositorioEvento;
	
	@Autowired
	private UsuarioDAO repositorioUsuario;
	
	@Autowired 
	private EntradaDAO repositorioEntrada;
	
	
	public Entrada realizarEntrada(InscricaoDto inscricaoDto) throws ServletException {
		Evento evento = repositorioEvento.findByNome(inscricaoDto.getNomeEvento());
		Usuario usuario = repositorioUsuario.findByNome(inscricaoDto.getNomeUsuario());
		Date now = new Date();
		
		if(now.after(evento.getDataHoraInicio())) {
			if(now.before(evento.getDataHoraFim())) {
				Entrada entrada = new Entrada();
				entrada.setEvento(evento);
				entrada.setUsuario(usuario);
				repositorioEntrada.save(entrada);
				
				return entrada;
				
			}
			throw new ServletException();			
		}
		throw new ServletException();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public ServicoEntrada() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
