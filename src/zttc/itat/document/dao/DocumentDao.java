package zttc.itat.document.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import zttc.itat.model.Pager;
import zttc.itat.model.SystemContext;
import zttc.itat.document.model.Document;


@Repository("documentDao")
public class DocumentDao extends HibernateDaoSupport implements IDocumentDao {
	
	@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	
	@Override
	public void add(Document document) {
		this.getHibernateTemplate().save(document);
	}

	@Override
	public void update(Document document) {
		this.getHibernateTemplate().update(document);
	}

	@Override
	public void delete(int id) {
		Document document = this.load(id);
		this.getHibernateTemplate().delete(document);
	}

	@Override
	public Document load(int id) {
		return this.getHibernateTemplate().load(Document.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Document> list() {
		return this.getSession().createQuery("from Document").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<Document> find() {
		int size = SystemContext.getSize();
		int offset = SystemContext.getOffset();
		Query query = this.getSession().createQuery("from Document");
		query.setFirstResult(offset).setMaxResults(size);
		List<Document> datas = query.list();
		Pager<Document> us = new Pager<Document>();
		us.setDatas(datas);
		us.setOffset(offset);
		us.setSize(size);
		long total = (Long)this.getSession()
					.createQuery("select count(*) from Document")
					.uniqueResult();
		us.setTotal(total);
		return us;
	}

	@Override
	public Document loadByName(String name) {
		return (Document)this.getSession().createQuery("from Document where name=?")
					.setParameter(0, name).uniqueResult();
	}

}
