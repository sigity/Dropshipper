package id.co.dropshipper.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.dropshipper.model.Pengambilan;

@Service
public class PengambilanDAO {
	@Autowired
	private EntityManagerFactory factory;
	public List<Pengambilan> index(){
		return factory.createEntityManager()
				.createQuery("from Pengambilan where  isactive= 1 or isactive=null")
				.getResultList();
	}
	
	public Pengambilan getId(short id) {
		return (Pengambilan) factory.createEntityManager()
				.createQuery("from Pengambilan where bankid = " + id)
				.getSingleResult();
	}
	
	public boolean add(Pengambilan object) {
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
	public boolean edit(Pengambilan update) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi= null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Pengambilan ex = (Pengambilan) eManager.find(Pengambilan.class, update.getPengambilanid());
			ex.setWaktuid(update.getWaktuid());
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
