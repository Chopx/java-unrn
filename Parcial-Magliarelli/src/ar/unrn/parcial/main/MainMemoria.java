package ar.unrn.parcial.main;

import java.awt.EventQueue;

import ar.unrn.parcial.modelo.RepositorioDeFacturas;
import ar.unrn.parcial.persistance.RegistroDeFacturasEnMemoria;
import ar.unrn.parcial.ui.UiPrincipal;

public class MainMemoria {

	public static void main(String[] args) {

		RepositorioDeFacturas repo = new RegistroDeFacturasEnMemoria();
		UiPrincipal frame = new UiPrincipal(repo);
		frame.setVisible(true);

	}
}
