package id.co.dropshipper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.dropshipper.dao.BarangDAO;
import id.co.dropshipper.model.Barang;

@RestController
public class BackgroundHandler {
	@Autowired
	private BarangDAO barangDAO;
	
	@GetMapping("/deletebarang")
	public boolean deleteBarang(@RequestParam("barangId") short barangId) {
		Barang objbarangedit = barangDAO.getBarangid(barangId);
		objbarangedit.setIsActive(0);
		return barangDAO.updateBarang(objbarangedit);
	}
}
