package id.co.dropshipper.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.dropshipper.model.Vendor;

@Service
public class VendorDAO {
	@Autowired
	private EntityManagerFactory factory;
	public List<Vendor> index(){
		return factory.createEntityManager()
				.createQuery("from Vendor where  isactive= 1 or isactive=null")
				.getResultList();
	}
	public Vendor getId(short id) {
		return (Vendor) factory.createEntityManager()
				.createQuery("from Vendor where vendorid = " + id)
				.getSingleResult();
	}
	public boolean add(Vendor object) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi= null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			
			transaksi.begin();
			object.setIsactive(1);
			eManager.persist(object);
			transaksi.commit();
		} catch (Exception e) {
			transaksi.rollback();
			isSuccess = false;
			
			System.out.println(e.getMessage());
		}
		return isSuccess;
	}
	public boolean edit(Vendor update) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi= null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Vendor ex = (Vendor) eManager.find(Vendor.class, update.getVendorid());
			ex.setVendorname(update.getVendorname());
			ex.setVendormail(update.getVendormail());
			ex.setVendorphone(update.getVendorphone());
			ex.setLokasiid(update.getLokasiid());
			ex.setIsactive(update.getIsactive());
			transaksi.commit();
		} catch (Exception e) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(e.getMessage());
		}
		return isSuccess;
	}
}
