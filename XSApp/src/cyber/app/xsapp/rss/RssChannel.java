package cyber.app.xsapp.rss;

import java.util.Collection;

/**
 * This class is an instance of tag "channel" in rss form
 * @author Luan Vu
 *
 */
public class RssChannel {
	/** xml tag: "title" */
	private String title;
	
	/** xml tag: "description" */
	private String description;
	
	/** xml tag: "link" */
	private String link;
	
	/** xml tag: "pubDate" */
	private String pubDate;
	
	/** xml tag: "generator" */
	private String generator;
	
	/** xml tag: "item" */
	private Collection<RssItem> listItems;
	
	/** Default constructor */
	public RssChannel() {
		super();
	}
	
	/**
	 * @param title
	 * @param description
	 * @param link
	 * @param pubDate
	 * @param generator
	 * @param listItems
	 */
	public RssChannel(String title, String description, String link,
			String pubDate, String generator, Collection<RssItem> listItems) {
		super();
		this.title = title;
		this.description = description;
		this.link = link;
		this.pubDate = pubDate;
		this.generator = generator;
		this.listItems = listItems;
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
	public String getGenerator() {
		return generator;
	}
	public void setGenerator(String generator) {
		this.generator = generator;
	}
	public Collection<RssItem> getListItems() {
		return listItems;
	}
	public void setListItems(Collection<RssItem> listItems) {
		this.listItems = listItems;
	}
	
}
