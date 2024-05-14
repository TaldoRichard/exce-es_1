package Aplicação;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reserva;
import model.exceptions.DomainException;

public class Programa {

	public static void main(String[] args)  {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Numero do quarto: ");
			int numeroDoQuarto = sc.nextInt();
			System.out.print("Data de check-in (dd/mm/aaaa): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data de check-out (dd/mm/aaaa): ");
			Date checkOut = sdf.parse(sc.next());
			
			
			Reserva reserva = new Reserva(numeroDoQuarto, checkIn, checkOut);
			System.out.println("Reserva:" + reserva);
			
			System.out.println();
			System.out.println("Digite uma data para atualizar a reserva:");
			System.out.print("Data de check-in (dd/mm/aaaa): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de check-out (dd/mm/aaaa): ");
			checkOut = sdf.parse(sc.next());
			
		
			String erro = reserva.atualizarDatas(checkIn, checkOut);
			if (erro != null) {
				System.out.println("Erro na reserva: " + erro);
			}
			else {
				System.out.println("Reserva: " + reserva);
			}
		}
		catch (ParseException e) {
			System.out.println("Formato de data invalido!");
		}
		catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado.");
		}

		sc.close();
	}

}
