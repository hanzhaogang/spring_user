package zttc.itat.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	/* this line gives the compiler an instructor, which means that the compiler should keep silence 
	 * for some warning in the codes that this line is for. 
	 * 
	 *  the real SQL statement should be: 
	 *  SELECT keyword FROM table WHERE id='id_number' ORDER BY keyword LIMIT 2 OFFSET 1; or: (page size 2)
	 *  SELECT keyword FROM table WHERE id='id_number' ORDER BY keyword LIMIT 2, 1; (page size 1)
	 *  
	 *  two parameters here: page size& offset.
	 *  
	 *  to achieve a pager, we can have different ways. 
	 *  1: plugin of myBatis , which is actually a filter chain, which is called Interceptor in myBatis. 
	 *  2: filter chain of java ee, which is more common. 
	 *  
	 *  question: what is the difference? 
	 */ 

	@SuppressWarnings("unchecked")
	@Override
	public Pager<User> find() { 
		int size = SystemContext.getSize();
		int offset = SystemContext.getOffset();
		/*Query query = this.getSession().createQuery("from User");
		query.setFirstResult(offset).setMaxResults(size);
		List<User> datas = query.list();
		*/

	    IUserOperation userOperation = this.getSqlSession().getMapper(IUserOperation.class);
		List<User> listUser = new ArrayList<User>();
	    listUser = userOperation.find(size,offset);

		Pager<User> userPager = new Pager<User>();
		userPager.setDatas(listUser);
		userPager.setOffset(offset);
		userPager.setSize(size);
		//long total = (Long)this.getSqlSession() .createQuery("select count(*) from User") .uniqueResult();
		long total = (Long)countAll();
		userPager.setTotal(total);
		
	    //Map<String, Integer> resultMap = userOperation.find(size,offset);
	    /*
	     * org.apache.ibatis.exceptions.TooManyResultsException: 
	     * Expected one result (or null) to be returned by selectOne(), but found: 3
	     */

	    /*
	     * for each grammer
	     */
	    for(User user:listUser) {
	    	System.out.println(user.getNickname());	
	    }
	    //System.out.println(listUser);
		return userPager;
	}
	
	
	/*
	 * find all users in the table t_user;
	 */
	public List<User> findAll() {
	    IUserOperation userOperation = this.getSqlSession().getMapper(IUserOperation.class);
		List<User> allUser = userOperation.findAll();
		return allUser;
	}
	
	/*
	 * count how many users are there in the t_user table, which is based on the findAll function.
	 */
	public long countAll() {
		List<User> allUser = findAll();
		/*
		 *  List.size() returns an int value, and the max of an int value is 2^32 = 65525^2, it is a billon levle number.
		 *  2^10=1024
		 *  
		 */
		return allUser.size();

		
	}
	
	
	

}
