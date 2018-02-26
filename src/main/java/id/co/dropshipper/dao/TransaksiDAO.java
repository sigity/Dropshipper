package id.co.dropshipper.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.dropshipper.model.Transaksi;

@Service
public class TransaksiDAO {
	@Autowired
	private EntityManagerFactory factory;
	public List<Transaksi> index(){
		return factory.createEntityManager()
				.createQuery("from Transaksi where  isactive= 1 or isactive=null")
				.getResultList();
	}
	public Transaksi getId(short id) {
		return (Transaksi) factory.createEntityManager()
				.createQuery("from Transaksi where bankid = " + id)
				.getSingleResult();
	}
	public boolean add(Transaksi object) {
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
	public boolean edit(Transaksi update) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi= null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Transaksi ex = (Transaksi) eManager.find(Transaksi.class, update.getTransaksiid());
			ex.setTransaksitgl(update.getTransaksitgl());
			ex.setUserid(update.getUserid());
			ex.setTglpengiriman(update.getTglpengiriman());
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
