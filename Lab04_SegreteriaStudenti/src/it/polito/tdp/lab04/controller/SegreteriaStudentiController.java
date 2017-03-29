package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SegreteriaStudentiController {
	Model model;
	public void setModel(Model model) {
		this.model = model;
		List<String> nomeCorsi=new LinkedList<String>();
		nomeCorsi.add("");
		for(Corso c: model.getCorsi()){
			nomeCorsi.add(c.getNome());
		}
		comboCorso.getItems().addAll(nomeCorsi);
		
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboCorso;

    @FXML
    private Button btnCercaIscrittiCorso;

    @FXML
    private TextField txtMatricola;

    @FXML
    private ImageView btnCercaNome;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	int matricola=Integer.parseInt(txtMatricola.getText());
    	
    	Studente s=model.completaStudente(matricola);
    	if(s==(null)){
    		txtResult.appendText("Matricola non valida.\n");
    		
    	}else{
    		List<Corso> corsiSeguiti=model.corsiSeguiti(s);
    		for(Corso c: corsiSeguiti){
    			txtResult.appendText(String.format("%-10s %-5s %-50s %-10s\n", c.getCodins(),c.getCrediti(),c.getNome(),c.getPd()));
    		}
    		
    	}
    	
    	
    }
    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {
    	String corso=comboCorso.getValue();
    	if(corso.equals("") || corso.equals(null)){
    		txtResult.appendText("Selezionare un corso per effettuare la ricerca.\n");
    		return;
    	}else{
    		List<Studente> lista=model.iscrittiCorso(corso);
    		for(Studente s: lista){
    			txtResult.appendText(String.format("%-10s %-20s %-20s %-20s\n", s.getMatricola(), s.getNome(), s.getCognome(), s.getCds() ));
    		}
    	}
    }

    @FXML
    void doCercaNome(MouseEvent event) {
    	int matricola=Integer.parseInt(txtMatricola.getText());
    	Studente s=model.completaStudente(matricola);
    	txtNome.setText(s.getNome());
    	txtCognome.setText(s.getCognome());
    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert comboCorso != null : "fx:id=\"comboCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaNome != null : "fx:id=\"btnCercaNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        
        txtResult.setStyle("-fx-font-family: monospace");
        
    }
}


