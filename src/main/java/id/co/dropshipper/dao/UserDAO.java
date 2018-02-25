package id.co.dropshipper.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

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
	public User getUser(String username) {
		return (User) factory.createEntityManager()
				.createQuery("from User where username = '" + username +"'")
				.getSingleResult();
	}
	
	public boolean addUser(User user) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			
			transaksi = eManager.getTransaction();
			transaksi.begin();
			user.setIsactive(1);
			eManager.persist(user);
			transaksi.commit();
			
			
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			transaksi.rollback();
			isSuccess = false;
			
		}
		return isSuccess;
	}
	
	public boolean editUser(User updatedUser) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi = null;
		boolean isSuccess = true;
		try {
			
			transaksi = eManager.getTransaction();
			transaksi.begin();
			User existingUser =
					(User) eManager.find(User.class, updatedUser.getUserid());
			existingUser.setUsername(updatedUser.getUsername());
			existingUser.setUserpassword(updatedUser.getUserpassword());
			existingUser.setUserktp(updatedUser.getUserktp());
			existingUser.setUsermail(updatedUser.getUsermail());
			existingUser.setUserphone(updatedUser.getUserphone());
			transaksi.commit();
			
			
			
		}catch(Exception ex) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(ex.getMessage());
		}
		return isSuccess;
	}
	
	public List<Barang> getAllBarang(){
		return factory.createEntityManager()
				.createQuery("from Barang")
				.getResultList();
	}
	public List<Barang> getAllBarangCari(String nama){
		return factory.createEntityManager()
				.createQuery("from Barang where barangName like '%" + nama + "%'")
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
	
	public Barang getDetailBarang(short id) {
		return (Barang) factory.createEntityManager()
				.createQuery("from Barang where barangId = " + id)
				.getSingleResult();
	}
}
