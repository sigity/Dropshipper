package id.co.dropshipper.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.dropshipper.model.Bank;
import id.co.dropshipper.model.Kategori;

@Service
public class KategoriDAO {
@Autowired
private EntityManagerFactory factory;
public List<Kategori> getAllKategori(){
	return factory.createEntityManager()
			.createQuery("from Kategori")
			.getResultList();
}
public Kategori getKategoriid(short id) {
	return (Kategori) factory.createEntityManager()
			.createQuery("from Kategori where kategoriId = " + id)
			.getSingleResult();
}
public boolean tambahkategori(Kategori objkategori) {
	EntityManager eManager = factory.createEntityManager();
	EntityTransaction transaksi= null;
	boolean isSuccess = true;
	try {
		transaksi = eManager.getTransaction();
		
		transaksi.begin();
		objkategori.setIsactive(1);
		eManager.persist(objkategori);
		transaksi.commit();
	} catch (Exception e) {
		transaksi.rollback();
		isSuccess = false;
		
		System.out.println(e.getMessage());
	}
	return isSuccess;
}
public boolean updateKat(Kategori updatekateg) {
	EntityManager eManager = factory.createEntityManager();
	EntityTransaction transaksi= null;
	boolean isSuccess = true;
	try {
		transaksi.begin();
		Kategori ex = (Kategori) eManager.find(Kategori.class,updatekateg.getKategoriid());
		ex.setKategoriname(updatekateg.getKategoriname());
		ex.setKategorilevel(updatekateg.getKategorilevel());
		ex.setKategoriparentid(updatekateg.getKategoriparentid());
		ex.setIsactive(updatekateg.getIsactive());
		transaksi.commit();
	} catch (Exception e) {
		transaksi.rollback();
		isSuccess = false;
		System.out.println(e.getMessage());
	}
	return isSuccess;
	}
}
