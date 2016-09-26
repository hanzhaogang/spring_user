package zttc.itat.inter;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import zttc.itat.model.Pager;
import zttc.itat.model.User;

public interface IUserOperation {   
    public User load(int id);
    public User loadByUsername(String username);
    public void add(User user);
    public void delete(int id);
    public void update(User user);
   
    /* we can have more than one parameters */
    //public Map<String, Integer> find(@Param("size")int size, @Param("offset")int offset);
    //public Pager<User> find(@Param("size")int size, @Param("offset")int offset);
    public List<User> find(@Param("size")int size, @Param("offset")int offset);
    
    public List<User> findAll();
}