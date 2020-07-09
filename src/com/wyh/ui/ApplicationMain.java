package com.wyh.ui;

import com.wyh.back.DelStudent;
import com.wyh.back.GetStudent;
import com.wyh.back.Public;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ApplicationMain extends Application implements Initializable{


    public static Map<String, Integer> selectStudentMap = new HashMap<>();
    @FXML
    public TableView table;
    @FXML
    public TableColumn ID;
    @FXML
    public TableColumn Name;
    @FXML
    public TableColumn Age;
    @FXML
    public TableColumn Address;
    @FXML
    public TableColumn Num;
    @FXML
    public TableColumn Bj;
    @FXML
    public TableColumn Sc;
    ObservableList<Data> list = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    public void showList(boolean setFactory) {//只映射一次
        List<Data> data = null;
        try {
            list = GetStudent.get_Student();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//        list.clear();
//        for (Data dat : data) {
//            list.add(dat);
//        }

        //表格映射
        if (setFactory) {
            ID.setCellValueFactory(new PropertyValueFactory("id"));
            Name.setCellValueFactory(new PropertyValueFactory("name"));
            Age.setCellValueFactory(new PropertyValueFactory("age"));
            Address.setCellValueFactory(new PropertyValueFactory("address"));
            Num.setCellValueFactory(new PropertyValueFactory("su_id"));
            table.setItems(list);
            table.getSelectionModel().selectedItemProperty().addListener(
                    new ChangeListener<Data>() {
                        @Override
                        public void changed(ObservableValue<? extends Data> observableValue, Data oldValue, Data newValue) {
//                        更新选中行
                            int row = 0;
                            List<Data> l = table.getItems();
                            for (int i = 0; i < table.getItems().size(); i++) {
                                if (newValue.getId().equals(l.get(i).getId())) {
                                    row = i;
                                    Public.val.ID = i;
                                }
                            }
                            selectStudentMap.put("row", row);
                            selectStudentMap.put("id", Integer.parseInt(newValue.getId()));
                            System.out.println("选中:" + row);

                        }
                    }
            );
            Runnable runnable=new Runnable() {
                @Override
                public void run() {
                    System.out.println("刷新学生");
                    table.setItems(list);
                }
            };
            ScheduledExecutorService service= Executors.newSingleThreadScheduledExecutor();
            service.scheduleAtFixedRate(runnable,0,5000, TimeUnit.MILLISECONDS);
        } else {
            table.refresh();
        }
    }

    public void initialize(URL url, ResourceBundle rb) {
        showList(true);
    }

    @Override
    public void start(Stage home) throws Exception {
        Image img = new Image("/icon/icon2.jpg");//传入图片
        home.getIcons().add(img);//设置图标
        home.setTitle("学生管理系统  By:Memory");//设置窗口标题
        //导入fxml布局
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        home.setScene(new Scene(root, 1003, 590));//设置窗口大小
        home.setResizable(false);//固定窗口大小
        Button addBtn = (Button) root.lookup("#Bt");
        Button delBtn = (Button) root.lookup("#Del");
        //启动窗口
        home.show();

        //添加数据按钮事件监控
        addBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Add ad = new Add();
                try {
                    ad.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        delBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                System.out.println(table.getItems());
                if (selectStudentMap.get("id") == 0) {
                    System.out.println("未选中");
                    return;
                }
//                list.remove(0);
                if (DelStudent.del_Student(selectStudentMap.get("id"))) {
                    System.out.println("删除成功");
                    System.out.println("等待刷新表格");
                    try {
                        list = GetStudent.get_Student();
                        System.out.println("数据已刷新");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    System.out.println("删除行：" + selectStudentMap.get("row"));
                    selectStudentMap.put("id", 0);
                } else {
                    System.out.println("删除失败");
                }
            }
        });

    }
}
