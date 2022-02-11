package com.crm.graficos;

import java.io.Serializable;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelRequisitos  extends JPanel implements Serializable{
	private JCheckBox check1, check2, check3, check4, check5, check6, check7, check8, check9, check10, check11, check12,
			check13, check14, check15, check16, check17, check18, check19, check20, check21, check22, check23, check24,
			check25, check26, check27, check28;
	private JTextArea etNotas;
	private JTextField dni;
	private JButton boton1, boton2;

	public PanelRequisitos() {
		setLayout(new BorderLayout());
		add(PanelCentral(PanelOeste(), PanelEste()), BorderLayout.CENTER);
		add(PanelSur(espacio1(), PanelSur()), BorderLayout.SOUTH);
	}

	public JPanel PanelCentral(JPanel p1, JPanel p2) {
		JPanel PaneldelCentro = new JPanel();
		PaneldelCentro.setLayout(new BorderLayout());
		PaneldelCentro.add(p1, BorderLayout.WEST);
		PaneldelCentro.add(p2, BorderLayout.EAST);
		return PaneldelCentro;
	} // final del panel norte

	public JPanel PanelSur(JPanel p1, JPanel p2) {
		JPanel PaneldelCentro = new JPanel();
		PaneldelCentro.setLayout(new BorderLayout());
		PaneldelCentro.add(p1, BorderLayout.WEST);
		PaneldelCentro.add(p2, BorderLayout.CENTER);
		PaneldelCentro.setBorder(BorderFactory.createLoweredBevelBorder());
		return PaneldelCentro;
	} // final del panel norte

	private JPanel PanelOeste() {
		JPanel PanelOeste = new JPanel();
		PanelOeste.setLayout(new FlowLayout(FlowLayout.LEFT));
		PanelOeste.setPreferredSize(new Dimension(425, 75));

		JLabel TPCA = new JLabel("..........TRABAJADORES POR CUENTA AJENA(PARA NOSOTROS)..........");
		TPCA.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(TPCA);
		PanelOeste.add(Box.createRigidArea(new Dimension(0, 10)));

		JLabel etDni = new JLabel("");
		etDni.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(etDni);
		PanelOeste.add(Box.createRigidArea(new Dimension(0, 5)));
		check1 = new JCheckBox("Fotocopia DNI/NIE");
		check1.setMaximumSize(new Dimension(100, 30));
		check1.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(check1);

		JLabel etUltimasNominas = new JLabel("");
		etUltimasNominas.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(etUltimasNominas);
		PanelOeste.add(Box.createRigidArea(new Dimension(50, 5)));
		check2 = new JCheckBox("Fotocopia de las tres últimas nominas");
		check2.setMaximumSize(new Dimension(100, 30));
		check2.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(check2);

		JLabel etControlLaboral = new JLabel("");
		etControlLaboral.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(etControlLaboral);
		PanelOeste.add(Box.createRigidArea(new Dimension(0, 5)));
		check3 = new JCheckBox("Copia del control laboral(< 3)");
		check3.setMaximumSize(new Dimension(100, 30));
		check3.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(check3);

		JLabel etMovimientosBancarios = new JLabel("");
		etMovimientosBancarios.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(etMovimientosBancarios);
		PanelOeste.add(Box.createRigidArea(new Dimension(0, 5)));
		check4 = new JCheckBox("Fotocopia de los últimos movimientos bancarios");
		check4.setMaximumSize(new Dimension(100, 30));
		check4.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(check4);

		JLabel etVidaLaboral = new JLabel("");
		etVidaLaboral.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(etVidaLaboral);
		PanelOeste.add(Box.createRigidArea(new Dimension(20, 5)));
		check5 = new JCheckBox("Vida laboral");
		check5.setMaximumSize(new Dimension(100, 30));
		check5.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(check5);

		JLabel etRecibosdeHAP = new JLabel("");
		etRecibosdeHAP.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(etRecibosdeHAP);
		PanelOeste.add(Box.createRigidArea(new Dimension(0, 5)));
		check6 = new JCheckBox("Fotocopia últimos recibos de hipotreca/alquiler/prestamos");
		check6.setMaximumSize(new Dimension(100, 30));
		check6.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(check6);

		JLabel etContribucion = new JLabel("");
		etContribucion.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(etContribucion);
		PanelOeste.add(Box.createRigidArea(new Dimension(0, 5)));
		check7 = new JCheckBox("Fotocopia último recibo de contribución");
		check7.setMaximumSize(new Dimension(100, 40));
		check7.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(check7);

		JLabel etIRPF = new JLabel("");
		etIRPF.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(etIRPF);
		PanelOeste.add(Box.createRigidArea(new Dimension(0, 5)));
		check8 = new JCheckBox("Fotocopia última declaración IRPF");
		check8.setMaximumSize(new Dimension(100, 30));
		check8.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(check8);

		JLabel TPCAPEB = new JLabel("..........TRABAJADORES POR CUENTA AJENA(PARA EL BANCO)..........");
		TPCAPEB.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(TPCAPEB);
		PanelOeste.add(Box.createRigidArea(new Dimension(0, 10)));

		JLabel etDni1 = new JLabel("");
		etDni1.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(etDni1);
		PanelOeste.add(Box.createRigidArea(new Dimension(0, 5)));
		check9 = new JCheckBox("Fotocopia DNI/NIE");
		check9.setMaximumSize(new Dimension(100, 30));
		check9.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(check9);

		JLabel etUltimasNominas1 = new JLabel("");
		etUltimasNominas1.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(etUltimasNominas1);
		PanelOeste.add(Box.createRigidArea(new Dimension(50, 5)));
		check10 = new JCheckBox("Fotocopia de las tres últimas nominas");
		check10.setMaximumSize(new Dimension(100, 30));
		check10.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(check10);

		JLabel etControlLaboral1 = new JLabel("");
		etControlLaboral1.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(etControlLaboral1);
		PanelOeste.add(Box.createRigidArea(new Dimension(0, 5)));
		check11 = new JCheckBox("Copia del control laboral(< 3)");
		check11.setMaximumSize(new Dimension(100, 30));
		check11.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(check11);

		JLabel etMovimientosBancarios1 = new JLabel("");
		etMovimientosBancarios1.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(etMovimientosBancarios1);
		PanelOeste.add(Box.createRigidArea(new Dimension(0, 5)));
		check12 = new JCheckBox("Fotocopia de los últimos movimientos bancarios(3 meses)");
		check12.setMaximumSize(new Dimension(100, 30));
		check12.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(check12);

		JLabel etVidaLaboral1 = new JLabel("");
		etVidaLaboral1.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(etVidaLaboral1);
		PanelOeste.add(Box.createRigidArea(new Dimension(20, 5)));
		check13 = new JCheckBox("Vida laboral");
		check13.setMaximumSize(new Dimension(100, 30));
		check13.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(check13);

		JLabel etRecibosdeHAP1 = new JLabel("");
		etRecibosdeHAP1.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(etRecibosdeHAP1);
		PanelOeste.add(Box.createRigidArea(new Dimension(0, 5)));
		check14 = new JCheckBox("Fotocopia últimos recibos de hipotreca/alquiler/prestamos");
		check14.setMaximumSize(new Dimension(100, 30));
		check14.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelOeste.add(check14);

		return PanelOeste;
	}

	private JPanel PanelEste() {
		JPanel PanelEste = new JPanel();
		PanelEste.setLayout(new FlowLayout(FlowLayout.LEFT));
		PanelEste.setPreferredSize(new Dimension(500, 75));

		JLabel TPCA = new JLabel("..........TRABAJADORES AUTONOMOS(PARA NOSOTROS)..........");
		TPCA.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(TPCA);
		PanelEste.add(Box.createRigidArea(new Dimension(0, 10)));

		JLabel etDni = new JLabel("");
		etDni.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(etDni);
		PanelEste.add(Box.createRigidArea(new Dimension(40, 10)));
		check15 = new JCheckBox("Fotocopia DNI/NIE");
		check15.setMaximumSize(new Dimension(100, 30));
		check15.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(check15);

		JLabel etIRPF = new JLabel("");
		etIRPF.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(etIRPF);
		PanelEste.add(Box.createRigidArea(new Dimension(100, 10)));
		check16 = new JCheckBox("Fotocopia última declaración vigente IRPF");
		check16.setMaximumSize(new Dimension(100, 30));
		check16.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(check16);

		JLabel etIAE = new JLabel("");
		etIAE.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(etIAE);
		PanelEste.add(Box.createRigidArea(new Dimension(160, 10)));
		check17 = new JCheckBox("Alta IAE");
		check17.setMaximumSize(new Dimension(100, 30));
		check17.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(check17);

		JLabel etMovimientosBancarios = new JLabel("");
		etMovimientosBancarios.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(etMovimientosBancarios);
		PanelEste.add(Box.createRigidArea(new Dimension(70, 10)));
		check18 = new JCheckBox("Fotocopia de los últimos movimientos bancarios(3 meses)");
		check18.setMaximumSize(new Dimension(100, 30));
		check18.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(check18);

		JLabel etRecibosdeHAP = new JLabel("");
		etRecibosdeHAP.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(etRecibosdeHAP);
		PanelEste.add(Box.createRigidArea(new Dimension(0, 5)));
		check19 = new JCheckBox("Fotocopia de últimos recibos hipotreca/alquiler/prestamos");
		check19.setMaximumSize(new Dimension(100, 30));
		check19.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(check19);

		JLabel etContribucion = new JLabel("");
		etContribucion.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(etContribucion);
		PanelEste.add(Box.createRigidArea(new Dimension(0, 5)));
		check20 = new JCheckBox("Fotocopia último recibo de contribución");
		check20.setMaximumSize(new Dimension(100, 40));
		check20.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(check20);

		JLabel etTrismentrales = new JLabel("");
		etTrismentrales.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(etTrismentrales);
		PanelEste.add(Box.createRigidArea(new Dimension(0, 5)));
		check21 = new JCheckBox("Fotocopia de pagos trimestrales IVA  e IRPF");
		check21.setMaximumSize(new Dimension(100, 30));
		check21.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(check21);

		JLabel etConsolidadoIVA = new JLabel("");
		etConsolidadoIVA.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(etConsolidadoIVA);
		PanelEste.add(Box.createRigidArea(new Dimension(0, 5)));
		check22 = new JCheckBox("Fotocopia del ejercicio consolidado del IVA");
		check22.setMaximumSize(new Dimension(100, 30));
		check22.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(check22);

		JLabel TAPEB = new JLabel("..........TRABAJADORES AUTONOMOS(PARA EL BANCO)..........");
		TAPEB.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(TAPEB);
		PanelEste.add(Box.createRigidArea(new Dimension(0, 10)));

		JLabel etDni1 = new JLabel("");
		etDni1.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(etDni1);
		PanelEste.add(Box.createRigidArea(new Dimension(40, 10)));
		check23 = new JCheckBox("Fotocopia DNI/NIE");
		check23.setMaximumSize(new Dimension(100, 30));
		check23.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(check23);

		JLabel etIRPF1 = new JLabel("");
		etIRPF1.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(etIRPF1);
		PanelEste.add(Box.createRigidArea(new Dimension(100, 10)));
		check24 = new JCheckBox("Fotocopia última declaración vigente IRPF");
		check24.setMaximumSize(new Dimension(100, 30));
		check24.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(check24);

		JLabel etIAE1 = new JLabel("");
		etIAE1.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(etIAE1);
		PanelEste.add(Box.createRigidArea(new Dimension(160, 10)));
		check25 = new JCheckBox("Alta IAE");
		check25.setMaximumSize(new Dimension(100, 30));
		check25.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(check25);

		JLabel etMovimientosBancarios1 = new JLabel("");
		etMovimientosBancarios1.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(etMovimientosBancarios1);
		PanelEste.add(Box.createRigidArea(new Dimension(70, 10)));
		check26 = new JCheckBox("Fotocopia de los últimos movimientos bancarios(3 meses)");
		check26.setMaximumSize(new Dimension(100, 30));
		check26.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(check26);

		JLabel etRecibosdeHAP1 = new JLabel("");
		etRecibosdeHAP1.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(etRecibosdeHAP1);
		PanelEste.add(Box.createRigidArea(new Dimension(0, 5)));
		check27 = new JCheckBox("Fotocopia de últimos recibos hipotreca/alquiler/prestamos");
		check27.setMaximumSize(new Dimension(100, 30));
		check27.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(check27);

		JLabel etContribucion1 = new JLabel("");
		etContribucion1.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(etContribucion1);
		PanelEste.add(Box.createRigidArea(new Dimension(0, 5)));
		check28 = new JCheckBox("Fotocopia último recibo de contribución");
		check28.setMaximumSize(new Dimension(100, 40));
		check28.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelEste.add(check28);

		return PanelEste;
	} // final del Panel Este

	private JPanel PanelSur() {
		JPanel PanelSur = new JPanel();
		PanelSur.setLayout(new FlowLayout(FlowLayout.LEFT));
		PanelSur.setPreferredSize(new Dimension(1275, 230));

		boton1 = new JButton("REGISTRAR");
		boton1.setMaximumSize(new Dimension(100, 30));
		boton1.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelSur.add(boton1);

// boton1.addActionListener(this);
// imp.addActionListener(new GestorImprimir());
// imp.addActionListener(new GestorImprimir());

		etNotas = new JTextArea();
		etNotas.setLineWrap(true);
		etNotas.setWrapStyleWord(true);
		etNotas.setPreferredSize(new Dimension(250, 150));
		JScrollPane sp = new JScrollPane(etNotas);
		sp.setHorizontalScrollBar(null);
		sp.setPreferredSize(new Dimension(240, 100));
		sp.setAlignmentX(Component.CENTER_ALIGNMENT);
		sp.setBorder(BorderFactory.createLoweredBevelBorder());
		PanelSur.add(sp);

		JLabel fn = new JLabel(" DNI/NIE: ");
		fn.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelSur.add(fn);
		PanelSur.add(Box.createRigidArea(new Dimension(0, 3)));
		dni = new JTextField(25);
		dni.setMaximumSize(new Dimension(100, 30));
		dni.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelSur.add(dni);

		boton2 = new JButton("BUSCAR");
		boton2.setMaximumSize(new Dimension(100, 30));
		boton2.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelSur.add(Box.createRigidArea(new Dimension(0, 10)));
		PanelSur.add(boton2);

		JLabel aquiCliente = new JLabel("           aqui cliente");
		aquiCliente.setAlignmentX(Component.LEFT_ALIGNMENT);
		PanelSur.add(aquiCliente);
		aquiCliente.setMaximumSize(new Dimension(150, 30));
		PanelSur.add(Box.createRigidArea(new Dimension(150, 10)));

		return PanelSur;
	}

	private JPanel espacio1() {
		JPanel espacio1 = new JPanel();
		espacio1.setLayout(new FlowLayout(FlowLayout.LEFT));
		espacio1.setPreferredSize(new Dimension(200, 30));
//espacio1.setBorder(BorderFactory.createLoweredBevelBorder());
		return espacio1;
	}
}
