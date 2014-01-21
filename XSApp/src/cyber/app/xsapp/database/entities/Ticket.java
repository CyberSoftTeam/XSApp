/**
 * 
 */
package cyber.app.xsapp.database.entities;

/**
 * @author luanvu
 *
 */
public class Ticket {
	private int id;
	private int provinceId;
	private long openedDate;
	private String number;
	private int isChecked;
	private int isView;
	private String prizes;
	private String luckyPrizes;
	
	public Ticket() {
	}
	
	public Ticket(int provinceId, long openedDate, String number,
			int isChecked, int isView, String prizes, String luckyPrizes) {
		super();
		this.provinceId = provinceId;
		this.openedDate = openedDate;
		this.number = number;
		this.isChecked = isChecked;
		this.isView = isView;
		this.prizes = prizes;
		this.luckyPrizes = luckyPrizes;
	}

	public Ticket(int id, int provinceId, long openedDate, String number,
			int isChecked, int isView, String prizes, String luckyPrizes) {
		this.id = id;
		this.provinceId = provinceId;
		this.openedDate = openedDate;
		this.number = number;
		this.isChecked = isChecked;
		this.isView = isView;
		this.luckyPrizes = luckyPrizes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	public long getOpenedDate() {
		return openedDate;
	}

	public void setOpenedDate(long openedDate) {
		this.openedDate = openedDate;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getIsChecked() {
		return isChecked;
	}

	public void setIsChecked(int isChecked) {
		this.isChecked = isChecked;
	}

	public int getIsView() {
		return isView;
	}

	public void setIsView(int isView) {
		this.isView = isView;
	}

	public String getPrizes() {
		return prizes;
	}

	public void setPrizes(String prizes) {
		this.prizes = prizes;
	}

	public String getLuckyPrizes() {
		return luckyPrizes;
	}

	public void setLuckyPrizes(String luckyPrizes) {
		this.luckyPrizes = luckyPrizes;
	}
	
}
