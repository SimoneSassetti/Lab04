package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public Studente getStudente(int codice){
		
		final String sql="SELECT * FROM studente WHERE matricola=?";
		
		Studente result=null;
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, codice);
			ResultSet rs = st.executeQuery();
		
			if(rs.next()){
				Studente s=new Studente(rs.getInt("matricola"),rs.getString("cognome"), rs.getString("nome"), rs.getString("cds"));
				result=s;
			}else
				result=null;
			
			conn.close();
			
		}catch(SQLException e) {
			throw new RuntimeException("Errore Db");
		}
		return result;
	}

	public void corsiStudente(Studente studente) {
		
		String sql="SELECT c.codins,c.crediti,c.nome,c.pd FROM iscrizione as i, corso as c WHERE i.codins=c.codins && i.matricola=? ";
		List<Corso> corsi=new ArrayList<Corso>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, studente.getMatricola());
			ResultSet rs = st.executeQuery();
		
			while (rs.next()) {
				Corso c=new Corso(rs.getString("codins"),rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd"));
				corsi.add(c);
				}
			studente.setCorsi(corsi);
			conn.close();
			}
		catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
		
	}
	
	
	
	
	
	
	
	
	
}
