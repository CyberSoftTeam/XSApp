package cyber.app.xsapp.rss;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

/**
 * Class helper for parsing data from xml(rss format) files.
 * @author Luan Vu
 *
 */
public class RssHelper {
	/** Tag "rss" */
	private static final String RSS = "rss";
	
	/** Tag "channel" */
	private static final String CHANNEL = "channel";
	
	/** Tag "title" */
	private static final String TITLE = "title";
	
	/** Tag "description" */
	private static final String DESCRIPTION = "description";
	
	/** Tag "link" */
	private static final String LINK = "link";
	
	/** Tag "pubDate" */
	private static final String PUBLIC_DATE = "pubDate";
	
	/** Tag "generator" */
	private static final String GENERATOR = "generator";
	
	/** Tag "item" */
	private static final String ITEM = "item";
	
	/** Xml parser namespaces */
	private static final String NAMESPACES = null;
	
	/** An instance of a parser */
	private XmlPullParser parser;
	
	/**
	 * Creates a rss helper on the specified InputStream
	 * @param input the InputStream to be parser
	 * @throws XmlPullParserException
	 * @throws IOException
	 */
	public RssHelper(InputStream input) throws XmlPullParserException, IOException {
		init(input);
	}
	
	/**
	 * Creates a rss helper on the specified Reader
	 * @param input the Reader to be parser
	 * @throws XmlPullParserException
	 * @throws IOException
	 */
	public RssHelper(Reader input) throws XmlPullParserException, IOException {
		init(input);
	}
	
	private void init(InputStream input) throws XmlPullParserException, IOException {
		try {
			parser = Xml.newPullParser();
			parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
			parser.setInput(input, null);
			parser.nextTag();
		} finally {
			input.close();
		}
	}
	
	private void init(Reader input) throws XmlPullParserException, IOException {
		try {
			parser = Xml.newPullParser();
			parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
			parser.setInput(input);
			parser.nextTag();
		} finally {
			input.close();
		}
	}
	
	/**
	 * Reads a specified xml(rss format)
	 * @return Rss that is an instances of a xml(rss format) file
	 * @throws XmlPullParserException
	 * @throws IOException
	 * @see Rss
	 */
	public Rss parse() throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, NAMESPACES, RSS);
		RssChannel channel = null;
		while (parser.next() != XmlPullParser.END_TAG) {
			if(parser.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			String name = parser.getName();
			if(name.equals(CHANNEL)) {
				channel = readChannel();
			}
		}
		return new Rss(channel);
	}
	
	/**
	 * Reads "channel" tag which tested "rss" tag
	 * @return RssChannel that is an instances of a xml(rss format) "channel" tag
	 * @throws XmlPullParserException
	 * @throws IOException
	 */
	private RssChannel readChannel() throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, NAMESPACES, CHANNEL);
		String title = null;
		String description = null;
		String link = null;
		String pubDate = null;
		String generator = null;
		Collection<RssItem> listItems = new ArrayList<RssItem>();
		while(parser.next() != XmlPullParser.END_TAG) {
			if(parser.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			String name = parser.getName();
			if(name.equals(TITLE)) {
				title = readTitle();
			} else if(name.equals(DESCRIPTION)) {
				description = readDescription();
			} else if(name.equals(LINK)) {
				link = readLink();
			} else if(name.equals(PUBLIC_DATE)) {
				pubDate = readPublicDate();
			} else if(name.equals(GENERATOR)) {
				generator = readGenerator();
			} else if(name.equals(ITEM)) {
				listItems.add(readItem());
			} else {
				skip();
			}
		}
		return new RssChannel(title, description, link, pubDate, generator, listItems);
	}
	
	/**
	 * Reads a "item" tag which tested into a "channel" tag 
	 * @return RssItem that is an instances of "item" tag
	 * @throws XmlPullParserException
	 * @throws IOException
	 */
	private RssItem readItem() throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, NAMESPACES, ITEM);
		String title = null;
		String description = null;
		String link = null;
		String pubDate = null;
		while(parser.next() != XmlPullParser.END_TAG) {
			if(parser.getEventType() != XmlPullParser.START_TAG) {
				continue;
			}
			String name = parser.getName();
			if(name.equals(TITLE)) {
				title = readTitle();
			} else if(name.equals(DESCRIPTION)) {
				description = readDescription();
			} else if(name.equals(LINK)) {
				link = readLink();
			} else if(name.equals(PUBLIC_DATE)) {
				pubDate = readPublicDate();
			} else {
				skip();
			}
		}
		return new RssItem(title, description, link, pubDate); 
	}
	
	/**
	 * Reads a "title"
	 * @return value of the tag
	 * @throws XmlPullParserException
	 * @throws IOException
	 */
	private String readTitle() throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, NAMESPACES, TITLE);
		String title = readText();
		parser.require(XmlPullParser.END_TAG, NAMESPACES, TITLE);
		return title;
	}
	
	/**
	 * Reads a "description" tag
	 * @return value of the tag
	 * @throws XmlPullParserException
	 * @throws IOException
	 */
	private String readDescription() throws XmlPullParserException, IOException { 
		parser.require(XmlPullParser.START_TAG, NAMESPACES, DESCRIPTION);
		String description = readText();
		parser.require(XmlPullParser.END_TAG, NAMESPACES, DESCRIPTION);
		return description;
	}
	
	/**
	 * Reads a "link" tag
	 * @return value of the tag
	 * @throws XmlPullParserException
	 * @throws IOException
	 */
	private String readLink() throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, NAMESPACES, LINK);
		String link = readText();
		parser.require(XmlPullParser.END_TAG, NAMESPACES, LINK);
		return link;
	}
	
	/**
	 * Reads a "pubDate" tag
	 * @return value of the tag
	 * @throws XmlPullParserException
	 * @throws IOException
	 */
	private String readPublicDate() throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, NAMESPACES, PUBLIC_DATE);
		String pubDate = readText();
		parser.require(XmlPullParser.END_TAG, NAMESPACES, PUBLIC_DATE);
		return pubDate;
	}
	
	/**
	 * Reads a "generator" tag
	 * @return value of the tag
	 * @throws XmlPullParserException
	 * @throws IOException
	 */
	private String readGenerator() throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG, NAMESPACES, GENERATOR);
		String generator = readText();
		parser.require(XmlPullParser.END_TAG, NAMESPACES, GENERATOR);
		return generator;
	}
	
	/**
	 * Reads value of tag
	 * @return value of the tag
	 * @throws XmlPullParserException
	 * @throws IOException
	 */
	private String readText() throws XmlPullParserException, IOException {
		String result = "";
		if(parser.next() == XmlPullParser.TEXT) {
			result = parser.getText();
			parser.nextTag();
		}
		return result;
	}
	
	/**
	 * skip the tags don't care about
	 * @throws XmlPullParserException
	 * @throws IOException
	 */
	private void skip() throws XmlPullParserException, IOException {
		if(parser.getEventType() != XmlPullParser.START_TAG) {
			throw new IllegalStateException();
		}
		int depth = 1;
		while (depth != 0) {
			switch (parser.next()) {
			case XmlPullParser.END_TAG:
				depth--;
				break;
			case XmlPullParser.START_TAG:
				depth++;
				break;
			}
		}
	}
	
}
