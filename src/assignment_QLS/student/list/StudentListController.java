package assignment_QLS.student.list;

import assignment_QLS.Main;
import assignment_QLS.entities.Student;
import assignment_QLS.helper.Connector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class StudentListController implements Initializable {
        public TableView<Student> tbStudents;
        public TableColumn<Student, Integer> tdIDSd;
        public TableColumn<Student, String> tdNameSd;
        public TableColumn<Student, String> tdEmailSd;
        public TableColumn<Student,String>tdTelSd;

        public final static String connectionString = "jdbc:mysql://localhost:3306/t2203e";
        public final static String user = "root";
        public final static String pwd = "";

        @Override
        public void initialize(URL location, ResourceBundle resources) {
                tdIDSd.setCellValueFactory(new PropertyValueFactory<Student,Integer>("id"));
                tdNameSd.setCellValueFactory(new PropertyValueFactory<Student,String>("name"));
                tdEmailSd.setCellValueFactory(new PropertyValueFactory<Student,String>("email"));
                tdTelSd.setCellValueFactory(new PropertyValueFactory<Student,String>("tel"));

                ObservableList<Student> ls = FXCollections.observableArrayList();

                try {
                        String sql_txt = "select * from students";
                        Connector conn = Connector.getInstance();
                        ResultSet rs = conn.query(sql_txt);
                        while (rs.next()) {
                                int id = rs.getInt("id");
                                String name = rs.getString("name");
                                String email = rs.getString("email");
                                String tel = rs.getString("tel");
                                Student s = new Student(id,name,email,tel);
                                ls.add(s);
                         }
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                } finally {
                        tbStudents.setItems(ls);
                }
        }

        public void createNewStudent(ActionEvent actionEvent) throws Exception {
                Parent listStudent = FXMLLoader.load(getClass().getResource("../create/create_form.fxml"));
                Main.rootStage.setTitle("Students");
                Main.rootStage.setScene(new Scene(listStudent,800,600));
        }
}
