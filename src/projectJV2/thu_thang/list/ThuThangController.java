package projectJV2.thu_thang.list;

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
import projectJV2.dao.impls.ThuThangRepository;
import projectJV2.entities.ThuThang;
import projectJV2.enums.RepoType;
import projectJV2.factory.RepositoryFactory;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ThuThangController implements Initializable {

    public TableView<ThuThang> tbThuThang;
    public TableColumn<ThuThang,Integer> tdId;
    public TableColumn<ThuThang,String> tdRole;
    public TableColumn<ThuThang,Integer> tdIncome;
    public TableColumn<ThuThang, Date> tdDate;
    public TableColumn<ThuThang,Button> tdEdit;
    public TableColumn<ThuThang,Integer> tdRoleId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<ThuThang,Integer>("id"));
        tdRoleId.setCellValueFactory(new PropertyValueFactory<ThuThang,Integer>("roleid"));
        tdRole.setCellValueFactory(new PropertyValueFactory<ThuThang,String>("role"));
        tdIncome.setCellValueFactory(new PropertyValueFactory<ThuThang,Integer>("income"));
        tdDate.setCellValueFactory(new PropertyValueFactory<ThuThang,Date>("date"));
        tdEdit.setCellValueFactory(new PropertyValueFactory<ThuThang,Button>("edit"));

        ObservableList<ThuThang> ls = FXCollections.observableArrayList();
        ThuThangRepository rp = (ThuThangRepository) RepositoryFactory.createRepository(RepoType.THUTHANG);
        ls.addAll(rp.all());
        tbThuThang.setItems(ls);
    }

    public void backToHome(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("../../Home.fxml"));
        Main.rootStage.setTitle("Quản Lý Chi Tieu");
        Main.rootStage.setScene(new Scene(listChi,625,573));
    }

    public void addThemThu2(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("/projectJV2/them_thu/themthu.fxml"));
        Main.rootStage.setTitle("Thêm Khoản Thu");
        Main.rootStage.setScene(new Scene(listChi,800,600));
    }
}
