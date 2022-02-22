package com.crm.graficos;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;

@SuppressWarnings("serial")
public class PanelEncargos extends JPanel implements Serializable {
	DefaultTableModel dtm;
	private JTable tabla;
	private JTextField c1, c2, dni1, dni2, fecha, domicilio;
	private JComboBox<String> asunto, email, receptor;
	private JButton ver, reg, borrar, imprimir;

	public PanelEncargos() {
		setLayout(new BorderLayout());
		add(PanelNorte(), BorderLayout.NORTH);
		add(PanelSur(), BorderLayout.SOUTH);
	}

	private JPanel PanelNorte() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setPreferredSize(new Dimension(1280, 150));
		panel.add(Box.createRigidArea(new Dimension(0, 3)));
		panel.setBorder(BorderFactory.createLoweredBevelBorder());

		panel.add(PanelNorte1(), BorderLayout.NORTH);
		panel.add(PanelNorte2(), BorderLayout.SOUTH);
		return panel;
	}

	private JPanel PanelNorte1() {
		JPanel norte = new JPanel();
		norte.setLayout(new FlowLayout(FlowLayout.CENTER));
		norte.setPreferredSize(new Dimension(1280, 47));
		JLabel ast = new JLabel("Asunto: ");
		ast.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte.add(ast);
		norte.add(Box.createRigidArea(new Dimension(0, 3)));
		String[] gp1 = new String[] { "hipotecas", "Credito Personal", "Tarjeta de Envio" };
		asunto = new JComboBox<String>(gp1);
		asunto.setAlignmentX(Component.CENTER_ALIGNMENT);
		asunto.setMaximumSize(new Dimension(100, 200));
		norte.add(asunto);
		norte.add(Box.createRigidArea(new Dimension(0, 3)));

		JLabel ems = new JLabel("Emails: ");
		ems.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte.add(ems);
		norte.add(Box.createRigidArea(new Dimension(0, 3)));
		String[] gp2 = new String[] { "hipotecas", "Credito Personal", "Tarjeta de Envio" };
		email = new JComboBox<String>(gp2);
		email.setAlignmentX(Component.CENTER_ALIGNMENT);
		email.setMaximumSize(new Dimension(100, 200));
		norte.add(email);
		norte.add(Box.createRigidArea(new Dimension(0, 3)));

		JLabel rep = new JLabel("Receptor: ");
		rep.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte.add(rep);
		norte.add(Box.createRigidArea(new Dimension(0, 3)));
		String[] gp3 = new String[] { "hipotecas", "Credito Personal", "Tarjeta de Envio" };
		receptor = new JComboBox<String>(gp3);
		receptor.setAlignmentX(Component.CENTER_ALIGNMENT);
		receptor.setMaximumSize(new Dimension(100, 200));
		norte.add(receptor);
		norte.add(Box.createRigidArea(new Dimension(0, 3)));

		ver = new JButton("Ver Tabla");
		// ver.addActionListener(new GestorVer());
		ver.setMaximumSize(new Dimension(170, 30));
		ver.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte.add(ver);
		norte.add(Box.createRigidArea(new Dimension(0, 3)));

		reg = new JButton("Registrar");
		// ver.addActionListener(new GestorVer());
		reg.setMaximumSize(new Dimension(170, 30));
		reg.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte.add(ver);
		norte.add(Box.createRigidArea(new Dimension(0, 3)));

		return norte;
	}

	private JPanel PanelNorte2() {
		JPanel norte2 = new JPanel();
		norte2.setLayout(new FlowLayout(FlowLayout.CENTER));
		norte2.setPreferredSize(new Dimension(1280, 100));
		JLabel cli = new JLabel(" Cliente: ");
		cli.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(cli);
		norte2.add(Box.createRigidArea(new Dimension(10, 3)));
		c1 = new JTextField(24);
		norte2.setMaximumSize(new Dimension(100, 70));
		norte2.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(c1);

		JLabel dni = new JLabel(" Dni/nie: ");
		dni.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(dni);
		norte2.add(Box.createRigidArea(new Dimension(10, 3)));
		dni1 = new JTextField(24);
		norte2.setMaximumSize(new Dimension(100, 70));
		norte2.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(dni1);

		JLabel cli2 = new JLabel(" Cliente2: ");
		cli2.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(cli2);
		norte2.add(Box.createRigidArea(new Dimension(10, 3)));
		c2 = new JTextField(24);
		norte2.setMaximumSize(new Dimension(100, 70));
		norte2.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(c2);

		JLabel dnie2 = new JLabel(" Dni/nie2: ");
		dnie2.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(dnie2);
		norte2.add(Box.createRigidArea(new Dimension(10, 3)));
		dni2 = new JTextField(24);
		norte2.setMaximumSize(new Dimension(100, 70));
		norte2.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(dni2);

		JLabel fc = new JLabel(" Fecha: ");
		fc.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(fc);
		norte2.add(Box.createRigidArea(new Dimension(10, 3)));
		fecha = new JTextField(24);
		norte2.setMaximumSize(new Dimension(100, 70));
		norte2.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(fecha);

		borrar = new JButton("Borrar");
		// ver.addActionListener(new GestorVer());
		borrar.setMaximumSize(new Dimension(170, 30));
		borrar.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(borrar);
		norte2.add(Box.createRigidArea(new Dimension(0, 3)));

		JLabel dom = new JLabel(" Domicilio: ");
		dom.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(dom);
		norte2.add(Box.createRigidArea(new Dimension(10, 3)));
		domicilio = new JTextField(24);
		norte2.setMaximumSize(new Dimension(100, 70));
		norte2.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(domicilio);

		imprimir = new JButton("Imprimir");
		// ver.addActionListener(new GestorVer());
		imprimir.setMaximumSize(new Dimension(170, 30));
		imprimir.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(imprimir);
		norte2.add(Box.createRigidArea(new Dimension(0, 3)));
		return norte2;
	}

	private JScrollPane PanelSur() {
		dtm = new DefaultTableModel();
		// panel oeste
		dtm.addColumn("receptor");
		dtm.addColumn("fecha");
		dtm.addColumn("expediente");
		dtm.addColumn("cliente1");
		dtm.addColumn("dni_nie1");
		dtm.addColumn("cliente2");
		dtm.addColumn("dni_nie2");

		tabla = new JTable(dtm);
		// tabla.addMouseListener(new GestorTabla());
		TableColumn column = null;
		for (int i = 0; i < dtm.getColumnCount(); i++) {
			column = tabla.getColumnModel().getColumn(i);
			column.setMinWidth(188);
			column.setPreferredWidth(206);
		}
		tabla.setBounds(0, 0, 1280, 780);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane sp = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setPreferredSize(new Dimension(1280, 780));
		sp.setBorder(BorderFactory.createLoweredBevelBorder());
		return sp;
	}// ver tabla

}
