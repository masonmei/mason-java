package org.personal.mason.pb.server.conf;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyConfig {
private static final String PROPERTYCONFIGFILE = "config.properties";
private static Properties configProp = new Properties();
static {
	try {
		InputStream resourceAsStream = PropertyConfig.class.getClassLoader().getResourceAsStream(PROPERTYCONFIGFILE);
		configProp.load(resourceAsStream);
	} catch (IOException e) {
		e.printStackTrace();
	}
}

public static Properties getConfigProp() {
	return configProp;
}

}
