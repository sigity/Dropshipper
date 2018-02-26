package id.co.dropshipper.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.dropshipper.model.Detailtransaksi;

@Service
public class DetailtransaksiDAO {
	@Autowired
	private EntityManagerFactory factory;
	public List<Detailtransaksi> index(){
		return factory.createEntityManager()
				.createQuery("from Detailtransaksi where  isactive= 1 or isactive=null")
				.getResultList();
	}
	public Detailtransaksi getId(short id) {
		return (Detailtransaksi) factory.createEntityManager()
				.createQuery("from Detailtransaksi where bankid = " + id)
				.getSingleResult();
	}
	public boolean add(Detailtransaksi object) {
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
	public boolean edit(Detailtransaksi update) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi= null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Detailtransaksi ex = (Detailtransaksi) eManager.find(Detailtransaksi.class, update.getDetailid());
			ex.setTransaksiid(update.getTransaksiid());
			ex.setDetailqty(update.getDetailqty());
			ex.setDetailtotal(update.getDetailtotal());
			ex.setTotalberat(update.getTotalberat());
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
