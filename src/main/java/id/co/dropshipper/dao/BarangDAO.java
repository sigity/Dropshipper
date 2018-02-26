package id.co.dropshipper.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.dropshipper.model.Bank;
import id.co.dropshipper.model.Barang;
import id.co.dropshipper.model.Kategori;
import id.co.dropshipper.model.Vendor;

@Service
public class BarangDAO {
	@Autowired
	private EntityManagerFactory factory;
	public List<Barang> getAllBarang(){
		return factory.createEntityManager()
				.createQuery("from Barang where isactive=1")
				.getResultList();
	}
	public Barang getBarangid(int barangid) {
		return (Barang) factory.createEntityManager()
				.createQuery("from Barang where barangid = " + barangid)
				.getSingleResult();
	}
	public List<Vendor> getAllVendor(){
		return factory.createEntityManager()
				.createQuery("from Vendor")
				.getResultList();
	}
	public Vendor getVendor(short id) {
		return (Vendor) factory.createEntityManager()
				.createQuery("from Vendor where vendorid = " + id)
				.getSingleResult();
	}
	public List<Kategori> getAllKategori(){
		return factory.createEntityManager()
				.createQuery("from Kategori")
				.getResultList();
	}
	
	public Kategori getKategori(short id) {
		return (Kategori) factory.createEntityManager()
				.createQuery("from Kategori where kategoriid = " + id)
				.getSingleResult();
	}
	
	public boolean tambahBarang(Barang objbarang) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi= null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			objbarang.setIsactive(1);
			eManager.persist(objbarang);
			transaksi.commit();
		} catch (Exception e) {
			transaksi.rollback();
			isSuccess = false;
			
			System.out.println(e.getMessage());
		}
		return isSuccess;
	}
	

	
	public boolean updateBarang(Barang updatebarang) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi= null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Barang exBarang= (Barang) eManager.find(Barang.class, updatebarang.getBarangid());
			exBarang.setKategoriid(updatebarang.getKategoriid());
			exBarang.setVendorid(updatebarang.getVendorid());
			exBarang.setSku(updatebarang.getSku());
			exBarang.setBarangname(updatebarang.getBarangname());
			exBarang.setWarna(updatebarang.getWarna());
			exBarang.setBerat(updatebarang.getBerat());
			exBarang.setDimensi(updatebarang.getDimensi());
			exBarang.setHarga(updatebarang.getHarga());
			exBarang.setIsactive(updatebarang.getIsactive());
			transaksi.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			transaksi.rollback();
			isSuccess = false;
			
		}
		return isSuccess;
	}
}
