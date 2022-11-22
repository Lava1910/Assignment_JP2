package projectJV2.residual;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import projectJV2.Main;
import projectJV2.dao.impls.TVRepository;
import projectJV2.dao.impls.chiThangRepository;

import java.net.URL;
import java.util.ResourceBundle;

public class ResidualController implements Initializable {
    public Text txtTongThu1;
    public Text txtTongChi1;
    public Text txtsodu1;

    public void backToHome(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("../Home.fxml"));
        Main.rootStage.setTitle("Quản Lý Chi Tieu");
        Main.rootStage.setScene(new Scene(listChi,625,573));

    }
    public int hienthitong(){
        chiThangRepository rp = new chiThangRepository();
        int t=rp.tongchi();
        return t;
    }

    public int hienthitong1(){
        TVRepository rp = new TVRepository();
        int t=rp.tongthu();
        return t;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtTongChi1.setText(String.valueOf(hienthitong()));
        txtTongThu1.setText(String.valueOf(hienthitong1()));
        txtsodu1.setText(String.valueOf(hienthitong1()-hienthitong()));
    }


}
