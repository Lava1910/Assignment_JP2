package projectJV2.them_thu.themthuthang;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import projectJV2.Main;
import projectJV2.dao.impls.ThuThangRepository;
import projectJV2.entities.ThuThang;

import java.time.LocalDate;

public class ThemThuThangController {
    public TextField txtRole;
    public TextField txtIncome;
    public TextField txtDate;


    public void backToThuThang() throws Exception{
        Parent listThu = FXMLLoader.load(getClass().getResource("/projectJV2/chi_thang/list/thuthang.fxml"));
        Main.rootStage.setTitle("Thu Tháng");
        Main.rootStage.setScene(new Scene(listThu,800,600));
    }

    public void Submit(ActionEvent actionEvent) {
        try {

            String role = txtRole.getText();
            Integer income = Integer.parseInt(txtIncome.getText());
            String date = txtDate.getText();
            ThuThang ThuThang = new ThuThang(null,role,income,date);
            ThuThangRepository rp = new ThuThangRepository();
            if (rp.create(ThuThang)){
                backToThuThang();
            }else {
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
