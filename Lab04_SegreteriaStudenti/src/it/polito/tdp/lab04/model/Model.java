package it.polito.tdp.lab04.model;

import java.util.*;

import it.polito.tdp.lab04.DAO.CorsoDAO;

public class Model {
	private List<Corso> corsi;

	public Model() {
		this.corsi=new ArrayList<Corso>();
	}
	
	public List<Corso> getCorsi(){
		CorsoDAO dao=new CorsoDAO();
		return dao.getTuttiICorsi();
	}
}
