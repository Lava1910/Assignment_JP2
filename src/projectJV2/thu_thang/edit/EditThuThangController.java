package projectJV2.thu_thang.edit;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import projectJV2.Main;
import projectJV2.dao.impls.ThuThangRepository;
import projectJV2.entities.ThuThang;

import java.net.URL;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

public class EditThuThangController implements Initializable {

    public TextField txtSName;
    public TextField txtInCome;
    public TextField txtDate;
    public static ThuThang editedThuThang;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (editedThuThang != null)
            txtSName.setText(editedThuThang.getRole());
        txtInCome.setText(editedThuThang.getIncome().toString());
        txtDate.setText(editedThuThang.getDate());
    }



    public void Submit(ActionEvent actionEvent) {
        try {
            String role = txtSName.getText();
            Integer income = Integer.parseInt(txtInCome.getText());
            String date = txtDate.getText();
            editedThuThang.setRole(role);
            editedThuThang.setIncome(income);
            editedThuThang.setDate(date);
            ThuThangRepository rp = new ThuThangRepository();
            if(rp.update(editedThuThang)){
                backToThuThang(null);
            }else {
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void backToThuThang(ActionEvent actionEvent) throws Exception {
        Parent listThu = FXMLLoader.load(getClass().getResource("/projectJV2/chi_thang/list/thuthang.fxml"));
        Main.rootStage.setTitle("Thu Tháng");
        Main.rootStage.setScene(new Scene(listThu,800,600));
    }
}
