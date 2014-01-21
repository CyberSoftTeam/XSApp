package cyber.app.xsapp;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.sun.syndication.feed.rss.Item;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import cyber.app.xsapp.R;
import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import cyber.app.xsapp.controller.ConnectionTask;
import cyber.app.xsapp.database.DBConstant.PrizeTable;
import cyber.app.xsapp.database.DBConstant.ProvinceTable;
import cyber.app.xsapp.database.DBHelper;
import cyber.app.xsapp.database.entities.Prize;
import cyber.app.xsapp.database.entities.Ticket;
import cyber.app.xsapp.services.ConnectionService;
import cyber.app.xsapp.utils.Common;
import cyber.app.xsapp.utils.MessageUtil;

public class MainActivity extends Activity {
	private TextView txtResult;
	private Button btnGet;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnGet = (Button)findViewById(R.id.btnGet);
		txtResult = (TextView)findViewById(R.id.result);

		Intent intent = new Intent(this, ConnectionService.class);
		startService(intent);
		
		File file = new File(Environment.getExternalStorageDirectory() + File.separator + "xsapp");
		
		if(!file.exists()) {
			file.mkdir();
		}
		

		btnGet.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				final DBHelper dbHelper = new DBHelper(getApplicationContext());
				ConnectionTask connectionTask = new ConnectionTask(MainActivity.this) {

					@Override
					protected Object doInBackground(String... params) {
						super.doInBackground(params);
						return dbHelper.getAllProvinces();
					}

					@Override
					protected void onPostExecute(Object result) {
						super.onPostExecute(result);
						Cursor cursor = (Cursor)result;
						String text = "";
						while (cursor.moveToNext()) {
							 text += cursor.getString(cursor.getColumnIndex(ProvinceTable.NAME)) + "\n";
						}
						txtResult.setText(text);
					}
					
				};
				
				connectionTask.execute("XXX");
				
				/*ConnectionTask connectionTask = new ConnectionTask(MainActivity.this) {

					@Override
					protected Object doInBackground(String... params) {
						super.doInBackground(params);
						String result = "";
						try {
							URL url = new URL("http://xskt.com.vn/rss-feed/can-tho-xsct.rss");
							XmlReader reader = new XmlReader(url);
							SyndFeedInput input = new SyndFeedInput();
							SyndFeed feed = input.build(reader);
							result += feed.getDescription();
							Log.d("XXX", result);
						} catch (MalformedURLException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (FeedException e) {
							e.printStackTrace();
						}
						return result;
					}

					@Override
					protected void onPostExecute(Object result) {
						super.onPostExecute(result);
						txtResult.setText((String)result);
					}
				};
				
				connectionTask.execute("XXX");*/
			}

		});
	}

	private void getInfo() {
		final String url = "http://xskt.com.vn/rss-feed/tp-hcm-xshcm.rss";

		// Check network connection
		if (!Common.isConnect(MainActivity.this)) {
			MessageUtil.showNetworkInfo(MainActivity.this);
				
			return;
		}
		
		ConnectionTask task = new ConnectionTask(MainActivity.this) {
			@Override
			protected String doInBackground(String... params) {
				super.doInBackground(params);
				ConnectionService service = new ConnectionService(MainActivity.this);
				
				return service.call(url);
				
			}
			
			@Override
			protected void onPostExecute(Object result) {
				super.onPostExecute(result);

				if (result != null) {
					txtResult.setText((String)result);
				} else {
					MessageUtil.showDialogInfo(this.activity,
							R.string.admin_configuration_fail);
				}

			}
		};
		
		task.execute(url);
	}
}
