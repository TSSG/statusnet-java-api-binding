package org.TSSG.social.statusnet.signin;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

public class SignInUtils {
	
	public static void signin(String userId) {
		
		SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userId, null, null));	
	}
	
}
