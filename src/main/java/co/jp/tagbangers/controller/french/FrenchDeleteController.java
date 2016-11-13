package co.jp.tagbangers.controller.french;

import co.jp.tagbangers.core.service.FrenchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users/delete/{id}")
public class FrenchDeleteController {

	@Autowired
	FrenchService userService;

	@DeleteMapping
	public String delete(
			@PathVariable Long id,
			RedirectAttributes redirectAttributes) {
		String deletedUser = userService.deleteUser(id);
		deletedUser = userService.searchUser(id) == null ? deletedUser : null;
		redirectAttributes.addFlashAttribute("deletedUser", deletedUser);
		return "redirect:/users";
	}
}
