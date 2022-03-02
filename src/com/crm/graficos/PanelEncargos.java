package com.crm.graficos;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.*;

import com.crm.funcionalidades.giveFecha;
import com.crm.persistencias.ConfigDir;
import com.crm.persistencias.MisConexiones;
import com.crm.pojos.Encargos;
import com.crm.wordprocessing.WordProcessing;

@SuppressWarnings("serial")
public class PanelEncargos extends JPanel implements Serializable {
	DefaultTableModel dtm;
	private JTable tabla;
	private int j;
	private JTextField c1, c2, dni1, dni2, fecha, domicilio, email1, telefono,ciudad;
	private JComboBox<String> asunto, email, receptor;
	private JButton ver, reg, borrar, imprimir;

	public PanelEncargos() throws SQLException {
		setLayout(new BorderLayout());
		add(PanelNorte(), BorderLayout.NORTH);
		add(PanelSur(), BorderLayout.SOUTH);
	}

	public JPanel PanelNorte() throws SQLException {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setPreferredSize(new Dimension(1280, 150));
		panel.add(Box.createRigidArea(new Dimension(0, 3)));
		panel.setBorder(BorderFactory.createLoweredBevelBorder());

		panel.add(PanelNorte1(), BorderLayout.NORTH);
		panel.add(PanelNorte2(), BorderLayout.SOUTH);
		return panel;
	}

	@SuppressWarnings("unchecked")
	public JPanel PanelNorte1() throws SQLException {
		JPanel norte = new JPanel();
		norte.setLayout(new FlowLayout(FlowLayout.CENTER));
		norte.setPreferredSize(new Dimension(900, 47));
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
		// String[] gp2 = new String[] { "hipotecas", "Credito Personal", "Tarjeta de
		// Envio" };
		email = new JComboBox<String>(dameEmails());
		email.setAlignmentX(Component.CENTER_ALIGNMENT);
		email.setMaximumSize(new Dimension(100, 200));
		norte.add(email);
		norte.add(Box.createRigidArea(new Dimension(0, 3)));

		JLabel rep = new JLabel("Receptor: ");
		rep.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte.add(rep);
		norte.add(Box.createRigidArea(new Dimension(0, 3)));
		//String[] gp3 = new String[] { "Jose angel", "Luis alberto", "Luisa maria" };
		receptor = new JComboBox<String>(dameNombre());
		receptor.setAlignmentX(Component.CENTER_ALIGNMENT);
		receptor.setMaximumSize(new Dimension(100, 200));
		norte.add(receptor);
		norte.add(Box.createRigidArea(new Dimension(0, 3)));

		ver = new JButton("Ver Tabla");
		ver.addActionListener(new GestorVer());
		ver.setMaximumSize(new Dimension(170, 30));
		ver.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte.add(ver);
		norte.add(Box.createRigidArea(new Dimension(0, 3)));

		reg = new JButton("Registrar");
		reg.addActionListener(new GestorAñadir());
		reg.setMaximumSize(new Dimension(170, 30));
		reg.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte.add(reg);
		norte.add(Box.createRigidArea(new Dimension(0, 3)));

		borrar = new JButton("Borrar");
		borrar.addActionListener(new GestorBorrar());
		borrar.setMaximumSize(new Dimension(170, 30));
		borrar.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte.add(borrar);
		norte.add(Box.createRigidArea(new Dimension(0, 3)));
		
		imprimir = new JButton("Imprimir");
		imprimir.addActionListener(new GestorImprimir());
		imprimir.setMaximumSize(new Dimension(170, 30));
		imprimir.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte.add(imprimir);
		norte.add(Box.createRigidArea(new Dimension(0, 3)));
		
		return norte;
	}

