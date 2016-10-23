package co.jp.tagbangers.controller.user;

import co.jp.tagbangers.core.entity.User;
import co.jp.tagbangers.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
@RequestMapping("/users/new")
public class UserCreateController {

	public static final String FORM_MODEL_KEY = "form";

	public static final String ERRORS_MODEL_KEYS = BindingResult.MODEL_KEY_PREFIX + FORM_MODEL_KEY;

	@Autowired
	UserService userService;

	@ModelAttribute(FORM_MODEL_KEY)
	public UserCreateForm setupUserCreateForm() {
		return new UserCreateForm();
	}

	@ModelAttribute("genders")
	public User.Gender[] setupGender() {
		User.Gender[] genders = User.Gender.values();
		return Arrays.copyOfRange(genders, 0, genders.length);
	}

	@GetMapping
	public String input(Model model) {
		UserCreateForm form = (UserCreateForm) model.asMap().get(FORM_MODEL_KEY);
		model.addAttribute("form", form);
		return "user/create";
	}

	@PostMapping
	public String save(
			@Validated @ModelAttribute(FORM_MODEL_KEY) UserCreateForm form,
			BindingResult errors,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute(FORM_MODEL_KEY, form);
		redirectAttributes.addFlashAttribute(ERRORS_MODEL_KEYS, errors);
		if (errors.hasErrors()) {
			return "redirect:/users/new?error";
		}
		User savedUser = userService.createUser(form.toUserCreateRequest());
		redirectAttributes.getFlashAttributes().clear();
		redirectAttributes.addFlashAttribute("savedUser", savedUser);

		return "redirect:/users";
	}
}
