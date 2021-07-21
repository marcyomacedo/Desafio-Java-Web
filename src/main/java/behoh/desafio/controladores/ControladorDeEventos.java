package behoh.desafio.controladores;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import behoh.desafio.entidades.Inscricao;
import behoh.desafio.dtos.EventoDto;
import behoh.desafio.dtos.EventoNomeDto;
import behoh.desafio.entidades.Evento;
import behoh.desafio.servicos.ServicoEvento;

@RestController
public class ControladorDeEventos {
	
	@Autowired
	private ServicoEvento servicoEvento;
	
	
	@PostMapping("/api/desafio/eventos")
	public ResponseEntity<Evento> adicionaEvento(@RequestBody EventoDto eventoDto) throws ParseException{
		return new ResponseEntity<Evento>(this.servicoEvento.adicionaEvento(eventoDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/api/desafio/eventos")
	public ResponseEntity<List<Inscricao>> listaInscricoesEvento(@RequestBody EventoNomeDto nomeEvento) throws ParseException{
		return new ResponseEntity<List<Inscricao>>(this.servicoEvento.listarInscricoesEvento(nomeEvento), HttpStatus.OK);
	}
	
	
	
	


	public ControladorDeEventos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
