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

import id.co.dropshipper.dao.BankDAO;
import id.co.dropshipper.model.Bank;
import id.co.dropshipper.model.Wilayah;

@Controller
public class bankController {
	@Autowired
	private BankDAO bankDAO;
	
	@GetMapping("/bank")
	public String barang(Model model) {
		model.addAttribute("semuabank", bankDAO.getAllBank());
		model.addAttribute("objbank", new Bank());
		return "Vbank";
	}
	
	@PostMapping("/bank")
	public String add(@Valid Bank objbank,BindingResult result) {
		if (bankDAO.tambahBank(objbank)) {
			return "redirect:/bank"; //sama sama mapping
		}else {
			for (ObjectError err : result.getAllErrors()) {
				System.out.println(err.getDefaultMessage());
			}
			return "bank"; //mapping
		}
		
	}
	@GetMapping("/editbank/{bankId}")
	public String editb(Model model, @PathVariable("bankId") short id) {
		model.addAttribute("objeditbank",bankDAO.getBankId(id));
		return "Vbankedit";	//view
	}
	
	@PostMapping("/editbank")
	public String editbara(@Valid Bank bank ,
			BindingResult result) {
		if(!result.hasErrors() && bankDAO.updateBank(bank)) {
			return "redirect:/bank"; //mapping
			
		}else {
			return "bank"; //mapping
		}
	}
}
