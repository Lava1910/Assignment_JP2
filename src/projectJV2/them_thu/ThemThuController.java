package projectJV2.them_thu;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import projectJV2.Main;
import projectJV2.dao.impls.ThuThangRepository;
import projectJV2.entities.ThuThang;

public class ThemThuController {
    public TextField txtThanhVien;
    public TextField txtSoTien;
    public TextField txtNgay;


    public void backToThuThang() throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("/projectJV2/thanh_vien/list/ThanhVien.fxml"));
        Main.rootStage.setTitle("Thành Viên");
        Main.rootStage.setScene(new Scene(listChi,779,588));
    }

    public void submmit(ActionEvent actionEvent) {
        try {
            String thanhVien = txtThanhVien.getText();
            Integer soTien = Integer.parseInt(txtSoTien.getText());
            String ngay = txtNgay.getText();
            ThuThang ThuThang = new ThuThang(null,thanhVien,soTien,ngay);
            ThuThangRepository rp = new ThuThangRepository();
            if (rp.create(ThuThang)){
                backToThuThang();
            }else {
                System.out.println("errors");
            }
       }catch (Exception e){
          System.out.println(e.getMessage());
        }
    }
}
