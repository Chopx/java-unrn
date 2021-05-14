package ar.unrn.parcial.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ar.unrn.parcial.modelo.Factura;
import ar.unrn.parcial.modelo.RepositorioDeFacturas;

public class UiListadoVentas extends JFrame {

	private JPanel contentPane;
	DefaultTableModel modelo;

	/**
	 * Launch the application.
	 * 
	 * @return
	 */

	/**
	 * Create the frame.
	 */
	public UiListadoVentas(RepositorioDeFacturas repo, LocalDateTime inicio, LocalDateTime fin) {

		String[] titulos = { "Fecha y hora", "Tipo Nafta", "Litros", "Monto" };
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Listado de facturas");

		JTable table = new JTable();
		table.setBounds(1, 30, 420, 0);

		modelo = new DefaultTableModel(new Object[][] {}, titulos);

		ArrayList<Factura> facturas = null;

		try {
			facturas = repo.obtenerFacturasEntreFechas(inicio, fin);
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR LITROS", JOptionPane.ERROR_MESSAGE);
		}

		for (Factura f : facturas) {
			System.out.println(f.toString());
		}

		for (Factura f : facturas) {
			String fecha = f.fechaDeFactura().format(DateTimeFormatter.ofPattern("dd-MM-yyyy h:mm"));
			modelo.addRow(
					new Object[] { fecha, f.verTipoDeCombustible(), f.cantidadDeLitros(), f.calcularMontoTotal() });
		}
		contentPane.setLayout(null);

		table.setModel(modelo);
		contentPane.add(table, BorderLayout.CENTER);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(13, 42, 422, 218);
		getContentPane().add(scrollPane);
		JButton cerrarButton = new JButton("Cerrar");
		cerrarButton.setBounds(447, 216, 110, 44);
		cerrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		contentPane.add(cerrarButton);
	}
}
