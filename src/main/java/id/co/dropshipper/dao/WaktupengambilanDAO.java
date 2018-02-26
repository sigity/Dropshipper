package id.co.dropshipper.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.dropshipper.model.Waktupengambilan;

@Service

public class WaktupengambilanDAO {
	@Autowired
	private EntityManagerFactory factory;
	public List<Waktupengambilan> index(){
		return factory.createEntityManager()
				.createQuery("from Waktupengambilan where  isactive= 1 or isactive=null")
				.getResultList();
	}
	public Waktupengambilan getId(short id) {
		return (Waktupengambilan) factory.createEntityManager()
				.createQuery("from Waktupengambilan where bankid = " + id)
				.getSingleResult();
	}
	public boolean add(Waktupengambilan object) {
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
	public boolean edit(Waktupengambilan update) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi= null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Waktupengambilan ex = (Waktupengambilan) eManager.find(Waktupengambilan.class, update.getWaktuid());
			ex.setWaktupengambilan(update.getWaktupengambilan());
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
