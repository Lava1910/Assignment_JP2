package projectJV2.thanh_vien.create;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import projectJV2.Main;
import projectJV2.dao.impls.TVRepository;
import projectJV2.entities.ThanhVien;

public class CreateTVController {


    public TextField txtRole;
    public TextField txtSalary;


    public void submit(ActionEvent actionEvent) {
        try {
            String role = txtRole.getText();
            Integer salary = Integer.parseInt(txtSalary.getText());
            ThanhVien thanhVien = new ThanhVien(null,role,salary);
            TVRepository rp = new TVRepository();
            if (rp.create(thanhVien)){
                backListTV();
            }else {
                System.out.println("Errorrrr");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void backListTV() throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("../list/thanhvien.fxml"));
        Main.rootStage.setTitle("member");
        Main.rootStage.setScene(new Scene(listChi,779,588));
    }
}