package org.personal.mason.ws.client.weather;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.personal.mason.ws.client.weather.config.EntityManagerHelper;
import org.personal.mason.ws.client.weather.domain.WeatherDefinition;

import com.cdyne.ws.weatherws.ArrayOfWeatherDescription;
import com.cdyne.ws.weatherws.Weather;
import com.cdyne.ws.weatherws.WeatherDescription;
import com.cdyne.ws.weatherws.WeatherSoap;

public class MainTest {
public static void main(String[] args) {
	Weather weather = new Weather();
	WeatherSoap weatherSoap12 = weather.getWeatherSoap12();
	ArrayOfWeatherDescription weatherInformation = weatherSoap12.getWeatherInformation();
	for (WeatherDescription wd : weatherInformation.getWeatherDescription()) {
		// short weatherID = wd.getWeatherID();
		String description = wd.getDescription();
		String pictureURL = wd.getPictureURL();

		try {
			EntityManagerHelper.beginTransaction();
			WeatherDefinition definition = new WeatherDefinition();
			definition.setDescription(description);

			URL url = new URL(pictureURL);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			int responseCode = conn.getResponseCode();
			if (responseCode != 200) {
				continue;
			}
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int len;
			while ((len = bin.read(buf)) > 0) {
				bos.write(buf, 0, len);
			}

			//

			byte[] weatherImage = bos.toByteArray();
			definition.setWeatherImage(weatherImage);

			EntityManagerHelper.commit();
		} catch (Exception e) {
			e.printStackTrace();
			EntityManagerHelper.rollback();
		}
	}

}
}
