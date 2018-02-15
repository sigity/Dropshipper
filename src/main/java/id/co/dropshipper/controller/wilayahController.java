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

import id.co.dropshipper.dao.WilayahDAO;
import id.co.dropshipper.model.Wilayah;

@Controller
public class wilayahController {
	@Autowired
	private WilayahDAO wilayahDAO;
	@GetMapping("/wilayah")
	public String barang(Model model) {
		model.addAttribute("semuawilayah", wilayahDAO.getAllWilayah());
		model.addAttribute("objwilayah", new Wilayah());
		return "Vwilayah";
	}
	
	@PostMapping("/wilayah")
	public String add(@Valid Wilayah objwilayah,BindingResult result) {
		if (wilayahDAO.tambahWilayah(objwilayah)) {
			return "redirect:/wilayah"; //sama sama mapping
		}else {
			for (ObjectError err : result.getAllErrors()) {
				System.out.println(err.getDefaultMessage());
			}
			return "wilayah"; //mapping
		}
		
	}
	@GetMapping("/editwilayah/{wilayahId}")
	public String editb(Model model, @PathVariable("wilayahId") short id) {
		model.addAttribute("objeditwilayah",wilayahDAO.getWilayah(id));
		return "Vwilayahedit";	//view
	}
	
	@PostMapping("/editwilayah")
	public String editbara(@Valid Wilayah wilayah,
			BindingResult result) {
		if(!result.hasErrors() && wilayahDAO.updateWi(wilayah)) {
			return "redirect:/wilayah"; //mapping
			
		}else {
			return "Vwilayah"; //mapping
		}
	}
}
