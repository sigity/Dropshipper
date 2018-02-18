package id.co.dropshipper.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.dropshipper.model.Kategori;

@Service
public class kategoriDAO {
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
		transaksi = eManager.getTransaction();
		transaksi.begin();
		Kategori exKategori = (Kategori) eManager.find(Kategori.class,updatekateg.getKategoriId());
		exKategori.setKategoriName(updatekateg.getKategoriName());
		exKategori.setKategoriLevel(updatekateg.getKategoriLevel());
		exKategori.setKategoriParentId(updatekateg.getKategoriParentId());
		exKategori.setIsActive(updatekateg.getIsActive());

	} catch (Exception e) {
		transaksi.rollback();
		isSuccess = false;
		System.out.println(e.getMessage());
	}
	return isSuccess;
}
}
