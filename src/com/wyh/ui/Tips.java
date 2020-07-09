package com.wyh.ui;

import com.wyh.back.Public;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Tips extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Text t = new Text();
        t.setText(Public.val.ms);
        Button button = new Button("确定");
        Image img = new Image("/icon/icon2.jpg");//传入图片
        GridPane gr = new GridPane();//使用gr布局
        Scene scene = new Scene(gr);
        primaryStage.setHeight(100);
        primaryStage.setWidth(200);
        primaryStage.setResizable(false);//固定窗口大小
        primaryStage.setTitle("提示");//设置窗口标题
        primaryStage.getIcons().add(img);//设置图标
        gr.add(t, 0, 0);
        gr.add(button, 0, 1);
        gr.setAlignment(Pos.CENTER);
        gr.setVgap(20);
        primaryStage.setScene(scene);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
        primaryStage.show();
    }
}
