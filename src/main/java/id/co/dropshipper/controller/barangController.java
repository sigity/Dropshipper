package id.co.dropshipper.controller;

import javax.validation.Valid;
import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.co.dropshipper.dao.BarangDAO;
import id.co.dropshipper.model.Bank;
import id.co.dropshipper.model.Barang;

@Controller
//@RequestMapping("admin")
public class barangController {
	
	@Autowired private BarangDAO barangDAO;
	
	@GetMapping("/barang")
	public String barang(Model model) {
		model.addAttribute("semuaBarang", barangDAO.getAllBarang());
		model.addAttribute("objbarang", new Barang());
		return "Vbarang";
	}

	@GetMapping("/tambah")
	public String tambah(Model model) {
		model.addAttribute("objbarang", new Barang());
		return "/barang/tambahbarang";
	}
	

	@PostMapping("/barang")
	public String add(@Valid Barang objbarang,BindingResult result) {
		if (barangDAO.tambahBarang(objbarang)) {
			return "redirect:/barang"; //sama sama mapping
		}else {
			for (ObjectError err : result.getAllErrors()) {
				System.out.println(err.getDefaultMessage());
			}
			return "barang"; //mapping
		}
		
	}
	
	@GetMapping("/editbarang/{barangId}")
	public String editb(Model model, @PathVariable("barangId") short id) {
		model.addAttribute("objedit", barangDAO.getBarangid(id));
		return "Vbarangedit";	//view
	}
	
	@PostMapping("/editbarang")
	public String editbara(@Valid Barang barang,
			BindingResult result) {
		if(!result.hasErrors() && barangDAO.updateBarang(barang)) {
			return "redirect:/barang"; //mapping
			
		}else {
			return "editbarang"; //mapping
		}
	}
	
}
