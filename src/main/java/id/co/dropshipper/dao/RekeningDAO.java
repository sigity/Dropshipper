package id.co.dropshipper.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.dropshipper.model.Rekening;

@Service
public class RekeningDAO {
	@Autowired
	private EntityManagerFactory factory;
	public List<Rekening> index(){
		return factory.createEntityManager()
				.createQuery("from Rekening where  isactive= 1 or isactive=null")
				.getResultList();
	}
	public Rekening getId(short id) {
		return (Rekening) factory.createEntityManager()
				.createQuery("from Rekening where bankid = " + id)
				.getSingleResult();
	}
	public boolean add(Rekening object) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi= null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			
			transaksi.begin();

			eManager.persist(object);
			transaksi.commit();
		} catch (Exception e) {
			transaksi.rollback();
			isSuccess = false;
			
			System.out.println(e.getMessage());
		}
		return isSuccess;
	}
	public boolean edit(Rekening update) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi= null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Rekening ex = (Rekening) eManager.find(Rekening.class, update.getRekeningid());
			ex.setRekeningname(update.getRekeningname());
			ex.setBankid(update.getBankid());
			ex.setRekeningnumber(update.getRekeningnumber());
			ex.setUserid(update.getUserid());
			transaksi.commit();
		} catch (Exception e) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(e.getMessage());
		}
		return isSuccess;
	}
}
