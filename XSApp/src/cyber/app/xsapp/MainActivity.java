package cyber.app.xsapp;

import cyber.app.xsapp.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import cyber.app.xsapp.controller.ConnectionTask;
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

		btnGet.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				getInfo();
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
