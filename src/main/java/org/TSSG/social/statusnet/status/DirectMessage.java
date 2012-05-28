package org.TSSG.social.statusnet.status;

import org.TSSG.social.statusnet.api.StatusnetUserProfile;

/**
 * 
 * @author Michael Treyvaud, michael.treyvaud@gmail.com
 * 
 * This class stores information about a direct message
 *
 */

public class DirectMessage {
	
	private int id;
	private String sender_id;
	private String text;
	private String recipient_id;
	private String created_at;
	private String sender_screen_name;
	private String recipient_screen_name;
	private StatusnetUserProfile sender;
	private StatusnetUserProfile recipient;
	
	
	public DirectMessage() {
	}
	
	public DirectMessage(int id, String sender_id, String text, String recipient_id, 
							String created_at,String sender_screen_name, String recipient_screen_name) {
		
		this.id = id;
		this.sender_id = sender_id;
		this.text = text;
		this.recipient_id = recipient_id;
		this.created_at = created_at;
		this.sender_screen_name = sender_screen_name;
		this.recipient_screen_name = recipient_screen_name;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSender_id() {
		return sender_id;
	}
	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getRecipient_id() {
		return recipient_id;
	}
	public void setRecipient_id(String recipient_id) {
		this.recipient_id = recipient_id;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getSender_screen_name() {
		return sender_screen_name;
	}
	public void setSender_screen_name(String sender_screen_name) {
		this.sender_screen_name = sender_screen_name;
	}
	public String getRecipient_screen_name() {
		return recipient_screen_name;
	}
	public void setRecipient_screen_name(String recipient_screen_name) {
		this.recipient_screen_name = recipient_screen_name;
	}
	public StatusnetUserProfile getSender() {
		return sender;
	}
	public void setSender(StatusnetUserProfile sender) {
		this.sender = sender;
	}
	public StatusnetUserProfile getRecipient() {
		return recipient;
	}
	public void setRecipient(StatusnetUserProfile recipient) {
		this.recipient = recipient;
	}	
}
