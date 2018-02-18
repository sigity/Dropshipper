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

import id.co.dropshipper.dao.kategoriDAO;
import id.co.dropshipper.model.Kategori;


@Controller
public class kategoriController {
	@Autowired
	private kategoriDAO kategoriDAO;
	
	@GetMapping("/kategori")
	public String barang(Model model) {
		model.addAttribute("semuakategori", kategoriDAO.getAllKategori());
		model.addAttribute("objkategori", new Kategori());
		return "Vkategori";
	}
	
	@PostMapping("/kategori")
	public String add(@Valid Kategori objkategori,BindingResult result) {
		if (kategoriDAO.tambahkategori(objkategori)) {
			return "redirect:/kategori"; //sama sama mapping
		}else {
			for (ObjectError err : result.getAllErrors()) {
				System.out.println(err.getDefaultMessage());
			}
			return "Vkategori"; //mapping
		}
		
	}
	@GetMapping("/editkategori/{kategoriId}")
	public String editb(Model model, @PathVariable("kategoriId") short id) {
		model.addAttribute("objeditkategori",kategoriDAO.getKategoriid(id));
		return "Vkategoriedit";	//view
	}
	
	@PostMapping("/editkategori")
	public String editbara(@Valid Kategori kategori,
			BindingResult result) {
		if(!result.hasErrors() && kategoriDAO.updateKat(kategori)) {
			return "redirect:/kategori"; //mapping
			
		}else {
			return "editkategori"; //mapping
		}
	}
}
