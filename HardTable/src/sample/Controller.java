package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.Arrays;

public class Controller {
    private final ObservableList<TableContent> usersData = FXCollections.observableArrayList();
    double[][] arr = new double[10][2];

    public Button quit;
    public TextField a;
    public TextField b;
    public Label outField;

    @FXML
    private TableView<TableContent> tableContent;
    @FXML
    private TableColumn<TableContent, Double> kiColumn;
    @FXML
    private TableColumn<TableContent, Double> yiColumn;
    @FXML
    private void initialize() {
        initData();
        kiColumn.setCellValueFactory(new PropertyValueFactory<TableContent, Double>("ki"));
        yiColumn.setCellValueFactory(new PropertyValueFactory<TableContent, Double>("yi"));
        tableContent.setItems(usersData);
        outField.setText("МОЖНО ВВОДИТЬ ТОЛЬКО ЧИСЛА!");
    }

    private void initData() {
        for (int i=0;i<10;i++)
            usersData.add(new TableContent(0, 0));
    }


    public void onClearMethod(){
        a.setText("");
        b.setText("");
    }
    public void onExitMethod(ActionEvent actionEvent) {
        ((Stage) quit.getScene().getWindow()).close();
    }

    public void onRandomMethod(){
        int ai,bi;
        outField.setText("МОЖНО ВВОДИТЬ ТОЛЬКО ЧИСЛА!");
        ai=(int)(Math.random() * 100);
        bi=(int)(Math.random() * 100);
        a.setText(ai+"");
        b.setText(bi+"");
        usersData.clear();
        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = Math.random()*100;
            arr[i][1] = 0;
            usersData.add(new TableContent(arr[i][0], arr[i][1]));
        }
        if (ai+bi==0) try {
            throw new RandomExeption("a и b одновременно не равны нулю");
        } catch (RandomExeption re) {
            outField.setText(re.getMessage());
            System.out.println(re.toString());
        }
    }

    public void onCountMethod(ActionEvent actionEvent) {
        int ai = 0,bi=0;
        String as=a.getText();
        String bs=b.getText();
        try {
            if (as.equals("") || bs.equals(""))
            throw new RandomExeption("Введены не все данные");
            ai=Integer.parseInt(as);
            bi=Integer.parseInt(bs);
            if (ai+bi==0)
                try {
                    if (Arrays.binarySearch(arr[0],0)!=-1) {
                        throw new RandomExeption("K, a, b одновременно не равны нулю");
                    }
                    throw new RandomExeption("a и b одновременно не равны нулю");
                } catch (RandomExeption re) {
                    outField.setText(re.getMessage());
                    System.out.println(re.toString());
                }
            int[] sum = new int[10]; double[] y=new double[10];
            for (int i=1;i<10;i++){
                sum[i] += (int) arr[i][0];
            }
            for (int i=1;i<10;i++){
                y[i] = Math.pow(Math.cos(arr[i][0]), 2);
                y[i]/= Math.pow(Integer.parseInt(a.getText()),2)+
                        Math.pow(Integer.parseInt(b.getText()),2)-
                        Math.sin(arr[i][0]);
                y[i] = Math.sqrt(y[i]);
                y[i]*= sum[i];
                arr[i][1] = y[i];
            }
            usersData.clear();
            for (int i = 0; i < arr.length; i++) {
                usersData.add(new TableContent(arr[i][0], arr[i][1]));
            }
        } catch (RandomExeption re) {
            outField.setText(re.getMessage());
            System.out.println(re.toString());
        }
    }
}

