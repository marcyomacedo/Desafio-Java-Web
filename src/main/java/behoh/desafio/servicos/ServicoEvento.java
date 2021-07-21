package behoh.desafio.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import behoh.desafio.dtos.EventoDto;
import behoh.desafio.entidades.Evento;
import behoh.desafio.entidades.Inscricao;
import behoh.desafio.repositorios.EventoDAO;
import behoh.desafio.repositorios.InscricaoDAO;

@Service
public class ServicoEvento {
	
	@Autowired
	private EventoDAO repositorioEvento;

	@Autowired
	private InscricaoDAO repositorioInscricao;
	
	
	public Evento adicionaEvento(EventoDto eventoDto) {
		
		Evento evento = new Evento();
		evento.setNome(eventoDto.getNome());
		evento.setVagas(eventoDto.getVagas());
		evento.setDataHoraInicio(eventoDto.getDataHoraInicio());
		evento.setDataHoraFim(eventoDto.getDataHoraFim());
		
		repositorioEvento.save(evento);
		
		return evento;
		
	}
	
	public List<Inscricao> listarInscricoesEvento(String nomeEvento){
		
		Evento evento = repositorioEvento.findByNome(nomeEvento);
		List<Inscricao> inscricoes = repositorioInscricao.findByEvento(evento);
		
		return inscricoes;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ServicoEvento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
