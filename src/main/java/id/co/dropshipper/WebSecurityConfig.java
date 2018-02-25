package id.co.dropshipper;

import javax.persistence.EntityManagerFactory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import id.co.dropshipper.dao.UserDAO;
import id.co.dropshipper.model.User;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/contoh", "/munculkan", "/", "/login", "/daftar", "/awal", "/css/**", "/js/**", "/fonts/**", "/images/**", "/sass/**")
			.permitAll()
			.antMatchers("/awal").hasAnyRole("ADMIN")
            .antMatchers("/user/**").hasAnyRole("USER")
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.defaultSuccessUrl("/default", true)
			.loginPage("/login")
			.permitAll()
			.and()
			.logout()
			.permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		List<User> listUser = entityManagerFactory
				.createEntityManager()
				.createQuery("from User")
				.getResultList();
		for (User user : listUser) {
			auth.inMemoryAuthentication().withUser(user.getUsername()).password(user.getUserpassword()).roles("USER")
			.and().withUser("pradnya").password("111").roles("ADMIN");
		}
	}
}

