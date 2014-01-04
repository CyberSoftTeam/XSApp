package cyber.app.xsapp.services;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.util.Log;
import cyber.app.xsapp.Constants;
import cyber.app.xsapp.Param;

public class ConnectionService {
	private Context context;
	
	public ConnectionService(Context context) {
		this.context = context;
	}

	public String call(String url) {
		try {
			// create http client
			HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams, Param.CONNECTION_TIME_OUT);
			HttpConnectionParams.setSoTimeout(httpParams, Param.SOCKET_TIME_OUT);
			HttpClient client = new DefaultHttpClient(httpParams);
			
			// create request
			HttpGet httpGet = new HttpGet(url);
			HttpResponse response = client.execute(httpGet);
			String res = EntityUtils.toString(response.getEntity());
			Log.i(Constants.TAG, "Result: " + res);
			return res;
			
		} catch (Exception e) {
			Log.e(Constants.TAG, e.getMessage(), e);
		}
		return null;
	}
}
