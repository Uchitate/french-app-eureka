package co.jp.tagbangers.controller.french;

import co.jp.tagbangers.core.service.FrenchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/frenches/delete/{id}")
public class FrenchDeleteController {

	@Autowired
	FrenchService frenchService;

	@DeleteMapping
	public String delete(
			@PathVariable Long id,
			RedirectAttributes redirectAttributes) {
		String deletedFrench = frenchService.delete(id);
		deletedFrench = frenchService.searchFrench(id) == null ? deletedFrench : null;
		redirectAttributes.addFlashAttribute("deletedFrench", deletedFrench);
		return "redirect:/frenches";
	}
}
