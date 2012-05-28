package org.TSSG.social.statusnet.connect;

import org.springframework.social.oauth1.OAuth1Template;

public class StatusnetOAuth1Template extends OAuth1Template{
	StatusnetOAuth1Template(String consumerKey, String consumerSecret, String requestTokenUrl, String authorizeUrl, String accessTokenUrl){
		super(consumerKey, consumerSecret, requestTokenUrl, authorizeUrl, accessTokenUrl);
	}
}
