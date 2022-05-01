package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

	private Integer numeroDoQuarto;
	private Date dataCheckIn;
	private Date dataCheckOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroDoQuarto, Date dataCheckIn, Date dataCheckOut) {
		this.numeroDoQuarto = numeroDoQuarto;
		this.dataCheckIn = dataCheckIn;
		this.dataCheckOut = dataCheckOut;
	}

	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}

	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}

	public Date getDataCheckIn() {
		return dataCheckIn;
	}

	public Date getDataCheckOut() {
		return dataCheckOut;
	}
	
	public long duracao() {
		long diferenca = dataCheckOut.getTime() - dataCheckIn.getTime(); // calculo entre datas em millisegundos, através do método getTime(); 
		return TimeUnit.DAYS.convert(diferenca, TimeUnit.MILLISECONDS);  // convertendo o calculo de millisegundos para numero de dias.
	}
	
	//Versão 1 do projeto Exceptions
	//public void atualizarDatas(Date checkIn, Date checkOut) {
	//	this.dataCheckIn   = checkIn;
	//	this.dataCheckOut  = checkOut;
	//}
	
	public String atualizarDatas(Date checkIn, Date checkOut) {
		Date agora = new Date();  // data corrente
		if(checkIn.before(agora) || checkOut.before(agora)) { //se as datas forem anteriores a data corrente, mostrar mensagem de erro. 
			return "Datas para atualização devem ser futuras.";
		} 
		
		if(!checkOut.after(checkIn)) {  //se a data de checkOut não for posterior a data de checkIn, mostra mensagem de erro.
			return "Data de check-out deve ser posterior a data de check-in.";
		}
		
		this.dataCheckIn   = checkIn;
		this.dataCheckOut  = checkOut;
		return null;   // é o critério estabelecido para dizer que este método não retornou erro.
	}
	
	@Override
	public String toString() {
		return "Sala " + numeroDoQuarto + ", check-in: " + sdf.format(dataCheckIn) + ", check-out: " + sdf.format(dataCheckOut) + ", Duração: " + duracao() + " noites.";
	}
	
}
