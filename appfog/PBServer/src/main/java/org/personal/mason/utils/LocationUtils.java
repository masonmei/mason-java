package org.personal.mason.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.core.io.support.PropertiesLoaderUtils;

public class LocationUtils {

private static final String LOCATION_PROPERTIES = "locations.properties";
private static Map<String, List<String>> LOCATION_MAP;

static {
	try {
		Properties properties = PropertiesLoaderUtils.loadAllProperties(LOCATION_PROPERTIES);
		Set<String> propertyNames = properties.stringPropertyNames();
		LOCATION_MAP = new Hashtable<>();
		for (String string : propertyNames) {
			String property = properties.getProperty(string, "");
			String[] split = property.split(",");
			LOCATION_MAP.put(string, Arrays.asList(split));
		}
	} catch (IOException e) {
	}

}

public static List<String> getAllProvince() {
	return new ArrayList<>(LOCATION_MAP.keySet());
}

public static List<String> getCitiesOfProvince(String provinceName) {
	return LOCATION_MAP.get(provinceName);
}

}
