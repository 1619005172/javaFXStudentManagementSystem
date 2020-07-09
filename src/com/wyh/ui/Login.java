package com.wyh.ui;

import com.wyh.back.GetStudent;
import com.wyh.back.LoginTest;
import com.wyh.back.Public;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.sql.SQLException;

public class Login extends Application {
    Tips tips = new Tips();
    LoginTest login = new LoginTest();

    public static void main(String[] args) {

        launch(args);
    }


    public void start(Stage primaryStying) {
        try {
            AnchorPane ap = new AnchorPane();//创建布局对象
            Image img = new Image("/icon/icon2.jpg");//传入图片
            Button button = new Button("登录");//创建按钮对象
            TextField text = new TextField();//文本框对象
            PasswordField password = new PasswordField();//密码框对象
            Label label_us = new Label();
            Label label_pw = new Label();
            Scene scene = new Scene(ap);

            label_us.setText("用户名：");
            label_pw.setText("密码：");
            text.setLayoutX(100);
            button.setLayoutX(100);
            label_us.setLayoutX(50);
            label_pw.setLayoutX(50);
            password.setLayoutX(100);
            text.setLayoutY(100);
            button.setLayoutY(200);
            label_us.setLayoutY(105);
            label_pw.setLayoutY(155);
            password.setLayoutY(150);
            text.setFont(Font.font(14));
            password.setFont(Font.font(14));
            text.setPromptText("请输入用户名");
            password.setPromptText("请输入密码");
            primaryStying.setWidth(400);//设置窗口宽度
            primaryStying.setHeight(500);//设置窗口高度
            ap.getChildren().add(button);//在布局中调用按钮
            ap.getChildren().add(text);//添加文本输入框
            ap.getChildren().add(password);//添加密码输入框
            ap.getChildren().add(label_us);
            ap.getChildren().add(label_pw);
            primaryStying.setTitle("管理员登录");//设置窗口标题
            primaryStying.setResizable(false);//固定窗口大小
            primaryStying.getIcons().add(img);//设置图标
            button.setCursor(Cursor.CLOSED_HAND);//设置鼠标移入窗口变手型
            primaryStying.setScene(scene);
            primaryStying.show();//启动窗口

            //按钮事件监听
            button.setOnAction(event -> {
                try {
                    login.login();
                    int info = login.login();
                    if (info != 0) {
                        Public.val.ms = "登陆成功";
                        primaryStying.close();
                        try {
                            GetStudent getstudent = new GetStudent();
                            getstudent.get_Student();
                            ApplicationMain app_home = new ApplicationMain();
                            app_home.start(new Stage());//启动主界面
                            tips.start(new Stage());//提示框
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        Public.val.ms = "登陆失败";
                        tips.start(new Stage());
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            //文本框输入监听
            text.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    Public.val.us = newValue;
                }
            });
            //密码框监听事件
            password.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    Public.val.pw = newValue;
                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
