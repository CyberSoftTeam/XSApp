/**
 * 
 */
package cyber.app.xsapp.database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cyber.app.xsapp.Constants;
import cyber.app.xsapp.database.DBConstant.PrizeTable;
import cyber.app.xsapp.database.DBConstant.ProvinceTable;
import cyber.app.xsapp.database.DBConstant.RegionTable;
import cyber.app.xsapp.database.DBConstant.TicketTable;
import cyber.app.xsapp.database.entities.Prize;
import cyber.app.xsapp.database.entities.Ticket;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * This class helps for database interaction
 * @author luanvu
 *
 */
public class DBHelper {
	private static final String TAG = DBHelper.class.getSimpleName();
	
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "xsapp.db";
	private static String DATABASE_PATH = "";

	private DatabaseHelper dbHelper = null;
	private SQLiteDatabase db = null;

	/**
	 * Default constructor
	 * @param context
	 */
	public DBHelper(Context context) {
		open(context);
	}

	public void open(Context context) {
		DATABASE_PATH = context.getApplicationContext().getApplicationInfo().dataDir;
		try {
			dbHelper = new DatabaseHelper(context);
			db = dbHelper.getWritableDatabase();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		db.close(); 
		dbHelper.close();
	}
	
	/**
	 * Get cursor with all info about all province on database
	 * @return
	 */
	public Cursor getAllProvinces() {
		return db.query(ProvinceTable.TABLE_NAME, null, null, null, null, null, null);
	}

	/**
	 * insert prize to table
	 * @param prize
	 * @param sequenceId
	 * @return
	 */
	public boolean insertPrize(Prize prize, boolean sequenceId) {
		ContentValues values = new ContentValues();
		
		if(!sequenceId) {
			values.put(PrizeTable.ID, prize.getId());
		}
		
		values.put(PrizeTable.PROVINCE_ID, prize.getProvinceId());
		values.put(PrizeTable.OPENED_DATE, prize.getOpenedDate());
		values.put(PrizeTable.SPECIAL, prize.getSpecial());
		values.put(PrizeTable.FIRST, prize.getFirst());
		values.put(PrizeTable.SECOND, prize.getSecond());
		values.put(PrizeTable.THIRD, prize.getThird());
		values.put(PrizeTable.FOURTH, prize.getFourth());
		values.put(PrizeTable.FIFTH, prize.getFifth());
		values.put(PrizeTable.SIXTH, prize.getSixth());
		values.put(PrizeTable.SEVENTH, prize.getSeventh());
		values.put(PrizeTable.EIGHTH, prize.getEighth());
		values.put(PrizeTable.HEAD, prize.getHead());
		values.put(PrizeTable.TAIL, prize.getTail());
		
		return db.insert(PrizeTable.TABLE_NAME, null, values) > 0;
	}

	/**
	 * Get a Cursor with all information about the prizes specified by the province id
	 * @param provinceId
	 * @return Cursor 
	 */
	public Cursor getPrizesByProvinceId(int provinceId) {
		return db.query(PrizeTable.TABLE_NAME, null, PrizeTable.PROVINCE_ID + " = " + provinceId, null, null, null, null);
	}

	/**
	 * Get prizes belong to a specific province
	 * @param provinceId
	 * @return
	 */
	/*public List<Prize> getPrizesByProvinceId(int provinceId) {
		String selection = PrizeTable.PROVINCE_ID + " = ?";
		String[] selectionArgs = { provinceId + "" };
		Cursor cursor = db.query(PrizeTable.TABLE_NAME, null, selection, selectionArgs, null, null, null);
		List<Prize> results = null;
		if(null == cursor) {
			 insert code here for handle error 
		} else {
			results = new ArrayList<Prize>();
			while (cursor.moveToNext()) {
				results.add(new Prize(cursor.getInt(cursor.getColumnIndex(PrizeTable.ID)), 
						cursor.getInt(cursor.getColumnIndex(PrizeTable.PROVINCE_ID)), 
						cursor.getString(cursor.getColumnIndex(PrizeTable.OPENED_DATE)), 
						cursor.getString(cursor.getColumnIndex(PrizeTable.SPECIAL)), 
						cursor.getString(cursor.getColumnIndex(PrizeTable.FIRST)), 
						cursor.getString(cursor.getColumnIndex(PrizeTable.SECOND)), 
						cursor.getString(cursor.getColumnIndex(PrizeTable.FOURTH)), 
						cursor.getString(cursor.getColumnIndex(PrizeTable.FIFTH)), 
						cursor.getString(cursor.getColumnIndex(PrizeTable.SIXTH)), 
						cursor.getString(cursor.getColumnIndex(PrizeTable.SEVENTH)), 
						cursor.getString(cursor.getColumnIndex(PrizeTable.EIGHTH)), 
						cursor.getString(cursor.getColumnIndex(PrizeTable.HEAD)), 
						cursor.getString(cursor.getColumnIndex(PrizeTable.TAIL))));
			}
			cursor.close();
		}
		return results;
	}*/

	/**
	 * Get a Cursor with all prizes information in the database
	 * @return Cursor
	 */
	public Cursor getAllPrizes() {
		return db.query(PrizeTable.TABLE_NAME, null, null, null, null, null, null);	
	}

	/**
	 * Get all prizes in table
	 * @return
	 */
	/*	public List<Prize> getAllPrizes() {
		Cursor cursor = db.query(PrizeTable.TABLE_NAME, null, null, null, null, null, null);
		List<Prize> results = null;
		if(null == cursor) {
			 insert code here for handle error 
		} else {
			results = new ArrayList<Prize>();
			while (cursor.moveToNext()) {
				results.add(new Prize(cursor.getInt(cursor.getColumnIndex(PrizeTable.ID)), 
						cursor.getInt(cursor.getColumnIndex(PrizeTable.PROVINCE_ID)), 
						cursor.getString(cursor.getColumnIndex(PrizeTable.OPENED_DATE)), 
						cursor.getString(cursor.getColumnIndex(PrizeTable.SPECIAL)), 
						cursor.getString(cursor.getColumnIndex(PrizeTable.FIRST)), 
						cursor.getString(cursor.getColumnIndex(PrizeTable.SECOND)), 
						cursor.getString(cursor.getColumnIndex(PrizeTable.FOURTH)), 
						cursor.getString(cursor.getColumnIndex(PrizeTable.FIFTH)), 
						cursor.getString(cursor.getColumnIndex(PrizeTable.SIXTH)), 
						cursor.getString(cursor.getColumnIndex(PrizeTable.SEVENTH)), 
						cursor.getString(cursor.getColumnIndex(PrizeTable.EIGHTH)), 
						cursor.getString(cursor.getColumnIndex(PrizeTable.HEAD)), 
						cursor.getString(cursor.getColumnIndex(PrizeTable.TAIL))));
			}
			cursor.close();
		}
		return results;
	}*/
	
	/**
	 * Get Cursor with all info about a Region by that id
	 * @param id
	 * @return
	 */
	public Cursor getRegionById(int id) {
		return db.query(RegionTable.TABLE_NAME, null, RegionTable.ID + " = " + id, null, null, null, null);
	}
	
	/**
	 * Get Cursor with all info about a Province by that code
	 * @param code
	 * @return
	 */
	public Cursor getProvinceByCode(String code) {
		return db.query(ProvinceTable.TABLE_NAME, null, ProvinceTable.CODE + " = " + code, null, null, null, null);		
	}
	
	/**
	 * Insert a new ticket to table
	 * @param ticket
	 * @param sequenceId
	 * @return
	 */
	public boolean insertTicket(Ticket ticket, boolean sequenceId) {
		ContentValues values = new ContentValues();
		
		if(!sequenceId) {
			values.put(TicketTable.ID, ticket.getId());
		}
		
		values.put(TicketTable.PROVINCE_ID, ticket.getProvinceId());
		values.put(TicketTable.OPENED_DATE, ticket.getOpenedDate());
		values.put(TicketTable.NUMBER, ticket.getNumber());
		values.put(TicketTable.IS_CHECKED, ticket.getIsChecked());
		values.put(TicketTable.IS_VIEW, ticket.getIsView());
		values.put(TicketTable.PRIZES, ticket.getPrizes());
		values.put(TicketTable.LUCKY_PRIZES, ticket.getLuckyPrizes());
		
		return db.insert(TicketTable.TABLE_NAME, null, values) > 0;
	}
	
	/**
	 * Get Cursor with all informations about a Ticket by number
	 * @param number
	 * @return
	 */
	public Cursor getTicket(String number) {
		return db.query(TicketTable.TABLE_NAME, null, TicketTable.NUMBER + " = " + number, null, null, null, null);
	}
	
	/**
	 * Get Cursor with all informations about a Ticket by number
	 * @param id
	 * @return
	 */
	public Cursor getTicket(int id) {
		return db.query(TicketTable.TABLE_NAME, null, TicketTable.ID + " = " + id, null, null, null, null);
	}
	
	/**
	 * Delete a specific ticket by which number
	 * @param number
	 * @return
	 */
	public boolean deleteTicket(String number) {
		return db.delete(TicketTable.TABLE_NAME, TicketTable.NUMBER + " = " + number, null) > 0;
	}
	
	/**
	 * Delete a specific ticket by which id
	 * @param id
	 * @return
	 */
	public boolean deleteTicket(int id) {
		return db.delete(TicketTable.TABLE_NAME, TicketTable.ID + " = " + id, null) > 0;
	}

	private class DatabaseHelper extends SQLiteOpenHelper {
		
		//private SQLiteDatabase db;
		private final Context context;
		
		/**
		 * Default constructor
		 * @param context
		 * @throws IOException 
		 */
		public DatabaseHelper(Context context) throws IOException {
			super(context, DATABASE_PATH + File.separator + DATABASE_NAME, null, DATABASE_VERSION);
			this.context = context;
			createDataBase();
		}
		
		@Override
		public void onCreate(SQLiteDatabase db) {

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			
		}
		
		/**
		 * Creates a empty database on the system and rewrites it with your own
		 * database.
		 * @throws IOException 
		 * */
		public void createDataBase() throws IOException{
			Log.i(TAG, "createDataBase");
			boolean dbExist = checkDataBase();
			Log.i(TAG, "dbExist : " + dbExist);

			/* By calling this method and empty database will be created
			 into the default system path
			 of your application so we are gonna be able to overwrite that
			 database with our database. */
			if(!dbExist) {
				this.getReadableDatabase();
				copyDataBase();
			} 
		}
		
/*		public void openDataBase(){
			Log.i(Constants.TAG, "openDataBase");
			// Open the database
			String myPath = DATABASE_PATH + File.separator + DATABASE_NAME;
			db = SQLiteDatabase.openDatabase(myPath, null,
					SQLiteDatabase.OPEN_READWRITE);
		}*/
		
		@Override
		public synchronized void close() {
			super.close();
		}
		
		/**
		 * Check if the database already exist to avoid re-copying the file each
		 * time you open the application.
		 * 
		 * @return true if it exists, false if it doesn't
		 */
		private boolean checkDataBase() {
			SQLiteDatabase checkDB = null;
			
			try {
				String myPath = DATABASE_PATH + File.separator + DATABASE_NAME;
				checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
			} catch (SQLiteException e) {
				Log.i(Constants.TAG, "Database does't exist yet.");
			}

			if (checkDB != null) {
				checkDB.close();
			}

			return checkDB != null;
		}

		/**
		 * Copies your database from your local assets-folder to the just
		 * created empty database in the system folder, from where it can be
		 * accessed and handled. This is done by transfering bytestream.
		 * */
		public void copyDataBase() throws IOException {
			Log.i(TAG, "Copying database");

			/* Open your local db as the input stream */
			InputStream myInput = context.getAssets().open(DATABASE_NAME);
			
			/* Path to the just created empty db */
			String outFileName = DATABASE_PATH + File.separator + DATABASE_NAME;
			File out = new File(outFileName);
			if (!out.exists())
				out.createNewFile();
			/* Open the empty db as the output stream */
			OutputStream myOutput = new FileOutputStream(outFileName);

			/* transfer bytes from the inputfile to the outputfile */
			byte[] buffer = new byte[1024];
			int length;
			while ((length = myInput.read(buffer)) != -1) {
				myOutput.write(buffer, 0, length);
			}
			Log.i(Constants.TAG, "Database copied successfully");

			/* Close the streams */
			myOutput.flush();
			myOutput.close();
			myInput.close();

			Log.i(Constants.TAG, "DB exist: " + checkDataBase());

		}
	}

}
