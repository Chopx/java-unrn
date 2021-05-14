package ar.unrn.parcial.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.unrn.parcial.modelo.*;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class UiCombustible extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public UiCombustible(RepositorioDeFacturas repo) {
		setTitle("Cargar Combustible");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 390, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(147, 37, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel Litros = new JLabel("Litros cargados:");
		Litros.setBounds(39, 40, 83, 14);
		contentPane.add(Litros);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(147, 68, 118, 22);
		contentPane.add(comboBox);
		comboBox.addItem("Comun");
		comboBox.addItem("Super");

		JLabel lblTipoDeNafta = new JLabel("Tipo de nafta:");
		lblTipoDeNafta.setBounds(39, 72, 83, 14);
		contentPane.add(lblTipoDeNafta);

		JButton Consultar_pago = new JButton("Consultar pago");
		Consultar_pago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDateTime hoy = LocalDateTime.now();
				Combustible tipoCombustible = tipoDeCombustible(comboBox);
				double monto;
				try {
					monto = repo.calcularMontoDeFactura(hoy, tipoCombustible, Integer.parseInt(textField.getText()));
					JOptionPane.showMessageDialog(null, "El monto es de: " + monto, "Informe monto",
							JOptionPane.OK_CANCEL_OPTION);
				} catch (NumberFormatException | ValidarLitrosException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),
							"Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		Consultar_pago.setBounds(58, 126, 111, 38);
		contentPane.add(Consultar_pago);

		JButton Consultar_confirmar_pago = new JButton("Confirmar pago");
		Consultar_confirmar_pago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LocalDateTime hoy = LocalDateTime.now();
				Combustible tipoCombustible = tipoDeCombustible(comboBox);
				try {
					repo.registrarFactura(hoy, tipoCombustible, Integer.parseInt(textField.getText()));
					dispose();
					JOptionPane.showMessageDialog(null, "Se agregó la factura exitosamente", "Registro de factura",
							JOptionPane.OK_CANCEL_OPTION);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR LITROS", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		Consultar_confirmar_pago.setBounds(205, 126, 118, 38);
		contentPane.add(Consultar_confirmar_pago);

		JButton Consultar_confirmar_pago_1 = new JButton("Atras");
		Consultar_confirmar_pago_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		Consultar_confirmar_pago_1.setBounds(293, 187, 71, 23);
		contentPane.add(Consultar_confirmar_pago_1);

	}

	private Combustible tipoDeCombustible(JComboBox box) {
		Combustible tipoCombustible = null;

		if (box.getSelectedItem().toString().equals("Comun"))
			return tipoCombustible = new Comun(70);

		return tipoCombustible = new Super(90);
	}

}
