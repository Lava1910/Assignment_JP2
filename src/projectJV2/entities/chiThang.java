package projectJV2.entities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import projectJV2.Main;
import projectJV2.chi_thang.edit.EditChiThangController;

import java.util.Date;

public class chiThang {
    public Integer id;
    public String sname;
    public Integer spending;
    public String date;
    public Button edit;

    public chiThang() {

    }

    public chiThang(Integer id, String sname, Integer spending, String date) {
        this.id = id;
        this.sname = sname;
        this.spending = spending;
        this.date = date;
        this.edit = new Button("Edit");
        this.edit.setOnAction((event) -> {
            try {
                EditChiThangController.editedChiThang = this;
                Parent edit = FXMLLoader.load(getClass().getResource("../chi_thang/edit/editChiThang.fxml"));
                Main.rootStage.setScene(new Scene(edit,800,600));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        });
    }

    public chiThang(Integer id, String sname, String spend, int date) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getSpending() {
        return spending;
    }

    public void setSpending(Integer spending) {
        this.spending = spending;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public  Button getEdit() {

        return edit;
    }
    public  String toString() {
        return getSname();
    }
}

    
