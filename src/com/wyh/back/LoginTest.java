package com.wyh.back;

import com.wyh.db.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginTest {

    public int login() throws SQLException {
        String us = Public.val.us;
        String pw = Public.val.pw;
        BaseDao dao = new BaseDao();//创建操作数据库对象
        String sql = "select * from db_user where user=? and password=?";//查询符合要求字段
        ResultSet rs = dao.query(sql,
                us, pw);//传入数据，对应sql语句中的?
//        while (rs.next()){
//            System.out.println(rs.getString("user"));
//        }
        rs.last();//获取最后一条数据的信息
        int row = rs.getRow();//获取当前信息的行数,并赋值
        rs.close();//关闭数据库连接
        if (row == 0) {//如果是0代表没有匹配用户
            System.out.println("登陆失败");
            return 0;
        } else {
            System.out.println("登陆成功");
            return row;
        }
    }
}
