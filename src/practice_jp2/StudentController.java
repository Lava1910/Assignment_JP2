package studentmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

    public TextField txtName;
    public TextField txtStudentId;
    public TextField txtPhone;
    public TextField txtAddress;

    public ListView<Student> lvStudent;
    public Text errors;
    private ObservableList<Student> list = FXCollections.observableArrayList();

    public void addStudent(ActionEvent actionEvent) {
        try {
            errors.setVisible(false);
            if(txtName.getText().isEmpty() || txtAddress.getText().isEmpty()
                    || txtStudentId.getText().isEmpty()|| txtStudentId.getText().isEmpty())
            {
                throw new Exception("Vui lòng nhập các thông tin hợp lệ");
            }
            list.add(new Student(txtStudentId.getText(),txtName.getText(),txtAddress.getText(),txtPhone.getText()));
            lvStudent.setItems(list);
            lvStudent.refresh();
            clearInput();
        }catch (Exception e){
            errors.setText(e.getMessage());
            errors.setVisible(true);
        }
    }

    public void clearInput(){
        txtStudentId.setText("");
        txtName.setText("");
        txtAddress.setText("");
        txtPhone.setText("");

    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lvStudent.setItems(list);
    }
}

