package assignment_jp2.dao.impls;

import assignment_jp2.dao.interfaces.IStudentRepository;
import assignment_jp2.entities.Student;
import assignment_jp2.helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentRepository implements IStudentRepository{
    @Override
    public ArrayList<Student> all() {
        ArrayList<Student> ls = new ArrayList<>();
        try {
            String sql_txt = "select * from student";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                Student s = new Student(id,name,address,phone);
                ls.add(s);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ls;
    }

    @Override
    public boolean create(Student student) {
        try {
            String sql_txt = "insert into books(id,name,address,phone) values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(student.getId());
            arr.add(student.getName());
            arr.add(student.getAddress());
            arr.add(student.getPhone());
            if(conn.execute(sql_txt,arr)) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }


}

