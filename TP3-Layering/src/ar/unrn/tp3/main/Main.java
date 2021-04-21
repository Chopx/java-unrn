package ar.unrn.tp3.main;
import java.awt.EventQueue;

import java.sql.SQLException;

import ar.unrn.tp3.bd.ParticipanteJDBC;
import ar.unrn.tp3.ui.UI;

public class Main {
	public static void main(String[] args) {
		/*
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new AgregarParticipante();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		});
	
		*/
		UI ui = new UI(new ParticipanteJDBC());
		ui.iniciarVentana();
		
	}
}