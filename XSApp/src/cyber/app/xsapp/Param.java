package cyber.app.xsapp;

public class Param {
	public static final int ADMIN_TIME_OUT = 5 * 60 * 1000;
	
	// Connection constant
	public static final int CONNECTION_TIME_OUT = 30000; // milliseconds
	public static final int SOCKET_TIME_OUT = 30000; // milliseconds

	// Map constants
	public static final double MAX_DISTANCE = 1.0E6;
	public static final long LOCATION_UPDATE_TIME = 30000;
	public static final float LOCATION_UPDATE_DISTANCE = 10F;
	
	// Synchronize period
	public static final int MINUTE = 60 * 1000;
	public static final long PERIOD_SYN = (long) (24 * 60 * MINUTE);
	public static final int PERIOD_COLLECT = 5; // minutes
	public static final int PERIOD_UPLOAD = 5; // minutes
	public static final int PERIOD_DETECT = 5; // minutes
	public static final int DETECT_TIME = 3; // detecting times
	public static final int DETECT_ACTIVE = 1; // active detecting mode
	
}
