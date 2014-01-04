package cyber.app.xsapp.utils;

import cyber.app.xsapp.Constants;
import cyber.app.xsapp.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class MessageUtil {

	/**
	 * Show network connection error info and allow user change language setting
	 * 
	 * @param act
	 */
	public static void showNetworkInfo(final Activity act) {
		// create dialog
		AlertDialog.Builder builder = new AlertDialog.Builder(act);
		builder.setTitle(R.string.app_name);
		builder.setMessage(R.string.no_network);
		builder.setCancelable(false);
		builder.setPositiveButton(R.string.btn_setting,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						Intent intent = new Intent(Settings.ACTION_SETTINGS);
						act.startActivity(intent);
					}
				});
		builder.setNegativeButton(R.string.btn_cancel,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
		AlertDialog alert = builder.create();
		alert.show();
	}

	// /**
	// * Show network connection error info and allow user continue without
	// * network
	// *
	// * @param act
	// */
	// public static void showNetworkState(final Activity act) {
	// // create dialog
	// AlertDialog.Builder builder = new AlertDialog.Builder(act);
	// builder.setTitle(R.string.app_name);
	// builder.setMessage(R.string.no_network);
	// builder.setCancelable(false);
	// builder.setPositiveButton(R.string.setting,
	// new DialogInterface.OnClickListener() {
	// public void onClick(DialogInterface dialog, int id) {
	// Intent intent = new Intent(
	// Settings.ACTION_WIRELESS_SETTINGS);
	// act.startActivity(intent);
	// act.finish();
	// }
	// });
	// builder.setNegativeButton(R.string.cancel,
	// new DialogInterface.OnClickListener() {
	// public void onClick(DialogInterface dialog, int id) {
	// dialog.cancel();
	// }
	// });
	// AlertDialog alert = builder.create();
	// alert.show();
	// }
	//
	// /**
	// * Show normal info
	// *
	// * @param act
	// */
	// public static void showFinishDialogInfo(final BaseTabGroupActvity act,
	// int message) {
	// // create dialog
	// AlertDialog.Builder builder = new AlertDialog.Builder(act);
	// builder.setTitle(R.string.app_name);
	// builder.setMessage(message);
	// builder.setCancelable(false);
	// builder.setNegativeButton(R.string.ok,
	// new DialogInterface.OnClickListener() {
	// public void onClick(DialogInterface dialog, int id) {
	// dialog.cancel();
	// act.getCurrentChild().finish();
	// }
	// });
	// AlertDialog alert = builder.create();
	// alert.show();
	// }

	/**
	 * Show normal info
	 * 
	 * @param act
	 */
	public static void showDialogInfo(Activity act, int message) {
		// create dialog
		AlertDialog.Builder builder = new AlertDialog.Builder(act);
		builder.setTitle(R.string.app_name);
		builder.setMessage(message);
		builder.setCancelable(false);
		builder.setNegativeButton(R.string.btn_ok,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
		AlertDialog alert = builder.create();
		alert.show();
	}

	/**
	 * Show normal info
	 * 
	 * @param act
	 */
	public static void showDialogInfo(Activity act, String message) {
		// create dialog
		AlertDialog.Builder builder = new AlertDialog.Builder(act);
		builder.setTitle(R.string.app_name);
		builder.setMessage(message);
		builder.setCancelable(false);
		builder.setNegativeButton(R.string.btn_ok,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
		AlertDialog alert = builder.create();
		alert.show();
	}

	/**
	 * Show message by Toast
	 * 
	 * @param context
	 * @param messageId
	 */
	public static void showToastInfo(Context context, int messageId) {
		Toast.makeText(context, messageId, Toast.LENGTH_LONG).show();
	}

	/**
	 * Show message by Toast
	 * 
	 * @param context
	 * @param message
	 */
	public static void showToastInfo(Context context, String message) {
		if (!StringUtil.isEmptyOrNull(message)) {
			Toast.makeText(context, message, Toast.LENGTH_LONG).show();
		}
	}

	/**
	 * Send a broadcast message.
	 * 
	 * @param context
	 *            application's context.
	 * @param message
	 *            message to be displayed.
	 */
	public static void displayMessage(Context context, String message) {
		Intent intent = new Intent(Constants.DISPLAY_MESSAGE_ACTION);
		intent.putExtra(Constants.EXTRA_MESSAGE, message);
		context.sendBroadcast(intent);
	}
}
