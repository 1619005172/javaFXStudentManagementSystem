package com.wyh.back;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.wyh.db.BaseDao;
import com.wyh.ui.Data;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GetStudent {
    public static ObservableList<Data> get_Student() throws SQLException {
        ObservableList<Data> student = FXCollections.observableArrayList();
        BaseDao dao = new BaseDao();//创建数据库操作
        String sql = "select * from db_student";//MySQL语句，查询db_student表
        ResultSet rs = dao.query(sql);//传入数据
        List<Data> list = new ArrayList<>();
        while (rs.next()) {
            Data data = new Data(rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("age"),
                    rs.getString("address"),
                    rs.getString("su_id"));
            list.add(data);
        }
        for (Data dat : list) {
            student.add(dat);
        }
        rs.close();
        return student;
    }
}
