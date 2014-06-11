package zttc.itat.document.web;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import zttc.itat.document.model.Document;
import zttc.itat.document.model.UserForm;
import zttc.itat.document.service.IDocumentService;

@Controller
@RequestMapping("/doc")
public class DocumentController {
	private IDocumentService documentService;

	public IDocumentService getDocumentService() {
		return documentService;
	}
	
	@Resource
	public void setDocumentService(IDocumentService documentService) {
		this.documentService = documentService;
	}

	@RequestMapping(value={"/docs","/"},method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("pagers", documentService.find());
		return "doc/list";
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(@ModelAttribute("document")Document document) {
		//model.addAttribute(new Document());
		return "doc/add";
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(  @Validated Document document,
			            BindingResult br,
			            @RequestParam("attachs")MultipartFile[] attachs,
			            HttpServletRequest req
			         ) throws IOException {
		
		if(br.hasErrors()) {
			return "doc/add";
		}

		String realpath = req.getSession().getServletContext().getRealPath("/resources/upload");
		System.out.println(realpath);
		
		for(MultipartFile attach:attachs) {
			if(attach.isEmpty()) continue;
			File f = new File(realpath+"/"+attach.getOriginalFilename());
			FileUtils.copyInputStreamToFile(attach.getInputStream(),f);
		}
	
		documentService.add(document);
		return "redirect:/doc/docs";
	}
	
	@RequestMapping(value="/addTest",method=RequestMethod.GET)
	public String addTest() {
		//model.addAttribute(new Document());
		return "doc/addTest";
	}

	@RequestMapping(value="/addTest",method=RequestMethod.POST)  
	    public String addTest( 
	    		@ModelAttribute("form") UserForm form,  
                @RequestParam("hiddenNumber") String hiddenNumber){  
        
		
		System.out.println(form.toString() + "-->" + hiddenNumber);  
	        return "/user/list"; 
	    }  
	
	
	//@RequestMapping(value="/add",method=RequestMethod.GET)
	//public String add() {
	//	//model.addAttribute(new Document());
	//	return "doc/addWithHTMLForm";
	//}
	// 
	//  
	//  
	//@RequestMapping(value="/add",method=RequestMethod.POST)
	//public String add(  @Validated Document document,
	//		            BindingResult br,
	//		            @RequestParam("attachs")MultipartFile[] attachs,
	//		            HttpServletRequest req
	//		         ) throws IOException {
	
	//	if(br.hasErrors()) {
	//		return "doc/addWithHTMLForm"; 
	//	}

	//	String realpath = req.getSession().getServletContext().getRealPath("/resources/upload");
	//	System.out.println(realpath);
	//	
	//	for(MultipartFile attach:attachs) {
	//		if(attach.isEmpty()) continue;
	//		File f = new File(realpath+"/"+attach.getOriginalFilename());
	//		FileUtils.copyInputStreamToFile(attach.getInputStream(),f);
	//	}
	
	//	documentService.add(document);
	//	return "redirect:/document/documents";
	//}
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String show(@PathVariable int id,Model model) {
		model.addAttribute(documentService.load(id));
		return "doc/show";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.GET)
	public String update(@PathVariable int id,Model model) {
		model.addAttribute(documentService.load(id));
		return "doc/update";
	}
	
	@RequestMapping(value="/{id}/update",method=RequestMethod.POST)
	public String update(@PathVariable int id,@Validated Document document,BindingResult br,Model model) {
		if(br.hasErrors()) {
			return "doc/update";
		}
		Document tu = documentService.load(id);
		tu.setCreateTime(document.getCreateTime());
		documentService.update(tu);
		return "redirect:/doc/docs";
	}
	
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		documentService.delete(id);
		return "redirect:/doc/docs";
	}

	@RequestMapping(value="/download",method=RequestMethod.GET)
	public String download() {
		
		return "doc/download";
	}
}