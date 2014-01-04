package cyber.app.xsapp.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class StringUtil {

	/**
	 * Determine the given string is null or empty
	 * 
	 * @param s
	 *            the given string
	 * @return TRUE if the given string is empty or null
	 */
	public static boolean isEmptyOrNull(String s) {
		return s == null || s.trim().length() == 0;
	}

	/**
	 * Get current time include time zone to save to DB
	 * 
	 * @return time string
	 */
	public static String getCurrentTimestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
	}

}
