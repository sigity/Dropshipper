package id.co.dropshipper.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.dropshipper.model.Wilayah;

@Service
public class WilayahDAO {
	@Autowired
	private EntityManagerFactory factory;
	public List<Wilayah> getAllWilayah(){
		return factory.createEntityManager()
				.createQuery("from Wilayah")
				.getResultList();
	}
	public Wilayah getWilayah(short id) {
		return (Wilayah) factory.createEntityManager()
				.createQuery("from Wilayah where wilayahId = " + id)
				.getSingleResult();
	}
	public boolean tambahWilayah(Wilayah objwilayah) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi= null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			
			transaksi.begin();
			eManager.persist(objwilayah);
			transaksi.commit();
		} catch (Exception e) {
			transaksi.rollback();
			isSuccess = false;
			
			System.out.println(e.getMessage());
		}
		return isSuccess;
	}
	public boolean updateWi(Wilayah updatewilayah) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi= null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Wilayah exWilayah = (Wilayah) eManager.find(Wilayah.class,updatewilayah.getWilayahId());
			exWilayah.setWilayahName(updatewilayah.getWilayahName());
			exWilayah.setLevel(updatewilayah.getLevel());
			exWilayah.setParentId(updatewilayah.getParentId());
			transaksi.commit();
		} catch (Exception e) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(e.getMessage());
		}
		return isSuccess;
	}
}
