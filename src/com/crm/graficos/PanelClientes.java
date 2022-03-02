package com.crm.graficos;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;
import com.crm.auxiliares.Servicios;
import com.crm.funcionalidades.giveFecha;
import com.crm.persistencias.ConfigDir;
import com.crm.persistencias.MisConexiones;
import com.crm.pojos.Cliente;

@SuppressWarnings("serial")
public class PanelClientes extends JPanel implements Serializable, Servicios {
	DefaultTableModel dtm;
	private JLabel etNotas;
	ArrayList<JButton> botones;
	private JTextField txtId, txtDni, txtNom, txtAp, txtTlf, txtMail, txtDir, txtCiudad, txtFechaAlta, txtCodigoPostal,
			txtNotas;
	private int grupoPermisos, id,j;
	private JCheckBox check1, check2, edit;
	private JTable tabla;
	private JMenu prueba2, prueba1;
	private JMenuBar menu;

	public PanelClientes() {
		setLayout(new BorderLayout());
		add(creaTabla(), BorderLayout.CENTER);
		add(crearJmenu(), BorderLayout.NORTH);
		add(crearPanelEste(creaPanelDatos(), creaPanelControl()), BorderLayout.EAST);
		reseteo();

	}

	public JMenuBar crearJmenu() {
		menu = new JMenuBar();
		prueba1 = new JMenu("Abrir");
		prueba2 = new JMenu("Buscar");
		JMenuItem prueba11 = new JMenuItem("Google");
		prueba11.addActionListener(new Google());
		JMenuItem prueba12 = new JMenuItem("Calculadora");
		prueba12.addActionListener(new Calculadora());
		JMenuItem prueba21 = new JMenuItem("Nombre");
		prueba21.addActionListener(new GestorNombre());
		JMenuItem prueba22 = new JMenuItem("Apellido");
		prueba22.addActionListener(new GestorApellido());
		JMenuItem prueba23 = new JMenuItem("Residente");
		prueba23.addActionListener(new GestorRes());
		JMenuItem prueba24 = new JMenuItem("Autonomo");
		prueba24.addActionListener(new GestorAu());
		menu.add(prueba1);
		menu.add(prueba2);
		prueba1.add(prueba11);
		prueba1.add(prueba12);
		prueba2.add(prueba21);
		prueba2.add(prueba22);
		prueba2.add(prueba23);
		prueba2.add(prueba24);

		return menu;
	}

	public JPanel creaPanelDatos() {
		JPanel dt = new JPanel();
		dt.setPreferredSize(new Dimension(180, 600));
		dt.setLayout(new BoxLayout(dt, BoxLayout.Y_AXIS));
		dt.add(Box.createRigidArea(new Dimension(0, 3)));

		JLabel etId = new JLabel("Id_cliente");
		etId.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(etId);
		dt.add(Box.createRigidArea(new Dimension(0, 3)));
		txtId = new JTextField();
		txtId.setMaximumSize(new Dimension(150, 35));
		txtId.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(txtId);

		JLabel etDni = new JLabel("Dni_nie");
		etDni.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(etDni);
		dt.add(Box.createRigidArea(new Dimension(0, 3)));
		txtDni = new JTextField();
		txtDni.setMaximumSize(new Dimension(150, 35));
		txtDni.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(txtDni);

		JLabel etNom = new JLabel("Nombre");
		etNom.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(etNom);
		dt.add(Box.createRigidArea(new Dimension(0, 3)));
		txtNom = new JTextField(30);
		txtNom.setMaximumSize(new Dimension(150, 35));
		txtNom.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(txtNom);

		JLabel etAp = new JLabel("Apellidos");
		etAp.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(etAp);
		dt.add(Box.createRigidArea(new Dimension(0, 3)));
		txtAp = new JTextField(30);
		txtAp.setMaximumSize(new Dimension(150, 35));
		txtAp.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(txtAp);

		JLabel etTlf = new JLabel("Teléfono_fijo");
		etTlf.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(etTlf);
		dt.add(Box.createRigidArea(new Dimension(0, 3)));
		txtTlf = new JTextField(30);
		txtTlf.setMaximumSize(new Dimension(150, 35));
		txtTlf.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(txtTlf);

		JLabel etMail = new JLabel("Email");
		etMail.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(etMail);
		dt.add(Box.createRigidArea(new Dimension(0, 3)));
		txtMail = new JTextField(30);
		txtMail.setMaximumSize(new Dimension(150, 35));
		txtMail.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(txtMail);

		JLabel etDireccion = new JLabel("Direccion_Vivienda");
		etDireccion.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(etDireccion);
		dt.add(Box.createRigidArea(new Dimension(0, 3)));
		txtDir = new JTextField(30);
		txtDir.setMaximumSize(new Dimension(150, 35));
		txtDir.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(txtDir);

		JLabel etCiudad = new JLabel("Ciudad");
		etCiudad.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(etCiudad);
		dt.add(Box.createRigidArea(new Dimension(0, 3)));
		txtCiudad = new JTextField(30);
		txtCiudad.setMaximumSize(new Dimension(150, 50));
		txtCiudad.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(txtCiudad);

		JLabel etCodigoPostal = new JLabel("Codigo Postal");
		etCodigoPostal.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(etCodigoPostal);
		dt.add(Box.createRigidArea(new Dimension(0, 3)));
		txtCodigoPostal = new JTextField(30);
		txtCodigoPostal.setMaximumSize(new Dimension(150, 35));
		txtCodigoPostal.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(txtCodigoPostal);

		JLabel etFechaAlta = new JLabel("Fecha Alta");
		etFechaAlta.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(etFechaAlta);
		dt.add(Box.createRigidArea(new Dimension(0, 3)));
		txtFechaAlta = new JTextField(30);
		txtFechaAlta.setMaximumSize(new Dimension(150, 35));
		txtFechaAlta.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(txtFechaAlta);

		JLabel etResidente = new JLabel("Residente");
		etResidente.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(etResidente);
		dt.add(Box.createRigidArea(new Dimension(0, 3)));
		check1 = new JCheckBox("");
		check1.setMaximumSize(new Dimension(80, 35));
		check1.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(check1);

		JLabel etAutonomo = new JLabel("Autonomo");
		etAutonomo.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(etAutonomo);
		dt.add(Box.createRigidArea(new Dimension(0, 3)));
		check2 = new JCheckBox("");
		check2.setMaximumSize(new Dimension(80, 35));
		check2.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(check2);
		return dt;

	}

