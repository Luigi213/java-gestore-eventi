package org.java;

import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		
		try {			
			Evento e1 = new Evento("ciao", LocalDate.of(2025, 05, 12));
			e1.prenota();
			e1.disdici();
			
			System.out.println(e1);
		} catch (Exception e) {
			System.err.println("Errore nella lettura della data, " + e.getMessage());
		}
		
	}
}
