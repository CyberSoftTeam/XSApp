package cyber.app.xsapp.controller;

import cyber.app.xsapp.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

public class ConnectionTask extends AsyncTask<String, Void, Object> {
	protected Activity activity;
	protected ProgressDialog progressDialog;

	/**
	 * Constructor
	 * 
	 * @param activity
	 *            Activity
	 */
	public ConnectionTask(Activity activity) {
		this.activity = activity;
	}


	@Override
	protected Object doInBackground(String... params) {
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// Show progress dialog
				progressDialog = ProgressDialog.show(activity, "",
						activity.getString(R.string.processing), true);
				progressDialog.setCancelable(false);
			}
		});
		
		return null;
	}

	@Override
	protected void onPostExecute(Object result) {
		progressDialog.dismiss();
	}
}
