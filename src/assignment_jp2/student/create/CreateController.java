package assignment_jp2.student.create;

import assignment_jp2.Main;
import assignment_jp2.dao.impls.StudentRepository;
import assignment_jp2.entities.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import projectJV2.dao.impls.TVRepository;
import projectJV2.entities.ThanhVien;


public class CreateController {
    public TextField txtID;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtPhone;


    public void backToMenu(ActionEvent actionEvent) throws Exception {
        Parent createStudent = FXMLLoader.load(getClass().getResource("student/home.fxml"));
        Main.rootStage.setTitle("Back to Menu");
        Main.rootStage.setScene(new Scene(createStudent,955,587));
    }

    public void submit(ActionEvent actionEvent) {
        try {
            String id = txtID.getText();
            String name = txtName.getText();
            String address = txtAddress.getText();
            String phone = txtPhone.getText();
            Student student = new Student(id,name,address,phone);
            StudentRepository rp = new StudentRepository();
            if (rp.create(student)){
                backListTV();
            }else {
                System.out.println("Errorrrr");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void backListTV() throws Exception{
        Parent listChi = FXMLLoader.load(getClass().getResource("student/list/list.fxml"));
        projectJV2.Main.rootStage.setTitle("member");
        projectJV2.Main.rootStage.setScene(new Scene(listChi,955, 587));
    }
}
