package co.jp.tagbangers.controller.french;

import co.jp.tagbangers.core.entity.French;
import co.jp.tagbangers.core.service.FrenchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/users/edit/{id}")
public class FrenchEditController {

	public static final String TARGET_ENTITY_KEY = "user";
	public static final String FORM_MODEL_KEY = "form";

	public static final String ERRORS_MODEL_KEYS = BindingResult.MODEL_KEY_PREFIX + FORM_MODEL_KEY;

	@Autowired
	FrenchService userService;

	@ModelAttribute(TARGET_ENTITY_KEY)
	public French setupUser(@PathVariable long id) {
		French user = userService.searchUser(id);
		return user;
	}

	@ModelAttribute("genders")
	public French.Gender[] setupGender() {
		French.Gender[] genders = French.Gender.values();
//		return Arrays.copyOfRange(genders, 0, genders.length);
		return genders;
	}


	@GetMapping
	public String input(Model model) {
		French user = (French) model.asMap().get(TARGET_ENTITY_KEY);
		FrenchEditForm form = (FrenchEditForm) model.asMap().get(FORM_MODEL_KEY);
		form = Optional.ofNullable(form).orElse(new FrenchEditForm(user));

		model.addAttribute(FORM_MODEL_KEY, form);
		model.addAttribute(TARGET_ENTITY_KEY, user);
		return "user/edit";
	}

	@PostMapping
	public String update(
			@Validated @ModelAttribute(FORM_MODEL_KEY) FrenchEditForm form,
			@PathVariable Long id,
			BindingResult errors,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute(FORM_MODEL_KEY, form);
		redirectAttributes.addFlashAttribute(ERRORS_MODEL_KEYS, errors);
		if (errors.hasErrors()) {
			return "redirect:/users/new?error";
		}

		French updatedUser = userService.updateUser(form.toUserUpdateRequest(), id);
		redirectAttributes.getFlashAttributes().clear();
		redirectAttributes.addFlashAttribute("updatedUser", updatedUser);

		return "redirect:/users";
	}
}
