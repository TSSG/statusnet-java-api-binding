package org.TSSG.social.statusnet.connect;

import org.TSSG.social.statusnet.api.StatusnetApi;
import org.TSSG.social.statusnet.api.impl.StatusnetTemplate;
import org.springframework.social.oauth1.AbstractOAuth1ServiceProvider;

/**
 * 
 * @author Michael Treyvaud. michael.treyvaud@gmail.com
 *
 */

public class StatusnetServiceProvider extends AbstractOAuth1ServiceProvider<StatusnetApi> {

	//	You need to change the following three urls to your own instance of Statusnet
	public StatusnetServiceProvider(String consumerKey, String consumerSecret) {
		
		super(consumerKey, consumerSecret, new StatusnetOAuth1Template(consumerKey, consumerSecret, 
	            "http://status.tssg.org/api/oauth/request_token",
	            "http://status.tssg.org/api/oauth/authorize",
	            "http://status.tssg.org/api/oauth/access_token"));
	}

	@Override
	public StatusnetTemplate getApi(String accessToken, String secret) {
		
		return new StatusnetTemplate(getConsumerKey(), getConsumerSecret(), accessToken, secret);
	}
}
