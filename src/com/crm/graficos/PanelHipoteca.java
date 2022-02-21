package com.crm.graficos;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import com.crm.funcionalidades.giveFecha;
import com.crm.persistencias.ConfigDir;
import com.crm.persistencias.MisConexiones;
import com.crm.pojos.Hipoteca;
import com.crm.wordprocessing.WordProcessing;
import com.crm.pojos.Datoseco;
import com.crm.pojos.Datospro;

@SuppressWarnings("serial")
public class PanelHipoteca extends JPanel implements Serializable {
	DefaultTableModel dtm;
	private JTextArea etNotas;
	private JTable tabla;
	private JComboBox<String> op1, op2, op3, op4;
	ArrayList<JButton> botones;
	private JTextField finalidad, adquisicion, vali, credito, plazo, drc_vivi, cargas, fecha, pf, dom, pob, cop, nmp,
			adem, antd, dni_nie, pam, sam, nom, pnm, demp, tlf_em, inf, inv, gad, ghc, ots, vavl, cgv, cgobt, otbn,
			bqcl;
	private JCheckBox edit, d1, d2, d3, d4, d5, d6, check1, check2, check3, check4;

	public PanelHipoteca() {
		setLayout(new BorderLayout());
		add(PanelNorte(), BorderLayout.NORTH);
		add(PanelOeste(), BorderLayout.WEST);
		add(PaneldelCentro(PanelCentral(), PanelControl()), BorderLayout.CENTER);
		add((PanelEste()), BorderLayout.EAST);
		add(PanelSur(), BorderLayout.SOUTH);
	}

