package projectJV2.dao.interfaces;

import java.util.ArrayList;

public interface TRepository<T> {
    ArrayList<T> all();
    boolean create(T t);
    boolean update(T t);
    boolean delete(T t);
    T findOne(Integer id);
}