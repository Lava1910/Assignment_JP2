package projectJV2.chi_thang.edit;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import projectJV2.Main;
import projectJV2.dao.impls.chiThangRepository;
import projectJV2.entities.chiThang;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class EditChiThangController implements Initializable {

    public TextField txtSName;
    public TextField txtSpending;
    public TextField txtDate;
    public static chiThang editedChiThang;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (editedChiThang != null)
            txtSName.setText(editedChiThang.getSname());
            txtSpending.setText(editedChiThang.getSpending().toString());
            txtDate.setText(editedChiThang.getDate());
    }



    public void Submit(ActionEvent actionEvent) {
        try {
            String sname = txtSName.getText();
            Integer spending = Integer.parseInt(txtSpending.getText());
            String date = txtDate.getText();
            editedChiThang.setSname(sname);
            editedChiThang.setSpending(spending);
            editedChiThang.setDate(date);
            chiThangRepository rp = new chiThangRepository();
            if(rp.update(editedChiThang)){
                backToChiThang(null);
            }else {
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void backToChiThang(ActionEvent actionEvent) throws Exception {
        Parent listChi = FXMLLoader.load(getClass().getResource("/projectJV2/chi_thang/list/chithang.fxml"));
        Main.rootStage.setTitle("Chi Tháng");
        Main.rootStage.setScene(new Scene(listChi,900,600));
    }

    public void delete(ActionEvent actionEvent) {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete spend");
            alert.setHeaderText("Are you sure delete spend: "+ editedChiThang.getSname());
            Optional<ButtonType> optional = alert.showAndWait();
            if (optional.get() == ButtonType.OK){
                chiThangRepository rp = new chiThangRepository();
                if (rp.delete(editedChiThang)){
                    backToChiThang(null);
                }else {
                    System.out.println("errors");
                }
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
