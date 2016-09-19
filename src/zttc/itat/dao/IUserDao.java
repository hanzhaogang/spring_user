package zttc.itat.dao;

import zttc.itat.model.Pager;
import zttc.itat.model.User;

public interface IUserDao {
	public void add(User user);
	public void update(User user);
	public void delete(int id);
	public User load(int id);
	public User loadByUsername(String username);
	/* 
	 * Usually, we use pager in the server end, not the front end. 
	 * but, we should use AJAX, when the front end need the next page.
	 */
	public Pager<User> find();
}
