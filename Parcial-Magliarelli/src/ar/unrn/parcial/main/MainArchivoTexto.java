package ar.unrn.parcial.main;

import java.awt.EventQueue;

import ar.unrn.parcial.modelo.RepositorioDeFacturas;
import ar.unrn.parcial.persistance.RegistroDeFacturasEnDisco;
import ar.unrn.parcial.ui.UI_Principal;

public class MainArchivoTexto {

	public static void main(String[] args) {
		
					RepositorioDeFacturas repo = new RegistroDeFacturasEnDisco();
					UI_Principal frame = new UI_Principal(repo);
					frame.setVisible(true);
		
	}
}
