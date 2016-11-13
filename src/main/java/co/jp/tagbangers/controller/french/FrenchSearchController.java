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
@RequestMapping("/frenches")
public class FrenchSearchController {

	public static final String FORM_MODEL_KEY = "form";

	@Autowired
	private FrenchService frenchService;

	@ModelAttribute(FORM_MODEL_KEY)
	public FrenchSearchForm setFrenchSearchFrom() {
		return new FrenchSearchForm();
	}

	@GetMapping
	public String index(Model model) {
		List<French> frenches = frenchService.allFrenches();
		model.addAttribute("frenches", frenches);
		return "french/search";
	}

	@PostMapping
	public String search(
			@Validated @ModelAttribute(FORM_MODEL_KEY) FrenchSearchForm form,
			Model model) {
		List<French> frenches = frenchService.searchFrenches(form.toFrenchSearchRequest());
		model.addAttribute("frenches", frenches);
		return "french/search";
	}
}
