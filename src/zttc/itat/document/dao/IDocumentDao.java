package zttc.itat.document.dao;

import java.util.List;
import java.util.Map;

import zttc.itat.model.Pager;
import zttc.itat.document.model.*;


public interface IDocumentDao {
	public void add(Document document);
	public void update(Document document);
	public void delete(int id);
	public Document load(int id);
	public List<Document> list();
	public Pager<Document> find();
	
    public Pager<Document> search(Map<String,Object> searchCondition);

    public Document loadByName(String name);
	
	/**
	 * 把所有的栏目获取并生成一颗完整的树
	 * @return
	 */
	public List<DocumentTree> generateTree();
}
