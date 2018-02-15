package id.co.dropshipper;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.dropshipper.model.Kategori;

@RestController
public class SearchAPI {

	private static final Logger log = LoggerFactory.getLogger(SearchAPI.class);
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@GetMapping("/keranjang/{sku}")
	public String setKeranjang(@PathVariable("sku") String sku) {
		stringRedisTemplate.opsForList().leftPush("keranjang", sku);
		return "redirect:/user/barang";
	}
	
	@GetMapping ("/kategori")
	public List<String> getKategori() {
		StringBuilder builder ;
		
		List<String> hasil = new ArrayList<>();
		
		List<Kategori> listkategori = 
				entityManagerFactory
				.createEntityManager()
				.createQuery("from Kategori")
				.getResultList();
		
		for(Kategori kategori: listkategori) {
			builder = new StringBuilder();
			builder.append(kategori.getKategoriId()); 
			builder.append(",");
			builder.append(kategori.getKategoriName());
			hasil.add(builder.toString());
		}
			
		return hasil;
	}
}
