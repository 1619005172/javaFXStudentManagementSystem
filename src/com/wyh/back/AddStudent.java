package com.wyh.back;
//添加学生

import com.wyh.db.BaseDao;

public class AddStudent {
    public int add_Student() {
        BaseDao dao = new BaseDao();//数据库操作对象
        String sql = "INSERT INTO db_student (name,age,address,su_id)" +
                "" + "values(?,?,?,?)";//插入数据库语句
        return dao.update(sql,
                Public.val.add_name, Public.val.add_age, Public.val.add_address, Public.val.add_us_id);
    }
}
