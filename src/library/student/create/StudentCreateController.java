package assignment_QLS.student.create;

import library.Main;
import library.helper.Connector;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class StudentCreateController {
        public TextField txtName;
        public TextField txtEmail;
        public TextField txtTel;

        public void submit(ActionEvent actionEvent) {
                try {
                        String name = txtName.getText();
                        String email = txtEmail.getText();
                        String tel = txtTel.getText();
                        String sql_txt = "insert into students(name,email,tel) values(?,?,?)";
                        Connector conn = Connector.getInstance();
                        ArrayList arr = new ArrayList();
                        arr.add(name);
                        arr.add(email);
                        arr.add(tel);
                        if(conn.execute(sql_txt,arr)) {
                                backToList();
                        } else {
                                System.out.println("Error");
                        }
                } catch (Exception e) {
                        System.out.println(e.getMessage());
                }
        }

        public void backToList() throws Exception {
                Parent listStudent = FXMLLoader.load(getClass().getResource("../list/list.fxml"));
                Main.rootStage.setTitle("Students");
                Main.rootStage.setScene(new Scene(listStudent, 800, 600));
        }
}
