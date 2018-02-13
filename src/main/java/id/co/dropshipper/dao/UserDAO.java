package id.co.dropshipper.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.dropshipper.model.Barang;
import id.co.dropshipper.model.Kategori;
import id.co.dropshipper.model.User;
import id.co.dropshipper.model.Vendor;

@Service
public class UserDAO {
	
	@Autowired
	private EntityManagerFactory factory;
	
	public List<User> getAllUsers(){
		return factory.createEntityManager()
				.createQuery("from User")
				.getResultList();
	}
	
	public List<Barang> getAllBarang(){
		return factory.createEntityManager()
				.createQuery("from Barang")
				.getResultList();
	}
	public List<Vendor> getAllVendor(){
		return factory.createEntityManager()
				.createQuery("from Vendor")
				.getResultList();
	}
	public Vendor getVendor(short id) {
		return (Vendor) factory.createEntityManager()
				.createQuery("from Vendor where vendorId = " + id)
				.getSingleResult();
	}
	public List<Kategori> getAllKategori(){
		return factory.createEntityManager()
				.createQuery("from Kategori")
				.getResultList();
	}
	
	public Kategori getKategori(short id) {
		return (Kategori) factory.createEntityManager()
				.createQuery("from Kategori where kategoriId = " + id)
				.getSingleResult();
	}
}
