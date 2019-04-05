package src.atj.rest.resources;

import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

import src.atj.rest.model.AverageRateResult;
import src.atj.rest.service.AverageRateService;

@Path("/rates")
@Produces(MediaType.APPLICATION_XML)
public class AverageRateResource  {
	AverageRateService avgService = new AverageRateService();
	
	@GET
	@Path("/{currency}/{sessions}")
	public AverageRateResult getRateResult(
			@PathParam("currency") String currency,
			@PathParam("sessions") String sessions)
	{
		try {
			return avgService.getResult(currency, sessions);
		} catch (JAXBException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
				
	
	
	
}
