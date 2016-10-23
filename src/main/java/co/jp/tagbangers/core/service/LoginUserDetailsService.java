package co.jp.tagbangers.core.service;

import co.jp.tagbangers.core.entity.User;
import co.jp.tagbangers.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByName(username);

		if (user == null) {
			throw new UsernameNotFoundException("The request user is not found.");
		}
		return new LoginUserDetails(user);
	}
}
