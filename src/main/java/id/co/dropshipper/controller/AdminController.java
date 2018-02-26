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

import id.co.dropshipper.dao.BankDAO;
import id.co.dropshipper.dao.BarangDAO;
import id.co.dropshipper.dao.DetailtransaksiDAO;
import id.co.dropshipper.dao.KategoriDAO;
import id.co.dropshipper.dao.KurirDAO;
import id.co.dropshipper.dao.LokasiDAO;
import id.co.dropshipper.dao.PengambilanDAO;
import id.co.dropshipper.dao.RekeningDAO;
import id.co.dropshipper.dao.TransaksiDAO;
import id.co.dropshipper.dao.VendorDAO;
import id.co.dropshipper.dao.WaktupengambilanDAO;
import id.co.dropshipper.dao.WilayahDAO;
import id.co.dropshipper.model.Bank;
import id.co.dropshipper.model.Barang;
import id.co.dropshipper.model.Detailtransaksi;
import id.co.dropshipper.model.Kategori;
import id.co.dropshipper.model.Kurir;
import id.co.dropshipper.model.Lokasi;
import id.co.dropshipper.model.Pengambilan;
import id.co.dropshipper.model.Rekening;
import id.co.dropshipper.model.Vendor;
import id.co.dropshipper.model.Wilayah;

