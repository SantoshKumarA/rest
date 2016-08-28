package main;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.StatusType;

/**
 * Calls the RESTful web service at REST_URL defined below.
 * 
 * @author Santosh Kumar
 *
 */
public class RESTMain {
	// some times these services may be down..
	private static final String REST_URL = "https://currency-api.appspot.com/api/USD/EUR.json";
	private static final int OK_STATUS = Response.Status.OK.getStatusCode();

	/**
	 * Call the web service and display the response
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// call the web service and get the response object
		Response response = ClientBuilder.newClient().target(REST_URL).request(MediaType.APPLICATION_JSON).get();

		// process the response object
		StatusType statusType = response.getStatusInfo();
		int statusCode = statusType.getStatusCode();

		if (statusCode == OK_STATUS) {
			System.out.println(response.readEntity(String.class));
		} else {
			System.out.printf("Service returned status: \"%d %s\"\n", statusCode, statusType.getReasonPhrase());
		}
	}

}
