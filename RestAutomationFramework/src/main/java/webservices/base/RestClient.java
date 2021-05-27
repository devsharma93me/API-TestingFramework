package webservices.base;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {

//1.GET METHOD
	public void get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet();
		CloseableHttpResponse closablehttpResponse = httpclient.execute(httpGet);
		
//1.a GET STATUS CODE
		
		int statusCode = closablehttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code -- "+statusCode);

	}

}
