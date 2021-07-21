package behoh.desafio.dtos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventoDto {
	
	private String nome;
	private int vagas;
	private String dataHoraInicio;
	private String dataHoraFim;
	
	
	
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public int getVagas() {
		return vagas;
	}



	public void setVagas(int vagas) {
		this.vagas = vagas;
	}



	public Date getDataHoraInicio() throws ParseException{
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Date dataFormatada = formato.parse(this.dataHoraInicio);	
		
		return dataFormatada;
	}



	public void setDataHoraInicio(String dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}



	public Date getDataHoraFim() throws ParseException {
		SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Date dataFormatada2 = formato2.parse(this.dataHoraFim);	
		
		return dataFormatada2;
	}



	public void setDataHoraFim(String dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}



	public EventoDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
