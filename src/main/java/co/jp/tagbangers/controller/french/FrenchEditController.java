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

import static java.util.Optional.ofNullable;

@Controller
@RequestMapping("/frenches/edit/{id}")
public class FrenchEditController {

	public static final String TARGET_ENTITY_KEY = "french";
	public static final String FORM_MODEL_KEY = "form";

	public static final String ERRORS_MODEL_KEYS = BindingResult.MODEL_KEY_PREFIX + FORM_MODEL_KEY;

	@Autowired
	FrenchService frenchService;

	@ModelAttribute(TARGET_ENTITY_KEY)
	public French setupFrench(@PathVariable long id) {
		return frenchService.searchFrench(id);
	}

	@GetMapping
	public String input(Model model) {
		French french = (French) model.asMap().get(TARGET_ENTITY_KEY);
		FrenchEditForm form = (FrenchEditForm) model.asMap().get(FORM_MODEL_KEY);
		form = ofNullable(form).orElse(new FrenchEditForm(french));

		model.addAttribute(FORM_MODEL_KEY, form);
		model.addAttribute(TARGET_ENTITY_KEY, french);
		return "french/edit";
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
			return "redirect:/frenches/new?error";
		}

		French updatedFrench = frenchService.update(form.toFrenchUpdateRequest(), id);
		redirectAttributes.getFlashAttributes().clear();
		redirectAttributes.addFlashAttribute("updatedFrench", updatedFrench);

		return "redirect:/frenches";
	}
}
