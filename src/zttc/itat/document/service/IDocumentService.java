package zttc.itat.document.service;

import java.util.List;
import java.util.Map;

import zttc.itat.model.Pager;
import zttc.itat.document.model.Document;
import zttc.itat.document.model.DocumentTree;

public interface IDocumentService {

	public void add(Document document);
	public void update(Document document);
	public void delete(int id);
	public Document load(int id);
	public List<Document> list();
	public Pager<Document> find();
	public Pager<Document> search(Map<String,Object> searchCondition);
	/**
	 * 把所有的栏目获取并生成一颗完整的树
	 * @return
	 */
	public List<DocumentTree> generateTree();
}
