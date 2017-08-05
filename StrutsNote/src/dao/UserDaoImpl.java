package dao;


import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDaoImpl extends BaseDao implements UserDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public int addUser(User user) {
        String sql = "insert into users(userName, password, gender, head, regTime) values(?,?," + user.getGender() + ",?,?)";
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String[] parm = {user.getUserName(), user.getPassword(), user.getHead(), time};
        return this.executeSQL(sql, parm);
    }

    @Override
    public User findUser(int userId) {
        String sql = "select * from users where userId = ?";
        User user = null;
        try {
            conn = this.getConn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getInt("gender"));
                user.setHead(rs.getString("head"));
                user.setRegTime(rs.getDate("regTime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return user;
    }

    @Override
    public User findUser(String userName, String password) {
        String sql = "select * from users where userName = ? and password = ?";
        User user = null;
        try {
            conn = this.getConn();
            System.out.println("conn" + conn);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setGender(rs.getInt("gender"));
                user.setHead(rs.getString("head"));
                user.setRegTime(rs.getDate("regTime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return user;
    }
}
