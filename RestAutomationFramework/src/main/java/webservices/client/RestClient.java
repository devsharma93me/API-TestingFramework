package webservices.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {

//1.GET METHOD
	public void get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse closablehttpresponse = httpclient.execute(httpget);

//1.a GET STATUS CODE

		int statusCode = closablehttpresponse.getStatusLine().getStatusCode();
		System.out.println("Status Code -- " + statusCode);

//1.b JSON String

		String responseString = EntityUtils.toString(closablehttpresponse.getEntity(), "UTF-8");
		JSONObject responseJSON = new JSONObject(responseString);
		System.out.println("Response in JSON from API" + responseJSON);

//1.c ALL HEADERS
		Header[] headersArray = closablehttpresponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : headersArray) {
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("Headers---->>" + allHeaders);
	}

}
