package com.wyh.back;
//删除学生

import com.wyh.db.BaseDao;


public class DelStudent {
    public static boolean del_Student(int id) {
        String sql = "delete from db_student where id=?";//sql语句，匹配参数？
        BaseDao dao = new BaseDao();//数据库操作对象
        int row = dao.update(sql, id);
        if (row > 0) {
            return true;
        }
        return false;
    }
}
