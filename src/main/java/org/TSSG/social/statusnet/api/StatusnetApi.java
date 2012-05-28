package org.TSSG.social.statusnet.api;

import java.util.ArrayList;

import org.TSSG.social.statusnet.status.DirectMessage;
import org.TSSG.social.statusnet.status.Status;
import org.TSSG.social.statusnet.status.TSSGEventAnnotations;

/**
 * 
 * @author Michael Treyvaud michael.treyvaud@gmail.com
 * 
 * 	Statusnet Api interface, not all Api methods (listed here http://status.net/wiki/Twitter-compatible_API)
 *  have been implemented, I will add more if required.
 *  
 *	At the moment the only class that implements this interface is the StatusnetTemplate class,
 *	found within the org.springframework.social.statusnet.api.impl package.
 *
 */

public interface StatusnetApi {
	
	// Timeline resources
	public ArrayList<Status> getPublicTimeline();
	public ArrayList<Status> getHomeTimeline();
	public ArrayList<Status> getFriendsTimeline();
	public ArrayList<Status> getMentions();
	public ArrayList<Status> getReplies();
	public ArrayList<Status> getUserTimeline();
	public ArrayList<Status> getRetweetedtome();
	public ArrayList<Status> getRetweetedbyme();
	public ArrayList<Status> getRetweetsofme();
	
	// Status resources
	public Status getStatus(int statusId);
	public void updateStatus(String status);
	public void destroyStatus(int statusId);
	public void retweetStatus(int statusId);
	
	// User resources
	public ArrayList<StatusnetUserProfile> getFriends();
	
	// Get user profile
	public StatusnetUserProfile getUserProfile();
	public StatusnetUserProfile setProfileDetails();
	
	// Direct messages
	public ArrayList<DirectMessage> getDirectMessages();
	public ArrayList<DirectMessage> getDirectMessagesSent();
	public void newDirectMessage(String userName, String message);
	public void newDirectMessage(int userId, String message);
	
	// Favorite resources
	public ArrayList<Status> getFavorites();
	public void createFavorite(int id);
	public void destroyFavorite(int id);
	
	// Annotations (this requires the Annotations plug-in AND fix for statusnet)
	public void updateStatusIncludeAnnotations(String status, TSSGEventAnnotations annotations);
}
