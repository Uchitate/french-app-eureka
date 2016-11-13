package co.jp.tagbangers.core.service;

import co.jp.tagbangers.core.entity.French;
import co.jp.tagbangers.core.model.FrenchCreateRequest;
import co.jp.tagbangers.core.model.FrenchSearchRequest;
import co.jp.tagbangers.core.model.FrenchUpdateRequest;
import co.jp.tagbangers.core.repository.FrenchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrenchService {

	@Autowired
	FrenchRepository userRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public List<French> allUsers() {
		return userRepository.findAll();
	}

	public List<French> searchUsers(FrenchSearchRequest request) {
		return userRepository.search(request);
	}

	public French searchUser(long id) {
		return userRepository.findById(id);
	}

	public French createUser(FrenchCreateRequest request) {
		French user = new French(request.getName(), passwordEncoder.encode(request.getPassword()), request.getEmail(), request.getAge(), request.getGender());
		return userRepository.saveAndFlush(user);
	}

	public French updateUser(FrenchUpdateRequest request, long id) {
		French user = userRepository.findById(id);
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setAge(request.getAge());
		user.setGender(request.getGender());

		return userRepository.saveAndFlush(user);
	}

	public String deleteUser(Long id){
		French user = userRepository.findById(id);
		userRepository.delete(user);
		return user.getName();
	}
}
