/**
 * 
 */
package cyber.app.xsapp.database.entities;

/**
 * @author luanvu
 *
 */
public class Region {
	private int id;
	private String name;
	private String time;

	public Region() {
	}

	public Region(int id, String name, String time) {
		this.id = id;
		this.name = name;
		this.time = time;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
