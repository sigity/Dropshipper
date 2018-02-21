package id.co.dropshipper.controller;

import javax.servlet.http.HttpServletRequest;
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
//@RequestMapping("user")
public class UserController {

	@Autowired
	private UserDAO userDAO;
	
	@GetMapping("/user_index")
	public String index(Model model) {
		model.addAttribute("semuaUser", userDAO.getAllUsers());
		return "U_index";
	}
	
	@GetMapping("/user_barang")
	public String barang(Model model) {
		model.addAttribute("semuaBarang", userDAO.getAllBarang());
		return "U_barang";
	}
	
	@GetMapping("/user_barang/{barangName}")
	public String barangCari(Model model, @PathVariable("barangName") String nama) {
		model.addAttribute("semuaBarang", userDAO.getAllBarangCari(nama));
		return "U_barang";
	}
	
	@GetMapping("/user_detailbarang/{barangId}")
	public String detail(Model model, @PathVariable("barangId") short id) {
		model.addAttribute("objekBarang", userDAO.getDetailBarang(id));		
		return "U_detailbarang";
	}
	
	@GetMapping("/tambah_keranjang/{barangId}")
	public Model barangKeranjang(Model model, @PathVariable("barangId") short id) {
		model.addAttribute("objekBarang", userDAO.getDetailBarang(id));		
		return model;
	}
	
	@GetMapping("/user_daftar")
	public String addForm(Model model) {
		model.addAttribute("user", new User());
		return "U_daftar";
	}
	
	@PostMapping("/user_daftar")
	public String add(@Valid User user,
			BindingResult result) {
		if(!result.hasErrors() && userDAO.addUser(user)) {
			return "redirect:/login";
		} else {
			
			return "U_daftar";
		}
	}
	
	@GetMapping("/user_pengaturan/{userId}")
	public String pengaturan(Model model, @PathVariable("userId") short id) {
		model.addAttribute("user", userDAO.getUser(id));		
		return "U_pengaturan";
	}
	
	@PostMapping("/user_pengaturan")
	public String pengaturanUser(@Valid User user, 
			BindingResult result) {
		if(!result.hasErrors() && userDAO.editUser(user)) {
			return "redirect:/user_barang";

		} else {
			
			return "U_pengaturan";
		}
	}
	
}
