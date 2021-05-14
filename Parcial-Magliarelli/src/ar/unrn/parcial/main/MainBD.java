package ar.unrn.parcial.main;

import ar.unrn.parcial.ui.UiPrincipal;
import java.awt.EventQueue;

import ar.unrn.parcial.modelo.RepositorioDeFacturas;
import ar.unrn.parcial.persistance.FacturaJDBC;

public class MainBD {

	public static void main(String[] args) {

		RepositorioDeFacturas repo = new FacturaJDBC();
		UiPrincipal frame = new UiPrincipal(repo);
		frame.setVisible(true);

	}

}
