package id.co.dropshipper.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import id.co.dropshipper.dao.UserDAO;
import id.co.dropshipper.model.User;

@Controller
public class DefaultController {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@GetMapping("/daftar")
	public String addForm(Model model) {
		model.addAttribute("user", new User());
		return "U_daftar";
	}
	
	@PostMapping("/daftar")
	public String add(@Valid User user,
			BindingResult result) {
		if(!result.hasErrors() && userDAO.addUser(user)) {
			return "redirect:/login";
		} else {
			
			return "U_daftar";
		}
	}
	
	@RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin/barang";
        }
        return "redirect:/user/barang";
    }
	
	@PostMapping(value="/logout/{nama}")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response, @PathVariable("nama") String nama) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    stringRedisTemplate.delete("keranjang-" + nama);
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);       
	    }
	    
	    return "redirect:/login?logout";
	}
	
	@GetMapping("/403")
    public String error403() {
        return "403";
    }
}
