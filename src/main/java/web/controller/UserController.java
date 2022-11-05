package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.Users;
import web.service.UserService;


@Controller
@Transactional
public class UserController {
	private final UserService userService;
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public String listUsers(Model model) {
		model.addAttribute("users", userService.listUsers());
		return "index";
	}
	@GetMapping(value = "/add")
	String addUser(Model model) {
		model.addAttribute("user", new Users());
		return "add";
	}
	@PostMapping
	String addUser(@ModelAttribute("user") Users user){
		userService.add(user);
		return "redirect:/";
	}
	@GetMapping("/edit/{id}")
	public String edit(Model model, @PathVariable("id") long id) {
		model.addAttribute("user", userService.getUser(id));
		return "/edit";
	}
	@PostMapping("/{id}")
	public String updateUser(@ModelAttribute("user") Users user, @PathVariable("id") long id){
		userService.updateUserByID(user, id);
		return "redirect:/";
	}
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") long id) {
		userService.deleteUserByID(id);
		return "redirect:/";
	}
}