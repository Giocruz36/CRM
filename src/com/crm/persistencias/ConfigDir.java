package com.crm.persistencias;

import java.io.InputStream;
import java.util.Properties;

public class ConfigDir {
	private static Properties oProperties = new Properties();
	private static ConfigDir conf = null;

	public ConfigDir() {
		try {
			InputStream oImputStream = getClass().getResourceAsStream("cosa/CSIDir.properties");
			oProperties.load(oImputStream);
		} catch (Exception e) {
		}
	}

	public static ConfigDir getInstance() {
		if (null == conf)
			conf = new ConfigDir();
		return conf;
	}

	public String getProperty(String prop) {
		return oProperties.getProperty(prop);
	}

	public boolean getBooleanProperty(String prop) {
		boolean ret = false;
		String salida = oProperties.getProperty(prop);
		if (salida.equals("yes") || salida.equals("true") || salida.equals("si") || salida.equals("1"))
			ret = true;
		return ret;
	} 

	public boolean getBooleanProperty2(String prop) {
		boolean ret = false;
		String salida = prop;
		if (salida.equals("yes") || salida.equals("true") || salida.equals("si") || salida.equals("1"))
			ret = true;
		return ret;
	} 

}
