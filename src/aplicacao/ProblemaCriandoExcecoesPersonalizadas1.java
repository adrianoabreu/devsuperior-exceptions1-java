package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reserva;

public class ProblemaCriandoExcecoesPersonalizadas1 {
	/*
	 * Fazer um programa para ler os dados de uma reserva de hotel (número do quarto, data
	 * de entrada e data de saída) e mostrar os dados da reserva, inclusive sua duração em
	 * dias. Em seguida, ler novas datas de entrada e saída, atualizar a reserva, e mostrar
	 * novamente a reserva com os dados atualizados. O programa não deve aceitar dados
	 * inválidos para a reserva, conforme as seguintes regras:
	 * - Alterações de reserva só podem ocorrer para datas futuras
	 * - A data de saída deve ser maior que a data de entrada
	 * 
	 * Solução 1 (muito ruim): lógica de validação no programa principal
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
		
		if(!checkOut.after(checkIn)) {  //se a data de checkOut não for posterior a data de checkIn, mostra mensagem de erro.
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
			
			//Versão 1 do projeto Exceptions
			//Date agora = new Date();
			//if(checkIn.before(agora) || checkOut.before(agora)) { //se as datas forem anteriores a data corrente, mostrar mensagem de erro. 
			//	System.out.println("Erro na Reserva: Datas para atualização devem ser futuras.");
			//} else if(!checkOut.after(checkIn)) {  //se a data de checkOut não for posterior a data de checkIn, mostra mensagem de erro.
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