	public JPanel PanelNorte() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setPreferredSize(new Dimension(1275, 105));
		panel.add(Box.createRigidArea(new Dimension(0, 3)));
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createLoweredBevelBorder());

		panel.add(PanelNorte1(), BorderLayout.NORTH);
		panel.add(PanelNorte2(), BorderLayout.SOUTH);
		return panel;
	}

	public JPanel PaneldelCentro(JPanel p2, JPanel p3) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(p2, BorderLayout.NORTH);
		panel.add(p3, BorderLayout.CENTER);
		return panel;
	}

	private JPanel PanelNorte1() {
		JPanel dt = new JPanel();
		dt.setLayout(new FlowLayout(FlowLayout.LEFT));
		dt.setPreferredSize(new Dimension(600, 75));

		JLabel fn = new JLabel(" FINALIDAD: ");
		fn.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(fn);
		dt.add(Box.createRigidArea(new Dimension(15, 3)));
		finalidad = new JTextField(24);
		finalidad.setMaximumSize(new Dimension(150, 75));
		finalidad.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(finalidad);
		JLabel va = new JLabel(" CREDITO SOLICITADO:  Valor de adquisicion: ");
		va.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(va);
		dt.add(Box.createRigidArea(new Dimension(15, 3)));
		adquisicion = new JTextField(30);
		adquisicion.setMaximumSize(new Dimension(150, 200));
		adquisicion.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(adquisicion);

		JLabel cr = new JLabel(" Importe Credito: ");
		cr.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(cr);
		dt.add(Box.createRigidArea(new Dimension(15, 3)));
		credito = new JTextField(22);
		credito.setMaximumSize(new Dimension(150, 200));
		credito.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(credito);

		JLabel pl = new JLabel(" Plazo Total (meses): ");
		pl.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(pl);
		dt.add(Box.createRigidArea(new Dimension(15, 3)));
		plazo = new JTextField(26);
		plazo.setMaximumSize(new Dimension(150, 200));
		plazo.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(plazo);

		JLabel vivi = new JLabel(" Direccion Vivienda: ");
		vivi.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(vivi);
		dt.add(Box.createRigidArea(new Dimension(15, 3)));
		drc_vivi = new JTextField(19);
		drc_vivi.setMaximumSize(new Dimension(150, 200));
		drc_vivi.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(drc_vivi);

		JLabel tp = new JLabel("tipo: ");
		tp.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(tp);
		dt.add(Box.createRigidArea(new Dimension(5, 3)));
		String[] gp1 = new String[] { "libre", "con cargos" };
		op1 = new JComboBox<String>(gp1);
		op1.setAlignmentX(Component.CENTER_ALIGNMENT);
		op1.setMaximumSize(new Dimension(150, 200));
		dt.add(op1);
		dt.add(Box.createRigidArea(new Dimension(5, 3)));

		JLabel cg = new JLabel("Cargas");
		cg.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(cg);
		dt.add(Box.createRigidArea(new Dimension(15, 3)));
		cargas = new JTextField(15);
		cargas.setMaximumSize(new Dimension(150, 200));
		cargas.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(cargas);

		JLabel nv = new JLabel("nueva: ");
		nv.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(nv);
		dt.add(Box.createRigidArea(new Dimension(15, 3)));
		String[] gp2 = new String[] { "Si", "No" };
		op2 = new JComboBox<String>(gp2);
		op2.setAlignmentX(Component.LEFT_ALIGNMENT);
		op2.setMaximumSize(new Dimension(150, 200));
		dt.add(op2);
		dt.add(Box.createRigidArea(new Dimension(5, 3)));

		JLabel ec = new JLabel("Estado Civil: ");
		ec.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(ec);
		dt.add(Box.createRigidArea(new Dimension(5, 3)));
		String[] gp3 = new String[] { "Soltero/a", "Casado/a", "Divorciado/a", "Separado/a", "Divorciado/a" };
		op3 = new JComboBox<String>(gp3);
		op3.setAlignmentX(Component.LEFT_ALIGNMENT);
		op3.setMaximumSize(new Dimension(150, 200));
		dt.add(op3);
		dt.add(Box.createRigidArea(new Dimension(5, 3)));

		JLabel rb = new JLabel("Regimen de Bienes: ");
		rb.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(rb);
		dt.add(Box.createRigidArea(new Dimension(15, 3)));
		String[] gp4 = new String[] { "separacion", "gananciales", "participacion" };
		op4 = new JComboBox<String>(gp4);
		op4.setAlignmentX(Component.LEFT_ALIGNMENT);
		op4.setMaximumSize(new Dimension(150, 200));
		dt.add(op4);
		dt.add(Box.createRigidArea(new Dimension(0, 3)));

		return dt;
	}

	private JPanel PanelNorte2() {
		JPanel sbn = new JPanel();
		sbn.setLayout(new FlowLayout(FlowLayout.CENTER));
		sbn.setMaximumSize(new Dimension(640, 30));
		sbn.setBorder(BorderFactory.createLoweredBevelBorder());

		JLabel vna = new JLabel("Vinculado a:");
		vna.setAlignmentX(Component.LEFT_ALIGNMENT);
		sbn.add(vna);
		sbn.add(Box.createRigidArea(new Dimension(0, 3)));
		vali = new JTextField(15);
		vali.setMaximumSize(new Dimension(40, 30));
		vali.setAlignmentX(Component.LEFT_ALIGNMENT);
		sbn.add(vali);

		JLabel bcl = new JLabel("Busqueda Cliente:");
		bcl.setAlignmentX(Component.LEFT_ALIGNMENT);
		sbn.add(bcl);
		sbn.add(Box.createRigidArea(new Dimension(0, 3)));
		bqcl = new JTextField(15);
		bqcl.setMaximumSize(new Dimension(40, 30));
		bqcl.setAlignmentX(Component.LEFT_ALIGNMENT);
		sbn.add(bqcl);

		JLabel impt = new JLabel("    dato aqui:");
		impt.setAlignmentX(Component.LEFT_ALIGNMENT);
		sbn.add(impt);
		sbn.add(Box.createRigidArea(new Dimension(0, 3)));

		return sbn;
	}

	private JPanel PanelOeste() {
		JPanel dt = new JPanel();
		dt.setLayout(new BoxLayout(dt, BoxLayout.Y_AXIS));
		dt.setPreferredSize(new Dimension(450, 900));
		dt.add(Box.createRigidArea(new Dimension(0, 8)));

		JLabel dp = new JLabel("DATOS PERSONALES:");
		dp.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(dp);
		dt.add(Box.createRigidArea(new Dimension(0, 8)));

		JLabel tl = new JLabel("Titular:");
		tl.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(Box.createRigidArea(new Dimension(0, 8)));
		dt.add(tl);

		JLabel va = new JLabel("Dnie/Nie:");
		va.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(va);
		dt.add(Box.createRigidArea(new Dimension(0, 8)));
		dni_nie = new JTextField(10);
		dni_nie.setMaximumSize(new Dimension(100, 18));
		dni_nie.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(dni_nie);

		JLabel cr = new JLabel("Primer Apellido:");
		cr.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(cr);
		dt.add(Box.createRigidArea(new Dimension(0, 8)));
		pam = new JTextField(10);
		pam.setMaximumSize(new Dimension(100, 18));
		pam.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(pam);

		JLabel pl = new JLabel("Segundo Apellido:");
		pl.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(pl);
		dt.add(Box.createRigidArea(new Dimension(0, 8)));
		sam = new JTextField(10);
		sam.setMaximumSize(new Dimension(100, 18));
		sam.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(sam);

		JLabel vivi = new JLabel("Nombre:");
		vivi.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(vivi);
		dt.add(Box.createRigidArea(new Dimension(0, 8)));
		nom = new JTextField(10);
		nom.setMaximumSize(new Dimension(100, 18));
		nom.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(nom);

		JLabel fcn = new JLabel("Fecha nacimiento:(dd/mm/yyyy)");
		fcn.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(fcn);
		dt.add(Box.createRigidArea(new Dimension(0, 8)));
		fecha = new JTextField(10);
		fecha.setMaximumSize(new Dimension(100, 18));
		fecha.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(fecha);

		JLabel oc = new JLabel("OCUPACION:");
		oc.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(oc);
		dt.add(Box.createRigidArea(new Dimension(0, 8)));

		JLabel etfijo = new JLabel("");
		etfijo.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(etfijo);
		dt.add(Box.createRigidArea(new Dimension(0, 8)));
		check1 = new JCheckBox("Fijo");
		check1.setMaximumSize(new Dimension(100, 30));
		check1.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(check1);

		JLabel ettemp = new JLabel("");
		ettemp.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(ettemp);
		dt.add(Box.createRigidArea(new Dimension(0, 8)));
		check2 = new JCheckBox("Temporal");
		check2.setMaximumSize(new Dimension(100, 30));
		check2.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(check2);

		JLabel etAutonomo = new JLabel("");
		etAutonomo.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(etAutonomo);
		dt.add(Box.createRigidArea(new Dimension(0, 8)));
		check3 = new JCheckBox("Autonomo");
		check3.setMaximumSize(new Dimension(100, 30));
		check3.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(check3);

		JLabel etotros = new JLabel("");
		etotros.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(etotros);
		dt.add(Box.createRigidArea(new Dimension(0, 8)));
		check4 = new JCheckBox("Otros");
		check4.setMaximumSize(new Dimension(100, 30));
		check4.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(check4);

		JLabel cg = new JLabel("Profesion:");
		cg.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(cg);
		dt.add(Box.createRigidArea(new Dimension(0, 8)));
		pf = new JTextField(10);
		pf.setMaximumSize(new Dimension(100, 18));
		pf.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(pf);

		JLabel dm = new JLabel("Domicilio:");
		dm.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(dm);
		dt.add(Box.createRigidArea(new Dimension(0, 8)));
		dom = new JTextField(10);
		dom.setMaximumSize(new Dimension(100, 18));
		dom.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(dom);

		JLabel pb = new JLabel("Poblacion:");
		pb.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(pb);
		dt.add(Box.createRigidArea(new Dimension(0, 8)));
		pob = new JTextField(10);
		pob.setMaximumSize(new Dimension(100, 18));
		pob.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(pob);

		JLabel cp = new JLabel("Codigo Postal:");
		cp.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(cp);
		dt.add(Box.createRigidArea(new Dimension(0, 8)));
		cop = new JTextField(10);
		cop.setMaximumSize(new Dimension(100, 18));
		cop.setAlignmentX(Component.LEFT_ALIGNMENT);
		dt.add(cop);

		return dt;
	}

	private JPanel PanelCentral() {
		JPanel pe = new JPanel();
		pe.setLayout(new BoxLayout(pe, BoxLayout.Y_AXIS));
		pe.setPreferredSize(new Dimension(1200, 325));
		pe.add(Box.createRigidArea(new Dimension(0, 10)));

		JLabel dp = new JLabel("DATOS PROFESIONALES:");
		dp.setAlignmentX(Component.LEFT_ALIGNMENT);
		pe.add(dp);
		pe.add(Box.createRigidArea(new Dimension(0, 10)));

		JLabel ne = new JLabel("Nombre de Empresa:");
		ne.setAlignmentX(Component.LEFT_ALIGNMENT);
		pe.add(ne);
		pe.add(Box.createRigidArea(new Dimension(0, 10)));
		nmp = new JTextField(10);
		nmp.setMaximumSize(new Dimension(1200, 22));
		nmp.setAlignmentX(Component.LEFT_ALIGNMENT);
		pe.add(nmp);

		JLabel ade = new JLabel("Actividad de la empresa:");
		ade.setAlignmentX(Component.LEFT_ALIGNMENT);
		pe.add(ade);
		pe.add(Box.createRigidArea(new Dimension(0, 10)));
		adem = new JTextField(10);
		adem.setMaximumSize(new Dimension(1200, 22));
		adem.setAlignmentX(Component.LEFT_ALIGNMENT);
		pe.add(adem);

		JLabel ant = new JLabel("Antiguedad:");
		ant.setAlignmentX(Component.LEFT_ALIGNMENT);
		pe.add(ant);
		pe.add(Box.createRigidArea(new Dimension(0, 10)));
		antd = new JTextField(10);
		antd.setMaximumSize(new Dimension(1200, 22));
		antd.setAlignmentX(Component.LEFT_ALIGNMENT);
		pe.add(antd);

		JLabel pem = new JLabel("Puesto en la Empresa:");
		pem.setAlignmentX(Component.LEFT_ALIGNMENT);
		pe.add(pem);
		pe.add(Box.createRigidArea(new Dimension(0, 10)));
		pnm = new JTextField(10);
		pnm.setMaximumSize(new Dimension(1200, 22));
		pnm.setAlignmentX(Component.LEFT_ALIGNMENT);
		pe.add(pnm);

		JLabel dem = new JLabel("Dirreccion de la empresa:");
		dem.setAlignmentX(Component.LEFT_ALIGNMENT);
		pe.add(dem);
		pe.add(Box.createRigidArea(new Dimension(0, 10)));
		demp = new JTextField(10);
		demp.setMaximumSize(new Dimension(1200, 22));
		demp.setAlignmentX(Component.LEFT_ALIGNMENT);
		pe.add(demp);

		JLabel tfc = new JLabel("Telefono/fax/correo-e de la empresa:");
		tfc.setAlignmentX(Component.LEFT_ALIGNMENT);
		pe.add(tfc);
		pe.add(Box.createRigidArea(new Dimension(0, 10)));
		tlf_em = new JTextField(10);
		tlf_em.setMaximumSize(new Dimension(1200, 22));
		tlf_em.setAlignmentX(Component.LEFT_ALIGNMENT);
		pe.add(tlf_em);

		return pe;
	}

	private JPanel PanelControl() {
		JPanel pc = new JPanel();
		pc.setLayout(new BoxLayout(pc, BoxLayout.Y_AXIS));
		pc.setPreferredSize(new Dimension(250, 150));
		pc.setBorder(BorderFactory.createLoweredBevelBorder());
		JLabel de = new JLabel("PANEL DE CONTROL");
		de.setAlignmentX(Component.CENTER_ALIGNMENT);
		pc.add(Box.createRigidArea(new Dimension(0, 10)));
		pc.add(de);

		JButton imp = new JButton("IMPRIMIR PETICION");
		imp.addActionListener(new GestorImprimir());
		JButton add = new JButton("INSERTAR EN LA BBDD");
		add.addActionListener(new GestorVer());
		JButton lm = new JButton("LIMPIAR");
		lm.addActionListener(new GestorLimpiar());
		botones = new ArrayList<JButton>();
		botones.add(imp);
		botones.add(add);
		botones.add(lm);

		edit = new JCheckBox("EDITAR CAMPOS");
		edit.setAlignmentX(Component.CENTER_ALIGNMENT);
//		edit.addActionListener(new GestorEdicion());

		for (int c = 0; c < botones.size() + 1; c++) {
			if (c < botones.size()) {
				botones.get(c).setMaximumSize(new Dimension(170, 30));
				botones.get(c).setAlignmentX(Component.CENTER_ALIGNMENT);
				pc.add(botones.get(c));
			} else
				pc.add(edit);
			pc.add(Box.createRigidArea(new Dimension(0, 25)));

		}

		botones.get(0).addActionListener(new GestorImprimir());
		botones.get(0).addActionListener(new GestorVer());
		botones.get(1).addActionListener(new GestorLimpiar());

		etNotas = new JTextArea();
		etNotas.setLineWrap(true);
		etNotas.setWrapStyleWord(true);
		etNotas.setPreferredSize(new Dimension(250, 180));
		JScrollPane sp = new JScrollPane(etNotas);
		sp.setHorizontalScrollBar(null);
		sp.setPreferredSize(new Dimension(250, 180));
		sp.setAlignmentX(Component.CENTER_ALIGNMENT);
		sp.setBorder(BorderFactory.createLoweredBevelBorder());
		pc.add(sp);

		return pc;
	}

	private JPanel PanelEste() {
		JPanel pdc = new JPanel();
		pdc.setLayout(new BoxLayout(pdc, BoxLayout.Y_AXIS));
		pdc.setPreferredSize(new Dimension(450, 900));
		pdc.add(Box.createRigidArea(new Dimension(0, 8)));

		JLabel de = new JLabel("DATOS ECONOMICOS:");
		de.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(de);
		pdc.add(Box.createRigidArea(new Dimension(0, 8)));

		JLabel in = new JLabel("Ingresos Fijos (mes):");
		in.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(in);
		pdc.add(Box.createRigidArea(new Dimension(0, 8)));
		inf = new JTextField(10);
		inf.setMaximumSize(new Dimension(100, 18));
		inf.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(inf);

		JLabel va = new JLabel("Ingresos Variables (mes):");
		va.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(va);
		pdc.add(Box.createRigidArea(new Dimension(0, 8)));
		inv = new JTextField(10);
		inv.setMaximumSize(new Dimension(120, 18));
		inv.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(inv);

		JLabel ga = new JLabel("Gastos alquiler:");
		ga.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(ga);
		pdc.add(Box.createRigidArea(new Dimension(0, 8)));
		gad = new JTextField(10);
		gad.setMaximumSize(new Dimension(120, 18));
		gad.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(gad);

		JLabel gh = new JLabel("Gastos Hipoteca:");
		gh.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(gh);
		pdc.add(Box.createRigidArea(new Dimension(0, 8)));
		ghc = new JTextField(10);
		ghc.setMaximumSize(new Dimension(120, 18));
		ghc.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(ghc);

		JLabel ot = new JLabel("Otros:");
		ot.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(ot);
		pdc.add(Box.createRigidArea(new Dimension(0, 8)));
		ots = new JTextField(10);
		ots.setMaximumSize(new Dimension(120, 18));
		ots.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(ots);

		JLabel viv = new JLabel("Valor Vivienda:");
		viv.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(viv);
		pdc.add(Box.createRigidArea(new Dimension(0, 8)));
		vavl = new JTextField(10);
		vavl.setMaximumSize(new Dimension(120, 18));
		vavl.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(vavl);

		JLabel cv = new JLabel("Cargas Vivienda:");
		cv.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(cv);
		pdc.add(Box.createRigidArea(new Dimension(0, 8)));
		cgv = new JTextField(10);
		cgv.setMaximumSize(new Dimension(120, 18));
		cgv.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(cgv);

		JLabel etpd = new JLabel("");
		etpd.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(etpd);
		pdc.add(Box.createRigidArea(new Dimension(0, 8)));
		d1 = new JCheckBox("propiedad");
		d1.setMaximumSize(new Dimension(120, 30));
		d1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(d1);

		JLabel etes = new JLabel("");
		etes.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(etes);
		pdc.add(Box.createRigidArea(new Dimension(0, 8)));
		d2 = new JCheckBox("escritura");
		d2.setMaximumSize(new Dimension(120, 30));
		d2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(d2);

		JLabel etcp = new JLabel("");
		etcp.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(etcp);
		pdc.add(Box.createRigidArea(new Dimension(0, 8)));
		d3 = new JCheckBox("contrato privado");
		d3.setMaximumSize(new Dimension(120, 30));
		d3.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(d3);

		JLabel etot = new JLabel("");
		etot.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(etot);
		pdc.add(Box.createRigidArea(new Dimension(0, 8)));
		d4 = new JCheckBox("otros");
		d4.setMaximumSize(new Dimension(120, 30));
		d4.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(d4);

		JLabel etpdd = new JLabel("");
		etpdd.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(etpdd);
		pdc.add(Box.createRigidArea(new Dimension(0, 8)));
		d5 = new JCheckBox("padres");
		d5.setMaximumSize(new Dimension(120, 30));
		d5.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(d5);

		JLabel etal = new JLabel("");
		etal.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(etal);
		pdc.add(Box.createRigidArea(new Dimension(0, 8)));
		d6 = new JCheckBox("alquiler");
		d6.setMaximumSize(new Dimension(120, 30));
		d6.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(d6);

		JLabel otb = new JLabel("Otros Bienes:");
		otb.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(otb);
		pdc.add(Box.createRigidArea(new Dimension(0, 8)));
		otbn = new JTextField(10);
		otbn.setMaximumSize(new Dimension(120, 18));
		otbn.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(otbn);

		JLabel cobt = new JLabel("Cargos Otros Bienes:");
		cobt.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(cobt);
		pdc.add(Box.createRigidArea(new Dimension(0, 8)));
		cgobt = new JTextField(10);
		cgobt.setMaximumSize(new Dimension(120, 18));
		cgobt.setAlignmentX(Component.RIGHT_ALIGNMENT);
		pdc.add(cgobt);
		return pdc;
	}

	private JScrollPane PanelSur() {
		dtm = new DefaultTableModel();
		// panel oeste
		dtm.addColumn("ape1");
		dtm.addColumn("ape2");
		dtm.addColumn("nombre");
		dtm.addColumn("dni_nie");
		dtm.addColumn("fijo");
		dtm.addColumn("temporal");
		dtm.addColumn("autonomo");
		dtm.addColumn("otro");
		dtm.addColumn("profesion");
		dtm.addColumn("domicilio");
		dtm.addColumn("poblacion");
		dtm.addColumn("codpost");
		dtm.addColumn("fecha_nac");
		dtm.addColumn("finalidad");
		dtm.addColumn("valadq");
		dtm.addColumn("impcto");
		dtm.addColumn("plazoTot");
		dtm.addColumn("dirvivi");
		dtm.addColumn("tipovivi");
		dtm.addColumn("cargas");
		dtm.addColumn("nueva");
		dtm.addColumn("estadocivil");
		dtm.addColumn("regbienes");
		// panel central
		dtm.addColumn("nomemp");
		dtm.addColumn("activemp");
		dtm.addColumn("antig");
		dtm.addColumn("puesto");
		dtm.addColumn("diremp");
		dtm.addColumn("tel");
		// panel este
		dtm.addColumn("ingmesfi");
		dtm.addColumn("ingmesvar");
		dtm.addColumn("gastos_alq");
		dtm.addColumn("gastos_hip");
		dtm.addColumn("otros");
		dtm.addColumn("valorotvivi");
		dtm.addColumn("cargasotvivi");
		dtm.addColumn("prop");
		dtm.addColumn("propval");
		dtm.addColumn("escrit");
		dtm.addColumn("escritval");
		dtm.addColumn("contratpriv");
		dtm.addColumn("contratprivval");
		dtm.addColumn("ot");
		dtm.addColumn("otval");
		dtm.addColumn("padres");
		dtm.addColumn("padresval");
		dtm.addColumn("alquileres");
		dtm.addColumn("alquileresval");
		dtm.addColumn("otrobienes");
		dtm.addColumn("cargasotrosbienes");

		tabla = new JTable(dtm);
		tabla.addMouseListener(new GestorTabla());
		TableColumn column = null;
		for (int i = 0; i < dtm.getColumnCount(); i++) {
			column = tabla.getColumnModel().getColumn(i);
			column.setMinWidth(120);
			column.setPreferredWidth(120);
		}
		tabla.setBounds(0, 0, 1280, 185);
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane sp = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setPreferredSize(new Dimension(1280, 200));
		sp.setBorder(BorderFactory.createLoweredBevelBorder());
		return sp;
	}

	public class GestorVer implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ver();
		}
	}// gestor ver

	public class GestorLimpiar implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dtm.setRowCount(0);
			finalidad.setText("");
			adquisicion.setText("");
			vali.setText("");
			credito.setText("");
			plazo.setText("");
			drc_vivi.setText("");
			cargas.setText("");
			fecha.setText("");
			pf.setText("");
			dom.setText("");
			pob.setText("");
			cop.setText("");
			nmp.setText("");
			adem.setText("");
			antd.setText("");
			dni_nie.setText("");
			pam.setText("");
			sam.setText("");
			nom.setText("");
			pnm.setText("");
			demp.setText("");
			tlf_em.setText("");
			inf.setText("");
			inv.setText("");
			gad.setText("");
			ghc.setText("");
			ots.setText("");
			vavl.setText("");
			cgv.setText("");
			cgobt.setText("");
			otbn.setText("");
			bqcl.setText("");
			etNotas.setText("");
			edit.setSelected(false);
			d1.setSelected(false);
			d2.setSelected(false);
			d3.setSelected(false);
			d4.setSelected(false);
			d5.setSelected(false);
			d6.setSelected(false);
			check1.setSelected(false);
			check2.setSelected(false);
			check3.setSelected(false);
			check4.setSelected(false);

		}
	}// gestor limpiar

	public class GestorImprimir implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String fij;
			if (check1.isSelected())
				fij = "Si";
			else
				fij = "No";

			String temp;
			if (check2.isSelected())
				temp = "Si";
			else
				temp = "No";

			String ot;
			if (check4.isSelected())
				ot = "Si";
			else
				ot = "No";

			String au1;
			if (check3.isSelected())
				au1 = "Si";
			else
				au1 = "No";

			String prop;
			if (d1.isSelected())
				prop = "Si";
			else
				prop = "No";

			String esc;
			if (d2.isSelected())
				esc = "Si";
			else
				esc = "No";

			String conpvp;
			if (d3.isSelected())
				conpvp = "Si";
			else
				conpvp = "No";

			String otros;
			if (d4.isSelected())
				otros = "Si";
			else
				otros = "No";

			String padr;
			if (d5.isSelected())
				padr = "Si";
			else
				padr = "No";

			String alq;
			if (d6.isSelected())
				alq = "Si";
			else
				alq = "No";

			WordProcessing.createNewDocumentFromTemplate("credHipo.dotx");
			// datos personales
			WordProcessing.typeTextAtBookmark("fin", finalidad.getText());
			WordProcessing.typeTextAtBookmark("valad", adquisicion.getText());
			WordProcessing.typeTextAtBookmark("credito", credito.getText());
			WordProcessing.typeTextAtBookmark("plazotot", plazo.getText());
			WordProcessing.typeTextAtBookmark("dirviv", drc_vivi.getText());
			WordProcessing.typeTextAtBookmark("tipo", op1.getSelectedItem().toString());
			WordProcessing.typeTextAtBookmark("cargas", cargas.getText());
			WordProcessing.typeTextAtBookmark("nueva", op2.getSelectedItem().toString());
			WordProcessing.typeTextAtBookmark("estadcivil", op3.getSelectedItem().toString());
			WordProcessing.typeTextAtBookmark("estadcivil_conyu", "");
			WordProcessing.typeTextAtBookmark("regimen", op4.getSelectedItem().toString());
			WordProcessing.typeTextAtBookmark("regimen_conyu", "");
			WordProcessing.typeTextAtBookmark("dni_nie", dni_nie.getText());
			WordProcessing.typeTextAtBookmark("dni_nie_conyu", "");
			WordProcessing.typeTextAtBookmark("ape1", pam.getText());
			WordProcessing.typeTextAtBookmark("ape1_conyu", "");
			WordProcessing.typeTextAtBookmark("ape2", sam.getText());
			WordProcessing.typeTextAtBookmark("ape2_conyu", "");
			WordProcessing.typeTextAtBookmark("fechan", fecha.getText());
			WordProcessing.typeTextAtBookmark("fechan_conyu", "");
			WordProcessing.typeTextAtBookmark("nombrecli", nom.getText());
			WordProcessing.typeTextAtBookmark("nombrecli_conyu", "");
			WordProcessing.typeTextAtBookmark("fijo", fij);
			WordProcessing.typeTextAtBookmark("fijo_conyu", "");
			WordProcessing.typeTextAtBookmark("temp", temp);
			WordProcessing.typeTextAtBookmark("temp_conyu", "");
			WordProcessing.typeTextAtBookmark("aut", au1);
			WordProcessing.typeTextAtBookmark("aut_conyu", "");
			WordProcessing.typeTextAtBookmark("otros", ot);
			WordProcessing.typeTextAtBookmark("otros_conyu", ot);
			WordProcessing.typeTextAtBookmark("dom", dom.getText());
			WordProcessing.typeTextAtBookmark("dom_conyu", "");
			WordProcessing.typeTextAtBookmark("cp", cop.getText());
			WordProcessing.typeTextAtBookmark("cp_conyu", "");
			WordProcessing.typeTextAtBookmark("pob", pob.getText());
			WordProcessing.typeTextAtBookmark("pob_conyu", "");
			WordProcessing.typeTextAtBookmark("prof", pf.getText());
			WordProcessing.typeTextAtBookmark("prof_conyu", "");
			// datos profe
			WordProcessing.typeTextAtBookmark("nomemp", nmp.getText());
			WordProcessing.typeTextAtBookmark("nomemp_conyu", "");
			WordProcessing.typeTextAtBookmark("activemp", adem.getText());
			WordProcessing.typeTextAtBookmark("activemp_conyu", "");
			WordProcessing.typeTextAtBookmark("antiguo", antd.getText());
			WordProcessing.typeTextAtBookmark("antiguo_conyu", "");
			WordProcessing.typeTextAtBookmark("posicion", pnm.getText());
			WordProcessing.typeTextAtBookmark("posicion_conyu", "");
			WordProcessing.typeTextAtBookmark("diremp", demp.getText());
			WordProcessing.typeTextAtBookmark("diremp_conyu", "");
			WordProcessing.typeTextAtBookmark("telemp", tlf_em.getText());
			WordProcessing.typeTextAtBookmark("telemp_conyu", "");
			// datos eco
			WordProcessing.typeTextAtBookmark("fijosmen", inf.getText());
			WordProcessing.typeTextAtBookmark("fijosmen_conyu", "");
			WordProcessing.typeTextAtBookmark("varmen", inv.getText());
			WordProcessing.typeTextAtBookmark("varmen_conyu", "");
			WordProcessing.typeTextAtBookmark("gastosalq", gad.getText());
			WordProcessing.typeTextAtBookmark("gastosalq_conyu", "");
			WordProcessing.typeTextAtBookmark("gastoshipo", ghc.getText());
			WordProcessing.typeTextAtBookmark("gastoshipo_conyu", "");
			WordProcessing.typeTextAtBookmark("otrospres", ots.getText());
			WordProcessing.typeTextAtBookmark("otrospres_conyu", "");
			WordProcessing.typeTextAtBookmark("valorvivi", vavl.getText());
			WordProcessing.typeTextAtBookmark("valorvivi_conyu", "");
			WordProcessing.typeTextAtBookmark("cargasvivi", cgv.getText());
			WordProcessing.typeTextAtBookmark("cargasvivi_conyu", "");
			WordProcessing.typeTextAtBookmark("propiedad", prop);
			WordProcessing.typeTextAtBookmark("propiedad_conyu", "");
			WordProcessing.typeTextAtBookmark("escritura", esc);
			WordProcessing.typeTextAtBookmark("escritura_conyu", "");
			WordProcessing.typeTextAtBookmark("contratpriv", conpvp);
			WordProcessing.typeTextAtBookmark("contratpriv_conyu", "");
			WordProcessing.typeTextAtBookmark("otrosmas", otros);
			WordProcessing.typeTextAtBookmark("otrosmas_conyu", "");
			WordProcessing.typeTextAtBookmark("padres", padr);
			WordProcessing.typeTextAtBookmark("padres_conyu", "");
			WordProcessing.typeTextAtBookmark("alquiler", alq);
			WordProcessing.typeTextAtBookmark("alquiler_conyu", "");
			WordProcessing.typeTextAtBookmark("otrosbipat", otbn.getText());
			WordProcessing.typeTextAtBookmark("otrosbipat_conyu", "");
			WordProcessing.typeTextAtBookmark("cargasotrosbi", cgobt.getText());
			WordProcessing.typeTextAtBookmark("cargasotrosbi_conyu", "");
			WordProcessing.typeTextAtBookmark("antig", "");
			WordProcessing.typeTextAtBookmark("otrospat", "");
			WordProcessing.saveDocumentAsAndClose(nom.getText());
			WordProcessing.exec();
			try {
				CrearEstructuraFichero(nom.getText());
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("error al crear estructura");
			}
		}

		private void CrearEstructuraFichero(String nombreArch) throws FileNotFoundException, IOException {
			File fl = new File("C:/Users/dam/Documents/hipotecas/" + nom.getText());
			fl.mkdirs();
			File ini = new File("C:/Users/dam/Documents/" + nombreArch + ".docx");
			FileInputStream origen = new FileInputStream(ini);
			FileOutputStream destino = new FileOutputStream(
					"C:/Users/dam/Documents/hipotecas/" + nom.getText() + "/" + nombreArch + ".docx");
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

	public class GestorTabla extends MouseAdapter {
		public void mouseReleased(MouseEvent e) {
			int j = tabla.getSelectedRow();

			String ApEntero = (String) dtm.getValueAt(j, 0);
			pam.setText("" + ApEntero);
			String ApEntero1 = (String) dtm.getValueAt(j, 1);
			sam.setText("" + ApEntero1);
			String Nom = (String) dtm.getValueAt(j, 2);
			nom.setText("" + Nom);
			String Dnie = (String) dtm.getValueAt(j, 3);
			dni_nie.setText("" + Dnie);
			// Fijo
			if ((String) dtm.getValueAt(j, 4) == "Si")
				check1.setSelected(true);
			else
				check1.setSelected(false);
			// temporal
			if ((String) dtm.getValueAt(j, 5) == "Si")
				check2.setSelected(true);
			else
				check2.setSelected(false);
			// otro
			if ((String) dtm.getValueAt(j, 6) == "Si")
				check3.setSelected(true);
			else
				check3.setSelected(false);
			// autonomo
			if ((String) dtm.getValueAt(j, 7) == "Si")
				check4.setSelected(true);
			else
				check4.setSelected(false);
			String profesion = (String) dtm.getValueAt(j, 8);
			pf.setText("" + profesion);
			String domicilio = (String) dtm.getValueAt(j, 9);
			dom.setText("" + domicilio);
			String pobla = (String) dtm.getValueAt(j, 10);
			pob.setText("" + pobla);
			int CPEntero = (int) dtm.getValueAt(j, 11);
			cop.setText("" + CPEntero);
			String FAEntero = (String) dtm.getValueAt(j, 12);
			fecha.setText("" + FAEntero);
			String Fniladad = (String) dtm.getValueAt(j, 13);
			finalidad.setText("" + Fniladad);
			int valada = (int) dtm.getValueAt(j, 14);
			adquisicion.setText("" + valada);
			int cred = (int) dtm.getValueAt(j, 15);
			credito.setText("" + cred);
			int plzt = (int) dtm.getValueAt(j, 16);
			plazo.setText(""+plzt);
			String dirvivis = (String) dtm.getValueAt(j, 17);
			drc_vivi.setText("" + dirvivis);
			String tipoviv = (String) dtm.getValueAt(j, 18);
			op1.setToolTipText("" + tipoviv);
			int cag = (int) dtm.getValueAt(j, 19);
			cargas.setText("" + cag);
			String nv = (String) dtm.getValueAt(j, 20);
			op2.setToolTipText("" + nv);
			String esc = (String) dtm.getValueAt(j, 21);
			op3.setToolTipText("" + esc);
			String regb = (String) dtm.getValueAt(j, 22);
			op4.setToolTipText("" + regb);
			String noemp = (String) dtm.getValueAt(j, 23);
			nmp.setText("" + noemp);
			String ade = (String) dtm.getValueAt(j, 24);
			adem.setText("" + ade);
			float ant = (float) dtm.getValueAt(j, 25);
			antd.setText("" + ant);
			String pnms = (String) dtm.getValueAt(j, 26);
			pnm.setText("" + pnms);
			String dem = (String) dtm.getValueAt(j, 27);
			demp.setText("" + dem);
			int tlf = (int) dtm.getValueAt(j, 28);
			tlf_em.setText("" + tlf);
			int infv = (int) dtm.getValueAt(j, 29);
			inf.setText("" + infv);
			int infr = (int) dtm.getValueAt(j, 30);
			inv.setText("" + infr);
			int gads = (int) dtm.getValueAt(j, 31);
			gad.setText("" + gads);
			int ghcs = (int) dtm.getValueAt(j, 32);
			ghc.setText("" + ghcs);
			int otts = (int) dtm.getValueAt(j, 33);
			ots.setText("" + otts);
			int vavlv = (int) dtm.getValueAt(j, 34);
			vavl.setText("" + vavlv);
			int cgvs = (int) dtm.getValueAt(j, 35);
			cgv.setText("" + cgvs);
			// prop
			if ((String) dtm.getValueAt(j, 36) == "Si")
				d1.setSelected(true);
			else
				d1.setSelected(false);
			// escrit
			if ((String) dtm.getValueAt(j, 37) == "Si")
				d2.setSelected(true);
			else
				d2.setSelected(false);
			// contratpriv
			if ((String) dtm.getValueAt(j, 38) == "Si")
				d3.setSelected(true);
			else
				check3.setSelected(false);
			// ot
			if ((String) dtm.getValueAt(j, 39) == "Si")
				d4.setSelected(true);
			else
				d4.setSelected(false);
			// padres
			if ((String) dtm.getValueAt(j, 40) == "Si")
				d5.setSelected(true);
			else
				d5.setSelected(false);
			// alquileres
			if ((String) dtm.getValueAt(j, 41) == "Si")
				d6.setSelected(true);
			else
				d6.setSelected(false);
			int otbns = (int) dtm.getValueAt(j, 42);
			otbn.setText("" + otbns);
			int cgobtd = (int) dtm.getValueAt(j, 43);
			cgobt.setText("" + cgobtd);
		}
	}// gestor tabla
	
	public void ver() {
		Vector<Object> v = null;
		Hipoteca c = null;
		Datoseco dc = null;
		Datospro dp = null;
		ResultSet rs = null;
		dtm.setRowCount(0);
		try {
			rs = new MisConexiones().dameResultSetSimple(ConfigDir.getInstance().getProperty("consulta11"));
			while (rs.next()) {
				v = new Vector<Object>();
				c = new Hipoteca();
				dp = new Datospro();
				dc = new Datoseco();
				// panel oeste
				c.setApe1(rs.getString("ape1"));
				c.setApe2(rs.getString("ape2"));
				c.setNombre(rs.getString("nombre"));
				c.setDni_nie(rs.getString("dni_nie"));
				c.setFijo(rs.getBoolean("fijo"));
				c.setTemporal(rs.getBoolean("temporal"));
				c.setAutonomo(rs.getBoolean("autonomo"));
				c.setOtro(rs.getBoolean("otro"));
				c.setProfesion(rs.getString("profesion"));
				c.setDomicilio(rs.getString("domicilio"));
				c.setPoblacion(rs.getString("poblacion"));
				c.setCodpost(rs.getInt("codpost"));
				c.setFecha_nac(rs.getTimestamp("fecha_nac"));
				c.setfinalidad(rs.getString("finalidad"));
				c.setValadq(rs.getInt("valadq"));
				c.setImpcto(rs.getInt("impcto"));
				c.setPlazoTot(rs.getInt("plazoTot"));
				c.setDir_vivi(rs.getString("dirvivi"));
				c.setTipo_vivi(rs.getString("tipovivi"));
				c.setCargas(rs.getInt("cargas"));
				c.setNueva(rs.getString("nueva"));
				c.setEstadocivil(rs.getString("estadocivil"));
				c.setRegbienes(rs.getString("regbienes"));

				v.addElement(c.getApe1());
				v.addElement(c.getApe2());
				v.addElement(c.getNombre());
				v.addElement(c.getDni_nie());
				if (c.getFijo())
					v.addElement("Si");
				else
					v.addElement("No");
				if (c.getTemporal())
					v.addElement("Si");
				else
					v.addElement("No");
				if (c.getAutonomo())
					v.addElement("Si");
				else
					v.addElement("No");
				if (c.getOtro())
					v.addElement("Si");
				else
					v.addElement("No");
				v.addElement(c.getProfesion());
				v.addElement(c.getDomicilio());
				v.addElement(c.getPoblacion());
				v.addElement(c.getCodpost());
				v.addElement(new giveFecha().formateoDateAqui(c.getFecha_nac()));
				v.addElement(c.getfinalidad());
				v.addElement(c.getValadq());
				v.addElement(c.getImpcto());
				v.addElement(c.getPlazoTot());
				v.addElement(c.getDir_vivi());
				v.addElement(c.getTipo_vivi());
				v.addElement(c.getCargas());
				v.addElement(c.getNueva());
				v.addElement(c.getEstadocivil());
				v.addElement(c.getRegbienes());

				// panel central
				dp.setNomemp(rs.getString("nomemp"));
				dp.setActivemp(rs.getString("activemp"));
				dp.setAntig(rs.getFloat("antig"));
				dp.setPuesto(rs.getString("puesto"));
				dp.setDiremp(rs.getString("diremp"));
				dp.setTel(rs.getInt("tel"));

				v.addElement(dp.getNomemp());
				v.addElement(dp.getActivemp());
				v.addElement(dp.getAntig());
				v.addElement(dp.getPuesto());
				v.addElement(dp.getDiremp());
				v.addElement(dp.getTel());

				// panel este
				dc.setIngmesfi(rs.getInt("ingmesfi"));
				dc.setIngmesva(rs.getInt("ingmesvar"));
				dc.setGastos_alq(rs.getInt("gastos_alq"));
				dc.setGastos_hip(rs.getInt("gastos_hip"));
				dc.setOtros(rs.getInt("otros"));
				dc.setValorotvivi(rs.getInt("valorotvivi"));
				dc.setCargasotvivi(rs.getInt("cargasotvivi"));
				dc.setProp(rs.getBoolean("prop"));
				dc.setEscrit(rs.getBoolean("escrit"));
				dc.setContratpriv(rs.getBoolean("contratpriv"));
				dc.setOt(rs.getBoolean("ot"));
				dc.setPadres(rs.getBoolean("padres"));
				dc.setAlquileres(rs.getBoolean("alquileres"));
				dc.setOtrobienes(rs.getInt("otrobienes"));
				dc.setCargasotrosbienes(rs.getInt("cargasotrosbienes"));

				v.addElement(dc.getIngmesfi());
				v.addElement(dc.getIngmesva());
				v.addElement(dc.getGastos_alq());
				v.addElement(dc.getGastos_hip());
				v.addElement(dc.getOtros());
				v.addElement(dc.getValorotvivi());
				v.addElement(dc.getCargasotvivi());
				if (dc.getProp())
					v.addElement("Si");
				else
					v.addElement("No");
				if (dc.getEscrit())
					v.addElement("Si");
				else
					v.addElement("No");
				if (dc.getContratpriv())
					v.addElement("Si");
				else
					v.addElement("No");
				if (dc.getOt())
					v.addElement("Si");
				else
					v.addElement("No");
				if (dc.getPadres())
					v.addElement("Si");
				else
					v.addElement("No");
				if (dc.getAlquileres())
					v.addElement("Si");
				else
					v.addElement("No");
				v.addElement(dc.getOtrobienes());
				v.addElement(dc.getCargasotrosbienes());
				dtm.addRow(v);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}// del public ver
}