@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private BarangDAO barangDAO;
	@Autowired
	private BankDAO bankDAO;
	@Autowired
	private KategoriDAO kategoriDAO;
	@Autowired
	private KurirDAO kurirDAO;
	@Autowired
	private LokasiDAO lokasiDAO;
	@Autowired
	private PengambilanDAO pengambilanDAO;
	@Autowired
	private RekeningDAO rekeningDAO;
	@Autowired
	private TransaksiDAO transaksiDAO;
	@Autowired
	private  VendorDAO vendorDAO;
	@Autowired
	private WaktupengambilanDAO waktupengambilanDAO;
	@Autowired
	private WilayahDAO wilayahDAO;
	
	
	//barang
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
			return "redirect:/admin/barang"; //sama sama mapping
		}else {
			for (ObjectError err : result.getAllErrors()) {
				System.out.println(err.getDefaultMessage());
			}
			return "admin/barang"; //mapping
		}
		
	}
	
	@GetMapping("/editbarang/{barangid}")
	public String editb(Model model, @PathVariable("barangid") short id) {
		model.addAttribute("objedit", barangDAO.getBarangid(id));
		return "Vbarangedit";	//view
	}
	
	@PostMapping("/editbarang")
	public String editbara(@Valid Barang barang,
			BindingResult result) {
		if(!result.hasErrors() && barangDAO.updateBarang(barang)) {
			return "redirect:/admin/barang"; //mapping
			
		}else {
			return "admin/editbarang"; //mapping
		}
	}
	
	
	//bank
	@GetMapping("/bank")
	public String bank(Model model) {
		model.addAttribute("semuabank", bankDAO.getAllBank());
		model.addAttribute("objbank", new Bank());
		return "Vbank";
	}
	
	@PostMapping("/bank")
	public String add(@Valid Bank objbank,BindingResult result) {
		if (bankDAO.tambahBank(objbank)) {
			return "redirect:/admin/bank"; //sama sama mapping
		}else {
			for (ObjectError err : result.getAllErrors()) {
				System.out.println(err.getDefaultMessage());
			}
			return "admin/bank"; //mapping
		}
		
	}
	@GetMapping("/editbank/{bankid}")
	public String editbank(Model model, @PathVariable("bankid") short id) {
		model.addAttribute("objeditbank",bankDAO.getBankId(id));
		return "Vbankedit";	//view
	}
	
	@PostMapping("/editbank")
	public String editbara(@Valid Bank bank ,
			BindingResult result) {
		if(!result.hasErrors() && bankDAO.updateBank(bank)) {
			return "redirect:/admin/bank"; //mapping
			
		}else {
			return "admin/bank"; //mapping
		}
	}
	
	//kategori
	@GetMapping("/kategori")
	public String kategori(Model model) {
		model.addAttribute("semuakategori", kategoriDAO.getAllKategori());
		model.addAttribute("objkategori", new Kategori());
		return "Vkategori";
	}
	
	@PostMapping("/kategori")
	public String add(@Valid Kategori obj,BindingResult result) {
		if (kategoriDAO.tambahkategori(obj)) {
			return "redirect:/admin/kategori"; //sama sama mapping
		}else {
			for (ObjectError err : result.getAllErrors()) {
				System.out.println(err.getDefaultMessage());
			}
			return "admin/kategori"; //mapping
		}
		
	}
	@GetMapping("/editkategori/{kategoriid}")
	public String editkategori(Model model, @PathVariable("kategoriid") short id) {
		model.addAttribute("objeditkategori",kategoriDAO.getKategoriid(id));
		return "Vkategoriedit";	//view
	}
	
	@PostMapping("/editkategori")
	public String editKATEGORI(@Valid Kategori kategori,
			BindingResult result) {
		if(!result.hasErrors() && kategoriDAO.updateKat(kategori)) {
			return "redirect:/admin/kategori"; //mapping
			
		}else {
			return "Vkategoriedit"; //mapping
		}
	}
	
	
	//kurir
	@GetMapping("/kurir")
	public String kurir(Model model) {
		model.addAttribute("semuakurir", kurirDAO.index());
		model.addAttribute("objkurir", new Kurir());
		return "Vkurir";
	}
	
	@PostMapping("/kurir")
	public String add(@Valid Kurir obj,BindingResult result) {
		if (kurirDAO.add(obj)) {
			return "redirect:/admin/kurir"; //sama sama mapping
		}else {
			for (ObjectError err : result.getAllErrors()) {
				System.out.println(err.getDefaultMessage());
			}
			return "admin/kurir"; //mapping
		}
		
	}
	@GetMapping("/editkurir/{kuririd}")
	public String editkurir(Model model, @PathVariable("kuririd") short id) {
		model.addAttribute("objeditkurir",kurirDAO.getId(id));
		return "Vkuriredit";	//view
	}
	
	@PostMapping("/editkurir")
	public String editkurir(@Valid Kurir kurir,
			BindingResult result) {
		if(!result.hasErrors() && kurirDAO.edit(kurir)) {
			return "redirect:/admin/kurir"; //mapping
			
		}else {
			return "Vkuriredi"; //mapping
		}
	}
	
	//lokasi
	@GetMapping("/lokasi")
	public String lokasi(Model model) {
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
	public String editlokasi(Model model, @PathVariable("lokasiId") short id) {
		model.addAttribute("objeditlokasi",lokasiDAO.getLokasiid(id));
		return "Vlokasiedit";	//view
	}
	
	@PostMapping("/editlokasi")
	public String editlokasi(@Valid Lokasi lokasi,
			BindingResult result) {
		if(!result.hasErrors() && lokasiDAO.updateLok(lokasi)) {
			return "redirect:/lokasi"; //mapping
			
		}else {
			return "editlokasi"; //mapping
		}
	}
	
	
	//rekening
	@GetMapping("/rekening")
	public String rekening(Model model) {
		model.addAttribute("semuarekening",rekeningDAO.index());
		model.addAttribute("objrekening", new Lokasi());
		return "Vrekening";
	}
	
	@PostMapping("/rekening")
	public String add(@Valid Rekening obj,BindingResult result) {
		if (rekeningDAO.add(obj)) {
			return "redirect:/rekening"; //sama sama mapping
		}else {
			for (ObjectError err : result.getAllErrors()) {
				System.out.println(err.getDefaultMessage());
			}
			return "rekening"; //mapping
		}
		
	}
	@GetMapping("/editrekening/{rekeningid}")
	public String editrekening(Model model, @PathVariable("rekeningid") short id) {
		model.addAttribute("objeditrekening",rekeningDAO.getId(id));
		return "Vrekeningedit";	//view
	}
	
	@PostMapping("/editrekening")
	public String editrekening(@Valid Rekening rekening,
			BindingResult result) {
		if(!result.hasErrors() && rekeningDAO.edit(rekening)) {
			return "redirect:/rekening"; //mapping
			
		}else {
			return "rekening"; //mapping
		}
	}
	
	//vendor
	@GetMapping("/vendor")
	public String vendor(Model model) {
		model.addAttribute("semuavendor",vendorDAO.index());
		model.addAttribute("objvendor", new Vendor());
		return "Vvendor";
	}
	
	@PostMapping("/vendor")
	public String add(@Valid Vendor objvendor,BindingResult result) {
		if (vendorDAO.add(objvendor)) {
			return "redirect:/admin/vendor"; //sama sama mapping
		}else {
			for (ObjectError err : result.getAllErrors()) {
				System.out.println(err.getDefaultMessage());
			}
			return "vendor"; //mapping
		}
		
	}
	@GetMapping("/editvendor/{vendorid}")
	public String editvendor(Model model, @PathVariable("vendorid") short id) {
		model.addAttribute("objeditvendor",vendorDAO.getId(id) );
		return "Vvendoredit";	//view
	}
	
	@PostMapping("/editvendor")
	public String editvendor(@Valid Vendor vendor,
			BindingResult result) {
		if(!result.hasErrors() && vendorDAO.edit(vendor)) {
			return "redirect:/admin/vendor"; //mapping
			
		}else {
			return "editvendor"; //mapping
		}
	}
	@GetMapping("/wilayah")
	public String wilayah(Model model) {
		model.addAttribute("semuawilayah",wilayahDAO.index());
		model.addAttribute("objwilayah", new Wilayah());
		return "Vwilayah";
	}
	
	@PostMapping("/wilayah")
	public String add(@Valid Wilayah objwilayah,BindingResult result) {
		if (wilayahDAO.add(objwilayah)) {
			return "redirect:/admmin/wilayah"; //sama sama mapping
		}else {
			for (ObjectError err : result.getAllErrors()) {
				System.out.println(err.getDefaultMessage());
			}
			return "wilayah"; //mapping
		}
		
	}
	@GetMapping("/editwilayah/{wilayahid}")
	public String editwilayah(Model model, @PathVariable("wilayahid") short id) {
		model.addAttribute("objeditwilayah",wilayahDAO.getId(id) );
		return "Vwilayahedit";	//view
	}
	
	@PostMapping("/editwilayah")
	public String editwilayah(@Valid Wilayah wilayah,
			BindingResult result) {
		if(!result.hasErrors() && wilayahDAO.edit(wilayah)) {
			return "redirect:/wilayah"; //mapping
			
		}else {
			return "editwilayah"; //mapping
		}
	}
	
}
