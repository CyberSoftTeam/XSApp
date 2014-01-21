/**
 * 
 */
package cyber.app.xsapp.database.entities;

/**
 * 
 * @author luanvu
 *
 */
public class Province {
	private int id;
	private String name;
	private String code;
	private String regionId;
	private String calendar;
	private String url1;
	private String url2;
	
	public Province() {
	}

	public Province(int id, String name, String code, String regionId,
			String calendar, String url1, String url2) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.regionId = regionId;
		this.calendar = calendar;
		this.url1 = url1;
		this.url2 = url2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getCalendar() {
		return calendar;
	}

	public void setCalendar(String calendar) {
		this.calendar = calendar;
	}

	public String getUrl1() {
		return url1;
	}

	public void setUrl1(String url1) {
		this.url1 = url1;
	}

	public String getUrl2() {
		return url2;
	}

	public void setUrl2(String url2) {
		this.url2 = url2;
	}
}
