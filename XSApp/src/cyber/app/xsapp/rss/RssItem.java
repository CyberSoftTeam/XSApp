package cyber.app.xsapp.rss;

/**
 * This class contains data of an "item" tag in xml (rss format) file
 * @author luanvu
 *
 */
public class RssItem {
	/** xml tag: "title" */
	private String title;
	
	/** xml tag: "description" */
	private String description;
	
	/** xml tag: "link" */
	private String link;
	
	/** xml tag: "pubDate" */
	private String pubDate;
	
	/**
	 * @param title value's "title" tag
	 * @param description value's "description" tag
	 * @param link value's "link" tag
	 * @param pubDate value's "pubDate" tag
	 */
	public RssItem(String title, String description, String link, String pubDate) {
		super();
		this.title = title;
		this.description = description;
		this.link = link;
		this.pubDate = pubDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}
	
}
