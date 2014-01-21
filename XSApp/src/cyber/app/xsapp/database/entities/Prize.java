/**
 * 
 */
package cyber.app.xsapp.database.entities;

/**
 * @author luanvu
 *
 */
public class Prize {
	private int id;
	private int provinceId;
	private String openedDate;
	private String special;
	private String first;
	private String second;
	private String third;
	private String fourth; 
	private String fifth;
	private String sixth; 
	private String seventh;
	private String eighth;
	private String head;
	private String tail;
	
	public Prize() {
	}

	public Prize(int provinceId, String openedDate, String special,
			String first, String second, String third, String fourth,
			String fifth, String sixth, String seventh, String eighth,
			String head, String tail) {
		super();
		this.provinceId = provinceId;
		this.openedDate = openedDate;
		this.special = special;
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
		this.fifth = fifth;
		this.sixth = sixth;
		this.seventh = seventh;
		this.eighth = eighth;
		this.head = head;
		this.tail = tail;
	}

	public Prize(int id, int provinceId, String openedDate, String special,
			String first, String second, String third, String fourth,
			String fifth, String sixth, String seventh, String eighth,
			String head, String tail) {
		super();
		this.id = id;
		this.provinceId = provinceId;
		this.openedDate = openedDate;
		this.special = special;
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
		this.fifth = fifth;
		this.sixth = sixth;
		this.seventh = seventh;
		this.eighth = eighth;
		this.head = head;
		this.tail = tail;
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

	public String getOpenedDate() {
		return openedDate;
	}

	public void setOpenedDate(String openedDate) {
		this.openedDate = openedDate;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	public String getThird() {
		return third;
	}

	public void setThird(String third) {
		this.third = third;
	}

	public String getFourth() {
		return fourth;
	}

	public void setFourth(String fourth) {
		this.fourth = fourth;
	}

	public String getFifth() {
		return fifth;
	}

	public void setFifth(String fifth) {
		this.fifth = fifth;
	}

	public String getSixth() {
		return sixth;
	}

	public void setSixth(String sixth) {
		this.sixth = sixth;
	}

	public String getSeventh() {
		return seventh;
	}

	public void setSeventh(String seventh) {
		this.seventh = seventh;
	}

	public String getEighth() {
		return eighth;
	}

	public void setEighth(String eighth) {
		this.eighth = eighth;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getTail() {
		return tail;
	}

	public void setTail(String tail) {
		this.tail = tail;
	}
	
}
