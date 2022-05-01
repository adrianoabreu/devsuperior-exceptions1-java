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
	
	public void atualizarDatas(Date checkIn, Date checkOut) {
		this.dataCheckIn   = checkIn;
		this.dataCheckOut  = checkOut;
	}
	
	@Override
	public String toString() {
		return "Sala " + numeroDoQuarto + ", check-in: " + sdf.format(dataCheckIn) + ", check-out: " + sdf.format(dataCheckOut) + ", Duração: " + duracao() + " noites.";
	}
	
}
