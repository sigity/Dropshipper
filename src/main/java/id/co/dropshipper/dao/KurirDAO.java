package id.co.dropshipper.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.dropshipper.model.Kurir;

@Service
public class KurirDAO {
	@Autowired
	private EntityManagerFactory factory;
	public List<Kurir> index(){
		return factory.createEntityManager()
				.createQuery("from Kurir where  isactive= 1 or isactive=null")
				.getResultList();
	}
	public Kurir getId(short id) {
		return (Kurir) factory.createEntityManager()
				.createQuery("from Kurir where kuririd = " + id)
				.getSingleResult();
	}
	public boolean add(Kurir object) {
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
	public boolean edit(Kurir update) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi= null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Kurir ex = (Kurir) eManager.find(Kurir.class, update.getKuririd());
			ex.setKurirname(update.getKurirname());
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
