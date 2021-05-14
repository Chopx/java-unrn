package ar.unrn.parcial.main;

import java.awt.EventQueue;

import ar.unrn.parcial.modelo.RepositorioDeFacturas;
import ar.unrn.parcial.persistance.RegistroDeFacturasEnDisco;
import ar.unrn.parcial.ui.UiPrincipal;

public class MainArchivoTexto {

	public static void main(String[] args) {

		RepositorioDeFacturas repo = new RegistroDeFacturasEnDisco("C:\\Users\\ELJUEEN\\Desktop\\archivoParcial.txt");
		UiPrincipal frame = new UiPrincipal(repo);
		frame.setVisible(true);

	}
}
