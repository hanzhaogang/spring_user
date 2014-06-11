package zttc.itat.document.dao;

import java.util.List;

import zttc.itat.model.Pager;
import zttc.itat.document.model.*;


public interface IDocumentDao {
	public void add(Document document);
	public void update(Document document);
	public void delete(int id);
	public Document load(int id);
	public List<Document> list();
	public Pager<Document> find();
	public Document loadByName(String name);
}
