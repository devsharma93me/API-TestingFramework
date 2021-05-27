package testCaseExecutor;

import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import webservices.base.TestBase;
import webservices.client.RestClient;

public class GetAPITest extends TestBase {
	public TestBase testbase;
	public String Url;
	public String apiURL;
	public String URI;
	public RestClient restClient;

	@BeforeMethod
	public void setUP() {
		testbase = new TestBase();
		Url = prop.getProperty("URL");
		apiURL = prop.getProperty("serviceURL");
		URI = Url + apiURL;

	}
	@Test
	public void getTest() throws ClientProtocolException, IOException {
		restClient = new RestClient();
		restClient.get(URI);
	}

}
