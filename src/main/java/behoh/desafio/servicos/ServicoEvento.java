package behoh.desafio.servicos;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import behoh.desafio.dtos.EventoDto;
import behoh.desafio.dtos.EventoNomeDto;
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
	
	
	public Evento adicionaEvento(EventoDto eventoDto) throws ParseException {
		
		Evento evento = new Evento();
		evento.setNome(eventoDto.getNome());
		evento.setVagas(eventoDto.getVagas());
		evento.setDataHoraInicio(eventoDto.getDataHoraInicio());
		evento.setDataHoraFim(eventoDto.getDataHoraFim());
		
		repositorioEvento.save(evento);
		
		return evento;
		
	}
	
	public List<Inscricao> listarInscricoesEvento(EventoNomeDto eventoNomeDto){
		String nomeEvento = eventoNomeDto.getNome();
		Evento evento = repositorioEvento.findByNome(nomeEvento);
		List<Inscricao> inscricoes = repositorioInscricao.findByEvento(evento);
		
		return inscricoes;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ServicoEvento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
