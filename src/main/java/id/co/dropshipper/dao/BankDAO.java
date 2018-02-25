package id.co.dropshipper.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.dropshipper.model.Bank;
import id.co.dropshipper.model.Wilayah;

@Service
public class BankDAO {

	@Autowired
	private EntityManagerFactory factory;
	public List<Bank> getAllBank(){
		return factory.createEntityManager()
				.createQuery("from Bank")
				.getResultList();
	}
	public Bank getBankId(short id) {
		return (Bank) factory.createEntityManager()
				.createQuery("from Bank where bankId = " + id)
				.getSingleResult();
	}
	public boolean tambahBank(Bank objbank) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi= null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			
			transaksi.begin();
			eManager.persist(objbank);
			transaksi.commit();
		} catch (Exception e) {
			transaksi.rollback();
			isSuccess = false;
			
			System.out.println(e.getMessage());
		}
		return isSuccess;
	}
	public boolean updateBank(Bank updateBank) {
		EntityManager eManager = factory.createEntityManager();
		EntityTransaction transaksi= null;
		boolean isSuccess = true;
		try {
			transaksi = eManager.getTransaction();
			transaksi.begin();
			Bank exBank = (Bank) eManager.find(Bank.class, updateBank.getBankid());
			exBank.setBankname(updateBank.getBankname());
			//exBank.setBankTrfcd(updateBank.getBankTrfcd());
			
			transaksi.commit();
		} catch (Exception e) {
			transaksi.rollback();
			isSuccess = false;
			System.out.println(e.getMessage());
		}
		return isSuccess;
	}
	
	
}