	public JPanel PanelNorte2() {
		JPanel norte2 = new JPanel();
		norte2.setLayout(new FlowLayout(FlowLayout.CENTER));
		norte2.setPreferredSize(new Dimension(300, 100));
		JLabel cli = new JLabel(" Cliente:   ");
		cli.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(cli);
		norte2.add(Box.createRigidArea(new Dimension(0, 3)));
		c1 = new JTextField(20);
		norte2.setMaximumSize(new Dimension(110, 70));
		norte2.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(c1);

		JLabel dni = new JLabel(" Dni/nie:   ");
		dni.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(dni);
		norte2.add(Box.createRigidArea(new Dimension(0, 3)));
		dni1 = new JTextField(20);
		norte2.setMaximumSize(new Dimension(110, 70));
		norte2.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(dni1);

		JLabel cli2 = new JLabel(" Cliente2:  ");
		cli2.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(cli2);
		norte2.add(Box.createRigidArea(new Dimension(0, 3)));
		c2 = new JTextField(22);
		norte2.setMaximumSize(new Dimension(110, 70));
		norte2.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(c2);

		JLabel dnie2 = new JLabel(" Dni/nie2: ");
		dnie2.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(dnie2);
		norte2.add(Box.createRigidArea(new Dimension(0, 3)));
		dni2 = new JTextField(22);
		norte2.setMaximumSize(new Dimension(100, 70));
		norte2.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(dni2);

		JLabel fc = new JLabel(" Fecha: ");
		fc.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(fc);
		norte2.add(Box.createRigidArea(new Dimension(0, 3)));
		fecha = new JTextField(12);
		norte2.setMaximumSize(new Dimension(50, 70));
		norte2.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(fecha);

		JLabel dom = new JLabel(" Domicilio: ");
		dom.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(dom);
		norte2.add(Box.createRigidArea(new Dimension(0, 3)));
		domicilio = new JTextField(24);
		norte2.setMaximumSize(new Dimension(100, 70));
		norte2.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(domicilio);

		JLabel em = new JLabel(" email: ");
		em.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(em);
		norte2.add(Box.createRigidArea(new Dimension(0, 3)));
		email1 = new JTextField(20);
		norte2.setMaximumSize(new Dimension(100, 70));
		norte2.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(email1);

		JLabel tel = new JLabel(" Telefono: ");
		tel.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(tel);
		norte2.add(Box.createRigidArea(new Dimension(0, 3)));
		telefono = new JTextField(10);
		norte2.setMaximumSize(new Dimension(100, 70));
		norte2.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(telefono);
		
		JLabel ciu = new JLabel(" Ciudad: ");
		ciu.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(ciu);
		norte2.add(Box.createRigidArea(new Dimension(0, 3)));
		ciudad = new JTextField(14);
		norte2.setMaximumSize(new Dimension(100, 70));
		norte2.setAlignmentX(Component.CENTER_ALIGNMENT);
		norte2.add(ciudad);

		return norte2;
	}

	public JScrollPane PanelSur() {
		dtm = new DefaultTableModel();
		
		dtm.addColumn("receptor");
		dtm.addColumn("fecha");
		dtm.addColumn("expediente");
		dtm.addColumn("cliente1");
		dtm.addColumn("dni_nie1");
		dtm.addColumn("asunto");
		dtm.addColumn("domicilio");
		dtm.addColumn("cliente2");
		dtm.addColumn("dni_nie2");
		
		tabla = new JTable(dtm);
		// tabla.addMouseListener(new GestorTabla());
		TableColumn column = null;
		for (int i = 0; i < dtm.getColumnCount(); i++) {
			column = tabla.getColumnModel().getColumn(i);
			column.setMinWidth(100);
			column.setPreferredWidth(200);
		}
		tabla.setBounds(0, 0, 1280, 751);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane sp = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setPreferredSize(new Dimension(1280, 751));
		sp.setBorder(BorderFactory.createLoweredBevelBorder());
		return sp;
	}// ver tabla

