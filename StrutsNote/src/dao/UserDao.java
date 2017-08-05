package dao;


import model.User;

/**
 * Created by pokedo on 2017/4/15.
 */
public interface UserDao {
    public User findUser(int userId);

    public User findUser(String userName, String password);

    public int addUser(User user);
}
