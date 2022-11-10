package assignment_jp2.student.list;

import assignment_jp2.dao.impls.StudentRepository;
import assignment_jp2.entities.Student;
import assignment_jp2.enums.RepoType;
import assignment_jp2.factory.RepositoryFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.util.ResourceBundle;

public class ListController implements Initializable {
    public TableView<Student> tbStudent;
    public TableColumn<Student,String> tdID;
    public TableColumn<Student,String> tdName;
    public TableColumn<Student,String> tdAddress;
    public TableColumn<Student,String> tdPhone;
    public void createNewStudent(ActionEvent actionEvent) {
    }

    public void backToMenu(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdID.setCellValueFactory(new PropertyValueFactory<Student,String>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
        tdAddress.setCellValueFactory(new PropertyValueFactory<Student,String>("address"));
        tdPhone.setCellValueFactory(new PropertyValueFactory<Student,String>("phone"));

        ObservableList<Student> ls = FXCollections.observableArrayList();
        StudentRepository rp = (StudentRepository) RepositoryFactory.createRepository(RepoType.STUDENT);
        ls.addAll(rp.all());
        tbStudent.setItems(ls);
    }
}
