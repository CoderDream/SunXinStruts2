package org.sunxin.struts2.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.sunxin.struts2.persistence.entity.User;
import org.sunxin.struts2.util.DBUtil;

public class UserDao {

    /**
     * 在构造方法中初始化数据源对象。
     */
    public UserDao() {
    }

    /**
     * 实现用户注册功能，将用户信息保存到数据库表reg_user中。
     * 
     * @param user
     *            User对象，保存了用户提交的注册信息
     * @return 注册成功后的User对象
     */
    public User register(User user) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();

            String sql = "insert into reg_user(username,password,sex,email,pwd_question,pwd_answer,reg_date) values(?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            int index = 0;
            pstmt.setString(++index, user.getUsername());
            pstmt.setString(++index, user.getPassword());
            pstmt.setBoolean(++index, user.getSex());
            pstmt.setString(++index, user.getEmail());
            pstmt.setString(++index, user.getPwdQuestion());
            pstmt.setString(++index, user.getPwdAnswer());
            pstmt.setTimestamp(++index, new java.sql.Timestamp(user
                    .getRegDate().getTime()));

            pstmt.execute();
            // 读者需注意：在多用户的并发访问中，获取的自增长id值可能不正确。
            rs = pstmt.executeQuery("select last_insert_id()");
            if (rs.next())
                user.setId(rs.getInt(1));
            else {
                return null;
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pstmt);
            closeConnection(conn);
        }

        return user;
    }

    /**
     * 关闭ResultSet对象
     * 
     * @param rs
     */
    private void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
    }

    /**
     * 关闭PreparedStatement对象
     * 
     * @param pstmt
     */
    private void closePreparedStatement(PreparedStatement pstmt) {
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            pstmt = null;
        }
    }

    /**
     * 关闭数据库链接
     * 
     * @param conn
     */
    private void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
