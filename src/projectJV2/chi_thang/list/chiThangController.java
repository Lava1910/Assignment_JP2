package projectJV2.chi_thang.list;

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

import javafx.scene.text.Text;
import projectJV2.Main;
import projectJV2.dao.impls.chiThangRepository;
import projectJV2.entities.ThanhVien;
import projectJV2.entities.chiThang;
import projectJV2.enums.RepoType;
import projectJV2.factory.RepositoryFactory;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class chiThangController implements Initializable {

    public TableView<chiThang> tbChiThang;
    public TableColumn<chiThang,Integer> tdId;
    public TableColumn<chiThang,String> tdSName;
    public TableColumn<chiThang,Integer> tdSpending;
    public TableColumn<chiThang, Date> tdDate;
    public TableColumn<chiThang,Button> tdEdit;
    public TableColumn<chiThang,String> tdMember;
    public Text txtTongChi;
    ObservableList<chiThang> ls = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //tdMember.setCellValueFactory(new PropertyValueFactory<chiThang,String>("member"));
        tdId.setCellValueFactory(new PropertyValueFactory<chiThang,Integer>("id"));
        tdSName.setCellValueFactory(new PropertyValueFactory<chiThang,String>("sname"));
        tdSpending.setCellValueFactory(new PropertyValueFactory<chiThang,Integer>("spending"));
        tdDate.setCellValueFactory(new PropertyValueFactory<chiThang,Date>("date"));
        tdEdit.setCellValueFactory(new PropertyValueFactory<chiThang,Button>("edit"));

        //ObservableList<chiThang> ls = FXCollections.observableArrayList();
        chiThangRepository rp = (chiThangRepository) RepositoryFactory.createRepository(RepoType.CHITHANG);
        ls.addAll(rp.all());
        tbChiThang.setItems(ls);
        txtTongChi.setText(String.valueOf(hienthitong()));
    }

    public void backToHome2(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("/projectJV2/Home.fxml"));
        Main.rootStage.setTitle("Quản Lý Chi Tieu");
        Main.rootStage.setScene(new Scene(listChi,625,573));
    }

    public void addChiThang(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("/projectJV2/them_chi/themchithang/themchithang.fxml"));
        Main.rootStage.setTitle("Thêm Khoản Chi");
        Main.rootStage.setScene(new Scene(listChi,800,600));
    }
    public int sum(){
        int sum = 0;
        for(chiThang c : ls){
            sum = sum +c.getSpending();
        }
        return sum;
    }
    public int hienthitong(){
        chiThangRepository rp = new chiThangRepository();
        int t=rp.tongchi();
        return t;
    }
}
