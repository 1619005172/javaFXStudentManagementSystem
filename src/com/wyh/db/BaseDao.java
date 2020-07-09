package com.wyh.db;

import java.sql.*;

public class BaseDao {

    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:数据库地址";
    private static final String password = "数据库密码";
    private static final String user = "数据库用户名";
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;


    public void getConnection() {
        try {
            Class.forName(DRIVER_CLASS);
//			FileWorker cfg=new FileWorker();
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ResultSet query(String sql, Object... param) {
        getConnection();
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < param.length; i++) {
                ps.setObject(i + 1, param[i]);
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    //SQL预编译
    public int update(String sql, Object... param) {
        int num = 0;
        getConnection();
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < param.length; i++) {
                ps.setObject(i + 1, param[i]);
            }
            num = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return num;
    }

    //关闭数据库连接，并处理异常状态
    public void closeConnection() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
