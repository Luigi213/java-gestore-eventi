package org.java;

import java.util.List;

public class ProgrammEvento {
	private String titolo;
	private List<Evento> evento;
	
	public ProgrammEvento(String titolo, List<Evento> evento) {
		setTitolo(titolo);
		setEvento(evento);
	}
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public List<Evento> getEvento() {
		return evento;
	}
	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}
	
	public void svuota() {
		getEvento().removeAll(evento);
	}
	
	@Override
	public String toString() {
		return getTitolo() + "\n" + getEvento() + "\n";
	}
}
