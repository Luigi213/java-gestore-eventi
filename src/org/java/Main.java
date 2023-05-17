package org.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		Concerto c1 = null;
		LocalDate data = null;
		Evento e1 = null;
		
		List<Evento> eventi = new ArrayList<>();
		
		ProgrammEvento p1 = new ProgrammEvento("programma eventi", eventi);
		
		while (true) {
			System.out.println("1 - Inserire nuovo evento");
			System.out.println("2 - Uscire");
			int choise = in.nextInt();
			
			if ( choise < 1 || choise > 2 ) continue;
			if(choise == 2) break;
			in.nextLine();
			
			System.out.println("Nome dell'evento");
			String nome = in.nextLine(); 
			System.out.println("Data dell'evento");
			String str = in.nextLine();
		    data = LocalDate.parse(str);
			try {			
				e1 = new Evento(nome, data);
				eventi.add(new Evento(nome, data));
				
			} catch (Exception e) {
				System.err.println("Errore nella lettura della data, " + e.getMessage());
			}
			
			System.out.println("Quante prenotazioni vuoi fare");
			int numPre = in.nextInt();
			
			try {
				for(int i=0; i<numPre; i++) {					
					e1.prenota();
				}
				System.out.println("numero di posti prenotati: " + e1.getNumPosPre() + "/" + e1.getNumPosTot());
			} catch ( Exception e ) {
				System.err.println("Errore nella lettura della prenotazione, " + e.getMessage());
			}
			
			System.out.println("Quante prenotazioni vuoi disdire");
			int numDis = in.nextInt();
			
			try {
				for(int i=0; i<numDis; i++) {					
					e1.disdici();
				}
				System.out.println("numero di posti prenotati: " + e1.getNumPosPre() + "/" + e1.getNumPosTot());
				System.out.println("numero di posti disponibili: " + (e1.getNumPosTot() - e1.getNumPosPre()));
			} catch ( Exception e ) {
				System.err.println("Errore nella lettura della prenotazione, " + e.getMessage());
			}
		}
		
		System.out.println("\n-------------------------\n");
		
		while(true) {
			System.out.println("1 - Inserire nuovo concerto");
			System.out.println("2 - Uscire");
			int choise = in.nextInt();
			
			if ( choise < 1 || choise > 2 ) continue;
			if(choise == 2) break;
			in.nextLine();
			
			System.out.println("Nome del concerto");
			String nome = in.nextLine(); 
		    System.out.println("Orario del concerto");
		    LocalTime ora = LocalTime.parse(in.nextLine());
		    System.out.println("Prezzo del biglietto");
		    BigDecimal prezzo = in.nextBigDecimal();
			try {			
				c1 = new Concerto(nome, data, ora , prezzo);				
			} catch (Exception e) {
				System.err.println("Errore nella lettura della data, " + e.getMessage());
			}
		}
		System.out.println(c1);
		
		System.out.println(p1);
	}
}
