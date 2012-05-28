package org.TSSG.social.statusnet.connect;

import org.TSSG.social.statusnet.api.StatusnetApi;
import org.TSSG.social.statusnet.api.StatusnetUserProfile;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.web.client.HttpClientErrorException;

/**
 * 
 * @author Michael Treyvaud, michael.treyvaud@gmail.com
 *
 */

public class StatusnetApiAdapter implements ApiAdapter<StatusnetApi> {

	@Override
	//	Really here to test the that the oauth dance has authenticated you successfully
	public boolean test(StatusnetApi snetApi) {
		try {
			snetApi.getUserProfile();
			return true;
		} catch (HttpClientErrorException e) {
			return false;
		}
	}

	@Override
	//	Not really used at all... when accessing profile info, use
	//	StatusnetUserProfile instead
	public UserProfile fetchUserProfile(StatusnetApi snetApi) {
		StatusnetUserProfile profile = snetApi.getUserProfile();		
		String firstName = profile.getScreenName();
		String lastName = profile.getScreenName();
		String fullName = firstName + " " + lastName;
		return new UserProfileBuilder().setFirstName(firstName).setLastName(lastName).setName(fullName).build();
	}

	@Override
	public void setConnectionValues(StatusnetApi snetApi, ConnectionValues values) {
		StatusnetUserProfile profile = snetApi.getUserProfile();
		values.setProviderUserId(profile.getId());
		values.setDisplayName(profile.getScreenName());
	}

	@Override
	// Only works if you do not use annotations
	public void updateStatus(StatusnetApi snetApi, String status) {
		snetApi.updateStatus(status);
	}
}
