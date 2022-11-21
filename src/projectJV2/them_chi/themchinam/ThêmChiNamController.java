package projectJV2.them_chi.themchinam;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import projectJV2.Main;

public class ThêmChiNamController {
    public void backToChiNam(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("/projectJV2/chi_nam/list/chinam.fxml"));
        Main.rootStage.setTitle("Chi Năm");
        Main.rootStage.setScene(new Scene(listChi,800,600));
    }
}
