package zttc.itat.document.service;

import java.util.List;

import zttc.itat.model.Pager;
import zttc.itat.document.model.Document;

public interface IDocumentService {
	public void add(Document document);
	public void update(Document document);
	public void delete(int id);
	public Document load(int id);
	public List<Document> list();
	public Pager<Document> find();
}
