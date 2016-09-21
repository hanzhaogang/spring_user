package zttc.itat.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import zttc.itat.inter.IUserOperation;
import zttc.itat.model.Pager;
import zttc.itat.model.SystemContext;
import zttc.itat.model.User;

// http://www.cnblogs.com/zhangzhifeng/p/4228498.html
/*
 * Repository stands for beans in dao layer.
 */
@Repository("userDao")
public class UserDao extends SqlSessionDaoSupport implements IUserDao {
	
	/*
	 * @Resource & @Autowired both can denote an DI. 
	 * In below setter method, a bean managed by Spring named "sessionFactory" will be injected into this method.
	 * @Resource is an notation of Java, while @Autowired is an notation by Spring.
	 * @Resource is injected by name, while @Autowired is injected by type. 
	 */
	@Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }
	
	@Override
	public void add(User user) {
		//this.getHibernateTemplate().save(user);
		
		// use the orignal mapper, instead of the interface
		/*this.getSqlSession().selectList("com.yihaomen.inter.IUserOperation.getUserArticles",user);
		User user = (User) session.selectOne("com.yihaomen.mybatis.models.UserMapper.selectUserByID", 1);
		*/

		
	    /* User user = mapper.selectUserByID(1);
	    IUserOperation userOperation=session.getMapper(IUserOperation.class);
        userOperation.addUser(user);
	    User user = mapper.selectUserByID(1);
	    */
            
		// in the dao layer, we just call the interface
	    IUserOperation userOperation = this.getSqlSession().getMapper(IUserOperation.class);
	    userOperation.add(user);
	}

	@Override
	public void update(User user) {
		//this.getHibernateTemplate().update(user);

	    IUserOperation userOperation = this.getSqlSession().getMapper(IUserOperation.class);
	    userOperation.update(user);
	}

	@Override
	public void delete(int id) {
		//User user = this.load(id);
		//this.getHibernateTemplate().delete(user);
	    IUserOperation userOperation = this.getSqlSession().getMapper(IUserOperation.class);
	    userOperation.delete(id);

	}

	@Override
	public User load(int id) {
		//return this.getHibernateTemplate().load(User.class, id);
	    IUserOperation userOperation = this.getSqlSession().getMapper(IUserOperation.class);
	    return userOperation.load(id);
	}

	@Override
	public User loadByUsername(String username) {
		//return (User)this.getSession().createQuery("from User where username=?").setParameter(0, username).uniqueResult();
	    IUserOperation userOperation = this.getSqlSession().getMapper(IUserOperation.class);
	    return userOperation.loadByUsername(username);
	}

	// 该批注的作用是给编译器一条指令，告诉它对被批注的代码元素内部的某些警告保持静默。
	@SuppressWarnings("unchecked")
	@Override
	public Pager<User> find() {
		int size = SystemContext.getSize();
		int offset = SystemContext.getOffset();
		/*Query query = this.getSession().createQuery("from User");
		query.setFirstResult(offset).setMaxResults(size);
		List<User> datas = query.list();
		*/

		Pager<User> userPager = new Pager<User>();
		/*userPager.setDatas(datas);
		userPager.setOffset(offset);
		userPager.setSize(size);
		long total = (Long)this.getSession()
					           .createQuery("select count(*) from User")
					           .uniqueResult();
		userPager.setTotal(total);
		*/
		return userPager;
	}

}
