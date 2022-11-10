package library.dao.interfaces;

import library.entities.Student;

import java.util.ArrayList;

public interface IStudentRepository {
    ArrayList<Student> all();
    boolean create(Student student) throws Exception;
    boolean update(Student student) throws Exception;
    boolean delete(Student student) throws Exception;
    Student findOne(Integer id);
}
