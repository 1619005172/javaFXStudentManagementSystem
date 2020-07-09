package com.wyh.ui;

import com.wyh.back.AddStudent;
import com.wyh.back.Public;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Add extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage add) throws Exception {
        Image img = new Image("/icon/icon2.jpg");//传入图片
        add.getIcons().add(img);//设置图标
        add.setTitle("添加学生");//设置窗口标题
        GridPane gr = new GridPane();//使用gr布局
        Button button = new Button("添加");//创建按钮对象
        TextField text_name = new TextField();
        TextField text_age = new TextField();
        TextField text_address = new TextField();
        TextField text_us_id = new TextField();
        Label label_name = new Label();
        Label label_age = new Label();
        Label label_address = new Label();
        Label label_su_id = new Label();
        label_name.setText("姓名：");
        label_age.setText("年龄：");
        label_address.setText("住址：");
        label_su_id.setText("学号：");
        gr.add(label_name, 0, 0);
        gr.add(label_age, 0, 1);
        gr.add(label_address, 0, 2);
        gr.add(label_su_id, 0, 3);
        gr.add(text_name, 1, 0);
        gr.add(text_age, 1, 1);
        gr.add(text_address, 1, 2);
        gr.add(text_us_id, 1, 3);
        gr.add(button, 1, 4);
        add.setWidth(400);//设置窗口宽度
        add.setHeight(500);//设置窗口高度
        gr.setAlignment(Pos.CENTER);
        gr.setVgap(20);
        gr.setHgap(15);
        add.setResizable(false);//固定窗口大小
        Scene scene = new Scene(gr);
        add.setScene(scene);
        add.show();
        //监听按钮
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AddStudent add_c = new AddStudent();
                int i = add_c.add_Student();
                if (i != 0) {
                    Public.val.ms = "添加成功";
                    Tips tip = new Tips();
                    tip.start(new Stage());
                } else {
                    Public.val.ms = "添加失败";
                    Tips tip = new Tips();
                    tip.start(new Stage());
                }
            }
        });
        //文本框监听
        text_name.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Public.val.add_name = newValue;
            }
        });
        //年龄
        text_age.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Public.val.add_age = newValue;
            }
        });
        //住址
        text_address.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Public.val.add_address = newValue;
            }
        });
        //学号
        text_us_id.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Public.val.add_us_id = newValue;
            }
        });
    }
}