	public JPanel creaPanelControl() {
		JPanel ct = new JPanel();
		ct.setPreferredSize(new Dimension(200, 360));
		ct.setLayout(new BoxLayout(ct, BoxLayout.Y_AXIS));
		ct.add(Box.createRigidArea(new Dimension(0, 3)));
		ct.setBorder(BorderFactory.createLoweredBevelBorder());
		JButton ver = new JButton("Ver");
		ver.addActionListener(new GestorVer());
		JButton add = new JButton("Añadir");
		add.addActionListener(new GestorAñadir());
		JButton br = new JButton("Borrar");
		br.addActionListener(new GestorBorrar());
		JButton act = new JButton("Acutalizar");
		act.addActionListener(new GestorActualizar());
		JButton cs = new JButton("Cerrar Sesion");
		cs.addActionListener(new GestorCierrarSesion());
		botones = new ArrayList<JButton>();
		botones.add(ver);
		botones.add(add);
		botones.add(br);
		botones.add(act);
		botones.add(cs);
		edit = new JCheckBox("Iniciar Sesion");
		edit.addActionListener(new GestorEdicion());

		for (int c = 0; c < botones.size() + 1; c++) {
			if (c < botones.size()) {
				botones.get(c).setMaximumSize(new Dimension(175, 30));
				ct.add(botones.get(c));
			} else
				ct.add(edit);
			ct.add(Box.createRigidArea(new Dimension(0, 3)));

		}
		botones.get(0).addActionListener(new GestorVer());
		botones.get(1).addActionListener(new GestorAñadir());
		botones.get(2).addActionListener(new GestorBorrar());
		botones.get(3).addActionListener(new GestorActualizar());
		botones.get(4).addActionListener(new GestorCierrarSesion());

		etNotas = new JLabel("Notas");
		etNotas.setAlignmentX(Component.LEFT_ALIGNMENT);
		ct.add(etNotas);
		ct.add(Box.createRigidArea(new Dimension(0, 3)));
		txtNotas = new JTextField(30);
		txtNotas.setMaximumSize(new Dimension(150, 170));
		txtNotas.setAlignmentX(Component.LEFT_ALIGNMENT);
		ct.add(txtNotas);
		return ct;
	}

