package org.TSSG.social.statusnet.status;

/**
 * 
 * @author Michael Treyvaud, michael.treyvaud@gmail.com
 * 
 * Creates an object for a Status on Statusnet
 *
 */
public class Status {
	
	private String text;
	private boolean truncated;
	private String created;
	private String inReplyToStatusId;
	private String source;
	private int id;
	private String inReplyToUserId;
	private String inReplyToScreenName;
	private String geo;
	private boolean favorited;
	private String statusnetHTML;
	private String conversionId;
	
	public Status() {
		
	}
	
	public Status(String text, boolean truncated, String created, String in_reply_to_status_id, 
					String source, int id, String in_reply_to_user_id, String in_reply_to_screen_name, 
					String geo, boolean favorited, String statusnetHTML, String conversationId) {
		
		this.text = text;
		this.truncated = truncated;
		this.created = created;
		this.inReplyToStatusId = in_reply_to_status_id;
		this.source = source;
		this.id = id;
		this.inReplyToUserId = in_reply_to_user_id;
		this.inReplyToScreenName = in_reply_to_screen_name;
		this.geo = geo;
		this.favorited = favorited;
		this.statusnetHTML = statusnetHTML;
		this.conversionId = conversationId;
		
	}
	
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isTruncated() {
		return truncated;
	}
	public void setTruncated(boolean truncated) {
		this.truncated = truncated;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getInReplyToStatusId() {
		return inReplyToStatusId;
	}
	public void setInReplyToStatusId(String inReplyToStatusId) {
		this.inReplyToStatusId = inReplyToStatusId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInReplyToUserId() {
		return inReplyToUserId;
	}
	public void setInReplyToUserId(String inReplyToUserId) {
		this.inReplyToUserId = inReplyToUserId;
	}
	public String getInReplyToScreenName() {
		return inReplyToScreenName;
	}
	public void setInReplyToScreenName(String inReplyToScreenName) {
		this.inReplyToScreenName = inReplyToScreenName;
	}
	public String getGeo() {
		return geo;
	}
	public void setGeo(String geo) {
		this.geo = geo;
	}
	public boolean isFavorited() {
		return favorited;
	}
	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}
	public String getStatusnetHTML() {
		return statusnetHTML;
	}
	public void setStatusnetHTML(String statusnetHTML) {
		this.statusnetHTML = statusnetHTML;
	}
	public String getConversionId() {
		return conversionId;
	}
	public void setConversionId(String conversionId) {
		this.conversionId = conversionId;
	}
}
