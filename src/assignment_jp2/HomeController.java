package assignment_jp2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        ResourceBundle rb =
    }

    public void goToStudentList(ActionEvent actionEvent) throws Exception {
        Parent listStudent = FXMLLoader.load(getClass().getResource("student/list/list.fxml"));
        Main.rootStage.setTitle("Display student records");
        Main.rootStage.setScene(new Scene(listStudent,955,587));
    }

    public void createNewStudent(ActionEvent actionEvent) throws Exception {
        Parent createStudent = FXMLLoader.load(getClass().getResource("student/create/create.fxml"));
        Main.rootStage.setTitle("Add student records");
        Main.rootStage.setScene(new Scene(createStudent,955,587));
    }

    public void save(ActionEvent actionEvent) {

    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
        System.exit(0);
    }
}
