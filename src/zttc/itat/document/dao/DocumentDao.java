package zttc.itat.document.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import zttc.itat.document.model.Document;
import zttc.itat.document.model.DocumentTree;
import zttc.itat.model.Pager;
import zttc.itat.model.SystemContext;

@SuppressWarnings("unchecked")
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
		long total = (Long) this.getSession()
				.createQuery("select count(*) from Document").uniqueResult();
		us.setTotal(total);
		return us;
	}

	@SuppressWarnings("unchecked")
	// 该批注的作用是给编译器一条指令，告诉它对被批注的代码元素内部的某些警告保持静默。
	@Override
	public Pager<Document> search(Map<String, Object> searchCondition) {
		int size = SystemContext.getSize();
		int offset = SystemContext.getOffset();

		SearchConditionResolver conditionResolver = new SearchConditionResolver(searchCondition);
		Query query = null; 
		Boolean onlyName = conditionResolver.onlyName();
		if (onlyName) {
			query = this.getSession() .createQuery("from Document where name=?") .setParameter(0, searchCondition.get("name"));
		}
		if (conditionResolver.onlyType()) {
			query = this.getSession() .createQuery("from Document where type=?") .setParameter(0, searchCondition.get("type"));
		}
		if (conditionResolver.onlyCreater()) {
			query = this.getSession() .createQuery("from Document where creater=?") .setParameter(0, searchCondition.get("creater"));
		}
		if (conditionResolver.onlyCreateTime()) {
			query = this.getSession() .createQuery("from Document where createTime=?") .setParameter(0, searchCondition.get("createTime"));
		}
        assert query != null;
		query.setFirstResult(offset).setMaxResults(size);
		List<Document> datas = query.list();
		Pager<Document> us = new Pager<Document>();
		us.setDatas(datas);
		us.setOffset(offset);
		us.setSize(size);
		String queryString = query.toString();
		System.out.println("this is the queryString:-------->"+queryString+"<--------------------------");
		long total = (long) datas.size();
		us.setTotal(total);
		return us;

		// String hql =
		// getDocumentSelect()+" from Document d where d.name= '%"+name+"%' ";
		// return this.find(hql);
	}

//	private String getDocumentSelect() {
//		return "select new document(d.id,d.name,d.type,d.creater,d.createTime,d.path)";
//	}

	@SuppressWarnings("unchecked")
	@Override
	public Document loadByName(String name) {
		return (Document) this.getSession()
				              .createQuery("from Document where name=?")
				              .setParameter(0, name).uniqueResult();
	}

	@Override
	public List<DocumentTree> generateTree() {
		String sql = "select id,name,pid from t_document order by name";
		List<DocumentTree> cts = this.listBySql(sql, null, null,DocumentTree.class, false);
		initTreeNode(cts);
		System.out.println(cts.toString());
		return cts;

	}

	public static void initTreeNode(List<DocumentTree> cts) {
		cts.add(0,new DocumentTree(-5,"其他文件",0));
		cts.add(0,new DocumentTree(-4,"普通文件",0));
		cts.add(0,new DocumentTree(-3,"计算结果文件",0));
		cts.add(0,new DocumentTree(-2,"几何文件",0));
		cts.add(0,new DocumentTree(-1,"构型文件",0));
		for(DocumentTree ct:cts) {
			if(ct.getPid()==null)ct.setPid(0);
		}
	}

	public <N extends Object>List<N> listBySql(
			String sql, 
			Object[] args,
			Map<String, Object> alias, 
			Class<?> clz, 
			boolean hasEntity) {
		SQLQuery sq = getSession().createSQLQuery(sql);
		if(hasEntity) {
			sq.addEntity(clz);
		} else {
			sq.setResultTransformer(Transformers.aliasToBean(clz));
		};	
		return sq.list();
	}
}
