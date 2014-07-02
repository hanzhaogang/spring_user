package zttc.itat.document.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.inject.Inject;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import zttc.itat.document.model.Document;
import zttc.itat.document.model.DocumentTree;
import zttc.itat.document.model.UserForm;
import zttc.itat.document.service.IDocumentService;
import zttc.itat.model.Pager;

@Controller
@RequestMapping("/doc")
public class DocumentController {
	private IDocumentService documentService;

	public IDocumentService getDocumentService() {
		return documentService;
	}
	
	@Inject
	public void setDocumentService(IDocumentService documentService) {
		this.documentService = documentService;
	}

	@RequestMapping(value={"/docs","/"},method=RequestMethod.GET)
	public String list(Model model) {
		model.addAttribute("pagers", documentService.find());
		return "doc/list";
	}
	
	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String search() {
		return "doc/search";
	}
	
	@RequestMapping(value="/search",method=RequestMethod.POST)
	public String search(String name, String type, String creater, String createTime, Model model) {
        Map<String,Object> searchCondition = new HashMap<String,Object>();		
        searchCondition.put("name", name);
        searchCondition.put("type", type);
        searchCondition.put("creater", creater);
        searchCondition.put("createTime", createTime);
        
	    model.addAttribute("pagers", documentService.search(searchCondition));
		return "doc/search";
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
	//	return "doc/add";
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
	//		return "doc/add"; 
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

//async test mappings
	@RequestMapping(value="/jsonTest",method=RequestMethod.GET)
	public String jsonTest() {
		
		return "doc/zTree/jsonTest";
	}
	@RequestMapping(value="/viewTest",method=RequestMethod.GET)
	public String viewTest() {
		
		return "doc/zTree/viewTest";
	}

	@RequestMapping(value="/viewTest2",method=RequestMethod.GET)
	public String viewTest2() {
		
		return "doc/zTree/viewTest2";
	}

	@RequestMapping(value="/jsonTest2",method=RequestMethod.GET)
	public String jsonTest2() {
		
		return "doc/zTree/jsonTest2";
	}

	@RequestMapping("/treeAll")
	public @ResponseBody List<DocumentTree> tree() {
		return documentService.generateTree();
	}

	@RequestMapping("/treeList")
	public String treeList(Model model) {
//		model.addAttribute("treeDatas", JsonUtil.getInstance().obj2json(channelService.generateTree()));
		return "doc/zTree/async/treeList";
	}

//sync test mappings
	@RequestMapping(value="/zTree/ztree2",method=RequestMethod.GET)
	public String ztree2() {
		
		return "doc/zTree/ztree2";
	}

	@RequestMapping(value="/zTree/ztree",method=RequestMethod.GET)
	public String zTreeList(Model model, HttpServletRequest request) {
		
		Pager<Document> us = new Pager<Document>();
		us = documentService.find();
		for (int i = 0; i<us.getDatas().size();i++){
			
		//System.out.println("us:-------->"+us.getDatas().get(i).getName()+"<--------------------------");
		String key = "name"+i;
		String value =  us.getDatas().get(i).getName();
		System.out.println(key+","+value);
		model.addAttribute(key, value);
		model.addAttribute("pagers", documentService.find());
		}

        model.addAttribute("count", us.getDatas().size());

		ArrayList<String> nameList = new ArrayList<String>();
		for (int i = 0; i<us.getDatas().size();i++){
		    String value =  us.getDatas().get(i).getName();
            nameList.add(value);
		}
        //model.addAttribute("nameList", nameList);
        request.setAttribute("nameList", nameList);

		return "doc/zTree/ztree";
		
	}
}