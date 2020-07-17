package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.util.Arrays;
import java.util.Collection;

public class Controller {
    private final ObservableList<TabCont> usersData = FXCollections.observableArrayList();
    String mess="Если максимальный элемент в таблце больше минимального в 10 раз, то все нули заменить единицами, а отрицательные числа заменить на их значения по модулю.";
    int[][] arr = new int[5][5];

    public Label min;
    public Label max;
    public Button submit;
    public Button count;
    public Label mes;

    @FXML
    private TableView<TabCont> tabCont;
    @FXML
    private TableColumn<TabCont, Integer> c1Column;
    @FXML
    private TableColumn<TabCont, Integer> c2Column;
    @FXML
    private TableColumn<TabCont, Integer> c3Column;
    @FXML
    private TableColumn<TabCont, Integer> c4Column;
    @FXML
    private TableColumn<TabCont, Integer> c5Column;

    @FXML
    private void initialize() {
        initData();
        c1Column.setCellValueFactory(new PropertyValueFactory<TabCont, Integer>("c1"));
        c2Column.setCellValueFactory(new PropertyValueFactory<TabCont, Integer>("c2"));
        c3Column.setCellValueFactory(new PropertyValueFactory<TabCont, Integer>("c3"));
        c4Column.setCellValueFactory(new PropertyValueFactory<TabCont, Integer>("c4"));
        c5Column.setCellValueFactory(new PropertyValueFactory<TabCont, Integer>("c5"));
        tabCont.setItems(usersData);
        mes.setText(mess);
    }

    private void initData() {
        for (int i=0;i<5;i++)
            usersData.add(new TabCont(0,0,0,0,0));
    }

    private void startData(int[][] arr) {
        for (int[] row : arr)
            usersData.add(new TabCont(row[0], row[1], row[2], row[3], row[4]));
    }

    @FXML
    public void onRandomMethod(ActionEvent actionEvent){
        mes.setText(mess);
        for (int[] row : arr) {
            for (int i = 0; i < row.length; i++) {
                row[i] = (Math.random()<0.1?-1:1)*(int)(Math.random()*(Math.random()<0.9?10:1000));
            }
        }
        int max=arr[0][0], min=arr[0][0];
        for (int[] row : arr) {
            for (int value : row) {
                if (max <= value) max = value;
                if (min >= value) min = value;
            }
        }
        this.max.setText(max+"");
        this.min.setText(min+"");
        usersData.clear();
        startData(arr);
    }

    @FXML
    public void onCountMethod(ActionEvent actionEvent){
        if (min.getText().equals("")) {
            mes.setText("                                                                      Числа не сгенерированы");
            return;
        }
        if (Integer.parseInt(min.getText())==0) {
            mes.setText("                                                                        Делить на 0 нельзя!");
            return;
        }
        if (Math.abs(Integer.parseInt(max.getText())) / Math.abs(Integer.parseInt(min.getText())) > 10) {
            for (int i1 = 0; i1 < arr.length; i1++) {
                for (int i2 = 0; i2 < arr[0].length; i2++) {
                    if (arr[i1][i2] == 0) arr[i1][i2]++;
                    if (arr[i1][i2] < 0) arr[i1][i2] = Math.abs(arr[i1][i2]);
                }
            }
            usersData.clear();
            startData(arr);
        }
    }
}
