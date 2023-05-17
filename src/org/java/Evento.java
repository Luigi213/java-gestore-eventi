package org.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
	private String titolo;
	private LocalDate data;
	private int numPosTot;
	private int numPosPre;
	
	public Evento (String titolo, LocalDate data) throws Exception {
		setTitolo(titolo);
		setData(data);
		numPosTot = 100;
	}

	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) throws Exception {
		if (LocalDate.of(2022, 1, 10).isAfter(data)) {			
			throw new Exception("Data passata");
		}
		this.data = data;
	}
	public int getNumPosTot() {
		return numPosTot;
	}
	public int getNumPosPre() {
		return numPosPre;
	}
	
	public void prenota() throws Exception {
		if (LocalDate.now().isAfter(getData())) {			
			throw new Exception("Data passata non puoi prenotare");
		}
		if(getNumPosPre() > getNumPosTot()) {
			throw new Exception("Posti esauriti");
		}
		numPosPre = getNumPosPre() + 1; 
	}
	public void disdici() throws Exception {
		if (LocalDate.now().isAfter(getData())) {			
			throw new Exception("Data passata non puoi prenotare");
		}
		if(getNumPosPre() == 0) {
			throw new Exception("Non hai prenotato niente");
		}
		numPosPre = getNumPosPre() - 1; 
	}
	public String getDataFormat() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String data = getData().format(formatter);
        return data;
	}
	
	@Override
	public String toString() {
		return "titolo dell'evento: " + getTitolo()
				+ "\ndata dell'evento: " + getDataFormat();
	}
}
