package com.wyh.back;


//公共变量
public class Public {

    public static class val {
        //添加
        public static String add_name;
        public static String add_age;
        public static String add_address;
        public static String add_us_id;

        //登录
        public static String us;//用户名
        public static String pw;//密码
        //更新
        public static String up_id;
        public static String up_name;//姓名
        public static String up_age;//年龄
        public static String up_address;//家庭住址
        public static String up_su_id;//学号
        //删除
        public static String del_id;//删除所需id
        //提示
        public static String ms;
        //
        public static int ID;

        public val(String add_name, String add_age, String add_address, String add_us_id) {
            this.add_name = add_name;
            this.add_age = add_age;
            this.add_address = add_address;
            this.add_us_id = add_us_id;
        }
    }
}
