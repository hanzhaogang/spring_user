package zttc.itat.document.service;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zttc.itat.document.dao.IDocumentDao;
import zttc.itat.model.Pager;
import zttc.itat.document.model.Document;
import zttc.itat.document.model.DocumentException;
import zttc.itat.document.model.DocumentTree;

@Service("documentService")
public class DocumentService implements IDocumentService {

	private IDocumentDao documentDao;
	
	public IDocumentDao getDocumentDao() {
		return documentDao;
	}

	@Resource
	public void setDocumentDao(IDocumentDao documentDao) {
		this.documentDao = documentDao;
	}

	@Override
	public void add(Document document) {
		Document u = documentDao.loadByName(document.getName());
		if(u!=null) throw new DocumentException("要添加的文件已经存在");
		documentDao.add(document);
	}

	@Override
	public void update(Document document) {
		documentDao.update(document);
	}

	@Override
	public void delete(int id) {
		documentDao.delete(id);
	}

	@Override
	public Document load(int id) {
		return documentDao.load(id);
	}

	@Override
	public List<Document> list() {
		return documentDao.list();
	}

	@Override
	public Pager<Document> find() {
		return documentDao.find();
	}

	@Override
	public Pager<Document> search(Map<String,Object> searchCondition) {
		return documentDao.search(searchCondition);
	}

	@Override
	public List<DocumentTree> generateTree() {
		return documentDao.generateTree();
	}
}
