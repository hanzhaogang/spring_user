package zttc.itat.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import zttc.itat.model.User;
import zttc.itat.service.IUserService;

/*
 * In Spring MVC, Basically all requests are mapped to the DispatcherServlet which acts as a front controller. 
 * The DispatcherServlet will then call the controller whose annotations match the incoming request. 
 * This is neater than having to write these mappings yourself in the web.xml
 */
@Controller
@SessionAttributes("loginUser")
public class IndexController {

	private IUserService userService;
	public IUserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value={"/","/index"},method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value="/index",method=RequestMethod.POST)
	public String login(String username,String password,Model model) {
		User u = userService.login(username, password);
		model.addAttribute("loginUser", u);
		return "redirect:login";
	}
	
	@RequestMapping("/logout")
	public String logout(Model model,HttpSession session) {
		model.asMap().remove("loginUser");
		session.invalidate();
		return "redirect:/index";
	}
}