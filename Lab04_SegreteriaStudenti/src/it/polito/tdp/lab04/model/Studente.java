package it.polito.tdp.lab04.model;

import java.util.*;

public class Studente {
	private int matricola;
	private String cognome;
	private String nome;
	private String cds;
	
	private List<Corso> corsiSeguiti;
	
	public Studente(int matricola, String cognome, String nome, String cds) {
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
		this.cds = cds;
		corsiSeguiti=new LinkedList<Corso>();
	}
	public int getMatricola() {
		return matricola;
	}
	public String getCognome() {
		return cognome;
	}
	public String getNome() {
		return nome;
	}
	public String getCds() {
		return cds;
	}
	public void setCorsi(List<Corso> lista){
		corsiSeguiti=lista;
	}
	public List<Corso> getCorsi(){
		return corsiSeguiti;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cds == null) ? 0 : cds.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((corsiSeguiti == null) ? 0 : corsiSeguiti.hashCode());
		result = prime * result + matricola;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		if (cds == null) {
			if (other.cds != null)
				return false;
		} else if (!cds.equals(other.cds))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (corsiSeguiti == null) {
			if (other.corsiSeguiti != null)
				return false;
		} else if (!corsiSeguiti.equals(other.corsiSeguiti))
			return false;
		if (matricola != other.matricola)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	
	
	
	
}
