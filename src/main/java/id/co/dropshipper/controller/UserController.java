package id.co.dropshipper.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.co.dropshipper.dao.UserDAO;
import id.co.dropshipper.model.Barang;
import id.co.dropshipper.model.User;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("semuaUser", userDAO.getAllUsers());
		return "U_index";
	}
	
	@GetMapping("/barang")
	public String barang(Model model) {
		model.addAttribute("semuaBarang", userDAO.getAllBarang());
		return "U_barang";
	}
	
	@GetMapping("/barang/{barangname}")
	public String barangCari(Model model, @PathVariable("barangname") String nama) {
		model.addAttribute("semuaBarang", userDAO.getAllBarangCari(nama));
		return "U_barang";
	}
	
	@GetMapping("/detailbarang/{barangid}")
	public String detail(Model model, @PathVariable("barangid") short id) {
		model.addAttribute("objekBarang", userDAO.getDetailBarang(id));		
		return "U_detailbarang";
	}
	
	@GetMapping("/tambah_keranjang/{barangid}")
	public Model barangKeranjang(Model model, @PathVariable("barangid") short id) {
		model.addAttribute("objekBarang", userDAO.getDetailBarang(id));		
		return model;
	}
	
	
	@GetMapping("/pengaturan/{username}")
	public String pengaturan(Model model, @PathVariable("username") String username) {
		model.addAttribute("user", userDAO.getUser(username));		
		return "U_pengaturan";
	}
	
	@PostMapping("/pengaturan")
	public String pengaturanUser(@Valid User user, 
			BindingResult result) {
		if(!result.hasErrors() && userDAO.editUser(user)) {
			return "redirect:/user/barang";

		} else {
			
			return "U_pengaturan";
		}
	}
	
	@GetMapping("/keranjang/{barangid}")
	public String keranjang(Model model, @PathVariable("barangid") short id, Principal principal) {
		model.addAttribute("objekBarang", userDAO.getDetailBarang(id));
		String name = principal.getName();
		String sku =  userDAO.getDetailBarang(id).getSku();
		Object jumlah = stringRedisTemplate.opsForHash().get("keranjang-" + name, sku);
	    model.addAttribute("username", name);
	    model.addAttribute("jumlahBarang", jumlah);
	    model.addAttribute("skux", sku);
		return "U_keranjang";
	}
	
	@GetMapping("/transaksi") 
	public String transaksi(Model model, Principal principal) {
		String name = principal.getName();
		//Map<Object, Object> jumlah = stringRedisTemplate.opsForHash().entries("keranjang-" + name);
		Set<Object> key = stringRedisTemplate.opsForHash().keys("keranjang-" + name);
		Iterator iterator = key.iterator();
		List<Barang> KeySKU = new ArrayList<Barang>();
		while (iterator.hasNext()) {
			KeySKU.add(userDAO.getBarangBySKU(iterator.next().toString()));
		}
		model.addAttribute("semuaBarang", KeySKU);

		
		return "U_transaksi";
	}
	
}
