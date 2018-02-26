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

import id.co.dropshipper.dao.LokasiDAO;
import id.co.dropshipper.model.Lokasi;

@Controller
public class lokasiController {
	@Autowired
	private LokasiDAO lokasiDAO;
	
	@GetMapping("/lokasi")
	public String barang(Model model) {
		model.addAttribute("semuaLokasi", lokasiDAO.getAllLokasi());
		model.addAttribute("objlokasi", new Lokasi());
		return "Vlokasi";
	}
	
	@PostMapping("/lokasi")
	public String add(@Valid Lokasi objlokasi,BindingResult result) {
		if (lokasiDAO.tambahlokasi(objlokasi)) {
			return "redirect:/lokasi"; //sama sama mapping
		}else {
			for (ObjectError err : result.getAllErrors()) {
				System.out.println(err.getDefaultMessage());
			}
			return "Vlokasi"; //mapping
		}
		
	}
	@GetMapping("/editlokasi/{lokasiId}")
	public String editb(Model model, @PathVariable("lokasiId") short id) {
		model.addAttribute("objeditlokasi",lokasiDAO.getLokasiid(id));
		return "Vlokasiedit";	//view
	}
	
	@PostMapping("/editlokasi")
	public String editbara(@Valid Lokasi lokasi,
			BindingResult result) {
		if(!result.hasErrors() && lokasiDAO.updateLok(lokasi)) {
			return "redirect:/lokasi"; //mapping
			
		}else {
			return "editlokasi"; //mapping
		}
	}
}
