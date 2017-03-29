package it.polito.tdp.lab04.model;

import java.util.*;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	private List<Corso> corsi;

	public Model() {
		this.corsi=new ArrayList<Corso>();
	}
	
	public List<Corso> getCorsi(){
		CorsoDAO dao=new CorsoDAO();
		corsi.addAll(dao.getTuttiICorsi());
		return corsi;
	}
	
	public Studente completaStudente(int matricola){
		StudenteDAO dao=new StudenteDAO();
		return dao.getStudente(matricola);
	}

	public List<Studente> iscrittiCorso(String corso) {
		CorsoDAO dao=new CorsoDAO();
		Corso trovato=null;
		for(Corso c: corsi){
			if(c.getNome().equals(corso)){
				trovato=c;
				break;
			}
		}
		if(trovato!=null)
			dao.getStudentiIscrittiAlCorso(trovato);
		return trovato.getStudentiIscritti();
	}
	
	public List<Corso> corsiSeguiti(Studente s){
		StudenteDAO dao=new StudenteDAO();
		dao.corsiStudente(s);
		return s.getCorsi();
	}
	
	
	
}
