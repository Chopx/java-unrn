package ar.unrn.parcial.main;

import ar.unrn.parcial.ui.UI_Principal;
import java.awt.EventQueue;

import ar.unrn.parcial.modelo.RepositorioDeFacturas;
import ar.unrn.parcial.persistance.FacturaJDBC;

public class MainBD {

	public static void main(String[] args) {
		
					RepositorioDeFacturas repo = new FacturaJDBC();
					UI_Principal frame = new UI_Principal(repo);
					frame.setVisible(true);
	
	}
		
}
