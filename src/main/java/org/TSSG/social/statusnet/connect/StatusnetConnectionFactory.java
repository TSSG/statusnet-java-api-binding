package org.TSSG.social.statusnet.connect;

import org.TSSG.social.statusnet.api.StatusnetApi;
import org.springframework.social.connect.support.OAuth1ConnectionFactory;

public class StatusnetConnectionFactory extends OAuth1ConnectionFactory<StatusnetApi> {
	
    public StatusnetConnectionFactory(String consumerKey, String consumerSecret) {
    	super("statusnet", new StatusnetServiceProvider(consumerKey, consumerSecret), new StatusnetApiAdapter());
    }
}
