package org.java;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{
	private LocalTime ora;
	private BigDecimal prezzo;

	public Concerto(String titolo, LocalDate data, LocalTime ora, BigDecimal prezzo) throws Exception {
		super(titolo, data);
		setOra(ora);
		setPrezzo(prezzo);
	}
	
	public LocalTime getOra() {
		return ora;
	}
	public void setOra(LocalTime ora) {
		this.ora = ora;
	}
	public BigDecimal getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	
	public String formatDecimal() {
		DecimalFormat df = new DecimalFormat("#,###.00");
		String formatDec = "" + df.format(getPrezzo());
		return formatDec;
	}
	
	public String getTimeFormat() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		return getOra().format(dtf);
	}
	
	@Override
	public String toString() {
		return getDataFormat()
				+ " - " + getTimeFormat()
				+ " - " + getTitolo()
				+ " - " + formatDecimal() + "€";
	}
}