	public class GestorAñadir implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			int result = JOptionPane.showConfirmDialog(null,
					"Esta a punto de añadir un nuevo Encargo ¿Desea continuar?", "Confirmar", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, null);
			if (result == JOptionPane.YES_OPTION) {
				try {
					MisConexiones mc = null;
					mc = new MisConexiones();
					mc.damePSSimple4(ConfigDir.getInstance().getProperty("consulta15"),
							receptor.getSelectedItem().toString(), new Timestamp(new java.util.Date().getTime()),
							c1.getText(), dni1.getText(), asunto.getSelectedItem().toString(), domicilio.getText(),
							c2.getText(), dni2.getText()).execute();
					mc.cierraConexion(null);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e3) {
					e3.printStackTrace();
				}
			}
		}
	}

	public class GestorVer implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Vector<Object> v = null;
			Encargos en = null;
			ResultSet rs = null;
			dtm.setRowCount(0);
			try {
				rs= new MisConexiones().dameResultSetSimple(ConfigDir.getInstance().getProperty("consulta16"));
				while (rs.next()) {
					v = new Vector<Object>();
					en = new Encargos();
					en.setReceptor(rs.getString("receptor"));
					en.setFecha(rs.getTimestamp("fecha"));
					en.setExpediente(rs.getInt("expediente"));
					en.setCliente1(rs.getString("cliente1"));
					en.setDni_nie(rs.getString("dni_nie"));
					en.setAsunto(rs.getString("asunto"));
					en.setDomicilio(rs.getString("domicilio"));
					en.setCliente2(rs.getString("cliente2"));
					en.setDni_nie2(rs.getString("dni_nie2"));

					v.addElement(en.getReceptor());
					v.addElement(new giveFecha().formateoDateAqui(en.getFecha()));
					v.addElement(en.getExpediente());
					v.addElement(en.getCliente1());
					v.addElement(en.getDni_nie());
					v.addElement(en.getAsunto());
					v.addElement(en.getDomicilio());
					v.addElement(en.getCliente2());
					v.addElement(en.getDni_nie2());
				}
			}catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}// fin del gestor ver
	
	public class GestorImprimir implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			WordProcessing.createNewDocumentFromTemplate("encargo.dotx");
			WordProcessing.typeTextAtBookmark("sitio", ciudad.getText());
			WordProcessing.typeTextAtBookmark("fecha", fecha.getText());
			WordProcessing.typeTextAtBookmark("nom1", c1.getText());
			WordProcessing.typeTextAtBookmark("nom2", c2.getText());
			WordProcessing.typeTextAtBookmark("dninieuno", dni1.getText());
			WordProcessing.typeTextAtBookmark("dniniedos", dni2.getText());
			WordProcessing.typeTextAtBookmark("domicilio", domicilio.getText());
			WordProcessing.typeTextAtBookmark("emailCorp1", email.getSelectedItem().toString());
			WordProcessing.typeTextAtBookmark("tfno", telefono.getText());
			WordProcessing.typeTextAtBookmark("emailCorp2", email1.getText());

			WordProcessing.saveDocumentAsAndClose(c1.getText());
			WordProcessing.exec();
			try {
				CrearEstructuraFichero(c1.getText());
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("error al crear estructura");
			}
		}

		private void CrearEstructuraFichero(String nombreArch) throws FileNotFoundException, IOException {
			File fl = new File("C:/Users/dam/Documents/Encargos/" + c1.getText());
			fl.mkdirs();
			File ini = new File("C:/Users/dam/Documents/" + nombreArch + ".docx");
			FileInputStream origen = new FileInputStream(ini);
			FileOutputStream destino = new FileOutputStream(
					"C:/Users/dam/Documents/Encargos/" + c1.getText() + "/" + nombreArch + ".docx");
			byte[] buff = new byte[1024];
			int longa = 0;
			while ((longa = origen.read(buff)) > 0) {
				destino.write(buff, 0, longa);
			}
			origen.close();
			destino.close();
			ini.delete();
		}
	}// gestor imprimir

	public class GestorBorrar implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			JFrame marcoBorrar = new JFrame("Borrar Encargos");
			marcoBorrar.setLocationRelativeTo(null);
			marcoBorrar.setSize(350, 200);
			JPanel panelUsuario = new JPanel();
			marcoBorrar.add(panelUsuario);
			panelUsuario.setLayout(new BoxLayout(panelUsuario, BoxLayout.Y_AXIS));
			JLabel add_txt = new JLabel("Esta a punto de borrar a un encargo ¿Desea Continuar?");
			add_txt.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelUsuario.add(add_txt);
			panelUsuario.add(Box.createRigidArea(new Dimension(0, 3)));

			JTextField idBorrar = new JTextField(40);
			idBorrar.setMaximumSize(new Dimension(70, 20));
			idBorrar.setAlignmentX(Component.CENTER_ALIGNMENT);
			idBorrar.setText("" + c1.getText());
			panelUsuario.add(idBorrar);
			panelUsuario.add(Box.createRigidArea(new Dimension(0, 3)));

			JTextField NmbreBorrar = new JTextField(40);
			NmbreBorrar.setMaximumSize(new Dimension(120, 20));
			NmbreBorrar.setAlignmentX(Component.CENTER_ALIGNMENT);
			NmbreBorrar.setText("" + dni1.getText());
			panelUsuario.add(NmbreBorrar);
			panelUsuario.add(Box.createRigidArea(new Dimension(0, 3)));

			JButton si = new JButton("Si");
			si.setAlignmentX(Component.CENTER_ALIGNMENT);
			si.setMaximumSize(new Dimension(50, 25));
			panelUsuario.add(si);
			panelUsuario.add(Box.createRigidArea(new Dimension(0, 3)));

			JButton no = new JButton("No");
			no.setAlignmentX(Component.CENTER_ALIGNMENT);
			no.setMaximumSize(new Dimension(50, 25));
			panelUsuario.add(no);
			panelUsuario.add(Box.createRigidArea(new Dimension(0, 3)));
			marcoBorrar.setVisible(true);

			si.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					try {
						j = tabla.getSelectedRow();
						int aux = (Integer) dtm.getValueAt(j, 0);
						new MisConexiones().Borrar(ConfigDir.getInstance().getProperty("consulta17"), aux).execute();

					} catch (Exception e1) {
						e1.printStackTrace();

					}

					marcoBorrar.setVisible(false);
					marcoBorrar.dispose();
				}
			});
			no.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					marcoBorrar.setVisible(false);
					marcoBorrar.dispose();
					marcoBorrar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			});

		}
	}// fin del borrar

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector dameEmails() throws SQLException {
		Vector v = new Vector();
		try {
			ResultSet rs = new MisConexiones().dameResultSetSimple(ConfigDir.getInstance().getProperty("consulta13"));
			while (rs.next()) {
				v.addElement(rs.getString("Email"));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return v;
	}// fin del dameEmail

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Vector dameNombre() throws SQLException {
		Vector v = new Vector();
		try {
			ResultSet rs = new MisConexiones().dameResultSetSimple(ConfigDir.getInstance().getProperty("consulta14"));
			while (rs.next()) {
				v.addElement(rs.getString("Nombre") + "," + rs.getString("Apellidos"));
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return v;
	}// fin del dameNombre
	
	public class GestorTabla extends MouseAdapter {
		public void mouseReleased(MouseEvent e) {
			int j = tabla.getSelectedRow();
			/*String entero = (String) dtm.getValueAt(j, 0);
			receptor.setText("" + entero);*/
			String DEntero = (String) dtm.getValueAt(j, 1);
			fecha.setText("" + DEntero);
			String NomEntero = (String) dtm.getValueAt(j, 2);
			c1.setText("" + NomEntero);
			String ApEntero = (String) dtm.getValueAt(j, 3);
			dni1.setText("" + ApEntero);
			/*int TlfEntero = (int) dtm.getValueAt(j, 4);
			asunto.setText("" + TlfEntero);*/
			String EmailEntero = (String) dtm.getValueAt(j, 5);
			domicilio.setText("" + EmailEntero);
			String DirEntero = (String) dtm.getValueAt(j, 6);
			c2.setText("" + DirEntero);
			String CDEntero = (String) dtm.getValueAt(j, 7);
			dni2.setText("" + CDEntero);
			}
		}//fin del gestor tabla

}
