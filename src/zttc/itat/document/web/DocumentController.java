package zttc.itat.document.web;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import zttc.itat.document.model.DocumentForm;
import zttc.itat.document.model.DocumentTree;
import zttc.itat.document.service.IDocumentService;

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
	// @ModelAttribute should do the same job like model.addAttribute
	public String add(@ModelAttribute("documentForm")DocumentForm documentForm) {
		//model.addAttribute(new Document());
		return "doc/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(  @Validated DocumentForm documentForm,
			            BindingResult br,
			            @RequestParam("attachs")MultipartFile[] attachs,
			            HttpServletRequest req,
			            Model model) throws IOException {
		if(br.hasErrors()) {
			return "doc/add";
		}

		String realpath = req.getSession().getServletContext().getRealPath("/resources/upload");
	    // need refactor later	
		for(MultipartFile attach:attachs) {
			if(attach.isEmpty()) continue;
			File f = new File(realpath+"/"+attach.getOriginalFilename());
			FileUtils.copyInputStreamToFile(attach.getInputStream(),f);
		}
        Document document = new Document();
        document = generateDocumentViaDocumentForm(documentForm);
        
		documentService.add(document);
		return "redirect:/doc/treeList";
	}
	
	
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
		return "doc/operationSucceed";
	}
	
	@RequestMapping(value="/{id}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		documentService.delete(id);
		return "doc/operationSucceed";
	}

//async test mappings

	@RequestMapping("/treeAll")
	public @ResponseBody List<DocumentTree> tree() {
		return documentService.generateTree();
	}

	@RequestMapping("/treeList")
	public String treeList(Model model) {
		return "doc/treeList";
	}
	
	private Document generateDocumentViaDocumentForm(DocumentForm documentForm) {
		
		Document document = new Document();
        Date date = new Date();
        String dateStr = date.toString();

        document.setPid(Integer.valueOf(documentForm.getType()));
        document.setCreater(documentForm.getCreater());
        document.setCreateTime(dateStr);
        document.setPath(documentForm.getPath());
        document.setType(documentForm.getType());
        document.setName(documentForm.getName());

        return document;
	}

}