package org.personal.mason.ws.client;

import java.util.List;

import org.oorsprong.websamples.ArrayOftCountryInfo;
import org.oorsprong.websamples.ArrayOftLanguage;
import org.oorsprong.websamples.TCountryInfo;
import org.oorsprong.websamples.TLanguage;
import org.oorsprong.websamples_countryinfo.CountryInfoService;
import org.oorsprong.websamples_countryinfo.CountryInfoServiceSoapType;

public class TestTest {

public static void main(String[] args) {
	CountryInfoService service = new CountryInfoService();
	CountryInfoServiceSoapType soup = service.getCountryInfoServiceSoap();
	ArrayOftCountryInfo allCountry = soup.fullCountryInfoAllCountries();
	List<TCountryInfo> tCountryInfo = allCountry.getTCountryInfo();
	for (TCountryInfo info : tCountryInfo) {
	    ArrayOftLanguage languages = info.getLanguages();
	    List<TLanguage> tLanguage = languages.getTLanguage();
	    for (TLanguage lan : tLanguage) {
	        
        }
	    String sCapitalCity = info.getSCapitalCity();
	    String sContinentCode = info.getSContinentCode();
	    String sCountryFlag = info.getSCountryFlag();
	    String sCurrencyISOCode = info.getSCurrencyISOCode();
	    String sisoCode = info.getSISOCode();
	    String sName = info.getSName();
	    String sPhoneCode = info.getSPhoneCode();
	    
	    System.out.println(sName + "\t\t" + sPhoneCode + "\t\t" + sisoCode + "\t\t" + sCurrencyISOCode + "\t\t" + sCountryFlag + "\t\t" + sContinentCode + "\t\t" + sCapitalCity + "\n");
    }
	System.out.println(tCountryInfo.size());
}
}
