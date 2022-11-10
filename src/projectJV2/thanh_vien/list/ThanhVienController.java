package projectJV2.thanh_vien.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import projectJV2.Main;
import projectJV2.dao.impls.TVRepository;
import projectJV2.entities.ThanhVien;

import java.net.URL;
import java.util.ResourceBundle;

public class ThanhVienController implements Initializable {

    public TableView<ThanhVien> tbThanhVien;
    public TableColumn<ThanhVien, Integer> tdId;
    public TableColumn<ThanhVien, String> tdRole;
    public TableColumn<ThanhVien, Integer> tdSalary;
    public TableColumn<ThanhVien, Button> txtEdit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<ThanhVien, Integer>("id"));
        tdRole.setCellValueFactory(new PropertyValueFactory<ThanhVien, String>("role"));
        tdSalary.setCellValueFactory(new PropertyValueFactory<ThanhVien, Integer>("salary"));
        txtEdit.setCellValueFactory(new PropertyValueFactory<ThanhVien, Button>("edit"));

        ObservableList<ThanhVien> ls = FXCollections.observableArrayList();
        TVRepository rp = new TVRepository();
        ls.addAll(rp.all());
        tbThanhVien.setItems(ls);
    }

    public void backToHome4(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("/projectJV2/Home.fxml"));
        Main.rootStage.setTitle("Quản Lý Chi Tieu");
        Main.rootStage.setScene(new Scene(listChi,600,400));
    }


    public void addTV(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("/projectJV2/thanh_vien/create/createTV.fxml"));
        Main.rootStage.setTitle("member");
        Main.rootStage.setScene(new Scene(listChi,800,600));
    }




}