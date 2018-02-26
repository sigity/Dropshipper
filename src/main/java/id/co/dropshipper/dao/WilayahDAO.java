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
	public List<Wilayah> index(){
		return factory.createEntityManager()
				.createQuery("from Wilayah where  isactive= 1 or isactive=null")
				.getResultList();
	}
	public Wilayah getId(short id) {
		return (Wilayah) factory.createEntityManager()
				.createQuery("from Wilayah where wilayahid = " + id)
				.getSingleResult();
	}
	public boolean add(Wilayah object) {
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
	public boolean edit(Wilayah update) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi= null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Wilayah ex = (Wilayah) eManager.find(Wilayah.class, update.getWilayahid());
			ex.setWilayahname(update.getWilayahname());
			ex.setWilayahlevel(update.getWilayahlevel());
			ex.setWilayahparentid(update.getWilayahparentid());
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
