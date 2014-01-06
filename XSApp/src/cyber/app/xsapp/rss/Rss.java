package cyber.app.xsapp.rss;

/**
 * This class is an instance of a rss(xml schema) file 
 * @author luanvu
 *
 */
public class Rss {
	
	/** Rss channel tag */
	private RssChannel channel;

	/**
	 * @param channel instance of a channel in rss file
	 */
	public Rss(RssChannel channel) {
		this.channel = channel;
	}

	/**
	 * Default contruction
	 */
	public Rss() {
	}

	public RssChannel getChannel() {
		return channel;
	}

	public void setChannel(RssChannel channel) {
		this.channel = channel;
	}
	
}
