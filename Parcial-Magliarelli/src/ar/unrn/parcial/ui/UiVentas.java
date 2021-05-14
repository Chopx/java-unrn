package ar.unrn.parcial.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.unrn.parcial.modelo.RepositorioDeFacturas;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UiVentas extends JFrame {

	private JPanel contentPane;
	private JTextField JtextDiaInicio;
	private JTextField JtextMesInicio;
	private JTextField JtextAnioInicio;
	private JTextField JtextDiaFin;
	private JTextField JtextMesFin;
	private JTextField JtextAnioFin;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public UiVentas(RepositorioDeFacturas repo) {
		setTitle("Consulta de Ventas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel fecha_inicio = new JLabel("Fecha inicio:");
		fecha_inicio.setBounds(29, 64, 79, 14);
		contentPane.add(fecha_inicio);

		JLabel fecha_fin = new JLabel("Fecha fin:");
		fecha_fin.setBounds(29, 116, 79, 14);
		contentPane.add(fecha_fin);

		JtextDiaInicio = new JTextField();
		JtextDiaInicio.setBounds(118, 61, 32, 20);
		contentPane.add(JtextDiaInicio);
		JtextDiaInicio.setColumns(10);

		JLabel lblDia = new JLabel("D\u00EDa");
		lblDia.setHorizontalAlignment(SwingConstants.CENTER);
		lblDia.setBounds(118, 49, 32, 14);
		contentPane.add(lblDia);

		JtextMesInicio = new JTextField();
		JtextMesInicio.setColumns(10);
		JtextMesInicio.setBounds(174, 61, 32, 20);
		contentPane.add(JtextMesInicio);

		JLabel lblMes = new JLabel("Mes");
		lblMes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMes.setBounds(174, 49, 32, 14);
		contentPane.add(lblMes);

		JLabel lblMes_1 = new JLabel("-");
		lblMes_1.setBounds(160, 64, 4, 14);
		contentPane.add(lblMes_1);

		JLabel lblMes_1_1 = new JLabel("-");
		lblMes_1_1.setBounds(216, 64, 4, 14);
		contentPane.add(lblMes_1_1);

		JtextAnioInicio = new JTextField();
		JtextAnioInicio.setColumns(10);
		JtextAnioInicio.setBounds(230, 61, 32, 20);
		contentPane.add(JtextAnioInicio);

		JLabel lblAnio = new JLabel("A\u00F1o");
		lblAnio.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnio.setBounds(230, 49, 32, 14);
		contentPane.add(lblAnio);

		JLabel lblDia_1 = new JLabel("D\u00EDa");
		lblDia_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDia_1.setBounds(118, 101, 32, 14);
		contentPane.add(lblDia_1);

		JtextDiaFin = new JTextField();
		JtextDiaFin.setColumns(10);
		JtextDiaFin.setBounds(118, 113, 32, 20);
		contentPane.add(JtextDiaFin);

		JLabel lblMes_1_2 = new JLabel("-");
		lblMes_1_2.setBounds(160, 116, 4, 14);
		contentPane.add(lblMes_1_2);

		JtextMesFin = new JTextField();
		JtextMesFin.setColumns(10);
		JtextMesFin.setBounds(174, 113, 32, 20);
		contentPane.add(JtextMesFin);

		JLabel lblMes_2 = new JLabel("Mes");
		lblMes_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMes_2.setBounds(174, 101, 32, 14);
		contentPane.add(lblMes_2);

		JLabel lblMes_1_1_1 = new JLabel("-");
		lblMes_1_1_1.setBounds(216, 116, 4, 14);
		contentPane.add(lblMes_1_1_1);

		JtextAnioFin = new JTextField();
		JtextAnioFin.setColumns(10);
		JtextAnioFin.setBounds(230, 113, 32, 20);
		contentPane.add(JtextAnioFin);

		JLabel lblAnio_1 = new JLabel("A\u00F1o");
		lblAnio_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnio_1.setBounds(230, 101, 32, 14);
		contentPane.add(lblAnio_1);

		JButton btnNewButton = new JButton("Consultar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDateTime inicio = LocalDateTime.of(Integer.parseInt(JtextAnioInicio.getText()),
						Integer.parseInt(JtextMesInicio.getText()), Integer.parseInt(JtextDiaInicio.getText()), 0, 0);

				LocalDateTime fin = LocalDateTime.of(Integer.parseInt(JtextAnioFin.getText()),
						Integer.parseInt(JtextMesFin.getText()), Integer.parseInt(JtextDiaFin.getText()), 0, 0);

				UiListadoVentas vistaListadoVentas = new UiListadoVentas(repo, inicio, fin);
				vistaListadoVentas.setVisible(true);

			}
		});
		btnNewButton.setBounds(61, 171, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnAtras.setBounds(224, 171, 89, 23);
		contentPane.add(btnAtras);

		JLabel fecha_inicio_1 = new JLabel("                         X        -        X       -     XXXX");
		fecha_inicio_1.setForeground(Color.BLACK);
		fecha_inicio_1.setBounds(56, 24, 244, 14);
		contentPane.add(fecha_inicio_1);

		JLabel fecha_inicio_2 = new JLabel("Ingrese el ");
		fecha_inicio_2.setBounds(29, 11, 79, 14);
		contentPane.add(fecha_inicio_2);

		JLabel fecha_inicio_2_1 = new JLabel("sig formato:");
		fecha_inicio_2_1.setBounds(29, 26, 89, 14);
		contentPane.add(fecha_inicio_2_1);
	}
}
