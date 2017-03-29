package it.polito.tdp.lab04.model;

import java.util.*;

public class Corso {
	private String codins;
	private int crediti;
	private String nome;
	private int pd;
	
	private List<Studente> studenti;
	
	public Corso(String codins, int crediti, String nome, int pd) {
		super();
		this.codins = codins;
		this.crediti = crediti;
		this.nome = nome;
		this.pd = pd;
		studenti=new ArrayList<Studente>();
	}
	public String getCodins() {
		return codins;
	}
	public int getCrediti() {
		return crediti;
	}
	public String getNome() {
		return nome;
	}
	public int getPd() {
		return pd;
	}
	public void setStudenti(List<Studente> lista){
		this.studenti=lista;
	}
	public List<Studente> getStudentiIscritti() {
		return studenti;
	}
	
	
	
	
	
}
