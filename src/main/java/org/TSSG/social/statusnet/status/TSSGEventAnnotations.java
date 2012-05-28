package org.TSSG.social.statusnet.status;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 
 * @author Michael Treyvaud, michael.treyvaud@gmail.com
 * 
 * This class is used when creating hidden meta data while posting
 * a status to Statusnet via the API.
 * 
 * There is no point using this class at all, unless the Annotations plug-in is
 * operational on your instance of Statusnet.
 *
 */

public class TSSGEventAnnotations {
	
	private String title;
	private Timestamp start_time;
	private Timestamp end_time;
	private Date date;
	private String url;
	private String location;
	private String description;
	private String lat;
	private String longitude;
	
	public TSSGEventAnnotations() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getStart_time() {
		return start_time;
	}

	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}

	public Timestamp getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
