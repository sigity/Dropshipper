package id.co.dropshipper.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import id.co.dropshipper.dao.VendorDAO;
import id.co.dropshipper.model.Barang;
import id.co.dropshipper.model.Vendor;

@Controller
public class vendorController {
	@Autowired
	private VendorDAO vendorDAO;
	
	@GetMapping("/vendor")
	public String barang(Model model) {
		model.addAttribute("semuaVendor", vendorDAO.getAllVendor());
		model.addAttribute("objvendor", new Vendor());
		return "Vvendor";
	}
	
	@PostMapping("/vendor")
	public String add(@Valid Vendor objvendor,BindingResult result) {
		if (vendorDAO.tambahVendor(objvendor)) {
			return "redirect:/vendor"; //sama sama mapping
		}else {
			for (ObjectError err : result.getAllErrors()) {
				System.out.println(err.getDefaultMessage());
			}
			return "Vvendor"; //mapping
		}
		
	}
	@GetMapping("/editvendor/{vendorId}")
	public String editb(Model model, @PathVariable("vendorId") short id) {
		model.addAttribute("objeditvendor",vendorDAO.getVendor(id));
		return "Vvendoredit";	//view
	}
	
	@PostMapping("/editvendor")
	public String editbara(@Valid Vendor vendor,
			BindingResult result) {
		if(!result.hasErrors() && vendorDAO.updateVe(vendor)) {
			return "redirect:/vendor"; //mapping
			
		}else {
			return "editvendor"; //mapping
		}
	}
	
	
}
