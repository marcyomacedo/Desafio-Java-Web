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

import behoh.desafio.dtos.UsuarioDto;
import behoh.desafio.entidades.Inscricao;
import behoh.desafio.entidades.Usuario;
import behoh.desafio.servicos.ServicoUsuario;

@RestController
public class ControladorDeUsuarios {
	
	@Autowired
	private ServicoUsuario servicoUsuario;
	
	
	
	@PostMapping("/api/desafio/usuarios")
	public ResponseEntity<Usuario> adicionaUsuario(@RequestBody UsuarioDto usuarioDto) throws ParseException{
		return new ResponseEntity<Usuario>(this.servicoUsuario.adicionaUsuario(usuarioDto), HttpStatus.CREATED);
	}
	
	@GetMapping("/api/desafio/usuarios")
	public ResponseEntity<List<Inscricao>> inscricoesDoUsuario(@RequestBody UsuarioDto usuarioDto) throws ParseException{
		return new ResponseEntity<List<Inscricao>>(this.servicoUsuario.listarInscricoesUsuario(usuarioDto), HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public ControladorDeUsuarios() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
