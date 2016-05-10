package info.xuding.stock.utils;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class SimpleHttpLoader {

	public static String get(String url) {
		HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
		HttpGet httpGet = new HttpGet(url);
		try {
			HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
			HttpEntity entity = httpResponse.getEntity();
			System.out.println("status:" + httpResponse.getStatusLine() + " url:" + url);
			if (entity != null) {
				return EntityUtils.toString(entity);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				closeableHttpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
