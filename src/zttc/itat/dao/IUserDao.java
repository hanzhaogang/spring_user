package zttc.itat.dao;

import zttc.itat.model.Pager;
import zttc.itat.model.User;

public interface IUserDao {
	public void add(User user);
	public void update(User user);
	public void delete(int id);
	public User load(int id);
	public Pager<User> find();
	public User loadByUsername(String username);
}
