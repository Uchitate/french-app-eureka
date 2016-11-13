package co.jp.tagbangers.core.service;

import co.jp.tagbangers.core.entity.French;
import co.jp.tagbangers.core.repository.FrenchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginUserDetailsService implements UserDetailsService {

	@Autowired
	FrenchRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		French user = userRepository.findByName(username);

		if (user == null) {
			throw new UsernameNotFoundException("The request user is not found.");
		}
		return new LoginUserDetails(user);
	}
}
