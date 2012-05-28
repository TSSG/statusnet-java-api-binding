package org.TSSG.social.statusnet;

import java.security.Principal;
import java.util.ArrayList;

import javax.inject.Inject;

import org.TSSG.social.statusnet.account.AccountRepository;
import org.TSSG.social.statusnet.api.StatusnetApi;
import org.TSSG.social.statusnet.status.Status;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	private final AccountRepository accountRepository;

	private final ConnectionRepository connectionRepository;


	@Inject
	public HomeController(ConnectionRepository connectionRepository, AccountRepository userRepository) {
		this.connectionRepository = connectionRepository;
		this.accountRepository = userRepository;
	}
	
	
	@RequestMapping("/")
	public String home(Principal currentUser, Model model) {
		if(getStatusnetApi() != null) {
			StatusnetApi api = getStatusnetApi();
			ArrayList<Status> publicTimeline = api.getPublicTimeline();
			model.addAttribute("timeLineMessages", publicTimeline);
			model.addAttribute("statusnet_connected", true);
		}
		model.addAttribute(accountRepository.findAccountByUsername(currentUser.getName()));
		return "home";
	}
	
	private StatusnetApi getStatusnetApi() {
		Connection<StatusnetApi> connection = connectionRepository.findPrimaryConnection(StatusnetApi.class);
		return connection != null ? connection.getApi() : null;
	}
}
