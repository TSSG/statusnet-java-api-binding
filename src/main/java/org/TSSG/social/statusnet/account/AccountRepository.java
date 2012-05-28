package org.TSSG.social.statusnet.account;

public interface AccountRepository {
	
	void createAccount(Account account) throws UsernameAlreadyInUseException;

	Account findAccountByUsername(String username);
	
}
