package org.TSSG.social.statusnet.api.impl;

import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.TSSG.social.statusnet.api.StatusnetApi;
import org.TSSG.social.statusnet.api.StatusnetUserProfile;
import org.TSSG.social.statusnet.status.DirectMessage;
import org.TSSG.social.statusnet.status.Status;
import org.TSSG.social.statusnet.status.TSSGEventAnnotations;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * 
 * @author Michael Treyvaud michael.treyvaud@gmail.com
 * 
 * This class shows the implementation of the StatusnetApi interface.
 * At the moment everything in bundled into this one class - No intention of changing this unless required.
 * 
 * Every single callback below assumes json formatting,
 * if you want to change this - simply remove .json, and replace it with .xml
 * XML and json are the only supported formats for Statusnet.
 * 
 * Annotations HAVE to be in json format - due to the plugin restrictions, please do not change this! (jsonText within updateStatusIncludeAnnotations)
 * 
 */
public class StatusnetTemplate extends AbstractOAuth1ApiBinding implements StatusnetApi {

	//	This is the base url for your Statusnet instance
	// 	You will need to update this to your own Url if you want any of the api calls to function
	private final String baseUrl = "http://yourstatusnet.url/api/";
	
	// 	Timeline
	private final String publicTimeLine = "statuses/public_timeline.json";
	private final String homeTimeLine = "statuses/home_timeline.json";
	private final String friendsTimeLine = "statuses/friends_timeline.json";
	private final String mentionsTimeLine = "statuses/mentions.json";
	private final String repliesTimeLine = "statuses/replies.json";
	private final String userTimeLine = "statuses/user_timeline.json";
	private final String retweetedToTimeLine = "statuses/retweeted_to_me.json";
	private final String retweetedByTimeLine = "statuses/retweeted_by_me.json";
	private final String retweetedOfTimeLine = "statuses/retweets_of_me.json";
	
	// 	Status
	private final String showStatus = "statuses/show/";
	private final String updateStatus = "statuses/update.json";
	private final String destroyStatus = "statuses/destroy/";
	private final String retweetStatus = "statuses/retweet/";
	
	// 	User
	private final String friends = "statuses/friends.json";
	private final String profileDetails = "account/verify_credentials.json";
	
	// 	Direct Messages
	private final String directMessage = "direct_messages.json";
	private final String directMessageSent = "direct_messages/sent.json";
	private final String newDirectMessage = "direct_messages/new.json";
	
	// 	Favourites
	private final String favorites = "favorites.json";
	private final String createFavorite = "favorites/create/";
	private final String destroyFavorite = "favorites/destroy/";
	
	
	public StatusnetTemplate(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret){
		super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
	}
	
	//	Only really used for testing...
	public StatusnetTemplate() {
		super();
	}
	

