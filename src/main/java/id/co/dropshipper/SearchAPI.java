package id.co.dropshipper;

import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchAPI {

	private static final Logger log = LoggerFactory.getLogger(SearchAPI.class);
	@Autowired
	private EntityManagerFactory entityManagerFactory;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@GetMapping("/pushcoba")
	public Long setNegara() {
		return stringRedisTemplate.opsForList().leftPush("buah", "jeruk");
	}
}
