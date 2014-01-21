/**
 * 
 */
package cyber.app.xsapp.database;

/**
 * This interface contains database constaints
 * @author luanvu
 *
 */
public interface DBConstant {
	
	/** Contain constants of Province table */
	public interface ProvinceTable {
		public final static String TABLE_NAME = "Province";
		public final static String ID = "_id";
		public final static String NAME = "name";
		public final static String CODE = "code";
		public final static String REGION_ID = "regionId";
		public final static String CALENDAR = "calendar";
		public final static String URL1 = "url1";
		public final static String URL2 = "url2";
	}
	
	/** Contains constants of Ticket table */
	public interface TicketTable {
		public final static String TABLE_NAME = "Ticket";
		public final static String ID = "_id";
		public final static String PROVINCE_ID = "provinceId";
		public final static String OPENED_DATE = "openedDate";
		public final static String NUMBER = "number";
		public final static String IS_CHECKED = "isChecked";
		public final static String IS_VIEW = "isView";
		public final static String PRIZES = "prizes";
		public final static String LUCKY_PRIZES = "luckyPrizes";
	}
	
	/** Contains constants of Prize table */
	public interface PrizeTable {
		public final static String TABLE_NAME = "Prize";
		public final static String ID = "_id";
		public final static String PROVINCE_ID = "provinceId";
		public final static String OPENED_DATE = "openedDate";
		public final static String SPECIAL = "special";
		public final static String FIRST = "first";
		public final static String SECOND = "second";
		public final static String THIRD = "third";
		public final static String FOURTH = "fourth";
		public final static String FIFTH = "fifth";
		public final static String SIXTH = "sixth";
		public final static String SEVENTH = "seventh";
		public final static String EIGHTH = "eighth";
		public final static String HEAD = "head";
		public final static String TAIL = "tail";
	}
	
	/** Contains constants of Region table */
	public interface RegionTable {
		public final static String TABLE_NAME = "Region";
		public final static String ID = "_id";
		public final static String NAME = "name";
		public final static String TIME = "time";
	}
}
