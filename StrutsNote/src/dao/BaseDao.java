package dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
    public Connection getConn() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try {
            Context ic = new InitialContext();
            DataSource source = (DataSource) ic.lookup("java:comp/env/jdbc/notes");
            conn = source.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int executeSQL(String preparedSql, String[] param) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int num = 0;
        try {
            conn = getConn();
            pstmt = conn.prepareStatement(preparedSql);
            if (param != null) {
                for (int i = 0; i < param.length; i++)
                    pstmt.setString(i + 1, param[i]);
            }
            num = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, pstmt, null);
        }
        return num;
    }
}
