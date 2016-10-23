package co.jp.tagbangers.core.service;

import co.jp.tagbangers.core.entity.User;
import co.jp.tagbangers.core.model.UserCreateRequest;
import co.jp.tagbangers.core.model.UserSearchRequest;
import co.jp.tagbangers.core.model.UserUpdateRequest;
import co.jp.tagbangers.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public List<User> allUsers() {
		return userRepository.findAll();
	}

	public List<User> searchUsers(UserSearchRequest request) {
		return userRepository.search(request);
	}

	public User searchUser(long id) {
		return userRepository.findById(id);
	}

	public User createUser(UserCreateRequest request) {
		User user = new User(request.getName(), passwordEncoder.encode(request.getPassword()), request.getEmail(), request.getAge(), request.getGender());
		return userRepository.saveAndFlush(user);
	}

	public User updateUser(UserUpdateRequest request, long id) {
		User user = userRepository.findById(id);
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setAge(request.getAge());
		user.setGender(request.getGender());

		return userRepository.saveAndFlush(user);
	}

	public String deleteUser(Long id){
		User user = userRepository.findById(id);
		userRepository.delete(user);
		return user.getName();
	}
}