	public JPanel crearPanelEste(JPanel p1, JPanel p2) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(p1, BorderLayout.NORTH);
		panel.add(p2, BorderLayout.CENTER);
		return panel;
	}

	public JScrollPane creaTabla() {

		dtm = new DefaultTableModel();
		dtm.addColumn("id_cliente");
		dtm.addColumn("Dni_nie");
		dtm.addColumn("Nombre");
		dtm.addColumn("Apellidos");
		dtm.addColumn("Teléfono_fijo");
		dtm.addColumn("Email");
		dtm.addColumn("Direccion_vivienda");
		dtm.addColumn("Ciudad");
		dtm.addColumn("CP");
		dtm.addColumn("Fecha_alta");
		dtm.addColumn("residente");
		dtm.addColumn("autonomo");

		tabla = new JTable(dtm);
		JScrollPane sp = new JScrollPane(tabla);
		tabla.addMouseListener(new GestorTabla());
		sp.setPreferredSize(new Dimension(1024, 819));
		return sp;
	}

	public class GestorVer implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Vector<Object> v = null;
			Cliente c = null;
			ResultSet rs = null;
			dtm.setRowCount(0);
			try {
				rs = new MisConexiones().dameResultSetSimple(ConfigDir.getInstance().getProperty("consulta1"));
				while (rs.next()) {
					v = new Vector<Object>();
					c = new Cliente();

					c.setId_cliente(rs.getInt("id_cliente"));
					c.setDni_nie(rs.getString("Dni_nie"));
					c.setNombre(rs.getString("Nombre"));
					c.setApellidos(rs.getString("Apellidos"));
					c.setTelefono_fijo(rs.getInt("Teléfono_fijo"));
					c.setEmail(rs.getString("Email"));
					c.setDireccion_vivienda(rs.getString("Direccion_vivienda"));
					c.setCiudad(rs.getString("Ciudad"));
					c.setCP(rs.getInt("CP"));
					c.setFecha_alta(rs.getTimestamp("Fecha_alta"));
					c.setResidente(rs.getBoolean("residente"));
					c.setAutonomo(rs.getBoolean("autonomo"));
					v.addElement(c.getId_cliente());
					v.addElement(c.getDni_nie());
					v.addElement(c.getNombre());
					v.addElement(c.getApellidos());
					v.addElement(c.getTelefono_fijo());
					v.addElement(c.getEmail());
					v.addElement(c.getDireccion_vivienda());
					v.addElement(c.getCiudad());
					v.addElement(c.getCP());
					v.addElement(new giveFecha().formateoDateAqui(c.getFecha_alta()));
					if (c.getResidente())
						v.addElement("Si");
					else
						v.addElement("No");
					if (c.getAutonomo())
						v.addElement("Si");
					else
						v.addElement("No");
					dtm.addRow(v);

				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
	}

	public class GestorAñadir implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			boolean c1, c2;
			if (check1.isSelected())
				c1 = true;
			else
				c1 = false;
			if (check2.isSelected())
				c2 = true;
			else
				c2 = false;

			int result = JOptionPane.showConfirmDialog(null, "Esta a punto de añadir un nuevo cliente ¿Desea continuar?", "Confirmar",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null);
			if (result == JOptionPane.YES_OPTION) {
				try {
					MisConexiones mc = null;
					mc = new MisConexiones();
					mc.damePSSimple2(ConfigDir.getInstance().getProperty("consulta2"), txtDni.getText(),
							txtNom.getText(), txtAp.getText(), Integer.parseInt(txtTlf.getText()), txtMail.getText(),
							txtDir.getText(), txtCiudad.getText(), Integer.parseInt(txtCodigoPostal.getText()),
							new Timestamp(new java.util.Date().getTime()), c1, c2).execute();
					mc.cierraConexion(null);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e3) {
					e3.printStackTrace();
				}
			}
		}
	}

	public class GestorActualizar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			boolean c1, c2;
			if (check1.isSelected())
				c1 = true;
			else
				c1 = false;
			if (check2.isSelected())
				c2 = true;
			else
				c2 = false;
			try {
				int idAux = (Integer) dtm.getValueAt(id, 0);
				new MisConexiones().actualizarUsuario(ConfigDir.getInstance().getProperty("consulta4"),
						txtNom.getText(), txtAp.getText(), Integer.parseInt(txtTlf.getText()), txtMail.getText(),
						txtDir.getText(), txtCiudad.getText(), Integer.parseInt(txtCodigoPostal.getText()),
						Timestamp.valueOf(txtFechaAlta.getText()), c1, c2, idAux).execute();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e2) {
				e2.printStackTrace();
			}
		}
	}

	public class GestorBorrar implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			JFrame marcoBorrar = new JFrame("Borrar clientes");
			marcoBorrar.setLocationRelativeTo(null);
			marcoBorrar.setSize(350, 200);
			JPanel panelUsuario = new JPanel();
			marcoBorrar.add(panelUsuario);
			panelUsuario.setLayout(new BoxLayout(panelUsuario, BoxLayout.Y_AXIS));
			JLabel add_txt = new JLabel("Esta a punto de borrar a un cliente ¿Desea Continuar?");
			add_txt.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelUsuario.add(add_txt);
			panelUsuario.add(Box.createRigidArea(new Dimension(0, 3)));

			JTextField idBorrar = new JTextField(40);
			idBorrar.setMaximumSize(new Dimension(70, 20));
			idBorrar.setAlignmentX(Component.CENTER_ALIGNMENT);
			idBorrar.setText("" + txtId.getText());
			panelUsuario.add(idBorrar);
			panelUsuario.add(Box.createRigidArea(new Dimension(0, 3)));
			
			JTextField NmbreBorrar = new JTextField(40);
			NmbreBorrar.setMaximumSize(new Dimension(120, 20));
			NmbreBorrar.setAlignmentX(Component.CENTER_ALIGNMENT);
			NmbreBorrar.setText("" + txtNom.getText());
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
						new MisConexiones().Borrar(ConfigDir.getInstance().getProperty("consulta3"), aux)
								.execute();
						
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
	}//fin del borrar

	public class GestorTabla extends MouseAdapter {
		public void mouseReleased(MouseEvent e) {
			int j = tabla.getSelectedRow();
			id = j;
			int entero = (int) dtm.getValueAt(j, 0);
			txtId.setText("" + entero);
			String DEntero = (String) dtm.getValueAt(j, 1);
			txtDni.setText("" + DEntero);
			String NomEntero = (String) dtm.getValueAt(j, 2);
			txtNom.setText("" + NomEntero);
			String ApEntero = (String) dtm.getValueAt(j, 3);
			txtAp.setText("" + ApEntero);
			int TlfEntero = (int) dtm.getValueAt(j, 4);
			txtTlf.setText("" + TlfEntero);
			String EmailEntero = (String) dtm.getValueAt(j, 5);
			txtMail.setText("" + EmailEntero);
			String DirEntero = (String) dtm.getValueAt(j, 6);
			txtDir.setText("" + DirEntero);
			String CDEntero = (String) dtm.getValueAt(j, 7);
			txtCiudad.setText("" + CDEntero);
			int CPEntero = (int) dtm.getValueAt(j, 8);
			txtCodigoPostal.setText("" + CPEntero);
			String FAEntero = (String) dtm.getValueAt(j, 9);
			txtFechaAlta.setText("" + FAEntero);
			// Residente
			if ((String) dtm.getValueAt(j, 10) == "Si")
				check1.setSelected(true);
			else
				check1.setSelected(false);
			// Autonomo
			if ((String) dtm.getValueAt(j, 11) == "Si")
				check2.setSelected(true);
			else
				check2.setSelected(false);

		}
	}

	private void reseteo() {
		
		dtm.setRowCount(0);
		txtId.setEditable(false);
		txtId.setText("");
		txtDni.setEditable(false);
		txtDni.setText("");
		txtNom.setEditable(false);
		txtNom.setText("");
		txtAp.setEditable(false);
		txtAp.setText("");
		txtTlf.setEditable(false);
		txtTlf.setText("");
		txtMail.setEditable(false);
		txtMail.setText("");
		txtDir.setEditable(false);
		txtDir.setText("");
		txtCiudad.setEditable(false);
		txtCiudad.setText("");
		txtCodigoPostal.setEditable(false);
		txtCodigoPostal.setText("");
		txtFechaAlta.setEditable(false);
		txtFechaAlta.setText("");
		check1.setEnabled(false);
		check1.setSelected(false);
		check2.setEnabled(false);
		check2.setSelected(false);
		for (int k = 0; k < botones.size(); k++)
			botones.get(k).setEnabled(false);
	}

	private void reset(int grupoPermisos) {
		switch (grupoPermisos) {
		case 1:
			reseteo();
			System.out.println("admin");
			txtId.setEditable(true);
			txtDni.setEditable(true);
			txtNom.setEditable(true);
			txtAp.setEditable(true);
			txtTlf.setEditable(true);
			txtMail.setEditable(true);
			txtDir.setEditable(true);
			txtCiudad.setEditable(true);
			txtCodigoPostal.setEditable(true);
			txtFechaAlta.setEditable(true);
			check1.setEnabled(true);
			check2.setEnabled(true);
			for (int k = 0; k < botones.size(); k++)
				botones.get(k).setEnabled(true);
			registarNuevoUsuario();
			break;
		case 2:
			reseteo();
			System.out.println("User avanzado");
			txtId.setEditable(true);
			txtDni.setEditable(true);
			txtNom.setEditable(true);
			txtAp.setEditable(true);
			txtTlf.setEditable(true);
			txtMail.setEditable(true);
			txtDir.setEditable(true);
			txtCiudad.setEditable(true);
			txtCodigoPostal.setEditable(true);
			txtFechaAlta.setEditable(true);
			check1.setEnabled(true);
			check2.setEnabled(true);
			botones.get(0).setEnabled(true);
			botones.get(1).setEnabled(true);
			botones.get(4).setEnabled(true);
			break;

		case 3:
			reseteo();
			System.out.println("User raso");
			txtId.setEditable(true);
			txtDni.setEditable(true);
			txtNom.setEditable(true);
			txtAp.setEditable(true);
			txtTlf.setEditable(true);
			txtMail.setEditable(true);
			txtDir.setEditable(true);
			txtCiudad.setEditable(true);
			txtCodigoPostal.setEditable(true);
			txtFechaAlta.setEditable(true);
			check1.setEnabled(true);
			check2.setEnabled(true);
			botones.get(0).setEnabled(true);
			botones.get(4).setEnabled(true);
			break;
		}
	}

	private void registarNuevoUsuario() {
		JFrame marcoUsuario = new JFrame("Añadir nuevo usuario");
		marcoUsuario.setLocationRelativeTo(null);
		marcoUsuario.setSize(400, 150);
		JPanel panelUsuario = new JPanel();
		marcoUsuario.add(panelUsuario);
		panelUsuario.setLayout(new BoxLayout(panelUsuario, BoxLayout.Y_AXIS));
		JLabel add_txt = new JLabel("¿Quieres crear un nuevo usuario?");
		add_txt.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelUsuario.add(add_txt);
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
		marcoUsuario.setVisible(true);

		si.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarDatos();
				marcoUsuario.setVisible(false);
				marcoUsuario.dispose();
			}
		});
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcoUsuario.setVisible(false);
				marcoUsuario.dispose();
			}
		});
	}

	private void registrarDatos() {
		JFrame usuario = new JFrame("Nuevo usuario");
		usuario.setLocationRelativeTo(null);
		usuario.setSize(400, 200);

		JPanel panelUsuario = new JPanel();
		usuario.add(panelUsuario);
		panelUsuario.setLayout(new BoxLayout(panelUsuario, BoxLayout.Y_AXIS));

		JLabel etAlias = new JLabel("Alias");
		JTextField alias_txt = new JTextField(10);
		JLabel etPass = new JLabel("Contraseña");
		JTextField pass_txt = new JTextField(10);
		JLabel etGrupo = new JLabel("Grupo permisos");
		JTextField grupo_txt = new JTextField(10);

		usuario.setVisible(true);

		ArrayList<JLabel> et = new ArrayList<JLabel>();
		et.add(etAlias);
		et.add(etPass);
		et.add(etGrupo);
		ArrayList<JTextField> txt = new ArrayList<JTextField>();
		txt.add(alias_txt);
		txt.add(pass_txt);
		txt.add(grupo_txt);

		for (int i = 0; i < et.size(); i++) {
			et.get(i).setAlignmentX(Component.CENTER_ALIGNMENT);
			panelUsuario.add(et.get(i));
			panelUsuario.add(Box.createRigidArea(new Dimension(0, 3)));
			txt.get(i).setMaximumSize(new Dimension(150, 25));
			txt.get(i).setAlignmentX(Component.CENTER_ALIGNMENT);
			panelUsuario.add(txt.get(i));
			panelUsuario.add(Box.createRigidArea(new Dimension(0, 3)));
		}

		txt.get(2).addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String datos[] = new String[3];
					for (int i = 0; i < et.size(); i++)
						datos[i] = txt.get(i).getText();
					new MisConexiones().insertarUsuario(ConfigDir.getInstance().getProperty("consulta10"), datos)
							.execute();
					JOptionPane.showMessageDialog(null, "Usuario añadido.", "Correcto",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
					JOptionPane.showMessageDialog(null, "Error al introducir los datos.", "Error",
							JOptionPane.ERROR_MESSAGE);
				} finally {
					usuario.setVisible(false);
					usuario.dispose();
				}
			}
		});
	}

	public class GestorEdicion implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String[] grupo = new String[] { "1", "2", "3" };
			JFrame marcoUsuario = new JFrame("Usuarios");
			marcoUsuario.setLocationRelativeTo(null);
			marcoUsuario.setSize(300, 220);
			JPanel panelUsuario = new JPanel();
			marcoUsuario.add(panelUsuario);
			panelUsuario.setLayout(new BoxLayout(panelUsuario, BoxLayout.Y_AXIS));
			JLabel usuario = new JLabel("Usuario");
			JLabel passwordLabel = new JLabel("Contraseña");
			JLabel grupos = new JLabel("Tipo de permiso");
			JTextField usuario_txt = new JTextField(10);
			JPasswordField password_txt = new JPasswordField(10);
			marcoUsuario.setVisible(true);

			if (marcoUsuario.isVisible())
				edit.setEnabled(false);

			usuario.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelUsuario.add(usuario);
			panelUsuario.add(Box.createRigidArea(new Dimension(0, 3)));
			usuario_txt.setMaximumSize(new Dimension(150, 25));
			usuario_txt.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelUsuario.add(usuario_txt);
			panelUsuario.add(Box.createRigidArea(new Dimension(0, 3)));

			passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelUsuario.add(passwordLabel);
			panelUsuario.add(Box.createRigidArea(new Dimension(0, 3)));
			password_txt.setMaximumSize(new Dimension(150, 25));
			password_txt.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelUsuario.add(password_txt);
			panelUsuario.add(Box.createRigidArea(new Dimension(0, 3)));

			grupos.setAlignmentX(Component.CENTER_ALIGNMENT);
			panelUsuario.add(grupos);
			panelUsuario.add(Box.createRigidArea(new Dimension(0, 3)));
			JComboBox<String> opciones = new JComboBox<String>(grupo);
			opciones.setAlignmentX(Component.CENTER_ALIGNMENT);
			opciones.setMaximumSize(new Dimension(150, 25));
			panelUsuario.add(opciones);
			panelUsuario.add(Box.createRigidArea(new Dimension(0, 3)));

			JButton login = new JButton("Iniciar Sesion");
			login.setAlignmentX(Component.CENTER_ALIGNMENT);
			login.setMaximumSize(new Dimension(150, 50));
			panelUsuario.add(login);
			panelUsuario.add(Box.createRigidArea(new Dimension(0, 3)));

			login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						char[] aux = password_txt.getPassword();
						String valorGrupo = String.valueOf(opciones.getSelectedItem());
						grupoPermisos = Integer.parseInt(valorGrupo);
						final String password = String.copyValueOf(aux);
						if (!(usuario_txt.getText().length() == 0) && !(password.length() == 0)) {
							ResultSet rs = new MisConexiones()
									.validarUser(ConfigDir.getInstance().getProperty("consulta9"),
											usuario_txt.getText(), password, grupoPermisos)
									.executeQuery();
							if (rs.next()) {
								JOptionPane.showMessageDialog(null, "Bienvenido " + usuario_txt.getText() + ".",
										"Correcto", JOptionPane.INFORMATION_MESSAGE);
								marcoUsuario.setVisible(false);
								marcoUsuario.dispose();
								if (!marcoUsuario.isVisible())
									edit.setEnabled(true);
								edit.setSelected(false);
								reset(grupoPermisos);
							} else {
								JOptionPane.showMessageDialog(null,
										"Los datos introducidos no coinciden con ningún usuario.", "Error",
										JOptionPane.ERROR_MESSAGE);
								marcoUsuario.setVisible(false);
								marcoUsuario.dispose();
								if (!marcoUsuario.isVisible())
									edit.setEnabled(true);
								edit.setSelected(false);
								reset(0);
							}
						} else {
							JOptionPane.showMessageDialog(null, "No ha introducido datos.", "Error",
									JOptionPane.ERROR_MESSAGE);
							marcoUsuario.setVisible(false);
							marcoUsuario.dispose();
							if (!marcoUsuario.isVisible())
								edit.setEnabled(true);
							edit.setSelected(false);
							reset(0);
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			marcoUsuario.addWindowListener(new WindowListener() {
				public void windowClosed(WindowEvent e) {
				}

				public void windowOpened(WindowEvent e) {
				}

				public void windowClosing(WindowEvent e) {
					marcoUsuario.setVisible(false);
					marcoUsuario.dispose();
					if (!marcoUsuario.isVisible())
						edit.setEnabled(true);
					edit.setSelected(false);
				}

				public void windowIconified(WindowEvent e) {
				}

				public void windowDeiconified(WindowEvent e) {
				}

				public void windowActivated(WindowEvent e) {
				}

				public void windowDeactivated(WindowEvent e) {
				}
			});
		}
	}

	public class GestorCierrarSesion implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			reseteo();
		}
	}

	public class Calculadora implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] comandito = new String[] { "calc.exe", "/c" };
			try {
				final Process proceso = Runtime.getRuntime().exec(comandito);
				if (proceso != null) {
					System.out.println("Creando Proceso...");
					proceso.waitFor();// duerme hilos para que el proceso se ejecute
					System.out.println(".......Bien!!!");
					System.out.println(proceso.exitValue());
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public class Google implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String[] comandito = new String[] { "microsoftedge", "http://www.google.es" };
			try {
				final Process proceso = Runtime.getRuntime().exec(comandito);
				if (proceso != null) {
					System.out.println("Creando Proceso...");
					proceso.waitFor();// duerme hilos para que el proceso se ejecute
					System.out.println(".......Bien!!!");
					System.out.println(proceso.exitValue());
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public class GestorNombre implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Vector<Object> v = null;
			Cliente c = null;
			ResultSet rs = null;
			dtm.setRowCount(0);
			try {
				rs = new MisConexiones().dameResultSetSimple(ConfigDir.getInstance().getProperty("consulta5"));
				while (rs.next()) {
					v = new Vector<Object>();
					c = new Cliente();

					c.setId_cliente(rs.getInt("id_cliente"));
					c.setDni_nie(rs.getString("Dni_nie"));
					c.setNombre(rs.getString("Nombre"));
					c.setApellidos(rs.getString("Apellidos"));
					c.setTelefono_fijo(rs.getInt("Teléfono_fijo"));
					c.setEmail(rs.getString("Email"));
					c.setDireccion_vivienda(rs.getString("Direccion_vivienda"));
					c.setCiudad(rs.getString("Ciudad"));
					c.setCP(rs.getInt("CP"));
					c.setFecha_alta(rs.getTimestamp("Fecha_alta"));
					c.setResidente(rs.getBoolean("residente"));
					c.setAutonomo(rs.getBoolean("autonomo"));
					v.addElement(c.getId_cliente());
					v.addElement(c.getDni_nie());
					v.addElement(c.getNombre());
					v.addElement(c.getApellidos());
					v.addElement(c.getTelefono_fijo());
					v.addElement(c.getEmail());
					v.addElement(c.getDireccion_vivienda());
					v.addElement(c.getCiudad());
					v.addElement(c.getCP());
					v.addElement(new giveFecha().formateoDateAqui(c.getFecha_alta()));
					if (c.getResidente())
						v.addElement("Si");
					else
						v.addElement("No");
					if (c.getAutonomo())
						v.addElement("Si");
					else
						v.addElement("No");
					dtm.addRow(v);

				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
	}

	public class GestorApellido implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Vector<Object> v = null;
			Cliente c = null;
			ResultSet rs = null;
			dtm.setRowCount(0);
			try {
				rs = new MisConexiones().dameResultSetSimple(ConfigDir.getInstance().getProperty("consulta6"));
				while (rs.next()) {
					v = new Vector<Object>();
					c = new Cliente();

					c.setId_cliente(rs.getInt("id_cliente"));
					c.setDni_nie(rs.getString("Dni_nie"));
					c.setNombre(rs.getString("Nombre"));
					c.setApellidos(rs.getString("Apellidos"));
					c.setTelefono_fijo(rs.getInt("Teléfono_fijo"));
					c.setEmail(rs.getString("Email"));
					c.setDireccion_vivienda(rs.getString("Direccion_vivienda"));
					c.setCiudad(rs.getString("Ciudad"));
					c.setCP(rs.getInt("CP"));
					c.setFecha_alta(rs.getTimestamp("Fecha_alta"));
					c.setResidente(rs.getBoolean("residente"));
					c.setAutonomo(rs.getBoolean("autonomo"));
					v.addElement(c.getId_cliente());
					v.addElement(c.getDni_nie());
					v.addElement(c.getNombre());
					v.addElement(c.getApellidos());
					v.addElement(c.getTelefono_fijo());
					v.addElement(c.getEmail());
					v.addElement(c.getDireccion_vivienda());
					v.addElement(c.getCiudad());
					v.addElement(c.getCP());
					v.addElement(new giveFecha().formateoDateAqui(c.getFecha_alta()));
					if (c.getResidente())
						v.addElement("Si");
					else
						v.addElement("No");
					if (c.getAutonomo())
						v.addElement("Si");
					else
						v.addElement("No");
					dtm.addRow(v);

				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
	}

	public class GestorRes implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Vector<Object> v = null;
			Cliente c = null;
			ResultSet rs = null;
			dtm.setRowCount(0);
			try {
				rs = new MisConexiones().dameResultSetSimple(ConfigDir.getInstance().getProperty("consulta7"));
				while (rs.next()) {
					v = new Vector<Object>();
					c = new Cliente();

					c.setId_cliente(rs.getInt("id_cliente"));
					c.setDni_nie(rs.getString("Dni_nie"));
					c.setNombre(rs.getString("Nombre"));
					c.setApellidos(rs.getString("Apellidos"));
					c.setTelefono_fijo(rs.getInt("Teléfono_fijo"));
					c.setEmail(rs.getString("Email"));
					c.setDireccion_vivienda(rs.getString("Direccion_vivienda"));
					c.setCiudad(rs.getString("Ciudad"));
					c.setCP(rs.getInt("CP"));
					c.setFecha_alta(rs.getTimestamp("Fecha_alta"));
					c.setResidente(rs.getBoolean("residente"));
					c.setAutonomo(rs.getBoolean("autonomo"));
					v.addElement(c.getId_cliente());
					v.addElement(c.getDni_nie());
					v.addElement(c.getNombre());
					v.addElement(c.getApellidos());
					v.addElement(c.getTelefono_fijo());
					v.addElement(c.getEmail());
					v.addElement(c.getDireccion_vivienda());
					v.addElement(c.getCiudad());
					v.addElement(c.getCP());
					v.addElement(new giveFecha().formateoDateAqui(c.getFecha_alta()));
					if (c.getResidente())
						v.addElement("Si");
					else
						v.addElement("No");
					if (c.getAutonomo())
						v.addElement("Si");
					else
						v.addElement("No");
					dtm.addRow(v);

				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
	}

	public class GestorAu implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Vector<Object> v = null;
			Cliente c = null;
			ResultSet rs = null;
			dtm.setRowCount(0);
			try {
				rs = new MisConexiones().dameResultSetSimple(ConfigDir.getInstance().getProperty("consulta8"));
				while (rs.next()) {
					v = new Vector<Object>();
					c = new Cliente();

					c.setId_cliente(rs.getInt("id_cliente"));
					c.setDni_nie(rs.getString("Dni_nie"));
					c.setNombre(rs.getString("Nombre"));
					c.setApellidos(rs.getString("Apellidos"));
					c.setTelefono_fijo(rs.getInt("Teléfono_fijo"));
					c.setEmail(rs.getString("Email"));
					c.setDireccion_vivienda(rs.getString("Direccion_vivienda"));
					c.setCiudad(rs.getString("Ciudad"));
					c.setCP(rs.getInt("CP"));
					c.setFecha_alta(rs.getTimestamp("Fecha_alta"));
					c.setResidente(rs.getBoolean("residente"));
					c.setAutonomo(rs.getBoolean("autonomo"));
					v.addElement(c.getId_cliente());
					v.addElement(c.getDni_nie());
					v.addElement(c.getNombre());
					v.addElement(c.getApellidos());
					v.addElement(c.getTelefono_fijo());
					v.addElement(c.getEmail());
					v.addElement(c.getDireccion_vivienda());
					v.addElement(c.getCiudad());
					v.addElement(c.getCP());
					v.addElement(new giveFecha().formateoDateAqui(c.getFecha_alta()));
					if (c.getResidente())
						v.addElement("Si");
					else
						v.addElement("No");
					if (c.getAutonomo())
						v.addElement("Si");
					else
						v.addElement("No");
					dtm.addRow(v);

				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}
	}

	
	public void addCliente(Cliente cli) {
		// TODO Auto-generated method stub

	}

	
	public List<Cliente> getAllClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	public Cliente getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Cliente updatecli(Cliente cli) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void borrarcli(int id) {
		// TODO Auto-generated method stub

	}

	
	public Cliente getcliById(int id) {
		// TODO Auto-generated method stub
		return null;
	}	
}