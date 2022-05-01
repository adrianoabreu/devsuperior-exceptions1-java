package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class ProblemaCriandoExcecoesPersonalizadas1 {
	/*
	 * Fazer um programa para ler os dados de uma reserva de hotel (n�mero do quarto, data
	 * de entrada e data de sa�da) e mostrar os dados da reserva, inclusive sua dura��o em
	 * dias. Em seguida, ler novas datas de entrada e sa�da, atualizar a reserva, e mostrar
	 * novamente a reserva com os dados atualizados. O programa n�o deve aceitar dados
	 * inv�lidos para a reserva, conforme as seguintes regras:
	 * - Altera��es de reserva s� podem ocorrer para datas futuras
	 * - A data de sa�da deve ser maior que a data de entrada
	 * 
	 * Solu��o 1 (muito ruim): l�gica de valida��o no programa principal
	 * Caminho gitHub:  https://github.com/adrianoabreu/exceptions1-java
	 */
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do Quarto: ");
		int numero = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {  //se a data de checkOut n�o for posterior a data de checkIn, mostra mensagem de erro.
			System.out.println("Erro na reserva: Data de check-out deve ser posterior a data de check-in.");
		} else {
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Atualizar Datas da Reserva");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			//Vers�o 1 do projeto Exceptions
			//Date agora = new Date();
			//if(checkIn.before(agora) || checkOut.before(agora)) { //se as datas forem anteriores a data corrente, mostrar mensagem de erro. 
			//	System.out.println("Erro na Reserva: Datas para atualiza��o devem ser futuras.");
			//} else if(!checkOut.after(checkIn)) {  //se a data de checkOut n�o for posterior a data de checkIn, mostra mensagem de erro.
			//	System.out.println("Erro na reserva: Data de check-out deve ser posterior a data de check-in.");
			//} else {
			//	reserva.atualizarDatas(checkIn, checkOut);
			//	System.out.println("Reserva: " + reserva);
			//}
			
			String erro = reserva.atualizarDatas(checkIn, checkOut);
			if (erro != null) {
				System.out.println("Erro na reserva " + erro);
			} else {
				System.out.println("Reserva: " + reserva);
			}
			
		}
		
		sc.close();
	}

}
