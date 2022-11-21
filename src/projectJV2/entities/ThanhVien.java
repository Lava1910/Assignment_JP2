package projectJV2.entities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import projectJV2.Main;
import projectJV2.thanh_vien.create.CreateTVController;
import projectJV2.thanh_vien.edit.TVEditController;

public class ThanhVien {
    public Integer id;
    public String role;
    public Integer salary;

    public Button edit;

    public ThanhVien() {
    }

    public ThanhVien(Integer id, String role, Integer salary) {
        this.id = id;
        this.role = role;
        this.salary = salary;
        this.edit = new Button("Edit");
        this.edit.setOnAction((event) -> {
            try {
                TVEditController.editedTV = this;
                Parent edit = FXMLLoader.load(getClass().getResource("../thanh_vien/edit/EditTV.fxml"));
                Main.rootStage.setScene(new Scene((edit), 800, 600));
            }catch (Exception e){
            }
        });
    }

    public Button getEdit() {
        return edit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {return getRole();}
}