package zttc.itat.document.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.mybatis.spring.support.SqlSessionDaoSupport;
//import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import zttc.itat.document.model.Document;
import zttc.itat.document.model.DocumentTree;
import zttc.itat.model.Pager;
import zttc.itat.model.SystemContext;

@SuppressWarnings("unchecked")
/*
 * 用于将数据访问层 (DAO 层 ) 的类标识为 Spring Bean。具体只需将该注解标注在 DAO 类上即可。同时，为了让 Spring 能够扫描类路径中的类并识别出 @Repository 注解，
 * 需要在 XML 配置文件中启用 Bean 的自动扫描功能，这可以通过 <context:component-scan/> 实现。如下所示：

 // 首先使用 @Repository 将 DAO 类声明为 Bean 
 package bookstore.dao; 
 @Repository 
 public class UserDaoImpl implements UserDao{ …… } 

 // 其次，在 XML 配置文件中启动 Spring 的自动扫描功能
 <beans … > 
    ……
 <context:component-scan base-package=”bookstore.dao” /> 
……
 </beans> 
如此，我们就不再需要在 XML 中显式使用 <bean/> 进行 Bean 的配置。Spring 在容器初始化时将自动扫描 base-package 指定的包及其子包下的所有 class 文件，所有标注了 
@Repository 的类都将被注册为 Spring Bean。
 */
@Repository("documentDao")
//public class DocumentDao extends HibernateDaoSupport implements IDocumentDao {
public class DocumentDao extends SqlSessionDaoSupport implements IDocumentDao {

	/*@Resource
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		//this.setSessionFactory(sessionFactory);
	}
	*/

	@Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

	@Override
	public void add(Document document) {
		//this.getHibernateTemplate().save(document);
	}

	@Override
	public void update(Document document) {
		//this.getHibernateTemplate().update(document);
	}

	@Override
	public void delete(int id) {
		//Document document = this.load(id);
		//this.getHibernateTemplate().delete(document);

	}

	@Override
	public Document load(int id) {
		//return this.getHibernateTemplate().load(Document.class, id);
		//Document document = new Document();
		return null;
	}

	@Override
	public List<Document> list() {
		//return this.getSession().createQuery("from Document").list();
		List<Document> documentList = new ArrayList<Document>();
		return documentList;
	}

	@Override
	public Pager<Document> find() {
		//Query query = this.getSession().createQuery("from Document");
		Pager<Document> pager = new Pager<Document>();
        //pager = setPagerByQuery(query);
		return pager;
	}

	@Override
	public Pager<Document> search(Map<String, Object> searchCondition) {
		Query query = createQueryByConditionResolver(searchCondition);
		Pager<Document> pager = new Pager<Document>();
        pager = setPagerByQuery(query);
		return pager;
	}

	@Override
	public Document loadByName(String name) {
		//return (Document) this.getSession() .createQuery("from Document where name=?") .setParameter(0, name).uniqueResult();
		return null;
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

	// 
	public <N extends Object>List<N> listBySql(
    			String sql, 
    			Object[] args,
    			Map<String, Object> alias, 
    			Class<?> clz, 
    			boolean hasEntity) {
		/*SQLQuery sq = getSession().createSQLQuery(sql);
		if(hasEntity) {
			sq.addEntity(clz);
		} else {
			sq.setResultTransformer(Transformers.aliasToBean(clz));
		};	
		return sq.list();
		*/
		
		//return new ArrayList<N>();
		return null;
	}
    
	private Pager<Document> setPagerByQuery (Query query) {
		Pager<Document> pager = new Pager<Document>();

		/* int size = SystemContext.getSize();
		pager.setSize(size);

		int offset = SystemContext.getOffset();
		pager.setOffset(offset);

		query.setFirstResult(offset).setMaxResults(size);
		List<Document> datas = query.list();
		pager.setDatas(datas);
		
		long total = 0L;
        if (query.toString().contains("where")) {
            String    queryString =        query.toString().substring(10, 36);
            System.out.print("caution!---------"+query.toString());
            total = (Long) this.getSession().createQuery("select count(*) "+queryString).uniqueResult();
        } else {
            total = (Long) this.getSession().createQuery("select count(*) from Document ").uniqueResult();
        }
		pager.setTotal(total);

*/
	    return pager;	
	}

	private Query createQueryByConditionResolver(Map<String, Object> searchCondition) {
		Query query = null;
		/*SearchConditionResolver conditionResolver = new SearchConditionResolver(searchCondition);
		if (conditionResolver.onlyName()) {
			query = this.getSession() .createQuery("from Document where name=?") 
					    .setParameter(0, searchCondition.get("name"));
		}
		if (conditionResolver.onlyType()) {
			query = this.getSession() .createQuery("from Document where type=?") 
					    .setParameter(0, searchCondition.get("type"));
		}
		if (conditionResolver.onlyCreater()) {
			query = this.getSession() .createQuery("from Document where creater=?") 
					    .setParameter(0, searchCondition.get("creater"));
		}
		if (conditionResolver.onlyCreateTime()) {
			query = this.getSession() .createQuery("from Document where createTime=?") 
					    .setParameter(0, searchCondition.get("createTime"));
		}
		*/
		return query;
	}
}
