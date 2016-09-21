package zttc.itat.inter;
import zttc.itat.model.User;

public interface IUserOperation {   
    public User load(int id);
    public User loadByUsername(String username);
    public void add(User user);
    public void delete(int id);
    public void update(User user);
   
}