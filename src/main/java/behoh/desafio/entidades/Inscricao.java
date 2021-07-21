package behoh.desafio.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inscricao")
public class Inscricao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@ManyToOne
    @JoinColumn(name = "id_Evento")
	private Evento evento;
	
	@ManyToOne
    @JoinColumn(name = "id_Usuario")
	private Usuario usuario;
	
	
	

	public Long getId() {
		return id;
	}

	

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Inscricao() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	
	
	
	

}
