package id.co.dropshipper.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.dropshipper.model.Barang;
import id.co.dropshipper.model.Vendor;

@Service
public class VendorDAO {
	@Autowired
	private EntityManagerFactory factory;
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
	public boolean tambahVendor(Vendor objvendor) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi= null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			
			transaksi.begin();
			eManager.persist(objvendor);
			transaksi.commit();
		} catch (Exception e) {
			transaksi.rollback();
			isSuccess = false;
			
			System.out.println(e.getMessage());
		}
		return isSuccess;
	}
	public boolean updateVe(Vendor updatevendor) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi= null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Vendor exVendor = (Vendor) eManager.find(Vendor.class,updatevendor.getVendorid());
			exVendor.setVendorname(updatevendor.getVendorname());
			exVendor.setVendorphone(updatevendor.getVendorphone());
			exVendor.setVendormail(updatevendor.getVendormail());
			exVendor.setLokasiid(updatevendor.getLokasiid());
			transaksi.commit();
		} catch (Exception e) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(e.getMessage());
		}
		return isSuccess;
	}
}
