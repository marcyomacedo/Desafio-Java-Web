package behoh.desafio.controladores;

import java.text.ParseException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import behoh.desafio.dtos.InscricaoDto;
import behoh.desafio.entidades.Inscricao;
import behoh.desafio.servicos.ServicoInscricao;

@RestController
public class ControladorDeInscricoes {
	
	@Autowired
	private ServicoInscricao servicoInscricao;
	
	
	
	@PostMapping("/api/desafio/inscricoes")
	public ResponseEntity<Inscricao> realizaInscricao(@RequestBody InscricaoDto inscricaoDto) throws ParseException, ServletException{
		return new ResponseEntity<Inscricao>(this.servicoInscricao.realizarInscricao(inscricaoDto), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/api/desafio/inscricoes")
	public ResponseEntity<Inscricao> CancelarInscricao(@RequestBody InscricaoDto inscricaoDto) throws ParseException{
		return new ResponseEntity<Inscricao>(this.servicoInscricao.cancelarInscricao(inscricaoDto), HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public ControladorDeInscricoes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
