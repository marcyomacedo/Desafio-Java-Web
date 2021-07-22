package behoh.desafio.controladores;

import java.text.ParseException;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import behoh.desafio.dtos.InscricaoDto;
import behoh.desafio.entidades.Entrada;
import behoh.desafio.servicos.ServicoEntrada;

@RestController
public class ControladorDeEntradas {
	
	@Autowired
	private ServicoEntrada servicoEntrada;
	
	@PostMapping("/api/desafio/entradas")
	public ResponseEntity<Entrada> realizaEntrada(@RequestBody InscricaoDto inscricaoDto) throws ParseException, ServletException{
		return new ResponseEntity<Entrada>(this.servicoEntrada.realizarEntrada(inscricaoDto), HttpStatus.CREATED);
	}
	
	
	

	public ControladorDeEntradas() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
