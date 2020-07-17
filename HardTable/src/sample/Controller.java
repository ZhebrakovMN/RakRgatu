package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Controller {
    private final ObservableList<TableContent> usersData = FXCollections.observableArrayList();

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
                    throw new RandomExeption("a и b одновременно не равны нулю");
                } catch (RandomExeption re) {
                    outField.setText(re.getMessage());
                    System.out.println(re.toString());
                }
        } catch (RandomExeption re) {
            outField.setText(re.getMessage());
            System.out.println(re.toString());
        }
        // проверка K, a, b на 0
    }
}

