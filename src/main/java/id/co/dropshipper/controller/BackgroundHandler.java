package id.co.dropshipper.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.dropshipper.dao.BankDAO;
import id.co.dropshipper.dao.BarangDAO;
import id.co.dropshipper.dao.KategoriDAO;
import id.co.dropshipper.dao.KurirDAO;
import id.co.dropshipper.dao.LokasiDAO;
import id.co.dropshipper.dao.VendorDAO;
import id.co.dropshipper.dao.WilayahDAO;
import id.co.dropshipper.model.Bank;
import id.co.dropshipper.model.Barang;
import id.co.dropshipper.model.Kategori;
import id.co.dropshipper.model.Kurir;
import id.co.dropshipper.model.Lokasi;
import id.co.dropshipper.model.Vendor;
import id.co.dropshipper.model.Wilayah;

@RestController
public class BackgroundHandler {
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	@Autowired
	private BankDAO bankDAO;
	@Autowired
	private BarangDAO barangDAO;
	@Autowired
	private KategoriDAO kategoriDAO;
	@Autowired
	private VendorDAO vendorDAO;
	@Autowired
	private KurirDAO kurirDAO;
	@Autowired
	private WilayahDAO wilayahDAO;
	@Autowired
	private LokasiDAO lokasiDAO;
	
	@GetMapping("/deletebank")
	public boolean deleteBa(@RequestParam("bankid") short bankid) {
		Bank objbankedit = bankDAO.getBankId(bankid);
		objbankedit.setIsactive(0);
		return bankDAO.updateBank(objbankedit);
	}
	@GetMapping("/deletekurir")
	public boolean deleteKUR(@RequestParam("kuririd") short kuririd) {
		Kurir ob=kurirDAO.getId(kuririd);
		ob.setIsactive(0);
		return kurirDAO.edit(ob);
	}
	@GetMapping("/deletewilayah")
	public boolean deleteWIL(@RequestParam("wilayahid") short wilayahid) {
		Wilayah ob=wilayahDAO.getId(wilayahid);
		ob.setIsactive(0);
		return wilayahDAO.edit(ob);
	}
	
	@GetMapping("/deletelokasi")
	public boolean deleteLOK(@RequestParam("lokasiid") short lokasiid) {
		
		Lokasi ob=lokasiDAO.getLokasiid(lokasiid);
		ob.setIsactive(0);
		return lokasiDAO.updateLok(ob);
	}
	@GetMapping("/deletevendor")
	public boolean deleteVe(@RequestParam("vendorid") short vendorid) {
		Vendor objvn = vendorDAO.getId(vendorid);
		objvn.setIsactive(0);
		return vendorDAO.edit(objvn);
	}
	
	@GetMapping("/deletekategori")
	public boolean deleteKa(@RequestParam("kategoriid") short kategoriid) {
		Kategori obKategori = kategoriDAO.getKategoriid(kategoriid);
		obKategori.setIsactive(0);
		return kategoriDAO.updateKat(obKategori);
	}
	
	@GetMapping("/deletebarang")
	public boolean deleteBarang(@RequestParam("barangid") int barangid) {
		Barang objbarangedit =barangDAO.getBarangid(barangid);
		objbarangedit.setIsactive(0);
		return barangDAO.updateBarang(objbarangedit);
	}
	
	
	@GetMapping ("/wilayahidnya")
	public List<String> getWilayahid() {
		StringBuilder builder ;
		List<String> hasil = new ArrayList<>();
		List<Wilayah> listwilayahidnya = 
				entityManagerFactory
				.createEntityManager()
				.createQuery("from Wilayah")
				.getResultList();
		
		for(Wilayah wilayah : listwilayahidnya ) {
			builder = new StringBuilder();
			builder.append(wilayah.getWilayahid());
			hasil.add(builder.toString());
		}
			
		return hasil;
	}
	
	@GetMapping ("/wilayahnamanyanya")
	public List<String> getWilayahnama() {
		StringBuilder builder ;
		List<String> hasil = new ArrayList<>();
		List<Wilayah> listwilayahnamanyanya = 
				entityManagerFactory
				.createEntityManager()
				.createQuery("from Wilayah")
				.getResultList();
		
		for(Wilayah wilayah : listwilayahnamanyanya ) {
			builder = new StringBuilder();
			builder.append(wilayah.getWilayahname());
			hasil.add(builder.toString());
		}
			
		return hasil;
	}
}
