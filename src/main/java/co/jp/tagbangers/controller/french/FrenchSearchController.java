package co.jp.tagbangers.controller.french;

import co.jp.tagbangers.core.entity.French;
import co.jp.tagbangers.core.service.FrenchService;
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
public class FrenchSearchController {

	public static final String FORM_MODEL_KEY = "form";

	@Autowired
	private FrenchService userService;

	@ModelAttribute(FORM_MODEL_KEY)
	public FrenchSearchForm setUserSearchFrom() {
		return new FrenchSearchForm();
	}

	@ModelAttribute("genders")
	public French.Gender[] setupGender() {
		French.Gender[] genders = French.Gender.values();
//		return Arrays.copyOfRange(genders, 0, genders.length);
		return genders;
	}

	@GetMapping
	public String index(Model model) {
		List<French> users = userService.allUsers();
		model.addAttribute("users", users);
		return "user/search";
	}

	@PostMapping
	public String search(
			@Validated @ModelAttribute(FORM_MODEL_KEY) FrenchSearchForm form,
			Model model) {
		List<French> users = userService.searchUsers(form.toUserSearchRequest());
		model.addAttribute("users", users);
		return "user/search";
	}
}
