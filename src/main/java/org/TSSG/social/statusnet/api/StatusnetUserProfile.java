package org.TSSG.social.statusnet.api;

import org.TSSG.social.statusnet.status.Status;

/**
 * 
 * @author Michael Treyvaud, michael.treyvaud@gmail.com
 * This class holds information about a statusnet user
 *
 */

public class StatusnetUserProfile {
	
	private String id;
	private String name;
	private String screenName;
	private String location;
	private String description;
	private String profileImageUrl;
	private String url;
	private int followerCount;
	private int friendsCount;
	private String createdAt;
	private int favouritesCount;
	private int utcOffset;
	private String timeZone;
	private Status status;
	private String password;
	private String profileUrl;
	private String userName;
	
	//	Only used to test..
	public StatusnetUserProfile(String id, String screenName){
		this.id = id;
		this.screenName = screenName;
	}
	
	//	User blank constructor when creating profile,
	//	Call setProfileDetails within StatusnetTemplate to auto-generate details.
	public StatusnetUserProfile(){
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
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
	public String getProfileImageUrl() {
		return profileImageUrl;
	}
	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getFollowerCount() {
		return followerCount;
	}
	public void setFollowerCount(int followerCount) {
		this.followerCount = followerCount;
	}
	public int getFriendsCount() {
		return friendsCount;
	}
	public void setFriendsCount(int friendsCount) {
		this.friendsCount = friendsCount;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public int getFavouritesCount() {
		return favouritesCount;
	}
	public void setFavouritesCount(int favouritesCount) {
		this.favouritesCount = favouritesCount;
	}
	public int getUtcOffset() {
		return utcOffset;
	}
	public void setUtcOffset(int utcOffset) {
		this.utcOffset = utcOffset;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getProfileUrl() {
		return profileUrl;
	}
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
}

