package co.jp.tagbangers.controller.user;

import co.jp.tagbangers.core.entity.User;
import co.jp.tagbangers.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserSearchController {

	public static final String FORM_MODEL_KEY = "form";

	@Autowired
	private UserService userService;

	@ModelAttribute(FORM_MODEL_KEY)
	public UserSearchForm setUserSearchFrom() {
		return new UserSearchForm();
	}

	@ModelAttribute("genders")
	public User.Gender[] setupGender() {
		User.Gender[] genders = User.Gender.values();
//		return Arrays.copyOfRange(genders, 0, genders.length);
		return genders;
	}

	@GetMapping
	public String index(Model model) {
		List<User> users = userService.allUsers();
		model.addAttribute("users", users);
		return "user/search";
	}

	@PostMapping
	public String search(
			@Validated @ModelAttribute(FORM_MODEL_KEY) UserSearchForm form,
			Model model) {
		List<User> users = userService.searchUsers(form.toUserSearchRequest());
		model.addAttribute("users", users);
		return "user/search";
	}
}
