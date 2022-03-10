package com.crm.graficos;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Lan {
	private static JTextField texto;
	@SuppressWarnings("unused")
	private static String guardo1;

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		Image imagen = Toolkit.getDefaultToolkit().getImage("imagenes/icono.png");
		JFrame marco = new JFrame("CRM");
		marco.setIconImage(imagen);
		JDialog dialogo = new JDialog(marco, true);
		// top y left
		JPanel panel = new JPanel();
		panel.add(new JLabel("Introduce licencia"));
		texto = new JTextField(16);
		guardo1 = new String();
		dialogo.setSize(250, 125);
		texto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				String aux = texto.getText();
				if (aux.equals("0034")) {
					dialogo.dispose();
					marco.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Ha introducido una licencia erronea.", "¡Algo salió mal!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(texto);
		dialogo.getContentPane().add(panel);
		dialogo.setVisible(true);// visibilizar el dialogo
		// dialogo.dispose para cerrarlo

		marco.setLocation(0, 0);
		// no se puede hacer un new
		// metodo estatico
		Toolkit tk = Toolkit.getDefaultToolkit();
		// panel con varias pestañas
		JTabbedPane pestanias = new JTabbedPane();
		//pestanias.add("Directorio de Cliente", new PanelClientes());
		//pestanias.add("Peticion de Hipoteca", new PanelHipoteca());
		//pestanias.add("Requisitos", new PanelRequisitos());
		pestanias.add("Encargos", new PanelEncargos());
		// lo metemos en el frame (aqui se visualiza)
		marco.getContentPane().add(pestanias);
		// damos dimensión a nuestro marco según tamaño pantalla
		Dimension dim = tk.getScreenSize();
		System.out.println(dim.width + "," + dim.height);
		// no perder barra de tareas
		marco.setSize(dim.width-1, dim.height-55);
		// haciendo el marco visible,soe,pre al final
		// marco.setVisible(true);
		// Properties prop = System.getProperties();
		// prop.list(System.out);
		// String guardo = System.getProperty("user.language");
		// System.out.println(guardo);

		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
