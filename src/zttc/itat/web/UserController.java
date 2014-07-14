package zttc.itat.web;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import zttc.itat.model.User;
import zttc.itat.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private IUserService userService;
	public IUserService getUserService() {
		return userService;
	}
	@Resource
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value={"/users","/"},method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("pagers", userService.find());
		return "user/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(@ModelAttribute("user")User user) {
		//model.addAttribute(new User());
		return "user/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(  @Validated User user,
			            BindingResult br,
			            HttpServletRequest req
			         ) throws IOException {
		
		if(br.hasErrors()) {
			return "user/add";
		}
		userService.add(user);
		return "redirect:/user/users";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String show(@PathVariable int id,Model model) {
		model.addAttribute(userService.load(id));
		return "user/show";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String update(@PathVariable int id,Model model) {
		model.addAttribute(userService.load(id));
		return "user/update";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String update(@PathVariable int id,@Validated User updatedUser,BindingResult br,Model model) {
		if(br.hasErrors()) {
			return "user/update";
		}
		User user = userService.load(id);
		user.setPassword(updatedUser.getPassword());
		user.setNickname(updatedUser.getNickname());
		user.setEmail(updatedUser.getEmail());
		userService.update(user);
		return "redirect:/user/users";
	}
	
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/user/users";
	}
}
