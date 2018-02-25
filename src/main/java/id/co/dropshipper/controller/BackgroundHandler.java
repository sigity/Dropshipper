package id.co.dropshipper.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.dropshipper.dao.BarangDAO;
import id.co.dropshipper.model.Barang;
import id.co.dropshipper.model.Lokasi;
import id.co.dropshipper.model.Wilayah;

@RestController
public class BackgroundHandler {
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	@Autowired
	private BarangDAO barangDAO;
	
	@GetMapping("/deletebarang")
	public boolean deleteBarang(@RequestParam("barangId") short barangId) {
		System.out.println(barangId);
		Barang objbarangedit = barangDAO.getBarangid(barangId);
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
	
	@GetMapping ("/lokasi_lokasiid")
	public List<String> getLokasiId(){
		StringBuilder builder ;
		List<String> hasil = new ArrayList<>();
		List<Lokasi> listId = 
				entityManagerFactory
				.createEntityManager()
				.createQuery("from Lokasi")
				.getResultList();
		
		for(Lokasi lokasi : listId ) {
			builder = new StringBuilder();
			builder.append(lokasi.getLokasiid());
			hasil.add(builder.toString());
		}
			
		return hasil;
	}
	
	@GetMapping ("/lokasi_alamatlengkap")
	public List<String> getAlamatLengkap(){
		StringBuilder builder ;
		List<String> hasil = new ArrayList<>();
		List<Lokasi> listAlamat = 
				entityManagerFactory
				.createEntityManager()
				.createQuery("from Lokasi")
				.getResultList();
		
		for(Lokasi lokasi : listAlamat ) {
			builder = new StringBuilder();
			builder.append(lokasi.getAlamatlengkap());
			hasil.add(builder.toString());
		}
			
		return hasil;
	}
}
