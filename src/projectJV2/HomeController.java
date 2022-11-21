package projectJV2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.InputMethodEvent;

public class HomeController {

    public void goToThuThang(ActionEvent actionEvent) throws Exception{
        Parent listThu = FXMLLoader.load(getClass().getResource("thu_thang/list/thuthang.fxml"));
        Main.rootStage.setTitle("Thu Tháng");
        Main.rootStage.setScene(new Scene(listThu,800,600));
    }

    public void goToChiThang(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("chi_thang/list/chithang.fxml"));
        Main.rootStage.setTitle("Chi Tháng");
        Main.rootStage.setScene(new Scene(listChi,900,600));
    }


    public void goToThanhVien(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("thanh_vien/list/thanhvien.fxml"));
        Main.rootStage.setTitle("member");
        Main.rootStage.setScene(new Scene(listChi,779,588));
    }

    public void goToThemChi(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("them_chi/themchithang/themchithang.fxml"));
        Main.rootStage.setTitle("Thêm Khoản Chi");
        Main.rootStage.setScene(new Scene(listChi,800,600));
    }

    public void goToThemThu(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("them_thu/themthu.fxml"));
        Main.rootStage.setTitle("Thêm Khoản Thu");
        Main.rootStage.setScene(new Scene(listChi,800,600));
    }

    public void goToSoDu(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("residual/Residual.fxml"));
        Main.rootStage.setTitle("Số dư");
        Main.rootStage.setScene(new Scene(listChi,800,600));
    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }
}