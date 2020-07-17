package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button submit;

    @FXML
    private Button reset;

    @FXML
    private TextField result;

    @FXML
    private Button quit;

    @FXML
    private TextField x;

    @FXML
    private TextField a;

    @FXML
    private TextField b;

    @FXML
    private Label answer;

    @FXML
    public void onExitMethod(){
        ((Stage) quit.getScene().getWindow()).close();
    }

    @FXML
    public void onClearMethod(){
        x.setText("");
        a.setText("");
        b.setText("");
    }

    @FXML
    public void onClickMethod() {
        int x=0, a=0, b=0;
        String xs = this.x.getText();
        String xa = this.a.getText();
        String xb = this.b.getText();
        try{
            String mes1="   Введены не все параметры!";
            if (xs.equals("") || xa.equals("") || xb.equals("")) {
                answer.setText(mes1);
                throw new IllegalParametrException(mes1);
            }
            x = Integer.parseInt(this.x.getText());
            a = Integer.parseInt(this.a.getText());
            b = Integer.parseInt(this.b.getText());
            String mes2="       При х<=7, А и В не могут   одновременно равняться нулю!";
            if (x<=7 && a==0 && b==0){
                answer.setText(mes2);
                throw new IllegalParametrException(mes2);
            }
            if (x<=7) result.setText((x+4d)/(a*a+b*b)+"");
            else      result.setText(x*Math.pow(a+b,2) +"");
            answer.setText("                    Готово");
        }catch (IllegalParametrException ipl){
            System.out.println(ipl.toString());
        }
     }

    @FXML
    void initialize() {
        this.answer.setText("       При х<=7, А и В не могут   одновременно равняться нулю!");
        this.x.setText(""); this.a.setText(""); this.b.setText("");
    }
}

