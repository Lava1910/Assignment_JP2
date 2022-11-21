package projectJV2.thanh_vien.edit;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import projectJV2.Main;
import projectJV2.dao.impls.TVRepository;
import projectJV2.entities.ThanhVien;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class TVEditController implements Initializable {
    public static ThanhVien editedTV;
    public TextField txtRole;

    public TextField txtSalary;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if (editedTV != null){
            txtRole.setText(editedTV.getRole());
            txtSalary.setText(editedTV.getSalary().toString());
        }
    }

    public void submit(ActionEvent actionEvent) {
        try {
            String role = txtRole.getText();
            Integer salary = Integer.parseInt(txtSalary.getText());
            editedTV.setRole(role);
            editedTV.setSalary(salary);
            TVRepository rp = new TVRepository();
            rp.update(editedTV);
            if (rp.update(editedTV)){
                backList(null);
            }else{
                System.out.println("Error");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void backList(ActionEvent actionEvent) throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("../list/thanhvien.fxml"));
        Main.rootStage.setTitle("member");
        Main.rootStage.setScene(new Scene(listChi,779,588));
    }

    public void delete(ActionEvent actionEvent) {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete member?");
            alert.setHeaderText("Are you sure delete menber: "+editedTV.getRole());
            Optional<ButtonType> optional = alert.showAndWait();
            if (optional.get() == ButtonType.OK){
                TVRepository rp = new TVRepository();
                if (rp.delete(editedTV)){
                    backList(null);
                }else{
                    System.out.println("Error");
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
/*
public void delete(ActionEvent event) {
        try{
            Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Delete Book?");
            alert.setHeaderText("Are you sure delete book: "+editedBook.getName());
            Optional<ButtonType> option = alert.showAndWait();

            if(option.get() == ButtonType.OK){
                BookRepository rp = new BookRepository();
                if(rp.delete(editedBook)){
                    backToList(null);
                }else {
                    System.out.println("Error");
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
 */