package src.atj.rest.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import src.atj.rest.model.AverageRateResult;
import src.atj.rest.model.ExchangeRatesSeries;


public class AverageRateService {
	
public AverageRateResult getResult(String currency, String sessions) throws JAXBException, IOException{
		
		JAXBContext jaxbContext = JAXBContext.newInstance(ExchangeRatesSeries.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		String urlString = "http://api.nbp.pl/api/exchangerates/rates/C/"+currency+"/last/"+sessions+"/";
		
		URL url = new URL(urlString);
		
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/xml");
		connection.connect();

		ExchangeRatesSeries exch= (ExchangeRatesSeries) jaxbUnmarshaller.unmarshal(connection.getInputStream());
		AverageRateCalculation calcService = new AverageRateCalculation(exch);
		
		return new AverageRateResult(calcService.getAvgAsk(),calcService.getAvgBid());
				
	}
}
