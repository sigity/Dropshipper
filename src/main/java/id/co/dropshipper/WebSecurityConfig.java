//package id.co.dropshipper;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private EntityManagerFactory entityManagerFactory;
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/", "/login", "/user/daftar").permitAll().anyRequest().authenticated()
//				.and().formLogin().defaultSuccessUrl("/user/barang.html", true).loginPage("/login").permitAll().and()
//				.logout().permitAll();
//	}
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		List<User> listUser = entityManagerFactory
//				.createEntityManager()
//				.createQuery("from User")
//				.getResultList();
//		for (User user : listUser) {
//			auth.inMemoryAuthentication().withUser(user.getUserName()).password(user.getUserPassword()).roles("USER");
//		}
//	}
//}
