package id.co.dropshipper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import id.co.dropshipper.dao.UserDAO;

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
	
}
