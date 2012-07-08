package org.personal.mason.ws.client;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.oorsprong.websamples.ArrayOftContinent;
import org.oorsprong.websamples.ArrayOftCountryInfo;
import org.oorsprong.websamples.ArrayOftLanguage;
import org.oorsprong.websamples.TContinent;
import org.oorsprong.websamples.TCountryInfo;
import org.oorsprong.websamples.TLanguage;
import org.oorsprong.websamples_countryinfo.CountryInfoService;
import org.oorsprong.websamples_countryinfo.CountryInfoServiceSoapType;
import org.personal.mason.ws.client.conf.EntityManagerHelper;
import org.personal.mason.ws.client.domain.Continent;
import org.personal.mason.ws.client.domain.Country;
import org.personal.mason.ws.client.domain.Language;

public class Test {

public static void getAllCountries(String[] args) {
	// CountryInfoService service = new CountryInfoService();
	// CountryInfoServiceSoapType soup = service.getCountryInfoServiceSoap();
	// ArrayOftCountryInfo allCountry = soup.fullCountryInfoAllCountries();
	// List<TCountryInfo> tCountryInfo = allCountry.getTCountryInfo();
	// for (TCountryInfo info : tCountryInfo) {
	// ArrayOftLanguage languages = info.getLanguages();
	// List<TLanguage> tLanguage = languages.getTLanguage();
	// for (TLanguage lan : tLanguage) {
	//
	// }
	// String sCapitalCity = info.getSCapitalCity();
	// String sContinentCode = info.getSContinentCode();
	// String sCountryFlag = info.getSCountryFlag();
	// String sCurrencyISOCode = info.getSCurrencyISOCode();
	// String sisoCode = info.getSISOCode();
	// String sName = info.getSName();
	// String sPhoneCode = info.getSPhoneCode();
	//
	// try {
	// sCountryFlag = sCapitalCity.replaceAll(",.", ".");
	// URL url = new URL(sCountryFlag);
	// HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	// conn.connect();
	// int responseCode = conn.getResponseCode();
	// if(responseCode != 200){
	// System.err.println("Errors: --> " + sName + "\t\t" + sPhoneCode + "\t\t" + sisoCode + "\t\t" + sCurrencyISOCode +
	// "\t\t" + sCountryFlag + "\t\t" + sContinentCode + "\t\t" + sCapitalCity + "\n");
	// continue;
	// }
	// BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
	// ByteArrayOutputStream bos = new ByteArrayOutputStream();
	// byte[] buf = new byte[1024];
	// int len;
	// while ((len = bin.read(buf)) > 0) {
	// bos.write(buf, 0, len);
	// }
	//
	// // reader.re
	// byte[] countryFlag = bos.toByteArray();
	// Country country = new Country(sName, sPhoneCode, sisoCode, sCurrencyISOCode, countryFlag, sCapitalCity,
	// sContinentCode);
	//
	// try {
	// EntityManagerHelper.beginTransaction();
	// EntityManagerHelper.getEntityManager().persist(country);
	// EntityManagerHelper.commit();
	// } catch (Exception e) {
	// EntityManagerHelper.rollback();
	// }
	//
	// // System.out.println(sName + "\t\t" + sPhoneCode + "\t\t" + sisoCode + "\t\t" + sCurrencyISOCode + "\t\t" +
	// // sCountryFlag + "\t\t" + sContinentCode + "\t\t" + sCapitalCity + "\n");
	// } catch (MalformedURLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// System.out.println(tCountryInfo.size());
}

public static void getAllContinent() {
	CountryInfoService service = new CountryInfoService();
	CountryInfoServiceSoapType soup = service.getCountryInfoServiceSoap();
	ArrayOftContinent listOfContinentsByCode = soup.listOfContinentsByCode();
	List<TContinent> tContinent = listOfContinentsByCode.getTContinent();
	for (TContinent continent : tContinent) {
		String sCode = continent.getSCode();
		String sName = continent.getSName();
		Continent cont = new Continent(sName);
		cont.setContinentCode(sCode);

		try {
			EntityManagerHelper.beginTransaction();
			EntityManagerHelper.getEntityManager().persist(cont);
			EntityManagerHelper.commit();
		} catch (Exception e) {
			EntityManagerHelper.rollback();
		}
	}
}

public static void getAllLanguages() {
	CountryInfoService service = new CountryInfoService();
	CountryInfoServiceSoapType soup = service.getCountryInfoServiceSoap();
	ArrayOftLanguage listOfLanguagesByCode = soup.listOfLanguagesByCode();
	List<TLanguage> tLanguage = listOfLanguagesByCode.getTLanguage();
	for (TLanguage language : tLanguage) {
		String sisoCode = language.getSISOCode();
		String sName = language.getSName();
		Language lang = new Language(sName);
		lang.setLanguageCode(sisoCode);
		try {
			EntityManagerHelper.beginTransaction();
			EntityManagerHelper.getEntityManager().persist(lang);
			EntityManagerHelper.commit();
		} catch (Exception e) {
			EntityManagerHelper.rollback();
		}
	}
}

public static <V> void main(String... args) {
	getAllLanguages();
	getAllContinent();

	EntityManagerHelper.beginTransaction();
	EntityManager entityManager = EntityManagerHelper.getEntityManager();
	Query createQuery = entityManager.createQuery("from Continent");
	List<Continent> resultList = createQuery.getResultList();
	Map<String, Continent> cmap = new HashMap<String, Continent>();
	for (Continent continent : resultList) {
		cmap.put(continent.getContinentCode(), continent);
	}
	EntityManagerHelper.commit();

	EntityManagerHelper.beginTransaction();
	EntityManager em = EntityManagerHelper.getEntityManager();
	Query cq = em.createQuery("from Language");
	List<Language> rl = cq.getResultList();
	Map<String, Language> lmap = new HashMap<String, Language>();
	for (Language lang : rl) {
		lmap.put(lang.getLanguageCode(), lang);
	}
	EntityManagerHelper.commit();

	CountryInfoService service = new CountryInfoService();
	CountryInfoServiceSoapType soup = service.getCountryInfoServiceSoap();
	ArrayOftCountryInfo allCountry = soup.fullCountryInfoAllCountries();
	List<TCountryInfo> tCountryInfo = allCountry.getTCountryInfo();
	for (TCountryInfo info : tCountryInfo) {
		ArrayOftLanguage languages = info.getLanguages();

		String sCapitalCity = info.getSCapitalCity();
		String sContinentCode = info.getSContinentCode();
		String sCountryFlag = info.getSCountryFlag();
		String sCurrencyISOCode = info.getSCurrencyISOCode();
		String sisoCode = info.getSISOCode();
		String sName = info.getSName();
		String sPhoneCode = info.getSPhoneCode();

		try {
			sCountryFlag = sCountryFlag.replaceAll(",.", ".");
			URL url = new URL(sCountryFlag);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.connect();
			int responseCode = conn.getResponseCode();
			if (responseCode != 200) {
				System.err.println("Errors: --> " + sName + "\t\t" + sPhoneCode + "\t\t" + sisoCode + "\t\t" + sCurrencyISOCode + "\t\t" + sCountryFlag
				        + "\t\t" + sContinentCode + "\t\t" + sCapitalCity + "\n");
				continue;
			}
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int len;
			while ((len = bin.read(buf)) > 0) {
				bos.write(buf, 0, len);
			}

			// reader.re
			byte[] countryFlag = bos.toByteArray();
			Continent continent = cmap.get(sContinentCode);
			Country country = new Country(sName, sPhoneCode);
			country.setIsoCode(sisoCode);
			country.setCurrencyIsoCode(sCurrencyISOCode);
			country.setCountryFlag(countryFlag);
			country.setCapitalCity(sCapitalCity);
			country.setContinent(continent);
			Set<Language> langs = new HashSet<Language>();
			
			List<TLanguage> tLanguage = languages.getTLanguage();
			for (TLanguage lan : tLanguage) {
				langs.add(lmap.get(lan.getSISOCode()));
			}
			country.setLanguages(langs);
			if(country.getLanguages().size() > 1){
				System.out.println(country);
			}
			
			try {
				EntityManagerHelper.beginTransaction();
				EntityManagerHelper.getEntityManager().persist(country);
				EntityManagerHelper.commit();
			} catch (Exception e) {
				EntityManagerHelper.rollback();
			}

			

			// System.out.println(sName + "\t\t" + sPhoneCode + "\t\t" + sisoCode + "\t\t" + sCurrencyISOCode + "\t\t" +
			// sCountryFlag + "\t\t" + sContinentCode + "\t\t" + sCapitalCity + "\n");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	System.out.println(tCountryInfo.size());
}
}
