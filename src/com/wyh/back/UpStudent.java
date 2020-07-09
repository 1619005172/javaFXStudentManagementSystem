package com.wyh.back;

import com.wyh.db.BaseDao;

//修改学生信息
public class UpStudent {
    BaseDao dao = new BaseDao();//创建数据库操作对象

    //修改姓名方法
    //注释只详细打了一个，下面都类似
    public int up_name() {
        int up_i;//数据库操作判断验证
        String sql = "UPDATE db_student " + "SET name=? " + "where id=?";//sql语句（修改数据）
        up_i = dao.update(sql, Public.val.up_name, Public.val.up_id);//传入数据
        if (up_i != 0)//通过返回值进行判断是否修改成功
        {
            return 1;
        } else {
            return 0;
        }
    }

    //修改年龄方法
    public int up_age() {
        int up_i;
        String sql = "UPDATE db_student " + "set age=? " + "where id=?";
        up_i = dao.update(sql, Public.val.up_age, Public.val.up_id);
        if (up_i != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //修改学号方法
    public int up_su_id() {
        int up_i;
        String sql = "UPDATE db_student " + "set su_id=? " + "where id=?";
        up_i = dao.update(sql, Public.val.up_su_id, Public.val.up_id);
        if (up_i != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //修改住址方法
    public int up_address() {
        int up_i;
        String sql = "UPDATE db_student " + "set address=? " + "where id=?";
        up_i = dao.update(sql, Public.val.up_address, Public.val.up_id);
        if (up_i != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //修改一个人所有信息方法
    public int up_all() {
        int up_i;
        String sql = "UPDATE db_student " + "set name=?,age=?,address=?,su_id=? " + "where id=?";
        up_i = dao.update(sql, Public.val.up_name, Public.val.up_age, Public.val.up_address, Public.val.up_su_id, Public.val.up_id);
        if (up_i != 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