	@Override
	//	This method updates the users status but also adds Meta data (annotations) to the status, meta data is written in json format
	//	This can only be used if your instance of Statusnet uses the Annotations plugin found here (http://status.net/wiki/Plugin:Annotations)
	// 	Also - This plug-in is out dated and does not function correctly with the latest version of Statusnet 1.0.1 (at this time)
	//	This method assumes you are adding a custom event meta data - change this to whatever you like, this is just something I have worked on and needed
	//	Status: Status message contents
	//	annotations: Hidden meta data attached to Status
	public void updateStatusIncludeAnnotations(String status, TSSGEventAnnotations annotations) {
		
		String url = baseUrl + updateStatus;
		// Annotations have to be in json format, you can customize the object to add what ever meta data you like
		// Just make sure you check the Annotations plugin info first!
		String jsonText = "[{\"custom_tssg_event\":{\"event_title\":" + "\"" + annotations.getTitle() + "\","  +
														"\"start_time\":" + "\"" + annotations.getStart_time() + "\"," +
														"\"end_time\":" + "\"" + annotations.getEnd_time() + "\"," +
														"\"event_date\":" + "\"" + annotations.getDate() + "\"," +
														"\"event_location\":" + "\"" + annotations.getLocation() + "\"," +
														"\"event_url\":" + "\"" + annotations.getUrl() + "\"," + 
														"\"start_lat\":" + "\"" + annotations.getLat() + "\"," +
														"\"start_long\":" + "\"" + annotations.getLongitude() + "\"," +
														"\"event_description\":" + "\"" + annotations.getDescription() + "\"}}]";
		
		MultiValueMap<String, Object> form = new LinkedMultiValueMap<String, Object>();
		//	Status is required when posting data.
		form.add("status", status);
		//	When using the Annotations plug-in, the annotations field IS REQUIRED, or you will get 406 error.
		form.add("annotations", jsonText);
		
		try {
			getRestTemplate().postForLocation(url, form);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	//	Update the authenticated users status - Use this if you are NOT using Annotations
	//	status: Status message contents
	public void updateStatus(String status) {
		
		String url = baseUrl + updateStatus;
		
		MultiValueMap<String, Object> form = new LinkedMultiValueMap<String, Object>();
		// Status is the only required parameter, you can take a look at the api documentation to discover the others.
		// Simply add, form.add("parameter name", "value") to add additional parameters.
		form.add("status", status);
		
		try {
			getRestTemplate().postForLocation(url, form);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
		

	@Override
	//	Returns messages that are viewable to the public
	public ArrayList<Status> getPublicTimeline() {
		
    	ArrayList<Status> messages = filterTimeLineMessage(publicTimeLine);
    	return messages;
	}

	@Override
	//	Returns the authenticated users home time-line - friends, groups, personal etc..
	public ArrayList<Status> getHomeTimeline() {
		
		ArrayList<Status> messages = filterTimeLineMessage(homeTimeLine);
    	return messages;
	}

	@Override
	//	Returns the authenticated users friends' public posts
	public ArrayList<Status> getFriendsTimeline() {
		
		ArrayList<Status> messages = filterTimeLineMessage(friendsTimeLine);
    	return messages;
	}

	@Override
	// 	Returns any status updates which contain the authenticated users screen name
	public ArrayList<Status> getMentions() {
		
		ArrayList<Status> messages = filterTimeLineMessage(mentionsTimeLine);
    	return messages;
	}

	@Override
	// 	Returns status replies to the authenticated user
	public ArrayList<Status> getReplies() {
		
		ArrayList<Status> messages = filterTimeLineMessage(repliesTimeLine);
    	return messages;
	}

	@Override
	//	Returns statuses from the users time-line
	public ArrayList<Status> getUserTimeline() {
		
		ArrayList<Status> messages = filterTimeLineMessage(userTimeLine);
    	return messages;
	}

	@Override
	//	Returns status messages which were re-tweeted to the authenticated user
	public ArrayList<Status> getRetweetedtome() {
		
		ArrayList<Status> messages = filterTimeLineMessage(retweetedToTimeLine);
    	return messages;
	}

	@Override
	//	Returns status messages which have been re-tweeted by the authenticated user
	public ArrayList<Status> getRetweetedbyme() {
		
		ArrayList<Status> messages = filterTimeLineMessage(retweetedByTimeLine);
    	return messages;
	}

	@Override
	//	Returns status messages which tagged the authenticated user
	public ArrayList<Status> getRetweetsofme() {
		
		ArrayList<Status> messages = filterTimeLineMessage(retweetedOfTimeLine);
    	return messages;
	}

	@Override
	//	Gets all direct message sent or received
	public ArrayList<DirectMessage> getDirectMessages() {
		
		ArrayList<DirectMessage> messages = filterDirectMessage(directMessage);
		return messages;
	}
	
	@Override
	//	Returns messages that have been sent by the authenticated user
	public ArrayList<DirectMessage> getDirectMessagesSent() {
		
		ArrayList<DirectMessage> messages = filterDirectMessage(directMessageSent);
		return messages;
	}
	
	@Override
	//	Constructs a new direct message
	//	userName: user screen name the messages is intended for
	//	message: status message contents
	public void newDirectMessage(String userName, String message) {
		
		String url = baseUrl + newDirectMessage;
		String data = "?screen_name=" + userName + "&text=" + message;		
		
		try {
			getRestTemplate().postForLocation(url+data, null);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	//	Constructs a new direct message
	//	userId: User id the message is intended for
	//	message: status message contents
	public void newDirectMessage(int userId, String message) {
		
		String url = baseUrl + newDirectMessage;
		String data = "?user_id=" + userId + "&text=" + message;		
		
		try {
			getRestTemplate().postForLocation(url + data, null);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	//	Returns all status messages favorited by the authenticated user
	public ArrayList<Status> getFavorites() {
		
		ArrayList<Status> messages = filterTimeLineMessage(favorites);
		return messages;
	}
	
	@Override
	//	Favorites a status message on behalf of the authenticated user
	//	id: The status message's id which you intend to favor.
	public void createFavorite(int id) {
		
		String url = baseUrl + createFavorite;
		String data = id + ".json";		
		
		try {
			getRestTemplate().postForLocation(url + data, null);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	//	Un-favors a status message
	//	id: Status messages's id which you would like to un-favor
	public void destroyFavorite(int id) {
		
		String url = baseUrl + destroyFavorite;
		String data = id + ".json";	
		
		try {
			getRestTemplate().postForLocation(url + data, null);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	//	Returns a single status message
	//	statusId: The id of the status you would like to retrieve
	public Status getStatus(int statusId) {
		
		Status message = filterTimeLineMessage(statusId);
		return message;
	}

	//	Sets the profile details for the authenticated user,
	//	This is used to test the java API binding
	//	A lot more details can be found within the StatusnetUserProfile class,
	//	however at the moment these details are not required
	//	I will add them later if necessary
	public StatusnetUserProfile setProfileDetails() {
		
		StatusnetUserProfile profile = null;
		
		try{
			String details = getRestTemplate().getForObject(baseUrl + profileDetails, String.class);
		
			//	Creates a StatusnetUserProfile based on the returned json object
			JSONObject json = (JSONObject) JSONSerializer.toJSON(details);
			String id = json.getString("id");
			String name = json.getString("name");
			String screenName = json.getString("screen_name");
			String profile_image_url = json.getString("profile_image_url");
			String statusnetmProfileUrl = json.getString("statusnet_profile_url");
			profile = new StatusnetUserProfile();
			profile.setId(id);
			profile.setName(name);
			profile.setScreenName(screenName);
			profile.setProfileImageUrl(profile_image_url);
			profile.setProfileUrl(statusnetmProfileUrl);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return profile;
	}
	
	@Override
	//	Removes a status update
	//	statusId: Status id of message you would like to remove
	public void destroyStatus(int statusId) {
		
		String url = baseUrl + destroyStatus + statusId + ".json";
		
		try {
			getRestTemplate().postForLocation(url, null);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	//	Re-tweets a status message
	//	statusID: ID of the message you would like to re-tweet
	public void retweetStatus(int statusId) {

		String url = baseUrl + retweetStatus + statusId + ".json";
		try {
			getRestTemplate().postForLocation(url, null);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	// 	Returns the authenticated users profile as an object
	public StatusnetUserProfile getUserProfile() {
		
		StatusnetUserProfile profile = setProfileDetails();
		return profile;
	}
	
	@Override
	// 	Returns a list of all the authenticated users friends
	// 	List contains StatusnetUserProfile objects
	public ArrayList<StatusnetUserProfile> getFriends() {
		
		ArrayList<StatusnetUserProfile> friendsList = null;
		
		try {
			String timeLine = getRestTemplate().getForObject(baseUrl + friends, String.class);
		
			//	String returned is an Array of json objects
			//	Cycles through Array and constructs StatusnetUserProfile objects
			JSONArray array = JSONArray.fromObject(timeLine);
			friendsList = new ArrayList<>();
			for (int i = 0; i < array.size(); i ++) {
			
				JSONObject childJSONObject = array.getJSONObject(i);
				String id = childJSONObject.getString("id");
				String name = childJSONObject.getString("name");
				String screenname = childJSONObject.getString("screen_name");
				String profileimageurl = childJSONObject.getString("profile_image_url");
				String statusnetprofile_url = childJSONObject.getString("statusnet_profile_url");
				StatusnetUserProfile user = new StatusnetUserProfile();
				user.setId(id);
				user.setName(name);
				user.setScreenName(screenname);
				user.setProfileImageUrl(profileimageurl);
				user.setProfileUrl(statusnetprofile_url);
				friendsList.add(user);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return friendsList;
	}
	
	//	Parses the .json object returned from an API call,
	//	Parses the .json object to a java Status object, returns a list of
	//	Status objects when complete.
	//	Each json object returned contains more info eg. User, Not necessary for the moment - will add if required
	//	timeLineString: the api url to be parsed
	private ArrayList<Status> filterTimeLineMessage(String timeLineString) {
		
		ArrayList<Status> messages = null;
		
		try {
			String timeLine = getRestTemplate().getForObject(baseUrl + timeLineString, String.class);
		
			JSONArray array = JSONArray.fromObject(timeLine);
			messages = new ArrayList<Status>();
			for (int i = 0; i < array.size(); i++) {
    		
				JSONObject childJSONObject = array.getJSONObject(i);
				String text = childJSONObject.getString("text");
				boolean truncated = childJSONObject.getBoolean("truncated");
				String created = childJSONObject.getString("created_at");
				String inReplyToStatusId = childJSONObject.getString("in_reply_to_status_id");
				String source = childJSONObject.getString("source");
				int id = childJSONObject.getInt("id");
				String inReplyToUserId = childJSONObject.getString("in_reply_to_user_id");
				String geo = childJSONObject.getString("geo");
				String inreplyToScreenName = childJSONObject.getString("in_reply_to_screen_name");
				boolean favorited = childJSONObject.getBoolean("favorited");
				String statusnetHtml = childJSONObject.getString("statusnet_html");
				String conversationId = childJSONObject.getString("statusnet_conversation_id");
    	     
				Status status = new Status(text, truncated, created, inReplyToStatusId,
    	    		 					source, id, inReplyToUserId, geo, inreplyToScreenName,
    	    		 					favorited, statusnetHtml, conversationId);
				messages.add(status);
    	}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
    	return messages;
	}
	
	//	Similar to filterTimeLineMessage except returns a DirectMessage object
	//	timeLineString: the api url to be parsed
	private ArrayList<DirectMessage> filterDirectMessage(String timeLineString) {
		
		ArrayList<DirectMessage> messages = null;
		
		try {
			String timeLine = getRestTemplate().getForObject(baseUrl + timeLineString, String.class);
		
			JSONArray array = JSONArray.fromObject(timeLine);
			messages = new ArrayList<DirectMessage>();
			for (int i = 0; i < array.size(); i++) {
    		
				JSONObject childJSONObject = array.getJSONObject(i);
				int id = childJSONObject.getInt("id");
				String created_at = childJSONObject.getString("created_at");
				String sender_screen_name = childJSONObject.getString("sender_screen_name");
				String recipient_screen_name = childJSONObject.getString("recipient_screen_name");
    		
				JSONObject senderObject = childJSONObject.getJSONObject("sender");
				String sender_id = senderObject.getString("id");
				String text = childJSONObject.getString("text");

				JSONObject recipientObject = childJSONObject.getJSONObject("recipient");
				String recipient_id = recipientObject.getString("id");
    		
				DirectMessage directMessage = new DirectMessage(id, sender_id, text, recipient_id, created_at,
    														sender_screen_name, recipient_screen_name);
				messages.add(directMessage);
    	}
		}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}

		return messages;
	}
	
	//	Similar to filterTimeLineMessage except returns one single Status message
	//	statusId: id of the status you would like to retrieve
	private Status filterTimeLineMessage(int statusId) {
		
		Status status = null;
		
		try {
			String timeLine = getRestTemplate().getForObject(baseUrl + showStatus + statusId + ".json", String.class);
			JSONObject json = (JSONObject) JSONSerializer.toJSON(timeLine);
    	
			String text = json.getString("text");
			boolean truncated = json.getBoolean("truncated");
			String created = json.getString("created_at");
			String inReplyToStatusId = json.getString("in_reply_to_status_id");
			String source = json.getString("source");
			int id = json.getInt("id");
			String inReplyToUserId = json.getString("in_reply_to_user_id");
			String geo = json.getString("geo");
			String inreplyToScreenName = json.getString("in_reply_to_screen_name");
			boolean favorited = json.getBoolean("favorited");
			String statusnetHtml = json.getString("statusnet_html");
			String conversationId = json.getString("statusnet_conversation_id");
	    
			status = new Status(text, truncated, created, inReplyToStatusId,
								source, id, inReplyToUserId, geo, inreplyToScreenName,
								favorited, statusnetHtml, conversationId);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	    return status;
	}
}
