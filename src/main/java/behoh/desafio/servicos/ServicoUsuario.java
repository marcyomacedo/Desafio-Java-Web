package behoh.desafio.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import behoh.desafio.dtos.UsuarioDto;
import behoh.desafio.entidades.Usuario;
import behoh.desafio.entidades.Inscricao;
import behoh.desafio.repositorios.InscricaoDAO;
import behoh.desafio.repositorios.UsuarioDAO;

@Service
public class ServicoUsuario {
	
	@Autowired
	private UsuarioDAO repositorioUsuario;
	
	@Autowired
	private InscricaoDAO repositorioInscricao;
	
	public Usuario adicionaUsuario(UsuarioDto usuarioDto) {
		
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioDto.getNome());
		repositorioUsuario.save(usuario);
		
		return usuario;
		
		
	}
	
	public List<Inscricao> listarInscricoesUsuario(String nomeUsuario){
		
		Usuario usuario = repositorioUsuario.findByNome(nomeUsuario);
		List<Inscricao> inscricoes = repositorioInscricao.findByUsuario(usuario);
		
		return inscricoes;
		
	}


	public ServicoUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	

}
