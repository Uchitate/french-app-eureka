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
	FrenchRepository frenchRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	public List<French> allFrenches() {
		return frenchRepository.findAll();
	}

	public List<French> searchFrenches(FrenchSearchRequest request) {
		return frenchRepository.search(request);
	}

	public French searchFrench(long id) {
		return frenchRepository.findById(id);
	}

	public French create(FrenchCreateRequest request) {
		French french = new French(request.getName(), passwordEncoder.encode(request.getPassword()), request.getEmail(), request.getAddress());
		return frenchRepository.saveAndFlush(french);
	}

	public French update(FrenchUpdateRequest request, long id) {
		French french = frenchRepository.findById(id);
		french.setName(request.getName());
		french.setEmail(request.getEmail());
		french.setAddress(request.getAddress());

		return frenchRepository.saveAndFlush(french);
	}

	public String delete(Long id){
		French french = frenchRepository.findById(id);
		frenchRepository.delete(french);
		return french.getName();
	}
}
