package projectJV2.entities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import projectJV2.Main;
import projectJV2.thu_thang.edit.EditThuThangController;

import java.util.Date;

public class ThuThang {
    public Integer id;
    public Integer roleId;
    public String role;
    public Integer income;
    public String date;
    public Button edit;

    public ThuThang(int id, String role, int income, String date) {
    }

    public ThuThang(Integer id, Integer roleId, String role, Integer income, String date) {
        this.id = id;
        this.roleId = roleId;
        this.role = role;
        this.income = income;
        this.date = date;
        this.edit = new Button("edit");
        this.edit.setOnAction((event)->{
            try {
                EditThuThangController.editedThuThang = this;
                Parent edit = FXMLLoader.load(getClass().getResource("../thu_thang/edit/EditThuThang.fxml"));
                Main.rootStage.setScene(new Scene(edit,800,500));
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
    }

    public ThuThang(int id, int roleid, String role, int income, Date date) {
    }

    public ThuThang(Integer integer, String role, Integer income, String date) {
    }

    public ThuThang(Integer id, String role, int income, String date) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
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
}
