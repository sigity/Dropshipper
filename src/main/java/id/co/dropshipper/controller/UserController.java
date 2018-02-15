package id.co.dropshipper.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.co.dropshipper.dao.UserDAO;
import id.co.dropshipper.model.User;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserDAO userDAO;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("semuaUser", userDAO.getAllUsers());
		return "user/index";
	}
	
	@GetMapping("/barang")
	public String barang(Model model) {
		model.addAttribute("semuaBarang", userDAO.getAllBarang());
		return "user/barang";
	}
	
	@GetMapping("/detailbarang/{barangId}")
	public String detail(Model model, @PathVariable("barangId") short id) {
		model.addAttribute("objekBarang", userDAO.getDetailBarang(id));		
		return "user/detailbarang";
	}
	
	@GetMapping("/daftar")
	public String addForm(Model model) {
		model.addAttribute("user", new User());
		return "user/daftar";
	}
	
	@PostMapping("/daftar")
	public String add(@Valid User user,
			BindingResult result) {
		if(!result.hasErrors() && userDAO.addUser(user)) {
			return "redirect:/user/index";
		} else {
			
			return "user/daftar";
		}
	}
	
	@GetMapping("/pengaturan/{userId}")
	public String pengaturan(Model model, @PathVariable("userId") short id) {
		model.addAttribute("user", userDAO.getUser(id));		
		return "user/pengaturan";
	}
	
	@PostMapping("/pengaturan")
	public String pengaturanUser(@Valid User user, 
			BindingResult result) {
		if(!result.hasErrors() && userDAO.editUser(user)) {
			return "redirect:/user/index";
		} else {
			
			return "user/pengaturan";
		}
	}
	
}
